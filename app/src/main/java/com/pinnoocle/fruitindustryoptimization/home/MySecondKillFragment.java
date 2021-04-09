package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillAdapter;
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

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MySecondKillFragment extends BaseFragment implements OnRefreshLoadMoreListener, SecKillAdapter.OnItemClickListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private int page = 1;
    SecKillAdapter secKillAdapter;
    private List<SeckillModel.DataBeanX.MyListBean.DataBean> mShowItems = new ArrayList<>();

    @Override
    protected int LayoutId() {
        return R.layout.second_kill_venue;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        secKillAdapter = new SecKillAdapter(getContext());
        recycleView.setAdapter(secKillAdapter);

        secKillAdapter.setOnItemClickListener(this);
        refresh.setOnRefreshLoadMoreListener(this);
        secKill(page);
    }

    private void secKill(int page) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.task/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        dataRepository.seckill(map, new RemotDataSource.getCallback() {
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
                SeckillModel seckillModel = (SeckillModel) data;
                if (seckillModel.getCode() == 1) {
                    if (seckillModel.getData().getMyList().getCurrent_page() == seckillModel.getData().getMyList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    mShowItems.addAll(seckillModel.getData().getMyList().getData());
                    secKillAdapter.setData(mShowItems);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        secKill(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        mShowItems.clear();
        secKill(page);
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
        if (event.equals("12")) {
            page = 1;
            mShowItems.clear();
            secKill(page);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), SecKillDetailsActivity.class);
        intent.putExtra("task_id", mShowItems.get(position).getTask_id() + "");
        startActivity(intent);
    }
}
