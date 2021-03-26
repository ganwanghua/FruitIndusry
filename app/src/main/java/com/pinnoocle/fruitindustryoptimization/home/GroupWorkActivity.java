package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.FragmentAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupWorkActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.xTablayout)
    XTabLayout xTablayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_work);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        groupWork();
    }

    private void groupWork() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.index/index");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.groupWork(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                GroupWorkModel groupWorkModel = (GroupWorkModel) data;
                if (groupWorkModel.getCode() == 1) {
                    titles.add("首页");
                    for (int i = 0; i < groupWorkModel.getData().getCategoryList().size(); i++) {
                        titles.add(groupWorkModel.getData().getCategoryList().get(i).getName());
                    }
                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new GroupWorkFragment(0));
                        } else {
                            fragments.add(new GroupWorkFragment(groupWorkModel.getData().getCategoryList().get(i - 1).getCategory_id()));
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}