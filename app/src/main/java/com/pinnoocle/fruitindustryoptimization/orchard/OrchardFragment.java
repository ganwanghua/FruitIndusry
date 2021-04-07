package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.TreeAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class OrchardFragment extends BaseFragment implements TreeAdapter.OnItemClickListener {
    @BindView(R.id.tv_adopt)
    TextView tvAdopt;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.ll_tree)
    LinearLayout llTree;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    private TreeAdapter treeAdapter;
    private DataRepository dataRepository;
    private List<UserTreesModel.DataBean.TreesBean> mShowItems = new ArrayList<>();

    @Override
    protected int LayoutId() {
        return R.layout.fragment_orchard;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getActivity());

        recycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getActivity(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        treeAdapter = new TreeAdapter(getActivity());
        recycleView.setAdapter(treeAdapter);

        treeAdapter.setOnItemClickListener(this);

        userTrees();
    }

    private void userTrees() {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/user_trees");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.userTrees(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                UserTreesModel userTreesModel = (UserTreesModel) data;
                if (userTreesModel.getCode() == 1) {
                    mShowItems.addAll(userTreesModel.getData().getTrees());
                    treeAdapter.setData(mShowItems);
                    if (mShowItems.size() > 0) {
                        llTree.setVisibility(View.VISIBLE);
                        llEmpty.setVisibility(View.GONE);
                    }else {
                        llEmpty.setVisibility(View.VISIBLE);
                        llTree.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_adopt)
    public void onViewClicked() {
        ActivityUtils.startActivity(getActivity(), AdoptActivity.class);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), WateringFruitTreesActivity.class);
        intent.putExtra("tree_id", mShowItems.get(position).getUser_tree_id() + "");
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("11")) {
            userTrees();
        }
    }
}
