package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.AdoptionOrderAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.RebateAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.MyBalanceModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RebateActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_rebate)
    TextView tvRebate;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    RebateAdapter rebateAdapter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebate);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rebateAdapter = new RebateAdapter(this);
        recycleView.setAdapter(rebateAdapter);

        myBalance();
    }

    private void myBalance() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/my_balance");
        map.put("wxapp_id", "10001");
        map.put("type", "60");
        map.put("token", FastData.getToken());
        dataRepository.myBalance(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                MyBalanceModel myBalanceModel = (MyBalanceModel) data;
                if (myBalanceModel.getCode() == 1) {
                    rebateAdapter.setData(myBalanceModel.getData().getList());
                    tvRebate.setText("我的返利：" + myBalanceModel.getData().getList().size() + "次");
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}