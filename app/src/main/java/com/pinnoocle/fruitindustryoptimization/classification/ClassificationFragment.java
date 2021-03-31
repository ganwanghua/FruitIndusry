package com.pinnoocle.fruitindustryoptimization.classification;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.ChildAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.ClassificationAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.home.SearchActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ClassificationFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_search)
    TextView edSearch;
    @BindView(R.id.rv_classification)
    RecyclerView rvClassification;
    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;
    private DataRepository dataRepository;
    private ClassificationAdapter classificationAdapter;
    private ChildAdapter childAdapter;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_classification;

    }

    @Override
    protected void initView() {
        super.initView();
        rvClassification.setLayoutManager(new LinearLayoutManager(mContext));
        classificationAdapter = new ClassificationAdapter(mContext);
        rvClassification.setAdapter(classificationAdapter);
        classificationAdapter.setmOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<CategoryIndexModel.DataBeanX.ListBean>() {
            @Override
            public void onItemViewClick(View view, int position, CategoryIndexModel.DataBeanX.ListBean o) {
                classificationAdapter.setPos(position);
                getChildCat(o.getGoods().getData());
            }
        });

        rvGoodsList.setLayoutManager(new LinearLayoutManager(mContext));
        childAdapter = new ChildAdapter(mContext);
        rvGoodsList.setAdapter(childAdapter);
        childAdapter.setmOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<CategoryIndexModel.DataBeanX.ListBean.GoodsBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, CategoryIndexModel.DataBeanX.ListBean.GoodsBean.DataBean o) {
                if (view.getId() == R.id.iv_add_cart) {
                    cartAdd(o.getGoods_id() + "", o.getGoods_sku().getSpec_sku_id(), 1);
                } else {
                    Intent intent1 = new Intent(getContext(), GoodsDetailsActivity.class);
                    intent1.putExtra("goods_id", o.getGoods_id() + "");
                    startActivity(intent1);

                }
            }
        });

    }

    private void getChildCat(List<CategoryIndexModel.DataBeanX.ListBean.GoodsBean.DataBean> goods) {
        childAdapter.setData(goods);
    }

    @Override
    protected void initData() {
        super.initData();
        dataRepository = Injection.dataRepository(mContext);
        categoryIndex();
    }

    private void categoryIndex() {
        ViewLoading.show(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/category/index");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.categoryIndex(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CategoryIndexModel categoryIndexModel = (CategoryIndexModel) data;
                if (categoryIndexModel.getCode() == 1) {
                    List<CategoryIndexModel.DataBeanX.ListBean> list = categoryIndexModel.getData().getList();
                    classificationAdapter.setData(list);
                    getChildCat(list.get(0).getGoods().getData());
                }

            }
        });
    }

    private void cartAdd(String goods_id, String goods_sku_id, int goods_num) {
        ViewLoading.show(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/add");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", goods_id);
        map.put("goods_num", goods_num + "");
        map.put("goods_sku_id", goods_sku_id);
        dataRepository.cartAdd(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {

                }
                ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }


    @OnClick(R.id.ed_search)
    public void onViewClicked() {
        ActivityUtils.startActivity(getContext(), SearchActivity.class);

    }
}
