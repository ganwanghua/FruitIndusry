package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.pinnoocle.fruitindustryoptimization.MainActivity;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.Type;
import com.pinnoocle.fruitindustryoptimization.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaySuccessActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_success)
    TextView tvSuccess;
    @BindView(R.id.tv_go_home)
    TextView tvGoHome;
    @BindView(R.id.tv_go_class)
    TextView tvGoClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_success);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_go_home, R.id.tv_go_class})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_go_home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_go_class://去订单
                Intent intent1 = new Intent(this, OrderActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.putExtra("type", Type.Delivery);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

        EventBus.getDefault().post("8");
            }
        },100);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}