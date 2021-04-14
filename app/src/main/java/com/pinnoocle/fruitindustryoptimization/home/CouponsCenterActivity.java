package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;

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
//    private CouponsCenterAdapter adapter;

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
//        adapter = new CouponsCenterAdapter(this);
//        recycleView.setAdapter(adapter);
//        adapter.setmOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<CouponCenterBean.DataBean>() {
//            @Override
//            public void onItemViewClick(View view, int position, CouponCenterBean.DataBean o) {
//                getCoupon(o.getId());
//
//            }
//        });


    }

//    private void getCoupon(int promotion_id) {
//        ViewLoading.show(this);
//        Map<String, String> map = new HashMap<>();
//        map.put("token", FastData.getToken());
//        map.put("method", "coupon.getcoupon");
//        map.put("site_token", "123456");
//        map.put("promotion_id", promotion_id+"");
//        dataRepository.getCoupon(map, new RemotDataSource.getCallback() {
//            @Override
//            public void onFailure(String info) {
//                ViewLoading.dismiss(CouponsCenterActivity.this);
//            }
//
//            @Override
//            public void onSuccess(Object data) {
//                ViewLoading.dismiss(CouponsCenterActivity.this);
//                StatusBean statusBean = (StatusBean) data;
//                if (statusBean.isStatus()) {
////                    couponList(goods_id);
//                    EventBus.getDefault().post("coupons_refresh");
//                }
//                ToastUtils.showToast(statusBean.getMsg());
//            }
//        });
//    }


    private void initData() {
        dataRepository = Injection.dataRepository(this);
//        couponCenter();
        tvEmpty.setVisibility(View.VISIBLE);
    }

//    private void couponCenter() {
//        ViewLoading.show(this);
//        Map<String, String> map = new HashMap<>();
//        map.put("token", FastData.getToken());
//        map.put("method", "coupon.couponlist");
//        map.put("site_token", "123456");
//        dataRepository.couponCenter(map, new RemotDataSource.getCallback() {
//            @Override
//            public void onFailure(String info) {
//                ViewLoading.dismiss(CouponsCenterActivity.this);
//            }
//
//            @Override
//            public void onSuccess(Object data) {
//
//                ViewLoading.dismiss(CouponsCenterActivity.this);
//                CouponCenterBean couponCenterBean = (CouponCenterBean) data;
//                if (couponCenterBean.isStatus()) {
//                    List<CouponCenterBean.DataBean> dataBeanList = couponCenterBean.getData();
//                    adapter.setData(dataBeanList);
//
//
//                }
//
//            }
//        });
//    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
