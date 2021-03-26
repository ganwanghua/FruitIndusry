package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.MyApp;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GoodsAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsSearchModel;
import com.pinnoocle.fruitindustryoptimization.bean.HistoryBean;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.greendao.HistoryBeanDao;
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
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements AutoFlowLayout.OnItemClickListener, OnRefreshLoadMoreListener {

    @BindView(R.id.go_back)
    ImageView goBack;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_home_search)
    EditText etHomeSearch;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;
    @BindView(R.id.flow_layout)
    AutoFlowLayout flowLayout;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    @BindView(R.id.rl_goods)
    RelativeLayout rlGoods;
    private List<HistoryBean> historyList = new ArrayList<>();
    private DataRepository dataRepository;
    private int page = 1;
    private GoodsAdapter goodsAdapter;
    private List<GoodsSearchModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        dataRepository = Injection.dataRepository(this);
        historyList = MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().orderDesc(HistoryBeanDao.Properties.Id).list();
        if (historyList != null && historyList.size() > 0) {
            flowLayout.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
            flowLayout.setAdapter(new FlowAdapter(historyList) {
                @Override
                public View getView(int position) {
                    View item = LayoutInflater.from(SearchActivity.this).inflate(R.layout.special_item, null);
                    TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                    tvAttrTag.setText(historyList.get(position).getName());
                    return item;
                }
            });
        }
        flowLayout.setOnItemClickListener(this);

        etHomeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivClose.setVisibility(View.VISIBLE);
                } else {
                    ivClose.setVisibility(View.GONE);
                }
            }
        });

        recycleView.setLayoutManager(new GridLayoutManager(this, 2));
        goodsAdapter = new GoodsAdapter(this);
        recycleView.setAdapter(goodsAdapter);
        refresh.setOnRefreshLoadMoreListener(this);

        goodsAdapter.setmOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<GoodsSearchModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, GoodsSearchModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()) {
                    case R.id.iv_shop_car:
                        cartAdd(o.getGoods_sku().getGoods_id() + "", o.getGoods_sku().getSpec_sku_id(), 1);
                        break;
                    default:
                        Intent intent = new Intent(SearchActivity.this, GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", o.getGoods_sku().getGoods_id() + "");
                        startActivity(intent);
                        break;
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

    @Override
    public void onItemClick(int i, View view) {
        etHomeSearch.setText(historyList.get(i).getName());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
        HistoryBean history = new HistoryBean();
        history.setName(etHomeSearch.getText().toString());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
        llHistory.setVisibility(View.GONE);
        rlGoods.setVisibility(View.VISIBLE);
        goodsSearch(page, etHomeSearch.getText().toString());
    }

    @OnClick({R.id.go_back, R.id.tv_search, R.id.iv_close, R.id.iv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                finish();
                break;
            case R.id.tv_search:
                if (etHomeSearch.getText().toString().equals("")) {
                    ToastUtils.showToast("搜索内容不能为空");
                } else {
                    ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getWindow().getDecorView().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
                    HistoryBean history = new HistoryBean();
                    history.setName(etHomeSearch.getText().toString());
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
                    llHistory.setVisibility(View.GONE);
                    rlGoods.setVisibility(View.VISIBLE);
                    goodsSearch(page, etHomeSearch.getText().toString());
                }
                break;
            case R.id.iv_close:
                etHomeSearch.setText("");
                break;
            case R.id.iv_delete:
                MyApp.getInstance().getDaoSession().getHistoryBeanDao().deleteAll();
                flowLayout.clearViews();
                tvHint.setVisibility(View.VISIBLE);
                flowLayout.setVisibility(View.GONE);
                ivDelete.setVisibility(View.GONE);
                break;
        }
    }

    private void goodsSearch(int page, String content) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("page", page + "");
        map.put("sortType", "all");
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
                    } else {
                        rlEmpty.setVisibility(View.GONE);
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
        goodsSearch(page, etHomeSearch.getText().toString());
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        goodsSearch(page, etHomeSearch.getText().toString());
    }
}
