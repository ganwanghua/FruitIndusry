package com.pinnoocle.fruitindustryoptimization.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.ShoppingCartAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.event.CanSettlement;
import com.pinnoocle.fruitindustryoptimization.event.CartAllCheckedEvent;
import com.pinnoocle.fruitindustryoptimization.home.OrderConfirmActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.NumberButtonExt;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingCartFragment extends BaseFragment {

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.ll_del)
    LinearLayout llDel;
    @BindView(R.id.rl_select)
    RelativeLayout rlSelect;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.tv_all_select_1)
    TextView tvAllSelect1;
    @BindView(R.id.ll_all_select)
    LinearLayout llAllSelect;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    @BindView(R.id.iv_del)
    ImageView ivDel;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.tv_go_shop)
    TextView tvGoShop;
    @BindView(R.id.empty_shop_cart)
    LinearLayout emptyShopCart;
    private DataRepository dataRepository;
    private ShoppingCartAdapter adapter;
    private List<String> cartIdList;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_shopping_cart;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ShoppingCartAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setmOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<CartListsModel.DataBean.GoodsListBean>() {
            @Override
            public void onItemViewClick(View view, int position, CartListsModel.DataBean.GoodsListBean o) {
                switch (view.getId()){
                    case R.id.button_add:
                        cartAdd(o.getGoods_id()+"", o.getGoods_sku().getSpec_sku_id(),1);
                        o.setTotal_num(o.getTotal_num()+1);
                        break;
                    case R.id.button_sub:
                        if(o.getTotal_num()-1<1){
                            return;
                        }
                        cartSub(o.getGoods_id()+"", o.getGoods_sku().getSpec_sku_id(),1);
                        o.setTotal_num(o.getTotal_num()-1);
                        break;
                }
            }
        });

    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(mContext);
        cartList();
    }

    private void cartList() {
        ViewLoading.show(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.cartList(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CartListsModel cartListsModel = (CartListsModel) data;
                if (cartListsModel.getCode() == 1) {
                    List<CartListsModel.DataBean.GoodsListBean> goods_list = cartListsModel.getData().getGoods_list();
                    if (goods_list==null||goods_list.size() == 0) {
                        llContent.setVisibility(View.GONE);
                        rlPanel.setVisibility(View.GONE);
                        emptyShopCart.setVisibility(View.VISIBLE);

                    } else {
                        llContent.setVisibility(View.VISIBLE);
                        rlPanel.setVisibility(View.VISIBLE);
                        emptyShopCart.setVisibility(View.GONE);
                        adapter.setData(goods_list);
                        updateTotalPrice();
                    }
                }
            }
        });
    }

    private void cartDelete(String goods_sku_id) {
        ViewLoading.show(mContext);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/delete");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_sku_id", goods_sku_id);
        dataRepository.cartDelete(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    cartList();
                }

            }
        });
    }

    private void cartAdd(String goods_id,String goods_sku_id,int goods_num) {

        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/add");
        map.put("wxapp_id","10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", goods_id);
        map.put("goods_num",goods_num+"" );
        map.put("goods_sku_id", goods_sku_id);
        dataRepository.cartAdd(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {

                StatusModel statusModel = (StatusModel)data;
                if(statusModel.getCode()==1){
                    updateTotalPrice();
                }


            }
        });
    }

    private void cartSub(String goods_id,String goods_sku_id,int goods_num) {

        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/cart/sub");
        map.put("wxapp_id","10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", goods_id);
        map.put("goods_num",goods_num+"" );
        map.put("goods_sku_id", goods_sku_id);
        dataRepository.cartSub(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {

                StatusModel statusModel = (StatusModel)data;
                if(statusModel.getCode()==1){
                    updateTotalPrice();
                }


            }
        });
    }




    private void refreshEditStatus() {
        boolean isEditStatus = "管理" == tvEdit.getText().toString();
        String text;
        if (isEditStatus) {
            tvTotalPrice.setVisibility(View.GONE);
            ivDel.setVisibility(View.GONE);
            tvSettlement.setText("删 除");
            //删除按钮
            text = "完成";
        } else {
            text = "管理";
            ivDel.setVisibility(View.VISIBLE);
            tvTotalPrice.setVisibility(View.VISIBLE);
            tvSettlement.setText("去结算");

        }
        tvEdit.setText(text);
    }

    private String dealCartIdList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cartIdList.size(); i++) {
            if (i == cartIdList.size() - 1) {
                sb.append(cartIdList.get(i) + "");
            } else {
                sb.append(cartIdList.get(i) + ",");
            }
        }
        return sb.toString();
    }


    @OnClick({R.id.ll_del, R.id.tv_settlement, R.id.ll_all_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_del:
                refreshEditStatus();
                break;
            case R.id.tv_settlement:
                cartIdList = new ArrayList();
                List<CartListsModel.DataBean.GoodsListBean> adapterList = adapter.getData();
                for (int i = 0; i < adapterList.size(); i++) {
                    if (adapterList.get(i).isIs_select()) {
                        cartIdList.add(adapterList.get(i).getGoods_id() + "_" + adapterList.get(i).getGoods_sku_id());
                    }
                }
                if (tvSettlement.getText().toString().equals("删 除")) {
                    if (cartIdList.size() == 0) {
                        ToastUtils.showToast("请选择需要删除的商品");
                    } else {
                        String cartIds = dealCartIdList();
                        cartDelete(cartIds);
                    }
                } else {
                    if (cartIdList.size() == 0) {
                        ToastUtils.showToast("请选择需要购买的数据");
                    } else {
                        String cart_ids = dealCartIdList();
                        Intent intent = new Intent(mContext, OrderConfirmActivity.class);
                        intent.putExtra("cart_ids",cart_ids);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.ll_all_select:
                checkbox.setChecked(!checkbox.isChecked());
                for (CartListsModel.DataBean.GoodsListBean listBean :
                        adapter.getData()) {
                    listBean.setIs_select(checkbox.isChecked());
                }
                EventBus.getDefault().post(new CartAllCheckedEvent(checkbox.isChecked()));
                EventBus.getDefault().post(new CanSettlement(checkbox.isChecked()));
                adapter.notifyDataSetChanged();
                break;
        }
    }

    private void updateTotalPrice() {
        double totalPrice = 0;
        for (CartListsModel.DataBean.GoodsListBean listBean :
                adapter.getData()) {
            if (listBean.isIs_select()) {
                totalPrice += listBean.getTotal_num() * Double.parseDouble(listBean.getGoods_price());
            }
        }
        tvTotalPrice.setText("   ￥" + doubleToString(totalPrice));
    }

    public static String doubleToString(double num) {
        //使用0.00不足位补0，#.##仅保留有效位
        return new DecimalFormat("0.00").format(num);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(CartAllCheckedEvent event) {
        checkbox.setChecked(event.getAllChecked());
        updateTotalPrice();
//        if (event.getAllChecked()) {
//            tvAllSelect.setTextColor(getResources().getColor(R.color.grey));
//            tvCancel.setTextColor(getResources().getColor(R.color.light_black));
//        } else {
//            tvAllSelect.setTextColor(getResources().getColor(R.color.light_black));
//            tvCancel.setTextColor(getResources().getColor(R.color.grey));

//        }
    }

    //
//    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
//    public void onEvent(UpdateTotalPriceEvent event) {
//        updateTotalPrice();
//    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(CanSettlement event) {
        tvSettlement.setEnabled(event.canSettlement());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if(event.equals("cart_refresh"))
        {
            cartList();
        }
    }
}
