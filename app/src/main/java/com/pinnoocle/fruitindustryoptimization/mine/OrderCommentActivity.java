package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderCommentAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.UploadImageModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class OrderCommentActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    private OrderCommentAdapter adapter;
    private DataRepository dataRepository;

    private ArrayList<String> mList = new ArrayList<>();
    private List<LocalMedia> selectList = new ArrayList<>();
    List<String> file_ids = new ArrayList<>();
    List<String> file_paths = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_comment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new OrderCommentAdapter(mContext);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        dataRepository = Injection.dataRepository(mContext);
        orderDetail();
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.gridView:

                        break;

                }
            }
        });
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
                    adapter.setData(goods);
                }
            }
        });
    }

    private void commentOrder(String formData) {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.comment/order");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", getIntent().getStringExtra("order_id"));
        map.put("formData", formData);
        ViewLoading.show(mContext);
        dataRepository.commentOrder(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);

            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {

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


            }

            @Override
            public void onSuccess(Object data) {

                UploadImageModel uploadImageModel = (UploadImageModel) data;
                if (uploadImageModel.getCode() == 1) {
                    file_ids.add(uploadImageModel.getData().getFile_id());
                    file_paths.add(uploadImageModel.getData().getFile_path());
                }

            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selectList = PictureSelector.obtainMultipleResult(data);
        if (resultCode == RESULT_OK) {
            mList.clear();
            for (LocalMedia localMedia : selectList) {
                String compressPath = localMedia.getCompressPath();
                mList.add(compressPath);
            }
            adapter.setResult(adapter.gridViewMap.get(requestCode - 1000), mList, requestCode - 1000);

        }
    }


    @OnClick({R.id.iv_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure:
                sure();

                break;
        }
    }

    public void sure() {
        for (int i = 0; i < adapter.getData().size(); i++) {

            if (adapter.cacheListMap.get(i) != null && adapter.cacheListMap.get(i).size() > 0) {
                for (int j = 0; j < adapter.cacheListMap.get(i).size(); j++) {
                    image(new File(adapter.cacheListMap.get(i).get(j)));
                }
            } else {
                comment(i);
            }
        }

    }

    public void comment(int i) {

        adapter.commentMap.get(i).setContent(adapter.vhMap.get(i).edAdvise.getText().toString());
        adapter.commentMap.get(i).setGoods_id(adapter.getData().get(i).getGoods_id());
        adapter.commentMap.get(i).setOrder_goods_id(adapter.getData().get(i).getOrder_goods_id());

    }
}
