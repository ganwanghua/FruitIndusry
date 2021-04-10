package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.collection.ArraySet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.OrderCommentAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.CommentBean;
import com.pinnoocle.fruitindustryoptimization.bean.FormDataBean;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.UploadImageModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

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
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.FuncN;
import rx.schedulers.Schedulers;

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
    List<UploadImageModel> uploadImages = new ArrayList<>();

    private AtomicInteger carSize = new AtomicInteger();
    List<CommentBean> commentBeans = new ArrayList<>();
    private List<String> ids = new ArrayList<>();
    private List<String> image_list = new ArrayList<>();
    private int images;


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
        Map<String, String> map1 = new HashMap<>();
        map.put("s", "/api/user.comment/order");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_id", getIntent().getStringExtra("order_id"));
//        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), formData);

        map1.put("formData",formData);
        ViewLoading.show(mContext);
        dataRepository.commentOrder(map,map1, new RemotDataSource.getCallback() {
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
                }
                ToastUtils.showToast(statusModel.getMsg());
            }
        });
    }

    public void image(File file, int i,int j) {
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
                    ids.add(imageModel.getData().getFile_id());
                    image_list.add(imageModel.getData().getFile_path());
                    if(carSize.get()>=j){
                        adapter.commentMap.get(i).setUploaded(ids);
                        adapter.commentMap.get(i).setImage_list(image_list);
                    }
                    if( carSize.get() >= images)
                    {
                        comment();
                    }
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
        images = 0;
        for (int i = 0; i < adapter.getData().size(); i++) {
            if (adapter.vhMap.get(i) != null) {
                if (adapter.cacheListMap.get(i) != null && adapter.cacheListMap.get(i).size() > 0) {
                    for (int j = 0; j < adapter.cacheListMap.get(i).size(); j++) {
                        image(new File(adapter.cacheListMap.get(i).get(j)), i,adapter.cacheListMap.get(i).size()-1);
                    }
                    images += adapter.cacheListMap.get(i).size();
                } else {
                    if (adapter.vhMap.get(i) != null) {
                        adapter.commentMap.get(i).setContent(adapter.vhMap.get(i).edAdvise.getText().toString());
                        adapter.commentMap.get(i).setGoods_id(adapter.getData().get(i).getGoods_id());
                        adapter.commentMap.get(i).setOrder_goods_id(adapter.getData().get(i).getOrder_goods_id());
                        adapter.commentMap.get(i).setUploaded(new ArrayList<>());
                        adapter.commentMap.get(i).setImage_list(new ArrayList<>());

                        if (!TextUtils.isEmpty(adapter.vhMap.get(i).edAdvise.getText().toString())) {
                            commentBeans.add(adapter.commentMap.get(i));
                        }
                    }
                }
            }

        }
        if (carSize.get() == 0 ) {
            comment();
        }
    }

    public void comment() {
        FormDataBean formDataBean = new FormDataBean();
        formDataBean.formData = commentBeans;
        String form_data = new Gson().toJson(commentBeans);
        commentOrder(form_data);

    }
}
