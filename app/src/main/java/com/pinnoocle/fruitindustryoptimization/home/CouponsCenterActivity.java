package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.CouponCenterAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CouponCenterModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CouponsCenterActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.tv_empty)
    TextView tvEmpty;
    private DataRepository dataRepository;
    private CouponCenterAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_coupons_center);
        ButterKnife.bind(this);
        initView();
        initData();
    }


    private void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(mContext, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        adapter = new CouponCenterAdapter(mContext);
        recycleView.setAdapter(adapter);
        adapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<CouponCenterModel.DataBean.ListBean>() {
            @Override
            public void onItemViewClick(View view, int position, CouponCenterModel.DataBean.ListBean o) {
                if(o.isIs_receive()){
                 ToastUtils.showToast("已领取");
                }else {
                    getCoupon(o.getCoupon_id());
                }

            }
        });


    }

    private void getCoupon(int promotion_id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.coupon/receive");
        map.put("token", FastData.getToken());
        map.put("wxapp_id", "10001");
        map.put("coupon_id", promotion_id+"");
        dataRepository.getCoupon(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(CouponsCenterActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(CouponsCenterActivity.this);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode()==1) {
                    couponCenter();
                    ToastUtils.showToast("领取成功");
                    EventBus.getDefault().post("coupons_refresh");
                    EventBus.getDefault().post("1");
                }else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }


    private void initData() {
        dataRepository = Injection.dataRepository(this);
        couponCenter();
//        tvEmpty.setVisibility(View.VISIBLE);
    }

    private void couponCenter() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/coupon/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.couponCenter(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(CouponsCenterActivity.this);
            }

            @Override
            public void onSuccess(Object data) {

                ViewLoading.dismiss(CouponsCenterActivity.this);
                CouponCenterModel couponCenterModel = (CouponCenterModel) data;
                if (couponCenterModel.getCode() == 1) {
                    List<CouponCenterModel.DataBean.ListBean> list = couponCenterModel.getData().getList();
                    if (list != null && list.size() > 0) {
                        recycleView.setVisibility(View.VISIBLE);
                        tvEmpty.setVisibility(View.GONE);
                        adapter.setData(couponCenterModel.getData().getList());
                    } else {
                        recycleView.setVisibility(View.GONE);
                        tvEmpty.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
