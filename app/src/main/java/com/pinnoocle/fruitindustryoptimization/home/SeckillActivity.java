package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.AdoptionOrderAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.SeckillModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SeckillActivity extends BaseActivity implements SecKillAdapter.OnItemClickListener, OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.rl_seckill)
    RelativeLayout rlSeckill;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    SecKillAdapter secKillAdapter;
    private DataRepository dataRepository;
    private int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seckill);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        secKillAdapter = new SecKillAdapter(this);
        recycleView.setAdapter(secKillAdapter);

        secKillAdapter.setOnItemClickListener(this);
        refresh.setOnRefreshLoadMoreListener(this);
        seckill(page);
    }

    private void seckill(int page) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.task/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        dataRepository.seckill(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                SeckillModel seckillModel = (SeckillModel) data;
//                if (seckillModel.getCode() == 1) {
//                    adoptionOrderAdapter.setData(treeOrderModel.getData().getOrders());
//                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        seckill(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }
}