package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pinnoocle.fruitindustryoptimization.MainActivity;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.AppManager;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.login.LoginActivity;
import com.pinnoocle.fruitindustryoptimization.mine.SettingActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ECertActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_time)
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_cert);
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        EventBus.getDefault().post("2");
        Intent intent4 = new Intent(ECertActivity.this, MainActivity.class);
        intent4.putExtra("pos",1);
        intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent4);
        finish();
    }
}