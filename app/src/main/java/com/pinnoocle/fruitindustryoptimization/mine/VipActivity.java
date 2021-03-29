package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.VipAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.VipHotAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipListsModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.utils.StatusBarUtil;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.rl_seckill)
    RelativeLayout rlSeckill;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.recycleView1)
    RecyclerView recycleView1;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private DataRepository dataRepository;
    private VipHotAdapter vipHotAdapter;
    private VipAdapter vipAdapter;
    private List<VipListsModel.DataBeanXX.HotListBean.DataBeanX> dataBeanXES = new ArrayList<>();
    private List<VipListsModel.DataBeanXX.ListBean.DataBean> dataBeans = new ArrayList<>();
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setColor(this.getWindow(), 0xffFB2C20);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        recycleView.setLayoutManager(new GridLayoutManager(this, 3));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.HORIZONTAL, getResources().getColor(R.color.transparent), 20));
        vipHotAdapter = new VipHotAdapter(this);
        recycleView.setAdapter(vipHotAdapter);

        recycleView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView1.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        vipAdapter = new VipAdapter(this);
        recycleView1.setAdapter(vipAdapter);

        refresh.setOnRefreshLoadMoreListener(this);
        vip(page);
    }

    private void vip(int page) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/vip_lists");
        map.put("wxapp_id", "10001");
        map.put("page", page + "");
        map.put("token", FastData.getToken());
        dataRepository.vipLists(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                refresh.finishLoadMore();
                ViewLoading.dismiss(mContext);
                VipListsModel vipListsModel = (VipListsModel) data;
                if (vipListsModel.getCode() == 1) {
                    if (vipListsModel.getData().getList().getCurrent_page() == vipListsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (page == 1) {
                        for (int i = 0; i < vipListsModel.getData().getHot_list().getData().size(); i++) {
                            if (i < 3) {
                                dataBeanXES.add(vipListsModel.getData().getHot_list().getData().get(i));
                            }
                        }
                        vipHotAdapter.setData(dataBeanXES);
                    }
                    dataBeans.addAll(vipListsModel.getData().getList().getData());
                    vipAdapter.setData(dataBeans);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        vip(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanXES.clear();
        dataBeans.clear();
        vip(page);
    }
}