package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.MainActivity;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CertificateDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.AppManager;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ECertActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.imageView)
    ImageView imageView;
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
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_cert);
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
        dataRepository = Injection.dataRepository(this);

        certificateDetail();
    }

    private void certificateDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/certificate_detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_no", getIntent().getStringExtra("order_no"));
        map.put("tree_id", getIntent().getStringExtra("tree_id"));
        dataRepository.certificateDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CertificateDetailModel certificateDetailModel = (CertificateDetailModel) data;
                if (certificateDetailModel.getCode() == 1) {
                    tvName.setText(certificateDetailModel.getData().getName());
                    tvContent.setText(certificateDetailModel.getData().getContent());
                    tvOrder.setText(certificateDetailModel.getData().getTreeNum());
                    tvCompany.setText(certificateDetailModel.getData().getTreeComp());
                    tvTime.setText(certificateDetailModel.getData().getTreeDate());
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        EventBus.getDefault().post("11");
        Intent intent4 = new Intent(ECertActivity.this, MainActivity.class);
        intent4.putExtra("pos", 1);
        intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent4);
        finish();
    }
}