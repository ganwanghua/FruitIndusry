package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.MyApp;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderConfirmAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.BuyNowModel;
import com.pinnoocle.fruitindustryoptimization.bean.LoginModel;
import com.pinnoocle.fruitindustryoptimization.bean.RightBuyModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.mine.AddressActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.pinnoocle.fruitindustryoptimization.MyApp.mWxApi;

public class OrderConfirmActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_gps)
    ImageView ivGps;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.tv_delivery_fee)
    TextView tvDeliveryFee;
    @BindView(R.id.iv_wechat)
    ImageView ivWechat;
    @BindView(R.id.iv_wechat_mark)
    ImageView ivWechatMark;
    @BindView(R.id.iv_balance)
    ImageView ivBalance;
    @BindView(R.id.iv_balance_mark)
    ImageView ivBalanceMark;
    @BindView(R.id.ed_remark)
    EditText edRemark;
    @BindView(R.id.tv_actual_payment)
    TextView tvActualPayment;
    @BindView(R.id.tv_actual_payment_money)
    TextView tvActualPaymentMoney;
    @BindView(R.id.tv_go_buy)
    TextView tvGoBuy;
    @BindView(R.id.rl_pay)
    RelativeLayout rlPay;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    private DataRepository dataRepository;
    private OrderConfirmAdapter adapter;
    private String address_id;
    private String pay_type = "20";//余额支付10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        adapter = new OrderConfirmAdapter(mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        if (!TextUtils.isEmpty(getIntent().getStringExtra("cart_ids"))) {
            orderCart();
        } else {
            buyNow();
        }
    }

    private void buyNow() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/order/buyNow");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("delivery", "0");
        map.put("pay_type", pay_type);
        map.put("goods_num", getIntent().getStringExtra("goods_num"));
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_sku_id", "0");

        dataRepository.buyNow(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                BuyNowModel buyNowModel = (BuyNowModel) data;
                if (buyNowModel.getCode() == 1) {
                    tvTotalMoney.setText("￥" + buyNowModel.getData().getOrder_total_price());
                    tvCoupon.setText("无优惠券可用");
                    if (buyNowModel.getData().getAddress() != null) {
                        rlName.setVisibility(View.VISIBLE);
                        tvName.setText(buyNowModel.getData().getAddress().getName());
                        tvAddress.setText(buyNowModel.getData().getAddress().getRegion().toString() + buyNowModel.getData().getAddress().getDetail());
                        tvPhone.setText(buyNowModel.getData().getAddress().getPhone());
                        address_id = buyNowModel.getData().getAddress().getAddress_id() + "";
                    } else {
                        rlName.setVisibility(View.GONE);
                        tvAddress.setText("请选择配送地址");
                        tvDeliveryFee.setText("请先选择配送地址");
                    }
                    tvActualPaymentMoney.setText("￥" + buyNowModel.getData().getOrder_pay_price());
                    List<BuyNowModel.DataBean.GoodsListBean> goods_list = buyNowModel.getData().getGoods_list();
                    adapter.setData(goods_list);
                }
            }
        });
    }

    private void rightBuy() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/order/buyNow");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("delivery", "0");
        map.put("pay_type", pay_type);
        map.put("goods_num", getIntent().getStringExtra("goods_num"));
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_sku_id", "0");
        map.put("platform", "app");

        dataRepository.rightBuy(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("cart_refresh");
                    RightBuyModel rightBuyModel = new Gson().fromJson(statusModel.getData(), RightBuyModel.class);
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }

    private void orderCart() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/order/cart");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("delivery", "0");
        map.put("pay_type", pay_type);
        map.put("cart_ids", getIntent().getStringExtra("cart_ids"));


        dataRepository.orderCart(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                BuyNowModel buyNowModel = (BuyNowModel) data;
                if (buyNowModel.getCode() == 1) {
                    tvTotalMoney.setText("￥" + buyNowModel.getData().getOrder_total_price());
                    tvCoupon.setText("无优惠券可用");
                    if (buyNowModel.getData().getAddress() != null) {
                        rlName.setVisibility(View.VISIBLE);
                        tvName.setText(buyNowModel.getData().getAddress().getName());
                        tvAddress.setText(buyNowModel.getData().getAddress().getRegion().toString() + buyNowModel.getData().getAddress().getDetail());
                        tvPhone.setText(buyNowModel.getData().getAddress().getPhone());
                        address_id = buyNowModel.getData().getAddress().getAddress_id() + "";
                    } else {
                        rlName.setVisibility(View.GONE);
                        tvAddress.setText("请选择配送地址");
                        tvDeliveryFee.setText("请先选择配送地址");
                    }
                    tvActualPaymentMoney.setText("￥" + buyNowModel.getData().getOrder_pay_price());
                    List<BuyNowModel.DataBean.GoodsListBean> goods_list = buyNowModel.getData().getGoods_list();
                    adapter.setData(goods_list);
                }
            }
        });
    }

    private void rightBuyCart() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/order/cart");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("cart_ids", getIntent().getStringExtra("cart_ids"));
        map.put("pay_type", pay_type);
        map.put("platform", "app");

        dataRepository.rightBuyCart(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("cart_refresh");
                    RightBuyModel rightBuyModel = new Gson().fromJson(statusModel.getData(), RightBuyModel.class);
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9 && resultCode == RESULT_OK) {

            if (data.getSerializableExtra("result") != null) {
                Serializable result = data.getSerializableExtra("result");
                AddressListModel.DataBean.ListBean userShipBean = (AddressListModel.DataBean.ListBean) result;
                if (userShipBean == null) {
                    buyNow();
                } else {
                    rlName.setVisibility(View.VISIBLE);
                    address_id = userShipBean.getAddress_id() + "";
                    tvName.setText(userShipBean.getName());
                    String phone = userShipBean.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    tvPhone.setText(phone);
                    tvAddress.setText(userShipBean.getRegion().getProvince() + userShipBean.getRegion().getCity() + userShipBean.getRegion().getRegion());
                }

            }
        }
        if (requestCode == 9 && resultCode == 1001) {
            buyNow();
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_go_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_address:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("from", "from");
                startActivityForResult(intent, 9);
                break;
            case R.id.tv_go_buy:
                if (TextUtils.isEmpty(address_id)) {
                    ToastUtils.showToast("请输入收货地址");
                    return;
                }
//                if (Double.parseDouble(sureOrderData.getOrder_pay_price()) <= 0) {
//                    pay_type = "10";                    //0元支付
//                }
//                if (getIntent().getStringExtra("cart_ids") != null) {
//                    buyNowCart(getIntent().getStringExtra("cart_ids"));
//                } else {

//                }
                if (!TextUtils.isEmpty(getIntent().getStringExtra("cart_ids"))) {
                    rightBuyCart();
                } else {
                    rightBuy();
                }
                break;
        }
    }

}
