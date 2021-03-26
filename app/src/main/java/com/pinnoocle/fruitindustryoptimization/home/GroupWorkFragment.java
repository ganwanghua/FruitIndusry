package com.pinnoocle.fruitindustryoptimization.home;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupWorkListAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsSearchModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkListModel;
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

public class GroupWorkFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private int category_id;
    private DataRepository dataRepository;
    private GroupWorkListAdapter groupWorkListAdapter;
    private int page = 1;
    private List<GroupWorkListModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    public GroupWorkFragment(int i) {
        this.category_id = i;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_group_work;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        groupWorkListAdapter = new GroupWorkListAdapter(getActivity());
        recycleView.setAdapter(groupWorkListAdapter);

        refresh.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initData() {
        groupWorkList(page);
    }

    private void groupWorkList(int page) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.goods/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        map.put("category_id", category_id + "");
        dataRepository.groupWorkList(map, new RemotDataSource.getCallback() {
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
                GroupWorkListModel groupWorkListModel = (GroupWorkListModel) data;
                if (groupWorkListModel.getCode() == 1) {
                    if (groupWorkListModel.getData().getList().getCurrent_page() == groupWorkListModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    dataBeanList.addAll(groupWorkListModel.getData().getList().getData());
                    groupWorkListAdapter.setData(dataBeanList);
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        groupWorkList(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        groupWorkList(page);
    }
}