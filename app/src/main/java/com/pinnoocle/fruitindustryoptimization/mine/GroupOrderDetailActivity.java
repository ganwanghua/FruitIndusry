package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupWorkAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupOrderDetailActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_person_num)
    TextView tvPersonNum;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_invite)
    TextView tvInvite;
    @BindView(R.id.tv_more)
    TextView tvMore;
    private GroupWorkAdapter groupWorkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_order_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        groupWorkAdapter = new GroupWorkAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,5));
        recyclerView.setAdapter(groupWorkAdapter);
    }

    private void initData() {

    }

    @OnClick({R.id.iv_back, R.id.tv_invite, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_invite:
                break;
            case R.id.tv_more:
                break;
        }
    }
}
