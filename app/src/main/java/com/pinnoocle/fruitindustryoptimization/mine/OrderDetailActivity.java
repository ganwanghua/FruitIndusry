package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderDetailAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_wallet)
    ImageView ivWallet;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.iv_deliver_goods)
    ImageView ivDeliverGoods;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.iv_receiving_goods)
    ImageView ivReceivingGoods;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.iv_message_fill)
    ImageView ivMessageFill;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_deliver_goods)
    TextView tvDeliverGoods;
    @BindView(R.id.tv_receiving_goods)
    TextView tvReceivingGoods;
    @BindView(R.id.tv_message_fill)
    TextView tvMessageFill;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.iv_line)
    ImageView ivLine;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_total_num)
    TextView tvTotalNum;
    @BindView(R.id.tv_pay_money)
    TextView tvPayMoney;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.tv_total_merchandise)
    TextView tvTotalMerchandise;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.tv_goods_money)
    TextView tvGoodsMoney;
    @BindView(R.id.tv_pay_money_1)
    TextView tvPayMoney1;
    private DataRepository dataRepository;
    private OrderDetailAdapter adapter;

    private ImageView iv_ali_mark, iv_wx_mark;
    private String payType = "20";
    private String order_id;
    private String order_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderDetailAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<OrderDetailModel.DataBean.OrderBean.GoodsBeanX>() {
            @Override
            public void onItemViewClick(View view, int position, OrderDetailModel.DataBean.OrderBean.GoodsBeanX o) {
                Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                intent.putExtra("goods_id", o.getGoods_id() + "");
                startActivity(intent);
            }
        });
    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        orderDetail();
    }

    private void orderDetail() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", getIntent().getStringExtra("order_id"));

        ViewLoading.show(mContext);
        dataRepository.orderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                OrderDetailModel orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    tvStatus.setText(orderDetailModel.getData().getOrder().getState_text());
                    order_id = orderDetailModel.getData().getOrder().getOrder_id() + "";
                    order_no = orderDetailModel.getData().getOrder().getOrder_no() + "";
                    if (orderDetailModel.getData().getOrder().getState_text().equals("已取消")) {
                        rlPanel.setVisibility(View.GONE);
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("待付款")) {
                        view.setBackgroundResource(R.color.light_white);
                        view1.setBackgroundResource(R.color.light_white);
                        view2.setBackgroundResource(R.color.light_white);
                        ivDeliverGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivDeliverGoods.setImageResource(R.mipmap.deliver_goods_no);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvDeliverGoods.setTextColor(0x99ffffff);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已提交，请在2小时内完成支付~");

                        tvCancel.setText("取消订单");
                        tvBuy.setText("去付款");
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已付款，待发货")) {
                        view1.setBackgroundResource(R.color.light_white);
                        view2.setBackgroundResource(R.color.light_white);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单正在备货中~");

                        tvBuy.setText("申请售后");
                        tvCancel.setVisibility(View.GONE);
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已发货，待收货")) {
                        view2.setBackgroundResource(R.color.light_white);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已发货，请这注意查收~");

                        tvCancel.setText("申请售后");
                        tvBuy.setText("确认收货");
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已完成")) {
                        tvHint.setText("您的订单已完成，期待您的好评~");

                        tvCancel.setVisibility(View.GONE);
                        tvBuy.setText("去评价");
                    }
                    tvName.setText(orderDetailModel.getData().getOrder().getAddress().getName());
                    if (!TextUtils.isEmpty(orderDetailModel.getData().getOrder().getAddress().getPhone()) && orderDetailModel.getData().getOrder().getAddress().getPhone().length() > 6) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < orderDetailModel.getData().getOrder().getAddress().getPhone().length(); i++) {
                            char c = orderDetailModel.getData().getOrder().getAddress().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tvPhone.setText(sb.toString());
                    }

                    tvAddress.setText(orderDetailModel.getData().getOrder().getAddress().getRegion().getProvince() + orderDetailModel.getData().getOrder().getAddress().getRegion().getCity()
                            + orderDetailModel.getData().getOrder().getAddress().getRegion().getRegion() + orderDetailModel.getData().getOrder().getAddress().getDetail());
                    tvTotalMoney.setText("¥" + orderDetailModel.getData().getOrder().getTotal_price());
                    tvDeliveryFee.setText("+¥" + orderDetailModel.getData().getOrder().getExpress_price());
                    tvTotalMerchandise.setText("¥" + orderDetailModel.getData().getOrder().getOrder_price());
                    tvOrder.setText(orderDetailModel.getData().getOrder().getOrder_no());
                    tvUpdateTime.setText(orderDetailModel.getData().getOrder().getCreate_time());
                    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> goods = orderDetailModel.getData().getOrder().getGoods();
                    adapter.setData(goods);

                    tvOrderCode.setText("订单号：" + orderDetailModel.getData().getOrder().getOrder_no());
                    tvTime.setText(orderDetailModel.getData().getOrder().getCreate_time());
                    tvTotalNum.setText("共" + orderDetailModel.getData().getOrder().getGoods().size() + "件商品，实付:");
                    tvPayMoney.setText("￥" + orderDetailModel.getData().getOrder().getPay_price());
                    tvPayMoney1.setText("￥" + orderDetailModel.getData().getOrder().getPay_price());
                    tvGoodsMoney.setText("￥" + orderDetailModel.getData().getOrder().getOrder_price());
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
        ViewLoading.show(mContext);
        dataRepository.orderCancel(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    orderDetail();
                    EventBus.getDefault().post("order_refresh");
                }
            }

        });
    }


    private void showOrderCancelDialog(String order_ids) {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_cancel_dialog)
                .setScreenWidthAspect(mContext, 0.7f)
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


    private void orderPay(String order_ids, String order_no) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/pay");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", order_ids);
        map.put("payType", payType);
        map.put("platform", "app");
        ViewLoading.show(mContext);
        dataRepository.orderPay(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
                    orderDetail();
                    showOrderCommentDialog(order_ids, order_no);
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
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
        ViewLoading.show(mContext);
        dataRepository.orderReceipt(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("order_refresh");
                    orderDetail();
//                    showOrderCommentDialog(order_ids,order_no);
                }
            }

        });
    }


    private void showOrderConfirmDialog(String order_ids, String order_no) {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_confirm_dialog)
                .setScreenWidthAspect(mContext, 0.7f)
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
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_comment_dialog)
                .setScreenWidthAspect(mContext, 0.7f)
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
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.order_pay_dialog)
                .setScreenWidthAspect(mContext, 1f)
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


    @OnClick({R.id.iv_back, R.id.tv_cancel, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_cancel:
                if (tvCancel.getText().toString().equals("取消订单")) {
                    showOrderCancelDialog(order_id);
                } else if (tvCancel.getText().toString().equals("申请售后")) {

                }
                break;
            case R.id.tv_buy:
                if (tvBuy.getText().toString().equals("去付款")) {
                    showOrderPayDialog(order_id, order_no);
                } else if (tvBuy.getText().toString().equals("申请售后")) {
                    startActivity(new Intent(mContext,ApplyForAfterSalesActivity.class));

                } else if (tvBuy.getText().toString().equals("确认收货")) {
                    showOrderConfirmDialog(order_id, order_no);
                }
                break;
        }
    }
}
