package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.AdoptAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdoptActivity extends BaseActivity implements AdoptAdapter.OnItemClickListener {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    AdoptAdapter adoptAdapter;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.banner)
    Banner banner;
    private DataRepository dataRepository;
    private List<TreesModel.DataBean.NewBannerBean> bannerList = new ArrayList<>();
    private TreesModel treesModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        initView();
    }

    private void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        adoptAdapter = new AdoptAdapter(this);
        recycleView.setAdapter(adoptAdapter);

        adoptAdapter.setOnItemClickListener(this);
        trees();
    }

    private void trees() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/trees");
        map.put("wxapp_id", "10001");
        map.put("land_id", "0");
        map.put("token", FastData.getToken());
        dataRepository.trees(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                treesModel = (TreesModel) data;
                if (treesModel.getCode() == 1) {
                    bannerList = treesModel.getData().getNewBanner();
                    initBanner();
                    adoptAdapter.setData(treesModel.getData().getTrees());
                }
            }
        });
    }

    private void initBanner() {
        banner.isAutoLoop(true)
                .setIndicator(new CircleIndicator(this))
                .setAdapter(new BannerImageAdapter<TreesModel.DataBean.NewBannerBean>(bannerList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, TreesModel.DataBean.NewBannerBean data, int position, int size) {
                        //图片加载自己实现
                        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(holder.itemView)
                                .load(data.getFile_path())
                                .into(holder.imageView);
                        holder.itemView.setOnClickListener(v -> {

                        });
                    }
                });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, AdoptDetailsActivity.class);
        intent.putExtra("id", treesModel.getData().getTrees().get(position).getTree_id() + "");
        intent.putExtra("number", treesModel.getData().getTrees().get(position).getNumber() + "");
        startActivity(intent);
    }
}