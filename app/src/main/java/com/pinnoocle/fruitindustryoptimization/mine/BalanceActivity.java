package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.WalletModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BalanceActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.rl_balance_detail)
    RelativeLayout rlBalanceDetail;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.tv_withdrawal)
    TextView tvWithdrawal;
    private DataRepository dataRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        wallet();
    }

    private void wallet() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.wallet/index");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.wallet(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                WalletModel walletModel = (WalletModel) data;
                if (walletModel.getCode() == 1) {
                    tvMoney.setText(walletModel.getData().getUserInfo().getBalance());
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.rl_balance_detail, R.id.tv_recharge, R.id.tv_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_balance_detail:
                startActivity(new Intent(this, BalanceDetailActivity.class));
                break;
            case R.id.tv_recharge:
                startActivity(new Intent(this, RechargeActivity.class));
                break;
            case R.id.tv_withdrawal:
                startActivity(new Intent(this, WithdrawalActivity.class));
                break;
        }
    }
}