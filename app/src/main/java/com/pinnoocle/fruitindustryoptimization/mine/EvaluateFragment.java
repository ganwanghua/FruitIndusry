package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.EvaluateAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.FragmentAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupWorkListAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkListModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
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

public class EvaluateFragment extends BaseFragment implements OnRefreshLoadMoreListener, EvaluateAdapter.OnItemClickListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private String scoreType;
    private DataRepository dataRepository;
    private EvaluateAdapter evaluateAdapter;
    private int page = 1;
    private List<MyCommentModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    public EvaluateFragment(String s) {
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
        evaluateAdapter = new EvaluateAdapter(getActivity());
        recycleView.setAdapter(evaluateAdapter);
        evaluateAdapter.setOnItemClickListener(this);
        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        myComment(page, scoreType);
    }

    private void myComment(int page, String scoreType) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/comment/user_lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("scoreType", scoreType);
        map.put("page", page + "");
        dataRepository.myComment(map, new RemotDataSource.getCallback() {
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
                    evaluateAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        myComment(page, scoreType);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        myComment(page, scoreType);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent1 = new Intent(getActivity(), GoodsDetailsActivity.class);
        intent1.putExtra("goods_id", dataBeanList.get(position).getOrder_goods().getGoods_id() + "");
        startActivity(intent1);
    }
}
