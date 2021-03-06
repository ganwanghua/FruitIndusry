package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GridOrderAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.GlideCircleTransform;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.right)
    ImageView right;
    @BindView(R.id.gridView)
    GridView gridView;
    @BindView(R.id.gridView1)
    GridView gridView1;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.iv_purchase)
    ImageView ivPurchase;
    @BindView(R.id.iv_second_kill)
    ImageView ivSecondKill;
    @BindView(R.id.iv_tree)
    ImageView ivTree;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.iv_location)
    ImageView ivLocation;
    @BindView(R.id.iv_collection1)
    ImageView ivCollection1;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.rl_adoption_order)
    RelativeLayout rlAdoptionOrder;
    @BindView(R.id.ll_balance)
    LinearLayout llBalance;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_rebate)
    TextView tvRebate;
    @BindView(R.id.ll_rebate)
    LinearLayout llRebate;
    @BindView(R.id.rl_addresss)
    RelativeLayout rlAddresss;
    @BindView(R.id.rl_collection)
    RelativeLayout rlCollection;
    @BindView(R.id.ll_coupon)
    LinearLayout llCoupon;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.rl_setting)
    RelativeLayout rlSetting;
    @BindView(R.id.tv_all_order)
    TextView tvAllOrder;
    @BindView(R.id.rl_my_push)
    RelativeLayout rlMyPush;
    @BindView(R.id.ll_integral)
    LinearLayout llIntegral;
    @BindView(R.id.rl_group_order)
    RelativeLayout rlGroupOrder;
    @BindView(R.id.rl_evaluate)
    RelativeLayout rlEvaluate;
    @BindView(R.id.rl_secKill_order)
    RelativeLayout rlSecKillOrder;
    private int[] icon = {R.mipmap.paid, R.mipmap.delivered, R.mipmap.received, R.mipmap.evaluated, R.mipmap.after_sales};
    private int[] icon1 = {R.mipmap.membership, R.mipmap.my_fruit_tree, R.mipmap.adoption, R.mipmap.registration};
    private String[] iconName = {"?????????", "?????????", "?????????", "?????????", "??????/??????"};
    private String[] iconName1 = {"????????????", "????????????", "????????????", "??????"};
    private SimpleAdapter sim_adapter1;
    private GridOrderAdapter gridOrderAdapter;
    private ArrayList<Map<String, Object>> data_list, data_list1;
    private DataRepository dataRepository;
    private List<Integer> orderNums = new ArrayList<>();

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

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //???ui???????????????????????????100
    public void onEvent(String event) {
        if (event.equals("1")) {
            userInfo();
        }
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());
        grid();
        grid1();
        userInfo();
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                userInfo();
            }
        });
    }

    private void userInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.index/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.userInfo(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                refresh.finishRefresh();
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                UserInfoModel userInfoModel = (UserInfoModel) data;
                if (userInfoModel.getCode() == 1) {
                    Glide.with(getContext()).load(userInfoModel.getData().getUserInfo().getAvatarUrl()).apply(bitmapTransform(new GlideCircleTransform(getContext()))).into(ivAvatar);
                    tvNickName.setText(userInfoModel.getData().getUserInfo().getNickName());
                    if (!TextUtils.isEmpty(userInfoModel.getData().getUserInfo().getPhone()) && userInfoModel.getData().getUserInfo().getPhone().length() > 6) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < userInfoModel.getData().getUserInfo().getPhone().length(); i++) {
                            char c = userInfoModel.getData().getUserInfo().getPhone().charAt(i);
                            if (i >= 3 && i <= 6) {
                                sb.append('*');
                            } else {
                                sb.append(c);
                            }
                        }
                        tvPhone.setText(sb.toString());
                        tvMoney.setText(userInfoModel.getData().getUserInfo().getBalance());
                        tvRebate.setText(userInfoModel.getData().getTm() + "");
                        tvCoupon.setText(userInfoModel.getData().getCouponCount() + "");
                    }

                    UserInfoModel.DataBean.OrderCountBean orderCount = userInfoModel.getData().getOrderCount();
                    orderNums.clear();

                    orderNums.add(orderCount.getPayment());
                    orderNums.add(orderCount.getDelivery());
                    orderNums.add(orderCount.getReceived());
                    orderNums.add(orderCount.getComment());

