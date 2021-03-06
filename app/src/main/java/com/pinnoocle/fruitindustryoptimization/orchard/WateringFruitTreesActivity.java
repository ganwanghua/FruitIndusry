package com.pinnoocle.fruitindustryoptimization.orchard;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.GeneTreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreeDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.ActivityUtils;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.GlideCircleTransform;
import com.pinnoocle.fruitindustryoptimization.widget.SpringScaleInterpolator;
import com.pinnoocle.fruitindustryoptimization.widget.StrokeTextView1;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class WateringFruitTreesActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.rl_logo)
    RelativeLayout rlLogo;
    @BindView(R.id.iv_maturity_cycle)
    ImageView ivMaturityCycle;
    @BindView(R.id.ll_calendar)
    LinearLayout llCalendar;
    @BindView(R.id.ll_big)
    LinearLayout llBig;
    @BindView(R.id.iv_cloud)
    ImageView ivCloud;
    @BindView(R.id.iv_wish)
    ImageView ivWish;
    @BindView(R.id.tv_time)
    StrokeTextView1 tvTime;
    @BindView(R.id.tv_name)
    StrokeTextView1 tvName;
    @BindView(R.id.rl_big_gift_bag)
    RelativeLayout rlBigGiftBag;
    @BindView(R.id.ll_watering)
    RelativeLayout llWatering;
    @BindView(R.id.iv_kettle)
    ImageView ivKettle;
    @BindView(R.id.iv_water_drop)
    ImageView ivWaterDrop;
    @BindView(R.id.iv_water_drop1)
    ImageView ivWaterDrop1;
    @BindView(R.id.iv_water_drop2)
    ImageView ivWaterDrop2;
    @BindView(R.id.iv_tree)
    ImageView ivTree;
    @BindView(R.id.tv_name1)
    TextView tvName1;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.rl_tree1)
    RelativeLayout rlTree1;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.ll_tree_info)
    LinearLayout llTreeInfo;
    @BindView(R.id.rl_collar_tree)
    RelativeLayout rlCollarTree;
    @BindView(R.id.rl_fertilizer)
    RelativeLayout rlFertilizer;
    @BindView(R.id.iv_fertilizer)
    ImageView ivFertilizer;
    @BindView(R.id.iv_fertilizer1)
    ImageView ivFertilizer1;
    @BindView(R.id.iv_fertilizer2)
    ImageView ivFertilizer2;
    @BindView(R.id.iv_fertilizer3)
    ImageView ivFertilizer3;
    @BindView(R.id.ll_adoption_certificate)
    LinearLayout llAdoptionCertificate;
    @BindView(R.id.ll_live)
    LinearLayout llLive;
    @BindView(R.id.iv_cloud1)
    ImageView ivCloud1;
    @BindView(R.id.ll_cloud)
    RelativeLayout llCloud;
    @BindView(R.id.tv_video_photos)
    StrokeTextView1 tvVideoPhotos;
    @BindView(R.id.scrollview)
    NestedScrollView scrollview;
    @BindView(R.id.iv_tree1)
    ImageView ivTree1;
    @BindView(R.id.rl_cloud)
    RelativeLayout rlCloud;
    @BindView(R.id.rl_picture)
    RelativeLayout rlPicture;
    @BindView(R.id.iv_tree2)
    ImageView ivTree2;
    @BindView(R.id.iv_tree3)
    ImageView ivTree3;
    private DataRepository dataRepository;
    private UserTreeDetailModel userTreeDetailModel;
    private EditText ed_name, ed_name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initGreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_fruit_trees);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(screenW, -screenW);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(-1);
        valueAnimator.setDuration(25000);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                llCloud.scrollTo(value, 0);
            }
        });
        valueAnimator.start();

        userTreeDetail();
    }

    private void userTreeDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/user_tree_detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("order_no", "");
        map.put("tree_id", getIntent().getStringExtra("tree_id"));
        dataRepository.userTreeDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                userTreeDetailModel = (UserTreeDetailModel) data;
                if (userTreeDetailModel.getCode() == 1) {
                    Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser().getAvatarUrl()).apply(bitmapTransform(new GlideCircleTransform(WateringFruitTreesActivity.this))).into(ivAvatar);
                    if (userTreeDetailModel.getData().getUser_tree().getTree_status() == 1) {
                        ivTree.setVisibility(View.VISIBLE);
                        ivTree1.setVisibility(View.GONE);
                        ivTree2.setVisibility(View.GONE);
                        ivTree3.setVisibility(View.GONE);
                        Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser_tree().getPic()).into(ivTree);
                    } else if (userTreeDetailModel.getData().getUser_tree().getTree_status() == 2) {
                        ivTree.setVisibility(View.GONE);
                        ivTree1.setVisibility(View.VISIBLE);
                        ivTree2.setVisibility(View.GONE);
                        ivTree3.setVisibility(View.GONE);
                        Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser_tree().getPic()).into(ivTree1);
                    } else if (userTreeDetailModel.getData().getUser_tree().getTree_status() == 3) {
                        ivTree.setVisibility(View.GONE);
                        ivTree1.setVisibility(View.GONE);
                        ivTree2.setVisibility(View.VISIBLE);
                        ivTree3.setVisibility(View.GONE);
                        Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser_tree().getPic()).into(ivTree2);
                    }else if (userTreeDetailModel.getData().getUser_tree().getTree_status() == 4) {
                        ivTree.setVisibility(View.GONE);
                        ivTree1.setVisibility(View.GONE);
                        ivTree2.setVisibility(View.GONE);
                        ivTree3.setVisibility(View.VISIBLE);
                        Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser_tree().getPic()).into(ivTree3);
                    }
                    tvName1.setText(userTreeDetailModel.getData().getUser().getNickName());

                    tvDay.setText(userTreeDetailModel.getData().getUser_tree().getLeft_day() + "");
                    tvTime.setText(userTreeDetailModel.getData().getUser_tree().getEnd_date() + "??????");
                    if (userTreeDetailModel.getData().getUser_coupons().size() > 0) {
                        tvNotice.setVisibility(View.VISIBLE);
                    } else {
                        tvNotice.setVisibility(View.GONE);
                    }
                    if (TextUtils.isEmpty(userTreeDetailModel.getData().getUser_tree().getName())) {
                        tvName.setText("???????????????");
                    } else {
                        tvName.setText(userTreeDetailModel.getData().getUser_tree().getName());
                    }
                }
            }
        });
    }

    private void nameTree(String name) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/name_tree");
        map.put("wxapp_id", "10001");
        map.put("tree_id", getIntent().getStringExtra("tree_id"));
        map.put("token", FastData.getToken());
        map.put("name", name);
        dataRepository.nameTree(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    EventBus.getDefault().post("11");
                    ToastUtils.showToast(statusModel.getMsg());
                    userTreeDetail();
                }
            }
        });
    }

    private void geneTreeOrder() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/gene_tree_order");
        map.put("wxapp_id", "10001");
        map.put("tree_id", userTreeDetailModel.getData().getUser_tree().getTree_id() + "");
        map.put("token", FastData.getToken());
        map.put("spec", userTreeDetailModel.getData().getUser_tree().getType() + "");
        map.put("number", userTreeDetailModel.getData().getUser_tree().getNumber() + "");
        map.put("time", userTreeDetailModel.getData().getTime().get(0).getMonth() + "");
        map.put("user_tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
        dataRepository.geneTreeOrder(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                GeneTreeOrderModel geneTreeOrderModel = (GeneTreeOrderModel) data;
                if (geneTreeOrderModel.getCode() == 1) {
                    EventBus.getDefault().post("11");
                    userTreeDetail();
                }
            }
        });
    }

    @OnClick({R.id.tv_video_photos, R.id.ll_live, R.id.ll_adoption_certificate, R.id.tv_name, R.id.iv_back, R.id.iv_wish, R.id.rl_big_gift_bag, R.id.ll_watering, R.id.iv_tree, R.id.iv_tree1, R.id.iv_tree2, R.id.iv_tree3, R.id.ll_tree_info, R.id.rl_collar_tree, R.id.rl_fertilizer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_video_photos:
                Intent intent3 = new Intent(WateringFruitTreesActivity.this, VideoPicActivity.class);
                intent3.putExtra("tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
                startActivity(intent3);
                break;
            case R.id.ll_live:
                Intent intent1 = new Intent(WateringFruitTreesActivity.this, WebViewActivity.class);
                intent1.putExtra("live", userTreeDetailModel.getData().getSetting().getLive());
                startActivity(intent1);
                break;
            case R.id.ll_adoption_certificate:
                Intent intent = new Intent(WateringFruitTreesActivity.this, ECertActivity.class);
                intent.putExtra("order_no", "");
                intent.putExtra("pos", "1");
                intent.putExtra("tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
                startActivity(intent);
                break;
            case R.id.tv_name:
                new TDialog.Builder(getSupportFragmentManager())
                        .setLayoutRes(R.layout.dialog_name)
                        .setScreenWidthAspect(this, 1f)
                        .setGravity(Gravity.BOTTOM)
                        .setCancelableOutside(true)
                        .addOnClickListener(R.id.tv_save, R.id.tv_cancel)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {
                                ed_name1 = viewHolder.getView(R.id.ed_name);
                                if (!TextUtils.isEmpty(tvName.getText().toString())) {
                                    ed_name1.setText(userTreeDetailModel.getData().getUser_tree().getName());
                                }
                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.tv_cancel:
                                        tDialog.dismiss();
                                        break;
                                    case R.id.tv_save:
                                        nameTree(ed_name1.getText().toString());
                                        tDialog.dismiss();
                                        break;
                                }
                            }
                        })
                        .create()
                        .show();
                break;
            case R.id.rl_fertilizer:
                grow("2");
                break;
            case R.id.rl_collar_tree:
                ActivityUtils.startActivity(this, AdoptActivity.class);
                break;
            case R.id.ll_tree_info:
                new TDialog.Builder(getSupportFragmentManager())
                        .setLayoutRes(R.layout.dialog_tree_info)
                        .setScreenWidthAspect(this, 0.8f)
                        .setGravity(Gravity.CENTER)
                        .setCancelableOutside(true)
                        .addOnClickListener(R.id.tv_save, R.id.rl_adoption_certificate, R.id.rl_broadcast, R.id.tv_renew, R.id.rl_video_pic)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {
                                ImageView iv_avatar = viewHolder.getView(R.id.iv_avatar);
                                ed_name = viewHolder.getView(R.id.ed_name);
                                TextView tv_time = viewHolder.getView(R.id.tv_time);

                                Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser().getAvatarUrl()).apply(bitmapTransform(new GlideCircleTransform(WateringFruitTreesActivity.this))).into(iv_avatar);
                                if (!TextUtils.isEmpty(userTreeDetailModel.getData().getUser_tree().getName())) {
                                    ed_name.setText(userTreeDetailModel.getData().getUser_tree().getName());
                                }
                                tv_time.setText(userTreeDetailModel.getData().getUser_tree().getEnd_date() + "??????");
                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.rl_video_pic:
                                        Intent intent3 = new Intent(WateringFruitTreesActivity.this, VideoPicActivity.class);
                                        intent3.putExtra("tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
                                        startActivity(intent3);
                                        break;
                                    case R.id.tv_renew:
                                        tDialog.dismiss();
                                        new TDialog.Builder(getSupportFragmentManager())
                                                .setLayoutRes(R.layout.dialog_renew)
                                                .setScreenWidthAspect(WateringFruitTreesActivity.this, 1f)
                                                .setGravity(Gravity.BOTTOM)
                                                .setCancelableOutside(true)
                                                .addOnClickListener(R.id.tv_sure)
                                                .setOnBindViewListener(new OnBindViewListener() {
                                                    @Override
                                                    public void bindView(BindViewHolder viewHolder) {

                                                    }
                                                })
                                                .setOnViewClickListener(new OnViewClickListener() {
                                                    @Override
                                                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                                        switch (view.getId()) {
                                                            case R.id.tv_sure:
                                                                geneTreeOrder();
                                                                tDialog.dismiss();
                                                                break;
                                                        }
                                                    }
                                                })
                                                .create()
                                                .show();
                                        break;
                                    case R.id.tv_save:
                                        nameTree(ed_name.getText().toString());
                                        tDialog.dismiss();
                                        break;
                                    case R.id.rl_adoption_certificate:
                                        Intent intent = new Intent(WateringFruitTreesActivity.this, ECertActivity.class);
                                        intent.putExtra("order_no", "");
                                        intent.putExtra("pos", "1");
                                        intent.putExtra("tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
                                        startActivity(intent);
                                        break;
                                    case R.id.rl_broadcast:
                                        Intent intent1 = new Intent(WateringFruitTreesActivity.this, WebViewActivity.class);
                                        intent1.putExtra("live", userTreeDetailModel.getData().getSetting().getLive());
                                        startActivity(intent1);
                                        break;
                                }
                            }
                        })
                        .create()
                        .show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_wish:
                new TDialog.Builder(getSupportFragmentManager())
                        .setLayoutRes(R.layout.dialog_wish)
                        .setScreenWidthAspect(WateringFruitTreesActivity.this, 0.7f)
                        .setGravity(Gravity.CENTER)
                        .setCancelableOutside(false)
                        .addOnClickListener(R.id.iv_delete, R.id.rl_sure)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {
                                EditText ed_wish = viewHolder.getView(R.id.ed_wish);
                                if (!TextUtils.isEmpty(userTreeDetailModel.getData().getUser_tree().getWish())) {
                                    ed_wish.setText(userTreeDetailModel.getData().getUser_tree().getWish());
                                }
                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.iv_delete:
                                        tDialog.dismiss();
                                        break;
                                    case R.id.rl_sure:
                                        tDialog.dismiss();
                                        break;
                                }
                            }
                        })
                        .create()
                        .show();
                break;
            case R.id.rl_big_gift_bag:
                Intent intent2 = new Intent(this, BigGiftBagActivity.class);
                intent2.putExtra("tree_id", getIntent().getStringExtra("tree_id"));
                startActivity(intent2);
                break;
            case R.id.ll_watering:
                grow("1");
                break;
            case R.id.iv_tree:
                ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.0f, 1.1f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                // ???????????????????????????
                sa.setDuration(1000);
                sa.setFillAfter(true);
                sa.setInterpolator(new SpringScaleInterpolator(0.3f));
                sa.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                        // ???????????????????????????
                        sa.setDuration(500);
                        sa.setFillAfter(true);
                        ivTree.startAnimation(sa);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                ivTree.startAnimation(sa);
                break;
            case R.id.iv_tree1:
                ScaleAnimation sa1 = new ScaleAnimation(1f, 1.0f, 1.0f, 1.1f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                // ???????????????????????????
                sa1.setDuration(1000);
                sa1.setFillAfter(true);
                sa1.setInterpolator(new SpringScaleInterpolator(0.3f));
                sa1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                        // ???????????????????????????
                        sa.setDuration(500);
                        sa.setFillAfter(true);
                        ivTree1.startAnimation(sa);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                ivTree1.startAnimation(sa1);
                break;
            case R.id.iv_tree2:
                ScaleAnimation sa2 = new ScaleAnimation(1f, 1.0f, 1.0f, 1.1f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                // ???????????????????????????
                sa2.setDuration(1000);
                sa2.setFillAfter(true);
                sa2.setInterpolator(new SpringScaleInterpolator(0.3f));
                sa2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                        // ???????????????????????????
                        sa.setDuration(500);
                        sa.setFillAfter(true);
                        ivTree2.startAnimation(sa);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                ivTree2.startAnimation(sa2);
                break;
            case R.id.iv_tree3:
                ScaleAnimation sa3 = new ScaleAnimation(1f, 1.0f, 1.0f, 1.1f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                // ???????????????????????????
                sa3.setDuration(1000);
                sa3.setFillAfter(true);
                sa3.setInterpolator(new SpringScaleInterpolator(0.3f));
                sa3.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.1f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                        // ???????????????????????????
                        sa.setDuration(500);
                        sa.setFillAfter(true);
                        ivTree3.startAnimation(sa);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                ivTree3.startAnimation(sa3);
                break;
        }
    }

    private void grow(String type) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/grow");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("type", type);
        map.put("tree_id", getIntent().getStringExtra("tree_id"));
        dataRepository.grow(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
//                    GrowModel loginModel = new Gson().fromJson(statusModel.getData(), GrowModel.class);
                    if (type.equals("1")) {
                        Animation operatingAnim = AnimationUtils.loadAnimation(WateringFruitTreesActivity.this, R.anim.rotate_anim);
                        LinearInterpolator lin = new LinearInterpolator();
                        operatingAnim.setInterpolator(lin);
                        operatingAnim.setFillAfter(true);
                        operatingAnim.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                Animation animation1 = new AlphaAnimation(0f, 1.0f);
                                animation1.setDuration(800);//????????????????????????
                                animation1.setRepeatCount(1);
                                ivWaterDrop.startAnimation(animation1);

                                Animation animation2 = new AlphaAnimation(0f, 1.0f);
                                animation2.setDuration(800);//????????????????????????
                                animation2.setRepeatCount(1);
                                ivWaterDrop1.startAnimation(animation2);

                                Animation animation3 = new AlphaAnimation(0f, 1.0f);
                                animation3.setDuration(800);//????????????????????????
                                animation3.setRepeatCount(1);
                                ivWaterDrop2.startAnimation(animation3);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Animation operatingAnim = AnimationUtils.loadAnimation(WateringFruitTreesActivity.this, R.anim.rotate_anim_one);
                                LinearInterpolator lin = new LinearInterpolator();
                                operatingAnim.setInterpolator(lin);
                                operatingAnim.setFillAfter(true);
                                operatingAnim.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        Animation animation1 = new AlphaAnimation(1.0f, 0f);
                                        animation1.setDuration(1000);//????????????????????????
                                        animation1.setFillAfter(true);
                                        ivKettle.startAnimation(animation1);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                ivKettle.startAnimation(operatingAnim);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ivKettle.startAnimation(operatingAnim);
                    } else {
                        Animation operatingAnim = AnimationUtils.loadAnimation(WateringFruitTreesActivity.this, R.anim.rotate_anim);
                        LinearInterpolator lin = new LinearInterpolator();
                        operatingAnim.setInterpolator(lin);
                        operatingAnim.setFillAfter(true);
                        operatingAnim.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                Animation animation1 = new AlphaAnimation(0f, 1.0f);
                                animation1.setDuration(800);//????????????????????????
                                animation1.setRepeatCount(1);
                                ivFertilizer1.startAnimation(animation1);

                                Animation animation2 = new AlphaAnimation(0f, 1.0f);
                                animation2.setDuration(800);//????????????????????????
                                animation2.setRepeatCount(1);
                                ivFertilizer2.startAnimation(animation2);

                                Animation animation3 = new AlphaAnimation(0f, 1.0f);
                                animation3.setDuration(800);//????????????????????????
                                animation3.setRepeatCount(1);
                                ivFertilizer3.startAnimation(animation3);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Animation operatingAnim = AnimationUtils.loadAnimation(WateringFruitTreesActivity.this, R.anim.rotate_anim_one);
                                LinearInterpolator lin = new LinearInterpolator();
                                operatingAnim.setInterpolator(lin);
                                operatingAnim.setFillAfter(true);
                                operatingAnim.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        Animation animation1 = new AlphaAnimation(1.0f, 0f);
                                        animation1.setDuration(1000);//????????????????????????
                                        animation1.setFillAfter(true);
                                        ivFertilizer.startAnimation(animation1);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                ivFertilizer.startAnimation(operatingAnim);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ivFertilizer.startAnimation(operatingAnim);
                    }
                } else {
                    ToastUtils.showToast(statusModel.getMsg());
                }
            }
        });
    }
}