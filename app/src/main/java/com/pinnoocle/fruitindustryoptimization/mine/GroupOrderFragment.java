package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupOrderAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GroupOrderListModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderListModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class GroupOrderFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private String type;
    private DataRepository dataRepository;
    private GroupOrderAdapter orderAdapter;
    private List<GroupOrderListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private int page = 1;
    private ImageView iv_ali_mark, iv_wx_mark;
    private String payType = "20";

    public GroupOrderFragment(String type) {
        this.type = type;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("order_refresh")) {
            page = 1;
            dataBeanList.clear();
            groupOrderList();
        }
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new GroupOrderAdapter(getContext());
        recycleView.setAdapter(orderAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
        orderAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<OrderListModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, OrderListModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()) {
                    case R.id.tv_cancel:
                        if (o.getState_text().equals("待付款")) {  //取消
                            showOrderCancelDialog(o.getOrder_id() + "");
                        }
                        break;

                    case R.id.tv_pay:
                        if (o.getState_text().equals("待付款")) {  //去付款
                            showOrderPayDialog(o.getOrder_id() + "", o.getOrder_no());
                        } else if (o.getState_text().equals("已付款，待发货") || o.getState_text().equals("已发货，待收货")) {
                            Intent intent = new Intent(mContext, OrderDetailActivity.class);
                            intent.putExtra("order_id", o.getOrder_id() + "");
                            startActivity(intent);
                        } else if (o.getState_text().equals("已完成")) {//去评价
//                            Intent intent = new Intent(getContext(), OrderCommentActivity.class);
//                            intent.putExtra("order_id", o.getOrder_id() + "");
//                            startActivity(intent);

                        }

                        break;

//                    default:
//                        startActivity(new Intent(getContext(), OrderDetailActivity.class));
//                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        groupOrderList();
    }

    private void groupOrderList() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.order/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("dataType", type);
        map.put("page", page + "");
        ViewLoading.show(getContext());
        dataRepository.groupOrderList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                GroupOrderListModel orderListModel = (GroupOrderListModel) data;
                refresh.finishRefresh();
                if (orderListModel.getCode() == 1) {
                    if (orderListModel.getData().getList().getCurrent_page() == orderListModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && orderListModel.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(orderListModel.getData().getList().getData());
                        orderAdapter.setData(dataBeanList);
                    }

                }
            }
        });
    }

    private void orderCancel(String order_ids) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/cancel");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", order_ids);
        ViewLoading.show(getContext());
        dataRepository.orderCancel(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
                }
            }

        });
    }

    private void orderReceipt(String order_ids, String order_no) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/receipt");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", order_ids);
        ViewLoading.show(getContext());
        dataRepository.orderReceipt(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
//                    showOrderCommentDialog(order_ids,order_no);
                }
            }

        });
    }

    private void orderPay(String order_ids, String order_no) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/pay");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", order_ids);
        map.put("payType", payType);
        map.put("platform", "app");
        ViewLoading.show(getContext());
        dataRepository.orderPay(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
                    showOrderCommentDialog(order_ids, order_no);
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }

        });
    }


    private void showOrderCancelDialog(String order_ids) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_cancel_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                orderCancel(order_ids);
                                tDialog.dismiss();

                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void showOrderConfirmDialog(String order_ids, String order_no) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_confirm_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确认签收订单：" + order_no);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                orderReceipt(order_ids, order_no);
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void showOrderCommentDialog(String order_ids, String order_no) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_comment_dialog)
                .setScreenWidthAspect(getContext(), 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确认签收订单：" + order_no + "成功，，现在去评价订单？");
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
//                            case R.id.tv_sure:
//                                Intent intent = new Intent(getContext(), OrderCommentActivity.class);
//                                intent.putExtra("order_id", order_ids);
//                                startActivity(intent);
//                                tDialog.dismiss();
//                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void showOrderPayDialog(String order_ids, String order_no) {
        new TDialog.Builder(getActivity().getSupportFragmentManager())
                .setLayoutRes(R.layout.order_pay_dialog)
                .setScreenWidthAspect(getContext(), 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(true)
                .addOnClickListener(R.id.open_vip, R.id.rl_ali, R.id.rl_wechat)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        iv_ali_mark = viewHolder.itemView.findViewById(R.id.iv_ali_mark);
                        iv_wx_mark = viewHolder.itemView.findViewById(R.id.iv_wx_mark);
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.open_vip:
                                orderPay(order_ids, order_no);
                                tDialog.dismiss();

                                break;
                            case R.id.rl_ali:
                                setPayMode(iv_ali_mark, "ali_pay");
                                break;
                            case R.id.rl_wechat:
                                setPayMode(iv_wx_mark, "wx_pay");
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void setPayMode(ImageView imageView, String pay_mode) {
        iv_ali_mark.setImageResource(R.mipmap.grey_circle);
        iv_wx_mark.setImageResource(R.mipmap.grey_circle);
        this.payType = pay_mode;
        imageView.setImageResource(R.mipmap.juice_circle);
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        groupOrderList();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        groupOrderList();
    }

}
