package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.TreeAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GeneTreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;
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
                    } else {
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
    public void onItemClick(View v, int position) {
        switch (v.getId()) {
            case R.id.ll_watering:
                Intent intent = new Intent(getActivity(), WateringFruitTreesActivity.class);
                intent.putExtra("tree_id", mShowItems.get(position).getUser_tree_id() + "");
                startActivity(intent);
                break;
            case R.id.ll_renew:
                new TDialog.Builder(getFragmentManager())
                        .setLayoutRes(R.layout.dialog_renew)
                        .setScreenWidthAspect(getContext(), 1f)
                        .setGravity(Gravity.BOTTOM)
                        .setCancelableOutside(true)
                        .addOnClickListener(R.id.tv_sure)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {

                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.tv_sure:
                                        geneTreeOrder(position);
                                        tDialog.dismiss();
                                        break;
                                }
                            }
                        })
                        .create()
                        .show();
                break;
        }
    }

    @Override
    public void onItemClicks(int position) {
        Intent intent = new Intent(getActivity(), WateringFruitTreesActivity.class);
        intent.putExtra("tree_id", mShowItems.get(position).getUser_tree_id() + "");
        startActivity(intent);
    }

    private void geneTreeOrder(int position) {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/gene_tree_order");
        map.put("wxapp_id", "10001");
        map.put("tree_id", mShowItems.get(position).getTree_id() + "");
        map.put("token", FastData.getToken());
        map.put("spec", mShowItems.get(position).getType() + "");
        map.put("number", mShowItems.get(position).getNumber() + "");
        map.put("time", "12");
        map.put("user_tree_id", mShowItems.get(position).getUser_tree_id() + "");
        dataRepository.geneTreeOrder(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                GeneTreeOrderModel geneTreeOrderModel = (GeneTreeOrderModel) data;
                if (geneTreeOrderModel.getCode() == 1) {
                    mShowItems.clear();
                    userTrees();
                }
            }
        });
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
        if (event.equals("11")) {
            mShowItems.clear();
            userTrees();
        }
    }
}
