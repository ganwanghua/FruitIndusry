package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.FragmentAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.mine.EvaluateFragment;
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

public class EvaluationActivity extends BaseActivity {

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
        setContentView(R.layout.activity_evaluation);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        goodsComment();
    }

    private void goodsComment() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/comment/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id",getIntent().getStringExtra("goods_id"));
        map.put("scoreType", "-1");
        map.put("page", "1");
        dataRepository.goodsComment(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                MyCommentModel myCommentModel = (MyCommentModel) data;
                if (myCommentModel.getCode() == 1) {
                    titles.add("??????(" + myCommentModel.getData().getTotal().getAll() + ")");
                    titles.add("??????(" + myCommentModel.getData().getTotal().getPraise() + ")");
                    titles.add("??????(" + myCommentModel.getData().getTotal().getReview() + ")");
                    titles.add("??????(" + myCommentModel.getData().getTotal().getNegative() + ")");

                    for (int i = 0; i < titles.size(); i++) {
                        if (i == 0) {
                            fragments.add(new EvaluationFragment("-1"));
                        } else if (i == 1) {
                            fragments.add(new EvaluationFragment("10"));
                        } else if (i == 2) {
                            fragments.add(new EvaluationFragment("20"));
                        } else if (i == 3) {
                            fragments.add(new EvaluationFragment("30"));
                        }
                    }
                    FragmentAdapter adatper = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
                    viewPager.setAdapter(adatper);
                    viewPager.setOffscreenPageLimit(fragments.size());
                    //???TabLayout???ViewPager???????????????
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
