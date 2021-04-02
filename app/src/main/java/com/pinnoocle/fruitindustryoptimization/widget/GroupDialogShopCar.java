package com.pinnoocle.fruitindustryoptimization.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.core.BottomPopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.SharingGoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.home.GroupOrderConfirmActivity;
import com.pinnoocle.fruitindustryoptimization.home.OrderConfirmActivity;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.login.LoginActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ren.qinc.numberbutton.NumberButton;

public class GroupDialogShopCar extends BottomPopupView implements View.OnClickListener {

    private  int type = 10;
    private SharingGoodsDetailModel.DataBean dataBean;
    private String spec_sku_id;
    //    private GoodsDetailModel.DataBean.SpecDataBean specData;
    private FragmentManager fm;
    //    private List<SkuView> skuViews = new ArrayList<>();
    private ArrayList<String> imageList = new ArrayList<>();
    private Context context;
    private ImageView ivShop;
    private TextView tvPrice;
    private TextView tvStock;
    private ImageView ivClose;
    private LinearLayout mSkuView;
    private NumberButtonExt numberButton;
    private TextView tvBuy;
    private List<String> item_ids = new ArrayList<>();
    private DataRepository dataRepository;
    private String item_id;

    private int goods_sku_id;
    private TextView tvAddCart;


