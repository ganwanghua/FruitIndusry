package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
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

public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_wallet)
    ImageView ivWallet;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.iv_deliver_goods)
    ImageView ivDeliverGoods;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.iv_receiving_goods)
    ImageView ivReceivingGoods;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.iv_message_fill)
    ImageView ivMessageFill;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_deliver_goods)
    TextView tvDeliverGoods;
    @BindView(R.id.tv_receiving_goods)
    TextView tvReceivingGoods;
    @BindView(R.id.tv_message_fill)
    TextView tvMessageFill;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.ll_order_state)
    LinearLayout llOrderState;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.iv_line)
    ImageView ivLine;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.tv_total_merchandise)
    TextView tvTotalMerchandise;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_update_time)
    TextView tvUpdateTime;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        orderDetail();
    }

    private void orderDetail() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", getIntent().getStringExtra("order_id"));
        ViewLoading.show(mContext);
        dataRepository.orderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                OrderDetailModel orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    if (orderDetailModel.getData().getOrder().getState_text().equals("已取消")) {
                        llOrderState.setVisibility(View.GONE);
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("待付款")) {
                        view.setBackgroundResource(R.color.light_white);
                        view1.setBackgroundResource(R.color.light_white);
                        view2.setBackgroundResource(R.color.light_white);
                        ivDeliverGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivDeliverGoods.setImageResource(R.mipmap.deliver_goods_no);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvDeliverGoods.setTextColor(0x99ffffff);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已提交，请在2小时内完成支付~");
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已付款，待发货")) {
                        view1.setBackgroundResource(R.color.light_white);
                        view2.setBackgroundResource(R.color.light_white);
                        ivReceivingGoods.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivReceivingGoods.setImageResource(R.mipmap.receiving_goods_no);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvReceivingGoods.setTextColor(0x99ffffff);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单正在备货中~");
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已发货，待收货")) {
                        view2.setBackgroundResource(R.color.light_white);
                        ivMessageFill.setBackgroundResource(R.drawable.bg_light_white_stroke);
                        ivMessageFill.setImageResource(R.mipmap.message_fill_no);
                        tvMessageFill.setTextColor(0x99ffffff);
                        tvHint.setText("您的订单已发货，请这注意查收~");
                    } else if (orderDetailModel.getData().getOrder().getState_text().equals("已完成")) {
                        tvHint.setText("您的订单已完成，期待您的好评~");
                    }
                    tvName.setText(orderDetailModel.getData().getOrder().getAddress().getName());
                    if (!TextUtils.isEmpty(orderDetailModel.getData().getOrder().getAddress().getPhone()) && orderDetailModel.getData().getOrder().getAddress().getPhone().length() > 6) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < orderDetailModel.getData().getOrder().getAddress().getPhone().length(); i++) {
                            char c = orderDetailModel.getData().getOrder().getAddress().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tvPhone.setText(sb.toString());
                    }
                    tvAddress.setText(orderDetailModel.getData().getOrder().getAddress().getRegion().getProvince() + orderDetailModel.getData().getOrder().getAddress().getRegion().getCity()
                            + orderDetailModel.getData().getOrder().getAddress().getRegion().getRegion() + orderDetailModel.getData().getOrder().getAddress().getDetail());
                    tvTotalMoney.setText("¥" + orderDetailModel.getData().getOrder().getTotal_price());
                    tvDeliveryFee.setText("¥" + orderDetailModel.getData().getOrder().getExpress_price());
                    tvTotalMerchandise.setText("¥" + orderDetailModel.getData().getOrder().getOrder_price());
                    tvOrder.setText(orderDetailModel.getData().getOrder().getOrder_no());
                    tvUpdateTime.setText(orderDetailModel.getData().getOrder().getCreate_time());
                }
            }
        });
    }


    @OnClick({R.id.iv_back, R.id.tv_cancel, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_cancel:
                break;
            case R.id.tv_buy:
                break;
        }
    }
}
