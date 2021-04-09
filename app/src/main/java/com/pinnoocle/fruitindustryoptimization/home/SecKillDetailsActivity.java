package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupWorkAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.SecKillDetailsAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.TaskDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.DrawLineTextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecKillDetailsActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_line_price)
    DrawLineTextView tvLinePrice;
    @BindView(R.id.ll_price)
    LinearLayout llPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_num1)
    TextView tvNum1;
    @BindView(R.id.ll_num)
    LinearLayout llNum;
    @BindView(R.id.tv_introduction)
    TextView tvIntroduction;
    @BindView(R.id.rl_goods)
    RelativeLayout rlGoods;
    @BindView(R.id.tv_secKill)
    TextView tvSecKill;
    @BindView(R.id.tv_tip_title)
    TextView tvTipTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_tip)
    LinearLayout llTip;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    private SecKillDetailsAdapter secKillDetailsAdapter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_kill_details);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        secKillDetailsAdapter = new SecKillDetailsAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 5));
        recyclerView.setAdapter(secKillDetailsAdapter);

        taskDetail();
    }

    private void taskDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.task/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("task_id", getIntent().getStringExtra("task_id"));
        dataRepository.taskDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                TaskDetailModel taskDetailModel = (TaskDetailModel) data;
                if (taskDetailModel.getCode() == 1) {
                    Glide.with(SecKillDetailsActivity.this).load(taskDetailModel.getData().getGoods().getGoods_image()).into(ivShop);
                    tvTitle.setText(taskDetailModel.getData().getGoods().getGoods_name());
                    tvPrice.setText("￥" + taskDetailModel.getData().getActive().getFloor_price());
                    tvLinePrice.setText("￥" + taskDetailModel.getData().getGoods().getGoods_sku().getGoods_price());
                    tvNum.setText("" + taskDetailModel.getData().getActive().getActive_sales());
                    tvNum1.setText("" + taskDetailModel.getData().getGoods().getGoods_stock());
                    tvIntroduction.setText(taskDetailModel.getData().getGoods().getSelling_point());
                    tvContent.setText(taskDetailModel.getData().getSetting().getBargain_rules());
                    tvNumber.setText("互动完成进度：" + taskDetailModel.getData().getTask().getCut_people() + "/" + taskDetailModel.getData().getTask().getPeoples());

                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_secKill})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_secKill:
                break;
        }
    }
}