    public GroupDialogShopCar(@NonNull Context context, FragmentManager fm, SharingGoodsDetailModel.DataBean dataBean,int type) {
        super(context);
        this.fm = fm;
        this.context = context;
        this.dataBean = dataBean;
//        this.specData = dataBean.getSpecData();
        this.spec_sku_id = dataBean.getDetail().getGoods_sku().getSpec_sku_id();
        this.type = type;

    }


    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_group_shop_car;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initView();
        initListener();
        initNumberButton(numberButton);
//        EventBus.getDefault().register(this);
    }

    private void initNumberButton(NumberButtonExt numberButton) {
        numberButton.setCurrentNumber(1);
//        int buy_limit = dataBean.getBuy_limit();
        int stock = dataBean.getDetail().getGoods_stock();
        numberButton
                .setInventory(stock)
                .setOnWarnListener(new NumberButton.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        ToastUtils.showToast("当前库存:" + inventory);
                    }

                    @Override
                    public void onWarningForBuyMax(int buyMax) {
                        ToastUtils.showToast("超过最大购买数:" + buyMax);
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


    private void initListener() {
        ivClose.setOnClickListener(this);
        ivShop.setOnClickListener(this);
        tvBuy.setOnClickListener(this);
        tvAddCart.setOnClickListener(this);

    }

    private void initView() {

        ivShop = findViewById(R.id.iv_shop);
        tvPrice = findViewById(R.id.tv_price);
        tvStock = findViewById(R.id.tv_stock);
        ivClose = findViewById(R.id.iv_close);
        mSkuView = findViewById(R.id.mSkuView);
        numberButton = findViewById(R.id.number_button);
        tvBuy = findViewById(R.id.tv_buy);
        tvAddCart = findViewById(R.id.tv_add_cart);

        initData();
    }

    private void initData() {
        dataRepository = Injection.dataRepository(getContext());
//        if (specData != null) {
//            List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX> spec_attr = specData.getSpec_attr();
//            initSpec(spec_attr);
//
//        }
        SharingGoodsDetailModel.DataBean.DetailBean.GoodsSkuBean goods_sku = dataBean.getDetail().getGoods_sku();
        if (goods_sku.getImage() != null) {

            Glide.with(context).load(dataBean.getDetail().getGoods_image()).fitCenter().into(ivShop);
        } else {
            Glide.with(context).load(dataBean.getDetail().getGoods_image()).fitCenter().into(ivShop);
        }
        tvStock.setText("库存" + goods_sku.getStock_num() + "件");

        if(type==10) {
            tvPrice.setText("￥" + goods_sku.getGoods_price());
        }else {
            tvPrice.setText("￥" + goods_sku.getSharing_price());
        }

        goods_sku_id = goods_sku.getGoods_sku_id();
        imageList.add(dataBean.getDetail().getGoods_image());
    }

//    private void initSpec(List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX> spec_attr) {
//
//        for (int i = 0; i < spec_attr.size(); i++) {
//            String group_name = spec_attr.get(i).getGroup_name();
//            SkuView skuView = new SkuView(context);
//            List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX.SpecItemsBeanX> spec_items = spec_attr.get(i).getSpec_items();
//            skuView.setSkuData(group_name, spec_items);
//            skuViews.add(skuView);
//            mSkuView.addView(skuView);
//        }
//    }

//    private void getProductInfo(String id) {
//        item_ids.clear();
//        imageList.clear();
//        for (int i = 0; i < skuViews.size(); i++) {
//            Integer next = skuViews.get(i).getFlowlayout().getSelectedList().iterator().next();
//            String item_id = skuViews.get(i).getData().get(next).getItem_id();
//            item_ids.add(item_id);
//        }
//        if (item_ids.size() == skuViews.size()) {
//            item_id = "";
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < item_ids.size(); i++) {
//                if (i == item_ids.size() - 1) {
//                    sb.append(item_ids.get(i));
//                } else {
//                    sb.append(item_ids.get(i) + "_");
//                }
//            }
//            item_id = sb.toString();
//            List<GoodsDetailModel.DataBean.SpecDataBean.SpecListBeanX> spec_list = specData.getSpec_list();
//            for (int i = 0; i < spec_list.size(); i++) {
//                if (spec_list.get(i).getSpec_sku_id().equals(item_id)) {
//                    goods_sku_id = spec_list.get(i).getGoods_sku_id();
//                    GoodsDetailModel.DataBean.SpecDataBean.SpecListBeanX.FormBeanX form = spec_list.get(i).getForm();
//                    Glide.with(context).load(form.getImage_path()).fitCenter().into(ivShop);
//                    imageList.add(form.getImage_path());
//                    tvStock.setText("库存" + form.getStock_num() + "件");
//                    if (type.equals("vip")) {
//                        tvPrice.setText("￥" + form.getBalance_price());
//                    } else {
//                        tvPrice.setText("￥" + form.getGoods_price());
//                    }
//                }
//
//            }
//        }
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                dismiss();
                break;
            case R.id.tv_buy:
//                if (skuViews.size() != 0) {
//
//                    if (skuViews.get(0).isSelectNone()) {
//                        ToastUtils.showToast("请选择商品规格");
//                        return;
//                    }
//                    if (type.equals("add_shop_cart")) {
//                        cartAdd();
//                    } else {
//                        sureOrder();
//                    }
//                }else {
//                    if (type.equals("add_shop_cart")) {
//                        cartAdd();
//                    } else {
                sureOrder();
//                    }
//
//                }

//                ToastUtils.showToast("暂不支持支付");
//                Intent intent = new Intent(getContext(), OrderConfirmActivity.class);
//                getContext().startActivity(intent);
                break;
            case R.id.iv_shop:
                viewPluImg(imageList, 0);
                break;
            case R.id.tv_add_cart:
                cartAdd();
                break;
        }
    }

    private void sureOrder() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            getContext().startActivity(intent);
            return;
        }
        Intent intent = new Intent(context, GroupOrderConfirmActivity.class);
        intent.putExtra("goods_id", dataBean.getDetail().getGoods_id() + "");
        intent.putExtra("order_type", type + "");
        intent.putExtra("goods_num", numberButton.getNumber() + "");
        context.startActivity(intent);
        dismiss();
    }

    private void cartAdd() {
        if (TextUtils.isEmpty(FastData.getToken())) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            getContext().startActivity(intent);
            return;
        }
        ViewLoading.show(context);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/add");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", dataBean.getDetail().getGoods_id() + "");
        map.put("goods_sku_id", goods_sku_id + "");
        map.put("goods_num", numberButton.getNumber() + "");
        dataRepository.cartAdd(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(context);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(context);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    dismiss();
                }
                ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }


    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(getContext(), TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        getContext().startActivity(imgIntent);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
//    public void onEvent(TagRefleshEvent event) {
//        String id = event.getId();
//        getProductInfo(id);
//    }


}