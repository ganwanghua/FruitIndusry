package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.login.LoginActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.CountDownTimerUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ModifyPhoneActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ed_phone)
    TextView edPhone;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.tv_new_phone)
    TextView tvNewPhone;
    @BindView(R.id.ed_new_phone)
    EditText edNewPhone;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_get_code1)
    TextView tvGetCode1;
    @BindView(R.id.tv_code1)
    TextView tvCode1;
    @BindView(R.id.ed_code1)
    EditText edCode1;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setColor(this.getWindow(), 0xffF6F6F6);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_phone);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        edPhone.setText(getIntent().getStringExtra("phone"));
    }

    @OnClick({R.id.iv_back, R.id.tv_get_code, R.id.tv_get_code1, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_get_code:
                sendMessages(edPhone.getText().toString());
                break;
            case R.id.tv_get_code1:
                String telRegex = "[1][3456789]\\d{9}";
                boolean matches = edNewPhone.getText().toString().matches(telRegex);
                if (TextUtils.isEmpty(edNewPhone.getText().toString())) {
                    ToastUtils.showToast("请输入手机号码");
                } else if (matches == false) {
                    ToastUtils.showToast("请输入正确的手机号码");
                } else {
                    //获取验证码
                    sendMessages1(edNewPhone.getText().toString());
                }
                break;
            case R.id.tv_sure:
                if (TextUtils.isEmpty(edCode.getText().toString())) {
                    ToastUtils.showToast("请输入验证码");
                    return;
                }
                if (TextUtils.isEmpty(edNewPhone.getText().toString())) {
                    ToastUtils.showToast("请输入新手机号码");
                    return;
                }
                if (TextUtils.isEmpty(edCode1.getText().toString())) {
                    ToastUtils.showToast("请输入验证码");
                    return;
                }
                changePhone(edCode.getText().toString(), edNewPhone.getText().toString(), edCode1.getText().toString());
                break;
        }
    }

    private void changePhone(String edCode, String edNewPhone, String edCode1) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/change_phone");
        map.put("wxapp_id", "10001");
        map.put("code1", edCode);
        map.put("newphone", edNewPhone);
        map.put("code2", edCode1);
        map.put("token", FastData.getToken());
        dataRepository.changePhone(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    ToastUtils.showToast("手机号修改成功，请重新登录");
                    FastData.clear();
                    Intent intent = new Intent(ModifyPhoneActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }

    private void sendMessages1(String phone) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/send_sms");
        map.put("wxapp_id", "10001");
        map.put("phone", phone);
        dataRepository.sms(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    ToastUtils.showToast("发送成功");
                    getCode1();
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }

    private void sendMessages(String phone) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/send_sms");
        map.put("wxapp_id", "10001");
        map.put("phone", phone);
        dataRepository.sms(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    ToastUtils.showToast("发送成功");
                    getCode();
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }

    private void getCode() {
        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(tvGetCode, 60000, 1000);
        countDownTimerUtils.start();
    }

    private void getCode1() {
        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(tvGetCode1, 60000, 1000);
        countDownTimerUtils.start();
    }
}