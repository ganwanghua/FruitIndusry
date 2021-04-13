package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.AfterSaleListAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.RefundListsModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class GroupAfterSaleListFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private String type;
    private DataRepository dataRepository;
    private int page = 1;
    private List<RefundListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private AfterSaleListAdapter adapter;

    public GroupAfterSaleListFragment(String type) {
        this.type = type;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_after_sale_list;
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

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AfterSaleListAdapter(getContext());
        recycleView.setAdapter(adapter);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(mContext);
        refundLists();
    }

    private void refundLists() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.refund/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("state", type);
        map.put("page", page + "");
        ViewLoading.show(getContext());
        dataRepository.groupRefundLists(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
                refresh.finishRefresh();
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                RefundListsModel refundListsModel = (RefundListsModel) data;
                refresh.finishRefresh();
                if (refundListsModel.getCode() == 1) {
                    if (refundListsModel.getData().getList().getCurrent_page() == refundListsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && refundListsModel.getData().getList().getData().size() == 0) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(refundListsModel.getData().getList().getData());
                        adapter.setData(dataBeanList);
                    }

                }
            }
        });
    }



    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("order_refresh")) {
//            page = 1;
//            dataBeanList.clear();
//            orderList();
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        refundLists();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        refundLists();
    }
}
