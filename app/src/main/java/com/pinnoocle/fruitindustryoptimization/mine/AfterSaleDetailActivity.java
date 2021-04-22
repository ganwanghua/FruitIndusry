package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GridView2Adapter;
import com.pinnoocle.fruitindustryoptimization.bean.RefundDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.widget.WheelView;

public class AfterSaleDetailActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.ll_cancel)
    RelativeLayout llCancel;

    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.tv_person_name)
    TextView tvPersonName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_express_1)
    TextView tvExpress1;
    @BindView(R.id.tv_express)
    TextView tvExpress;
    @BindView(R.id.rl_express)
    RelativeLayout rlExpress;
    @BindView(R.id.tv_order_code_1)
    TextView tvOrderCode1;
    @BindView(R.id.ed_order_code)
    EditText edOrderCode;
    @BindView(R.id.rl_order_code)
    RelativeLayout rlOrderCode;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_goods_pattern)
    TextView tvGoodsPattern;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_goods_price)
    LinearLayout llGoodsPrice;
    @BindView(R.id.tv_order_pay_price)
    TextView tvOrderPayPrice;
    @BindView(R.id.ll_goods)
    LinearLayout llGoods;
    @BindView(R.id.ll_return)
    LinearLayout llReturn;
    @BindView(R.id.ll_express)
    LinearLayout llExpress;
    @BindView(R.id.nineGridImageView)
    NineGridImageView nineGridImageView;
    private DataRepository dataRepository;
    private List<RefundDetailModel.DataBean.ExpressListBean> expressList;
    private List<String> expressName = new ArrayList<>();
    private RefundDetailModel refundDetailModel;
    private String express_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_detail);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        refundDetail();
    }

    private void refundDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.refund/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_refund_id", getIntent().getStringExtra("order_refund_id"));
        dataRepository.refundDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                refundDetailModel = (RefundDetailModel) data;
                if (refundDetailModel.getCode() == 1) {
                    if (refundDetailModel.getData().getDetail().getStatus().getValue() == 0 && refundDetailModel.getData().getDetail().getIs_agree().getValue() != 0) {
                        llReturn.setVisibility(View.VISIBLE);
                        llExpress.setVisibility(View.VISIBLE);
                        tvSure.setVisibility(View.VISIBLE);

                    } else {
                        llReturn.setVisibility(View.GONE);
                        llExpress.setVisibility(View.GONE);
                        tvSure.setVisibility(View.GONE);

                    }
                    tvStatus.setText(refundDetailModel.getData().getDetail().getState_text());
                    Glide.with(mContext).load(refundDetailModel.getData().getDetail().getOrder_goods().getImage().getFile_path()).into(ivShop);
                    tvTitle.setText(refundDetailModel.getData().getDetail().getOrder_goods().getGoods_name());
                    tvPrice.setText(refundDetailModel.getData().getDetail().getOrder_goods().getGoods_price());
                    tvOrderPayPrice.setText(refundDetailModel.getData().getDetail().getOrder_goods().getTotal_pay_price());
                    tvNum.setText("x" + refundDetailModel.getData().getDetail().getOrder_goods().getTotal_num());
                    tvGoodsPattern.setText(refundDetailModel.getData().getDetail().getOrder_goods().getGoods_attr());
                    tvType.setText(refundDetailModel.getData().getDetail().getType().getText());
                    tvReason.setText(refundDetailModel.getData().getDetail().getApply_desc());
                    expressList = refundDetailModel.getData().getExpressList();
                    for (int i = 0; i < expressList.size(); i++) {
                        expressName.add(expressList.get(i).getExpress_name());
                    }
                    List<String> mList = new ArrayList<>();
                    for (int i = 0; i < refundDetailModel.getData().getDetail().getImage().size(); i++) {
                        mList.add(refundDetailModel.getData().getDetail().getImage().get(i).getFile_path());
                    }
                    nineGridImageView.setAdapter(new NineGridImageViewAdapter<String>() {
                        @Override
                        protected void onDisplayImage(Context context, ImageView imageView, String o) {
                            Glide.with(context)
                                    .load(o)
                                    .dontAnimate()
                                    .into(imageView);
                        }

                        @Override
                        protected void onItemImageClick(Context context, ImageView imageView, int index, List list) {
//                            viewPluImg((ArrayList<String>) list, index);
                        }
                    });
                    nineGridImageView.setImagesData(mList);
                    if (refundDetailModel.getData().getDetail().getAddress() != null) {
                        tvPersonName.setText(refundDetailModel.getData().getDetail().getAddress().getName());
                        tvAddress.setText(refundDetailModel.getData().getDetail().getAddress().getDetail());
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < refundDetailModel.getData().getDetail().getAddress().getPhone().length(); i++) {
                            char c = refundDetailModel.getData().getDetail().getAddress().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tvPhone.setText(sb.toString());
                    }

                }

            }
        });
    }

    private void refundDelivery() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.refund/delivery");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_refund_id", getIntent().getStringExtra("order_refund_id"));
        map.put("express_id", express_id);
        map.put("express_no",edOrderCode.getText().toString());
        dataRepository.refundDelivery(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if(statusModel.getCode()==1){
                    EventBus.getDefault().post("6");
                    finish();
                }
                ToastUtils.showToast(statusModel.getMsg());

            }});}



    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(mContext, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        mContext.startActivity(imgIntent);
    }


    private void showOption(List<String> sourceList, TextView textView, CallBack callBack) {
        OptionPicker picker1 = new OptionPicker(this, sourceList);
        picker1.setDividerRatio(WheelView.DividerConfig.FILL);
        picker1.setSubmitText("确定");
        picker1.setSubmitTextColor(0xffDA251D);
        picker1.setSubmitTextSize(16);
        picker1.setCancelText("取消");
        picker1.setCancelTextColor(0xff666666);
        picker1.setCancelTextSize(16);
        picker1.setTextColor(0xffDA251D);
        picker1.setDividerColor(0xffE6EAF0);
        picker1.setTopLineColor(0xffE6EAF0);
        picker1.setCycleDisable(true);

        picker1.setAnimationStyle(R.style.main_menu_anim_style);
        picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                textView.setText(item);
                picker1.setSelectedIndex(index);
                callBack.callBack(index);
            }
        });
        picker1.show();
    }


    @OnClick({R.id.iv_back, R.id.rl_express, R.id.tv_sure, R.id.ll_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_express:
                if (expressName != null && expressName.size() > 0) {
                    showOption(expressName, tvExpress, new CallBack() {
                        @Override
                        public void callBack(int position) {
                            express_id = expressList.get(position).getExpress_id()+"";
                        }
                    });
                }
                break;
            case R.id.tv_sure:
                if(TextUtils.isEmpty(tvExpress.getText().toString())){
                    ToastUtils.showToast("请选择快递公司");
                    return;
                }
                if(TextUtils.isEmpty(edOrderCode.getText().toString())){
                    ToastUtils.showToast("请输入快递单号");
                    return;
                }
                refundDelivery();
                break;
            case R.id.ll_goods:
                Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                intent.putExtra("goods_id", refundDetailModel.getData().getDetail().getOrder_goods().getGoods_id() + "");
                startActivity(intent);
                break;
        }
    }

    private interface CallBack {
        void callBack(int position);
    }
}
