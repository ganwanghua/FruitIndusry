package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.BigGiftBagAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.TreePacketModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CommItemDecoration;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BigGiftBagActivity extends BaseActivity implements BigGiftBagAdapter.OnItemClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.ll_big_gift)
    LinearLayout llBigGift;
    private DataRepository dataRepository;
    BigGiftBagAdapter bigGiftBagAdapter;
    private TreePacketModel treePacketModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_gift_bag);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 30));
        bigGiftBagAdapter = new BigGiftBagAdapter(this);
        recycleView.setAdapter(bigGiftBagAdapter);

        bigGiftBagAdapter.setOnItemClickListener(this);
        treePacket();
    }

    private void treePacket() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/tree_packet");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("tree_id", getIntent().getStringExtra("tree_id"));
        dataRepository.treePacket(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                treePacketModel = (TreePacketModel) data;
                if (treePacketModel.getCode() == 1) {
                    bigGiftBagAdapter.setData(treePacketModel.getData().getGoods());
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, GoodsDetailsActivity.class);
        intent.putExtra("goods_id", treePacketModel.getData().getGoods().get(position).getGoods_id() + "");
        startActivity(intent);
    }
}