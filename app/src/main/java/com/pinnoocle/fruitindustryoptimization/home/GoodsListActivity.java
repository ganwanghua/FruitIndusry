package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GoodsAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsSearchModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.orchard.AdoptionAgreementActivity;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
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

public class GoodsListActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    @BindView(R.id.go_back)
    ImageView goBack;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_home_search)
    TextView etHomeSearch;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.tv_composite)
    TextView tvComposite;
    @BindView(R.id.tv_sales)
    TextView tvSales;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_sort_price_top)
    ImageView ivSortPriceTop;
    @BindView(R.id.iv_sort_price_down)
    ImageView ivSortPriceDown;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.rl_goods)
    RelativeLayout rlGoods;
    private DataRepository dataRepository;
    private int page = 1;
    private GoodsAdapter goodsAdapter;
    private List<GoodsSearchModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private int sortType = 1;
    private boolean isPrice = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        etHomeSearch.setText(getIntent().getStringExtra("search"));

        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        goodsAdapter = new GoodsAdapter(this);
        recycleView.setAdapter(goodsAdapter);
        refresh.setOnRefreshLoadMoreListener(this);

        goodsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<GoodsSearchModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, GoodsSearchModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()) {
                    case R.id.iv_shop_car:
                        cartAdd(o.getGoods_sku().getGoods_id() + "", o.getGoods_sku().getSpec_sku_id(), 1);
                        break;
                    default:
                        Intent intent = new Intent(GoodsListActivity.this, GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", o.getGoods_sku().getGoods_id() + "");
                        startActivity(intent);
                        break;
                }
            }
        });

        goodsSearch(page, etHomeSearch.getText().toString(), "all", "0");
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

    private void goodsSearch(int page, String content, String type, String sortPrice) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        map.put("sortType", type);
        map.put("sortPrice", sortPrice);
        map.put("search", content);
        dataRepository.goodsSearch(map, new RemotDataSource.getCallback() {
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
                GoodsSearchModel goodsSearchModel = (GoodsSearchModel) data;
                if (goodsSearchModel.getCode() == 1) {
                    if (goodsSearchModel.getData().getList().getCurrent_page() == goodsSearchModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && goodsSearchModel.getData().getList().getData().size() == 0) {
                        rlEmpty.setVisibility(View.VISIBLE);
                        refresh.setVisibility(View.GONE);
                    } else {
                        rlEmpty.setVisibility(View.GONE);
                        refresh.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(goodsSearchModel.getData().getList().getData());
                        goodsAdapter.setData(dataBeanList);
                    }
                }
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        if (sortType == 1) {
            goodsSearch(page, etHomeSearch.getText().toString(), "all", "0");
        } else if (sortType == 2) {
            goodsSearch(page, etHomeSearch.getText().toString(), "sales", "0");
        } else if (sortType == 3) {
            if (isPrice) {
                goodsSearch(page, etHomeSearch.getText().toString(), "price", "0");
            } else {
                goodsSearch(page, etHomeSearch.getText().toString(), "price", "1");
            }
        }

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        if (sortType == 1) {
            goodsSearch(page, etHomeSearch.getText().toString(), "all", "0");
        } else if (sortType == 2) {
            goodsSearch(page, etHomeSearch.getText().toString(), "sales", "0");
        } else if (sortType == 3) {
            if (isPrice) {
                goodsSearch(page, etHomeSearch.getText().toString(), "price", "0");
            } else {
                goodsSearch(page, etHomeSearch.getText().toString(), "price", "1");
            }
        }
    }

    @OnClick({R.id.go_back, R.id.rl_search, R.id.tv_composite, R.id.tv_sales, R.id.rl_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                finish();
                break;
            case R.id.rl_search:
                if (getIntent().getIntExtra("pos", -1) == 1) {
                    Intent intent = new Intent(this, SearchActivity.class);
                    intent.putExtra("pos", 1);
                    startActivityForResult(intent, 1000);
                } else {
                    finish();
                }
                break;
            case R.id.tv_composite:
                tvComposite.setTextColor(0xffDA251D);
                tvSales.setTextColor(0xff111111);
                tvPrice.setTextColor(0xff111111);
                ivSortPriceTop.setImageResource(R.mipmap.sort_top);
                ivSortPriceDown.setImageResource(R.mipmap.sort_down);
                sortType = 1;
                page = 1;
                dataBeanList.clear();
                goodsSearch(page, etHomeSearch.getText().toString(), "all", "0");
                isPrice = true;
                break;
            case R.id.tv_sales:
                tvComposite.setTextColor(0xff111111);
                tvSales.setTextColor(0xffDA251D);
                tvPrice.setTextColor(0xff111111);
                ivSortPriceTop.setImageResource(R.mipmap.sort_top);
                ivSortPriceDown.setImageResource(R.mipmap.sort_down);
                sortType = 2;
                page = 1;
                dataBeanList.clear();
                goodsSearch(page, etHomeSearch.getText().toString(), "sales", "0");
                isPrice = true;
                break;
            case R.id.rl_price:
                if (isPrice) {
                    tvComposite.setTextColor(0xff111111);
                    tvSales.setTextColor(0xff111111);
                    tvPrice.setTextColor(0xffDA251D);
                    ivSortPriceTop.setImageResource(R.mipmap.sort_top_red);
                    ivSortPriceDown.setImageResource(R.mipmap.sort_down);
                    sortType = 3;
                    page = 1;
                    dataBeanList.clear();
                    goodsSearch(page, etHomeSearch.getText().toString(), "price", "0");
                    isPrice = false;
                } else {
                    tvComposite.setTextColor(0xff111111);
                    tvSales.setTextColor(0xff111111);
                    tvPrice.setTextColor(0xffDA251D);
                    ivSortPriceTop.setImageResource(R.mipmap.sort_top);
                    ivSortPriceDown.setImageResource(R.mipmap.sort_down_red);
                    sortType = 3;
                    page = 1;
                    dataBeanList.clear();
                    goodsSearch(page, etHomeSearch.getText().toString(), "price", "1");
                    isPrice = true;
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 1001) {
            if (data != null) {
                etHomeSearch.setText(data.getStringExtra("search"));
                page = 1;
                dataBeanList.clear();
                goodsSearch(page, data.getStringExtra("search"), "all", "0");
            }
        }
    }
}