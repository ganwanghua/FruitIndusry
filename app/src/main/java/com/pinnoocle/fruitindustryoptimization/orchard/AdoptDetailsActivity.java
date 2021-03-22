package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.FragmentAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.TreesDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.GlideCircleTransform;
import com.pinnoocle.fruitindustryoptimization.widget.SwitchView;
import com.pinnoocle.fruitindustryoptimization.widget.VerticalMarqueeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class AdoptDetailsActivity extends BaseActivity {


    @BindView(R.id.fl_banner)
    FrameLayout flBanner;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_adopt)
    TextView tvAdopt;
    @BindView(R.id.switchView)
    SwitchView switchView;
    @BindView(R.id.tv_dollar)
    TextView tvDollar;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.marquee_root)
    VerticalMarqueeLayout marqueeRoot;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    private List<Fragment> mList = new ArrayList<>();
    private BannerImageFragment bannerImageFragment;
    private BannerVideoFragment bannerVideoFragment;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_details);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        initView();
    }

    private void initView() {
        treesDetail();

        switchView.setOnClickCheckedListener(new SwitchView.onClickCheckedListener() {
            @Override
            public void onClick() {
                if (switchView.isChecked()) {
                    switchFragment(mList.get(1));
                } else {
                    switchFragment(mList.get(0));
                }
            }
        });
    }

    private void treesDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/get_tree");
        map.put("wxapp_id", "10001");
        map.put("id", getIntent().getStringExtra("id"));
        map.put("month", getIntent().getStringExtra("number"));
        map.put("token", FastData.getToken());
        dataRepository.treesDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                TreesDetailModel treesDetailModel = (TreesDetailModel) data;
                if (treesDetailModel.getCode() == 1) {
                    initMarqueeView(treesDetailModel.getData().getRecord());
                    bannerImageFragment = new BannerImageFragment(treesDetailModel.getData().getTree().getImages());
                    bannerVideoFragment = new BannerVideoFragment();
                    mList.add(bannerImageFragment);
                    mList.add(bannerVideoFragment);
                    switchFragment(mList.get(0));

//                    tvMoney.setText(treesDetailModel.getData().getTree().getPrice_show());
                    tvAddress.setText(treesDetailModel.getData().getTree().getSub_title());
                    tvName.setText(treesDetailModel.getData().getTree().getTree_title());
                    tvSubTitle.setText(treesDetailModel.getData().getTree().getSub_title());

                    titles.add("商品详情");
                    titles.add("认养收获");
                    titles.add("成长轨迹");
                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new ShopDetailFragment(treesDetailModel.getData().getTree().getDetail1()));
                        }else if (i == 1) {
                            fragments.add(new ShopDetailFragment(treesDetailModel.getData().getTree().getDetail2()));
                        }else {
                            fragments.add(new ShopDetailFragment(treesDetailModel.getData().getTree().getDetail3()));
                        }
                    }
                    FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
                    viewPager.setAdapter(adatper);
                    viewPager.setOffscreenPageLimit(fragments.size());
                    //将TabLayout和ViewPager关联起来。
                    xTablayout.setupWithViewPager(viewPager);

                }
            }
        });
    }

    private void initMarqueeView(List<TreesDetailModel.DataBean.RecordBean> record) {
        List<View> views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < record.size(); i++) {
            views.add(inflateView(inflater, marqueeRoot, record.get(i).getAvatar(), record.get(i).getWord()));
        }
        marqueeRoot.setViewList(views);
    }

    private View inflateView(LayoutInflater inflater, VerticalMarqueeLayout marqueeRoot, String name, String desc) {
        if (inflater == null) {
            inflater = LayoutInflater.from(this);
        }
        View view = inflater.inflate(R.layout.marquee_item, marqueeRoot, false);
        ImageView viewName = view.findViewById(R.id.marquee_name);
        TextView viewDesc = view.findViewById(R.id.marquee_desc);
        Glide.with(this).load(name).apply(bitmapTransform(new GlideCircleTransform(this))).into(viewName);
        viewDesc.setText(desc);
        return view;
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_banner, fragment).commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (bannerVideoFragment != null) {
            bannerVideoFragment.onBackPressed();
        }
        super.onBackPressed();

    }

    @OnClick({R.id.iv_back, R.id.tv_adopt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_adopt:
                Intent intent = new Intent(this, ConfirmOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}