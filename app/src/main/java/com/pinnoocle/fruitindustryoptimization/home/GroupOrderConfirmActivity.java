package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderConfirmAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.SelectCouponsAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.BuyNowModel;
import com.pinnoocle.fruitindustryoptimization.bean.ResultModel;
import com.pinnoocle.fruitindustryoptimization.bean.RightBuyModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.mine.AddressActivity;
import com.pinnoocle.fruitindustryoptimization.mine.GroupOrderActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupOrderConfirmActivity extends BaseActivity {

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
    private String order_type ;
    private String pay_type = "10";

    private SelectCouponsAdapter selectCouponsAdapter;
    private TDialog dialog;
    private List<BuyNowModel.DataBean.CouponBean> coupon_list;
    private String coupon_id;


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
        order_type = getIntent().getStringExtra("order_type");
        groupBuy();

    }

    private void groupBuy() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.order/checkout");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("delivery", "0");
        map.put("order_type", order_type);
        map.put("goods_num", getIntent().getStringExtra("goods_num"));
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_sku_id", "0");
        if (!TextUtils.isEmpty(coupon_id))
            map.put("coupon_id", coupon_id);

        dataRepository.groupBuy(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                BuyNowModel buyNowModel = (BuyNowModel) data;
                if (buyNowModel.getCode() == 1) {
                    tvTotalMoney.setText("???" + buyNowModel.getData().getOrder_total_price());
                    coupon_list = buyNowModel.getData().getCoupon_list();
                    if (coupon_list != null && coupon_list.size() > 0) {
                        tvCoupon.setText("???" + buyNowModel.getData().getCoupon_list().size() + "??????????????????");
                    } else {
                        tvCoupon.setText("??????????????????");
                    }
                    if(buyNowModel.getData().getCoupon_money()>0){
                        tvCoupon.setText("-???"+buyNowModel.getData().getCoupon_money());
                    }
                    if (buyNowModel.getData().getAddress() != null) {
                        rlName.setVisibility(View.VISIBLE);
                        tvName.setText(buyNowModel.getData().getAddress().getName());
                        tvAddress.setText(buyNowModel.getData().getAddress().getRegion().toString() + buyNowModel.getData().getAddress().getDetail());
                        tvPhone.setText(buyNowModel.getData().getAddress().getPhone());
                        address_id = buyNowModel.getData().getAddress().getAddress_id() + "";
                    } else {
                        rlName.setVisibility(View.GONE);
                        tvAddress.setText("?????????????????????");
                        tvDeliveryFee.setText("????????????????????????");
                    }
                    tvActualPaymentMoney.setText("???" + buyNowModel.getData().getOrder_pay_price());
                    List<BuyNowModel.DataBean.GoodsListBean> goods_list = buyNowModel.getData().getGoods_list();
                    adapter.setData(goods_list);
                }
            }
        });
    }

    private void groupRightBuy() {
        ViewLoading.show(mContext);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.order/checkout");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("delivery", "0");
        map.put("order_type", order_type);
        map.put("goods_num", getIntent().getStringExtra("goods_num"));
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("goods_sku_id", "0");
        map.put("remark", "");
        map.put("pay_type", pay_type);
        map.put("platform", "app");

        dataRepository.groupRightBuy(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                ResultModel statusModel = (ResultModel) data;
                if (statusModel.getCode() == 1) {
                    RightBuyModel rightBuyModel = new Gson().fromJson(statusModel.getData(), RightBuyModel.class);
                    ToastUtils.showToast("????????????");
                    startActivity(new Intent(mContext, GroupOrderActivity.class));
                    finish();
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
                    groupBuy();
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
            groupBuy();
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_address, R.id.tv_go_buy,R.id.rl_coupon})
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
                    ToastUtils.showToast("?????????????????????");
                    return;
                }
//                if (Double.parseDouble(sureOrderData.getOrder_pay_price()) <= 0) {
//                    pay_type = "10";                    //0?????????
//                }
//                if (getIntent().getStringExtra("cart_ids") != null) {
//                    buyNowCart(getIntent().getStringExtra("cart_ids"));
//                } else {
                groupRightBuy();
//                }

                break;
            case R.id.rl_coupon:
                if (coupon_list != null && coupon_list.size() > 0) {
                    showSelectCouponsDialog(coupon_list);
                }
                break;
        }
    }
    private void showSelectCouponsDialog(List<BuyNowModel.DataBean.CouponBean> list) {
        dialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_select_coupons)
                .setScreenWidthAspect(this, 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(true)
                .addOnClickListener(R.id.tv_no_use)
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        if(view.getId()==R.id.tv_no_use){
                            coupon_id = "";
                            tDialog.dismiss();
                        }
                    }
                })
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        RecyclerView recyclerView = viewHolder.itemView.findViewById(R.id.recyclerView);
                        TextView tv_empty = viewHolder.itemView.findViewById(R.id.tv_empty);
                        if (list.size() == 0 || list == null) {
                            tv_empty.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.GONE);
                        } else {
                            tv_empty.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                            if (selectCouponsAdapter == null) {
                                selectCouponsAdapter = new SelectCouponsAdapter(GroupOrderConfirmActivity.this);
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(GroupOrderConfirmActivity.this));
                            recyclerView.addItemDecoration(new CommItemDecoration(mContext, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
                            selectCouponsAdapter.setData(list);
                            recyclerView.setAdapter(selectCouponsAdapter);
                            selectCouponsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<BuyNowModel.DataBean.CouponBean>() {
                                @Override
                                public void onItemViewClick(View view, int position, BuyNowModel.DataBean.CouponBean o) {
                                    if (o != null) {
                                        coupon_id = o.getUser_coupon_id()+"";
                                        groupBuy();
                                    }
                                    dialog.dismiss();
                                }
                            });
                        }


                    }
                })
                .create();
        dialog.show();
    }

}
