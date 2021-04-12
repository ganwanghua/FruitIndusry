package com.pinnoocle.fruitindustryoptimization.mine;

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
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.GroupWorkFragment;
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

public class EvaluateActivity extends BaseActivity {

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
        setContentView(R.layout.activity_evaluate);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        myComment();
    }

    private void myComment() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/comment/user_lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("scoreType", "-1");
        map.put("page", "1");
        dataRepository.myComment(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                MyCommentModel myCommentModel = (MyCommentModel) data;
                if (myCommentModel.getCode() == 1) {
                    titles.add("全部(" + myCommentModel.getData().getTotal().getAll() + ")");
                    titles.add("好评(" + myCommentModel.getData().getTotal().getPraise() + ")");
                    titles.add("中评(" + myCommentModel.getData().getTotal().getReview() + ")");
                    titles.add("差评(" + myCommentModel.getData().getTotal().getNegative() + ")");

                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new EvaluateFragment("-1"));
                        } else if (i == 1) {
                            fragments.add(new EvaluateFragment("10"));
                        } else if (i == 2) {
                            fragments.add(new EvaluateFragment("20"));
                        } else if (i == 3) {
                            fragments.add(new EvaluateFragment("30"));
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