package com.pinnoocle.fruitindustryoptimization.mine;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.TreePosterModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserInfoDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.utils.SaveImageUtils;
import com.pinnoocle.fruitindustryoptimization.utils.StatusBarUtil;
import com.pinnoocle.fruitindustryoptimization.widget.GlideCircleTransform;
import com.tbruyelle.rxpermissions3.RxPermissions;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class InvitationPosterActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_poster)
    ImageView ivPoster;
    DataRepository dataRepository;
    private TreePosterModel treePosterModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setColor(this.getWindow(), 0xffF6F6F6);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation_poster);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        treePoster();
        ivPoster.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rxPermissionTest();
                return false;
            }
        });
    }

    private void rxPermissionTest() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request( Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        showSaveCode();
                    } else {
                        // Oups permission denied
                    }
                });
    }

    private void showSaveCode() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_code)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)
                .setCancelableOutside(false)
                .addOnClickListener(R.id.tv_cancel, R.id.tv_sure, R.id.tv_content)
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText("确定保存二维码图片？");
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
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            final Bitmap myBitmap = Glide.with(InvitationPosterActivity.this)//上下文
                                                    .asBitmap() //必须
                                                    .load(treePosterModel.getData().getQrcode())//url
                                                    .centerCrop()
                                                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                                    .get();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { //android 11
                                                        SaveImageUtils.saveImageToGallery2(InvitationPosterActivity.this, myBitmap);
                                                    }else {
                                                        SaveImageUtils.saveImageToGallerys(InvitationPosterActivity.this, myBitmap);
                                                    }
                                                }
                                            });

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
    }

    private void treePoster() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user.dealer.qrcode/tree_poster");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.treePoster(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                treePosterModel = (TreePosterModel) data;
                if (treePosterModel.getCode() == 1) {
                    Glide.with(InvitationPosterActivity.this).load(treePosterModel.getData().getQrcode()).into(ivPoster);
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}