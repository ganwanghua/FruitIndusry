package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dd.ShadowLayout;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GoodListAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.GridViewAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.HomeModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipIntroModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.orchard.AdoptActivity;
import com.pinnoocle.fruitindustryoptimization.orchard.AdoptionAgreementActivity;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.GridViewInScrollView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class HomeFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.gridView)
    GridViewInScrollView gridView;
    @BindView(R.id.scrollview)
    NestedScrollView scrollview;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.rl_marqueeView)
    RelativeLayout llMarqueeView;
    @BindView(R.id.jz_video)
    JzvdStd jzVideo;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.classic)
    ImageView classic;
    @BindView(R.id.iv_special)
    ImageView ivSpecial;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.upload_event)
    ImageView uploadEvent;
    @BindView(R.id.fab)
    ShadowLayout fab;
    private List<HomeModel.DataBeanX.ItemsBean.DataBean> bannerList = new ArrayList<>();
    private List<HomeModel.DataBeanX.ItemsBean.DataBean> dataBeans = new ArrayList<>();
    private DataRepository dataRepository;
    private GridViewAdapter gridViewAdapter;
    private List<String> titles = new ArrayList<>();
    private List<Integer> ids = new ArrayList<>();
    private GoodListAdapter adapter;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initGoodList();
    }

    @Override
    public void onStart() {
        super.onStart();
        marqueeView.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView.stopFlipping();
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(mContext);
        home();
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                dataBeans.clear();
                home();
            }
        });
        gridView.setOnItemClickListener(this);
    }

    private void home() {
        ViewLoading.show(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/page/index");
        map.put("page_id", "0");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.home(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(mContext);
                HomeModel homeModel = (HomeModel) data;
                if (homeModel.getCode() == 1) {
                    for (int i = 0; i < homeModel.getData().getItems().size(); i++) {
                        if (i == 3) {
                            gridViewAdapter = new GridViewAdapter(getContext(), homeModel.getData().getItems().get(i).getData());
                            gridView.setAdapter(gridViewAdapter);
                            gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
                        } else if (i == 2) {
                            bannerList = homeModel.getData().getItems().get(i).getData();
                            initBanner();
                        } else if (i == 4) {
                            titles.clear();
                            for (int j = 0; j < homeModel.getData().getItems().get(i).getData().size(); j++) {
                                titles.add(homeModel.getData().getItems().get(i).getData().get(j).getArticle_title());
                                ids.add(homeModel.getData().getItems().get(i).getData().get(j).getArticle_id());
                            }
                            initMarqueeView(titles);
                        } else if (i == 5) {
                            initJzVideo(homeModel.getData().getItems().get(i).getParams().getPoster());
                        } else if (i == 6) {
                            Glide.with(getContext()).load(homeModel.getData().getItems().get(i).getData().get(0).getImgUrl()).into(ivImage);
                        } else if (i == 8) {
                            Glide.with(getContext()).load(homeModel.getData().getItems().get(i).getParams().getImage()).into(uploadEvent);
                        } else if (i == 9 || i == 10 || i == 11) {
                            dataBeans.addAll(homeModel.getData().getItems().get(i).getData());
                            adapter.setData(dataBeans);
                        }
                    }
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


    private void initMarqueeView(List<String> titles) {
        marqueeView.startWithList(titles);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Intent intent1 = new Intent(getContext(), ArticleActivity.class);
                intent1.putExtra("id", ids.get(position));
                startActivity(intent1);
            }
        });
    }

    private void initBanner() {
        banner.isAutoLoop(true)
                .setIndicator(new CircleIndicator(getContext()))
                .setBannerRound(BannerUtils.dp2px(10))
                .setAdapter(new BannerImageAdapter<HomeModel.DataBeanX.ItemsBean.DataBean>(bannerList) {
                    @Override
                    public void onBindView(BannerImageHolder holder, HomeModel.DataBeanX.ItemsBean.DataBean data, int position, int size) {
                        //图片加载自己实现
                        Glide.with(holder.itemView)
                                .load(data.getImgUrl())
                                .into(holder.imageView);
                        holder.itemView.setOnClickListener(v -> {
                            if (position == 0) {
                                ActivityUtils.startActivity(getActivity(), AdoptActivity.class);
                            } else if (position == 1) {
                            } else if (position == 2) {
                                Intent intent1 = new Intent(getContext(), ArticleActivity.class);
                                intent1.putExtra("id", Integer.parseInt(data.getLinkUrl().replace("\"", "").split("=")[1]));
                                startActivity(intent1);
                            } else if (position == 3) {
                                ActivityUtils.startActivity(getActivity(), AdoptActivity.class);
                            }
                        });
                    }
                });
    }

    private void initGoodList() {
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new GoodListAdapter(getContext());
        recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                Intent intent1 = new Intent(getContext(), GoodsDetailsActivity.class);
                intent1.putExtra("goods_id", dataBeans.get(position).getGoods_id());
                startActivity(intent1);
            }
        });

        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<HomeModel.DataBeanX.ItemsBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, HomeModel.DataBeanX.ItemsBean.DataBean o) {
                cartAdd(o.getGoods_sku().getGoods_id() + "", o.getGoods_sku().getSpec_sku_id(), 1);
                EventBus.getDefault().post("cart_refresh");
            }
        });
    }

    private void initJzVideo(String image) {
        jzVideo.setUp("http://1251316161.vod2.myqcloud.com/5f6ddb64vodsh1251316161/ece2c7df5285890812999168943/mKHguCyn6gIA.mp4"
                , "");
        Glide.with(getContext())
                .load(image)
                .into(jzVideo.posterImageView);
        jzVideo.fullscreenButton.setOnClickListener(v -> {
            ActivityUtils.startActivity(getContext(), VideoActivity.class);
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    public void onBackPressed() {
        if (jzVideo.backPress()) {
            return;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            ActivityUtils.startActivity(getActivity(), AdoptActivity.class);
        }else if (position == 3) {
            vipIntro();
        }else if (position == 1) {
            ActivityUtils.startActivity(getActivity(), SeckillActivity.class);
        }else if (position == 2) {
            ActivityUtils.startActivity(getActivity(), GroupWorkActivity.class);
        }
    }

    private void vipIntro() {
        ViewLoading.show(getContext());
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/vip_intro");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.vipIntro(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                VipIntroModel vipIntroModel = (VipIntroModel) data;
                if (vipIntroModel.getCode() == 1) {
                    Intent intent1 = new Intent(getContext(), AdoptionAgreementActivity.class);
                    intent1.putExtra("content", vipIntroModel.getData().getVip_intro());
                    intent1.putExtra("title", "兵团优选");
                    startActivity(intent1);
                }
            }
        });
    }

    @OnClick({R.id.ll_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_search:
                ActivityUtils.startActivity(getContext(), SearchActivity.class);
                break;
        }
    }
}
