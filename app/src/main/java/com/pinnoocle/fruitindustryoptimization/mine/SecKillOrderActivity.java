package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.FragmentAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecKillOrderActivity extends BaseActivity {
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_kill_order);
        ButterKnife.bind(this);

        titles.add("全部");
        titles.add("待付款");
        titles.add("待发货");
        titles.add("待收货");
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new SecKillOrderFragment("all"));
            } else if (i == 1) {
                fragments.add(new SecKillOrderFragment("payment"));
            } else if (i == 2) {
                fragments.add(new SecKillOrderFragment("delivery"));
            } else if (i == 3) {
                fragments.add(new SecKillOrderFragment("received"));
            }
        }
        FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adatper);
        viewPager.setOffscreenPageLimit(fragments.size());
        //将TabLayout和ViewPager关联起来。
        xTablayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}