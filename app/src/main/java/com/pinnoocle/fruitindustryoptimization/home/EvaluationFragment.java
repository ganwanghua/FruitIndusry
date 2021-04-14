package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.EvaluateAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.EvaluationAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class EvaluationFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private String scoreType;
    private DataRepository dataRepository;
    private EvaluationAdapter adapter;
    private int page = 1;
    private List<MyCommentModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    public EvaluationFragment(String s) {
        this.scoreType = s;
    }

    @Override
    protected int LayoutId() {
        return R.layout.evaluate;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new EvaluationAdapter(getActivity());
        recycleView.setAdapter(adapter);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        goodsComment(page, scoreType);
    }

    private void goodsComment(int page, String scoreType) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/comment/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id",getActivity().getIntent().getStringExtra("goods_id"));
        map.put("scoreType", scoreType);
        map.put("page", page + "");
        dataRepository.goodsComment(map, new RemotDataSource.getCallback() {
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
                MyCommentModel myCommentModel = (MyCommentModel) data;
                if (myCommentModel.getCode() == 1) {
                    if (myCommentModel.getData().getList().getCurrent_page() == myCommentModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(myCommentModel.getData().getList().getData());
                    adapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        goodsComment(page, scoreType);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        goodsComment(page, scoreType);
    }


}
