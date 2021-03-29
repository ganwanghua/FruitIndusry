package com.pinnoocle.fruitindustryoptimization.mine;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.AdoptAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.CouponAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CouponListsModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class CouponFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private DataRepository dataRepository;
    private CouponAdapter couponAdapter;
    private String s;

    public CouponFragment(String s) {
        this.s = s;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_coupon;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());

        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(getContext(), DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        couponAdapter = new CouponAdapter(getContext());
        recycleView.setAdapter(couponAdapter);
    }

    @Override
    protected void initData() {
        couponLists();
    }

    private void couponLists() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.coupon/lists");
        map.put("wxapp_id", "10001");
        map.put("data_type", s);
        map.put("token", FastData.getToken());
        dataRepository.couponLists(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                CouponListsModel couponListsModel = (CouponListsModel) data;
                if (couponListsModel.getCode() == 1) {
                    couponAdapter.setData(couponListsModel.getData().getList());
                }
            }
        });
    }
}