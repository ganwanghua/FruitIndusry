package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
import com.pinnoocle.fruitindustryoptimization.bean.ActiveDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.GroupRuleModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.GroupGoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.home.GroupWorkActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.CountDownHelper;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupWorkDetailActivity extends BaseActivity {

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
    @BindView(R.id.tv_person_num)
    TextView tvPersonNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_invite)
    LinearLayout llInvite;
    @BindView(R.id.tv_tip_title)
    TextView tvTipTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_tip)
    RelativeLayout llTip;
    private GroupWorkAdapter groupWorkAdapter;
    private DataRepository dataRepository;
    private String content;
    private ActiveDetailModel activeDetailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_work_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        groupWorkAdapter = new GroupWorkAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 5));
        recyclerView.setAdapter(groupWorkAdapter);
    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        activeDetail();
        groupRule();
    }

    private void activeDetail() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.active/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("active_id", getIntent().getStringExtra("active_id"));

        ViewLoading.show(mContext);
        dataRepository.activeDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                activeDetailModel = (ActiveDetailModel) data;
                if (activeDetailModel.getCode() == 1) {
                    Glide.with(mContext).load(activeDetailModel.getData().getGoods().getGoods_image()).into(ivShop);
                    tvTitle.setText(activeDetailModel.getData().getGoods().getGoods_name());
                    tvPrice.setText("￥" + activeDetailModel.getData().getGoods().getGoods_sku().getSharing_price());

                    tvNum.setText(activeDetailModel.getData().getDetail().getPeople() + "人团");
                    tvPersonNum.setText(activeDetailModel.getData().getDetail().getSurplus_people() + "人");

                    List<ActiveDetailModel.DataBeanX.DetailBean.UsersBean> users = activeDetailModel.getData().getDetail().getUsers();
                    List<ActiveDetailModel.DataBeanX.DetailBean.UsersBean> all = new ArrayList<>();
                    all.addAll(users);
                    for (int i = 0; i < activeDetailModel.getData().getDetail().getSurplus_people(); i++) {
                        all.add(new ActiveDetailModel.DataBeanX.DetailBean.UsersBean());
                    }
                    groupWorkAdapter.setData(all);
                    long endtime = (activeDetailModel.getData().getDetail().getEnd_time().getValue()) * 1000;
                    long currentTime = System.currentTimeMillis();
                    long time = (endtime - currentTime);
                    CountDownHelper countDownHelper = new CountDownHelper(time);
                    countDownHelper.startCompute();
                    countDownHelper.setOnCountDownListener(new CountDownHelper.OnCountDownListener() {
                        @Override
                        public void countDown(String day, String hour, String minute, String second) {
                            tvTime.setText(hour + ":" + minute + ":" + second);
                        }

                        @Override
                        public void countDownFinish() {
                            llInvite.setEnabled(false);
                        }
                    });


                }

            }
        });
    }

    private void groupRule() {

        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.setting/getAll");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.groupRule(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                GroupRuleModel groupRuleModel = (GroupRuleModel) data;
                if(groupRuleModel.getCode()==1){
                    content = groupRuleModel.getData().getSetting().getBasic().getRule_detail();
                    tvContent.setText(groupRuleModel.getData().getSetting().getBasic().getRule_brief());
                }


            }
        });
    }
    private void showRuleDialog(String content) {
        TDialog tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_rule)
                //设置弹窗展示的xml布局
                .setCancelableOutside(false)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText(content);
                    }
                })
                .addOnClickListener(R.id.close)
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()){
                            case R.id.close:
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()   //创建TDialog
                .show();//展示
    }




    @OnClick({R.id.iv_back, R.id.ll_invite, R.id.tv_more, R.id.ll_tip,R.id.rl_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_invite:
                break;
            case R.id.tv_more:
                startActivity(new Intent(mContext, GroupWorkActivity.class));
                break;
            case R.id.ll_tip:
                showRuleDialog(content);
                break;
            case R.id.rl_goods:
                Intent intent = new Intent(mContext, GroupGoodsDetailsActivity.class);
                intent.putExtra("goods_id", activeDetailModel.getData().getGoods().getGoods_id() + "");
                startActivity(intent);
                break;
        }
    }
}
