package com.pinnoocle.fruitindustryoptimization.mine;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;

import com.pinnoocle.fruitindustryoptimization.adapter.GridView2Adapter;
import com.pinnoocle.fruitindustryoptimization.adapter.GridViewAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderDetailAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.UploadImageModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.GlideEngine;
import com.pinnoocle.fruitindustryoptimization.widget.GridViewInScrollView;
import com.tbruyelle.rxpermissions3.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ApplyForAfterSalesActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_exchange_goods)
    TextView tvExchangeGoods;
    @BindView(R.id.tv_return_goods)
    TextView tvReturnGoods;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.ed_advise)
    EditText edAdvise;
    @BindView(R.id.gridView)
    GridViewInScrollView gridView;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    private AtomicInteger carSize = new AtomicInteger();
    StringBuilder sb = new StringBuilder();
    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> selectGoods = new ArrayList<>();



    private List<String> images = new ArrayList<>();
    private ArrayList<String> mList = new ArrayList<>();
    private List<LocalMedia> selectList = new ArrayList<>();
    private DataRepository dataRepository;
    private OrderDetailAdapter adapter;
    private String type = "10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_aftersales);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderDetailAdapter(this);
        recyclerView.setAdapter(adapter);
        grid(mList);
        orderDetail();
    }

    private void orderDetail() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.order/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", getIntent().getStringExtra("order_id"));

        ViewLoading.show(mContext);
        dataRepository.orderDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                OrderDetailModel orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> goods = orderDetailModel.getData().getOrder().getGoods();
                    for (int i = 0; i < goods.size(); i++) {
                        if (getIntent().getStringExtra("order_goods_id").equals(goods.get(i).getOrder_goods_id() + "")) {
                            selectGoods.add(goods.get(i));
                        }

                    }
                    adapter.setData(selectGoods);
                }

            }
        });
    }

    private void refundApply(String images) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.refund/apply");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_goods_id", getIntent().getStringExtra("order_goods_id"));
        map.put("content",edAdvise.getText().toString());
        if(!TextUtils.isEmpty(images))
            map.put("images",images);

        ViewLoading.show(mContext);
        dataRepository.refundApply(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    finish();
                    EventBus.getDefault().post("order_refresh");
                    EventBus.getDefault().post("1");
                }
                ToastUtils.showToast(statusModel.getMsg());

            }
        });
    }

    public void image(File file) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/upload/image");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());

        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("iFile", file.getName(), fileBody);
        dataRepository.image(map, body, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                carSize.getAndIncrement();
            }

            @Override
            public void onSuccess(Object data) {
                carSize.getAndIncrement();
                UploadImageModel imageModel = (UploadImageModel) data;
                if (imageModel.getCode() == 1) {
                    images.add(imageModel.getData().getFile_id());

                    for (int i = 0; i < images.size(); i++) {
                        if (i == images.size() - 1) {
                            sb.append(images.get(i));
                        } else {
                            sb.append(images.get(i) + ",");
                        }
                    }

                    if (carSize.get() >= selectList.size()) {

                        refundApply(sb.toString());
                    }
                }
            }
        });
    }


    private void viewPluImg (ArrayList < String > list,int index){
            Intent imgIntent = new Intent(this, TaskBigImgActivity.class);
            imgIntent.putStringArrayListExtra("paths", list);
            imgIntent.putExtra("position", index);
            startActivity(imgIntent);
        }

        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            selectList = PictureSelector.obtainMultipleResult(data);
            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case PictureConfig.CHOOSE_REQUEST:
                        for (LocalMedia localMedia : selectList) {
                            String compressPath = localMedia.getCompressPath();
                            mList.add(compressPath);
                        }
                        grid(mList);
                        break;
                    default:
                        break;
                }
            }
        }
        private void grid (ArrayList < String > mList) {
            GridView2Adapter mGridViewAddImgAdapter = new GridView2Adapter(this, mList);

            gridView.setAdapter(mGridViewAddImgAdapter);
            mGridViewAddImgAdapter.setOnItemClickListener(new GridView2Adapter.OnItemClickListener() {
                @Override
                public void onItemViewClick(View view, int position) {
                    mList.remove(position);
                    mGridViewAddImgAdapter.notifyDataSetChanged();
                }
            });
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    rxPermissionTest();
                }
            });

        }


        private void rxPermissionTest () {
            RxPermissions rxPermissions = new RxPermissions(this);
            rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe(granted -> {
                        if (granted) {
                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,
                                                        int position, long id) {
                                    if (position == parent.getChildCount() - 1) {
                                        //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过5张，才能点击
                                        if (mList.size() == 6) {
                                            viewPluImg(mList, position);
                                        } else {
                                            //添加凭证图片
//                        selectPic();
                                            PictureSelector.create(ApplyForAfterSalesActivity.this)
                                                    .openGallery(PictureMimeType.ofImage())
                                                    .selectionMode(PictureConfig.MULTIPLE)
                                                    .compress(true)
                                                    .maxSelectNum(6)
                                                    .loadImageEngine(GlideEngine.createGlideEngine())
                                                    .enableCrop(false)
                                                    .forResult(PictureConfig.CHOOSE_REQUEST);
                                        }
                                    } else {
                                        viewPluImg(mList, position);
                                    }
                                }
                            });

//                        PictureSelector
//                                .create(AdviseActivity.this, PictureSelector.SELECT_REQUEST_CODE)
//                                .selectPicture(true);

                        } else {
                            // Oups permission denied
                        }
                    });
        }

        @OnClick({R.id.iv_back, R.id.tv_sure,R.id.tv_exchange_goods,R.id.tv_return_goods})
        public void onViewClicked (View view){
            switch (view.getId()) {
                case R.id.iv_back:
                    finish();
                    break;
                case R.id.tv_sure:
                    if (TextUtils.isEmpty(edAdvise.getText().toString())) {
                        ToastUtils.showToast("请输入退换货原因");
                        return;
                    }

                    if (selectList != null && selectList.size() > 0) {
                        for (int i = 0; i < selectList.size(); i++) {
                            image(new File(selectList.get(i).getCompressPath()));
                        }
                    } else {
                        refundApply("");
                    }
                    break;
                case R.id.tv_exchange_goods:
                    type = "20";
                    selectType(tvExchangeGoods);
                    break;
                case R.id.tv_return_goods:
                    type = "10";
                    selectType(tvReturnGoods);

                    break;
            }
        }

    private void selectType(TextView textView) {
        tvExchangeGoods.setTextColor(getResources().getColor(R.color.grey_3));
        tvReturnGoods.setTextColor(getResources().getColor(R.color.grey_3));
        tvExchangeGoods.setBackground(getResources().getDrawable(R.drawable.bg_grey_1_stroke));
        tvReturnGoods.setBackground(getResources().getDrawable(R.drawable.bg_grey_1_stroke));

        textView.setTextColor(getResources().getColor(R.color.light_red));
        textView.setBackground(getResources().getDrawable(R.drawable.bg_red_stroke_1));

    }

}
