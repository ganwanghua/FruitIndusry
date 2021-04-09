package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillVenueAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.SecKillVenueModel;
import com.pinnoocle.fruitindustryoptimization.bean.SeckillModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class SecondKillVenueFragment extends BaseFragment implements OnRefreshLoadMoreListener, SecKillVenueAdapter.OnItemClickListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private int page = 1;
    SecKillVenueAdapter secKillVenueAdapter;
    private List<SecKillVenueModel.DataBeanX.ActiveListBean.DataBean> mShowItems = new ArrayList<>();

    @Override
    protected int LayoutId() {
        return R.layout.second_kill_venue;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        secKillVenueAdapter = new SecKillVenueAdapter(getContext());
        recycleView.setAdapter(secKillVenueAdapter);

        secKillVenueAdapter.setOnItemClickListener(this);
        refresh.setOnRefreshLoadMoreListener(this);
        secKillVenue(page);
    }


    private void secKillVenue(int page) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.active/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        dataRepository.secKillVenue(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(mContext);
                SecKillVenueModel secKillVenueModel = (SecKillVenueModel) data;
                if (secKillVenueModel.getCode() == 1) {
                    if (secKillVenueModel.getData().getActiveList().getCurrent_page() == secKillVenueModel.getData().getActiveList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    mShowItems.addAll(secKillVenueModel.getData().getActiveList().getData());
                    secKillVenueAdapter.setData(mShowItems);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        secKillVenue(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        mShowItems.clear();
        secKillVenue(page);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), SecKillDetailActivity.class);
        intent.putExtra("active_id", mShowItems.get(position).getActive_id() + "");
        startActivity(intent);
    }
}
