package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.CollectionAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CollectModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionActivity extends BaseActivity implements BaseAdapter.OnItemDataClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recycleView)
    SwipeMenuRecyclerView recycleView;
    private CollectionAdapter collectionAdapter;
    private DataRepository dataRepository;
    private CollectModel collectModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        initSlide();

        collect();
    }

    private void collect() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/collect_list");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.collect(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                collectModel = (CollectModel) data;
                if (collectModel.getCode() == 1) {
                    collectionAdapter.setData(collectModel.getData().getList());
                }
            }
        });
    }

    private void initSlide() {
        collectionAdapter = new CollectionAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // ???????????????
        SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
                // ???Item???????????????????????????
                // 2 ??????
                SwipeMenuItem deleteItem = new SwipeMenuItem(CollectionActivity.this);
                deleteItem.setText("??????")
                        .setBackgroundColor(0xffDA711D)
                        .setTextColor(Color.WHITE) // ???????????????
                        .setTextSize(15) // ???????????????
                        .setWidth(150)
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                SwipeMenuItem deleteItem1 = new SwipeMenuItem(CollectionActivity.this);
                deleteItem1.setText("??????")
                        .setBackgroundColor(0xffDA4E1D)
                        .setTextColor(Color.WHITE) // ???????????????
                        .setTextSize(15) // ???????????????
                        .setWidth(150)
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                SwipeMenuItem deleteItem2 = new SwipeMenuItem(CollectionActivity.this);
                deleteItem2.setText("??????")
                        .setBackgroundColor(0xffDA251D)
                        .setTextColor(Color.WHITE) // ???????????????
                        .setTextSize(15) // ???????????????
                        .setWidth(150)
                        .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                rightMenu.addMenuItem(deleteItem);
                rightMenu.addMenuItem(deleteItem1);
                rightMenu.addMenuItem(deleteItem2);

                // ????????????????????????????????????????????????????????????
            }
        };
//        recycleView.addItemDecoration(new CommItemDecoration(this, DividerItemDecoration.VERTICAL, getResources().getColor(R.color.transparent), 20));
        // ??????????????????
        recycleView.setSwipeMenuCreator(mSwipeMenuCreator);

        SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                // ??????????????????????????????????????????????????????Item???????????????????????????
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); // ???????????????????????????
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView???Item???position???
                int menuPosition = menuBridge.getPosition(); // ?????????RecyclerView???Item??????Position???
                if (menuPosition == 0 || menuPosition == 1) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(80);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Intent intent1 = new Intent(CollectionActivity.this, GoodsDetailsActivity.class);
                            intent1.putExtra("goods_id", collectModel.getData().getList().get(adapterPosition).getGoods_id() + "");
                            startActivity(intent1);
                        }
                    }).start();

                } else {
                    userCollect(collectModel.getData().getList().get(adapterPosition).getGoods_id() + "");
                }
            }
        };

        // ?????????????????????
        recycleView.setSwipeMenuItemClickListener(mMenuItemClickListener);

        // ?????? ????????????
        recycleView.setAdapter(collectionAdapter);

        collectionAdapter.setOnItemDataClickListener(this);
    }

    private void userCollect(String goods_id) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/collect");
        map.put("wxapp_id", "10001");
        map.put("goods_id", goods_id);
        map.put("token", FastData.getToken());
        dataRepository.userCollect(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    collect();
                }
            }
        });

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onItemViewClick(View view, int position, Object o) {
        Intent intent1 = new Intent(this, GoodsDetailsActivity.class);
        intent1.putExtra("goods_id", collectModel.getData().getList().get(position).getGoods_id() + "");
        startActivity(intent1);
    }
}