//                    orderStatusNums.add(saveUserShipBean.getData().getIsAfterSale()); //??????
                    gridOrderAdapter.setOrderStatusNums(orderNums);
                }
            }
        });
    }

    private void grid1() {
        data_list1 = new ArrayList<Map<String, Object>>();
        //????????????
        getData1();
        //???????????????
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter1 = new SimpleAdapter(getContext(), data_list1, R.layout.item1, from, to);
        //???????????????
        gridView1.setAdapter(sim_adapter1);
        gridView1.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {
                    startActivity(new Intent(getContext(), InvitationPosterActivity.class));
                } else if (position == 1) {
                    EventBus.getDefault().post("2");
                } else if (position == 0) {
                    showAddressDeleteDialog();
                }
            }
        });
    }

    private void showAddressDeleteDialog() {
        new TDialog.Builder(getFragmentManager())
                .setLayoutRes(R.layout.vip_dialog)
                .setScreenWidthAspect(getContext(), 0.8f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                    }
                })
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_cancel:
                                tDialog.dismiss();
                                break;
                            case R.id.tv_sure:
                                tDialog.dismiss();
                                startActivity(new Intent(getContext(), VipActivity.class));
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private List<Map<String, Object>> getData1() {
        for (int i = 0; i < icon1.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon1[i]);
            map.put("text", iconName1[i]);
            data_list1.add(map);
        }
        return data_list1;
    }

    private void grid() {
        data_list = new ArrayList<Map<String, Object>>();
        //????????????
        getData();
        //???????????????
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        gridOrderAdapter = new GridOrderAdapter(getContext(), data_list);
        //???????????????
        gridView.setAdapter(gridOrderAdapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0: //?????????
                        Intent intent1 = new Intent(getContext(), OrderActivity.class);
                        intent1.putExtra("type", 1);
                        startActivity(intent1);
                        break;
                    case 1: //?????????
                        Intent intent2 = new Intent(getContext(), OrderActivity.class);
                        intent2.putExtra("type", 2);
                        startActivity(intent2);
                        break;
                    case 2: //??????
                        Intent intent4 = new Intent(getContext(), OrderActivity.class);
                        intent4.putExtra("type", 3);
                        startActivity(intent4);
                        break;
                    case 3: //?????????
                        Intent intent3 = new Intent(getContext(), OrderActivity.class);
                        intent3.putExtra("type", 4);
                        startActivity(intent3);
                        break;
                    case 4: //??????
                        startActivity(new Intent(getContext(), AfterSaleListActivity.class));
                        break;
                    default:
                        break;
                }

            }
        });
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    @OnClick({R.id.ll_integral, R.id.rl_setting, R.id.rl_my_push, R.id.rl_adoption_order, R.id.ll_balance, R.id.rl_addresss, R.id.ll_rebate, R.id.rl_collection, R.id.ll_coupon, R.id.tv_all_order
            , R.id.rl_group_order, R.id.rl_evaluate, R.id.rl_secKill_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_secKill_order:
                startActivity(new Intent(getContext(), SecKillOrderActivity.class));
                break;
            case R.id.rl_evaluate:
                startActivity(new Intent(getContext(), EvaluateActivity.class));
                break;
            case R.id.ll_integral:
                startActivity(new Intent(getContext(), IntegralActivity.class));
                break;
            case R.id.rl_my_push:
                startActivity(new Intent(getContext(), MyPushActivity.class));
                break;
            case R.id.ll_coupon:
                startActivity(new Intent(getContext(), CouponActivity.class));
                break;
            case R.id.rl_setting:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
            case R.id.rl_adoption_order:
                startActivity(new Intent(getContext(), AdoptionOrderActivity.class));
                break;
            case R.id.ll_balance:
                startActivity(new Intent(getContext(), BalanceActivity.class));
                break;
            case R.id.rl_addresss:
                startActivity(new Intent(getContext(), AddressActivity.class));
                break;
            case R.id.ll_rebate:
                startActivity(new Intent(getContext(), RebateActivity.class));
                break;
            case R.id.rl_collection:
                startActivity(new Intent(getContext(), CollectionActivity.class));
                break;
            case R.id.tv_all_order:
                startActivity(new Intent(mContext, OrderActivity.class));
                break;
            case R.id.rl_group_order:
                startActivity(new Intent(mContext, GroupOrderActivity.class));
                break;
        }
    }
}
