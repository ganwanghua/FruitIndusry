package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
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
    @BindView(R.id.rl_tree)
    RelativeLayout rlTree;
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
    private DataRepository dataRepository;
    private UserTreeDetailModel userTreeDetailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initGreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watering_fruit_trees);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

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
                    tvName1.setText(userTreeDetailModel.getData().getUser().getNickName());

                    tvDay.setText(userTreeDetailModel.getData().getUser_tree().getLeft_day() + "");
                    tvTime.setText(userTreeDetailModel.getData().getUser_tree().getEnd_date() + "到期");
                    if (userTreeDetailModel.getData().getUser_coupons().size() > 0) {
                        tvNotice.setVisibility(View.VISIBLE);
                    } else {
                        tvNotice.setVisibility(View.GONE);
                    }
                    if (TextUtils.isEmpty(userTreeDetailModel.getData().getUser_tree().getName())) {
                        tvName.setText("挂个名字吧");
                    } else {
                        tvName.setText(userTreeDetailModel.getData().getUser_tree().getName());
                    }
                }
            }
        });
    }

    @OnClick({R.id.ll_adoption_certificate, R.id.tv_name, R.id.iv_back, R.id.iv_wish, R.id.rl_big_gift_bag, R.id.ll_watering, R.id.rl_tree, R.id.ll_tree_info, R.id.rl_collar_tree, R.id.rl_fertilizer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
                        .addOnClickListener(R.id.tv_save, R.id.rl_adoption_certificate)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {
                                ImageView iv_avatar = viewHolder.getView(R.id.iv_avatar);
                                EditText ed_name = viewHolder.getView(R.id.ed_name);
                                TextView tv_time = viewHolder.getView(R.id.tv_time);

                                Glide.with(WateringFruitTreesActivity.this).load(userTreeDetailModel.getData().getUser().getAvatarUrl()).apply(bitmapTransform(new GlideCircleTransform(WateringFruitTreesActivity.this))).into(iv_avatar);
                                if (!TextUtils.isEmpty(userTreeDetailModel.getData().getUser_tree().getName())) {
                                    ed_name.setText(userTreeDetailModel.getData().getUser_tree().getName());
                                }
                                tv_time.setText(userTreeDetailModel.getData().getUser_tree().getEnd_date() + "到期");
                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.tv_save:
                                        tDialog.dismiss();
                                        break;
                                    case R.id.rl_adoption_certificate:
                                        Intent intent = new Intent(WateringFruitTreesActivity.this, ECertActivity.class);
                                        intent.putExtra("order_no", "");
                                        intent.putExtra("pos", "1");
                                        intent.putExtra("tree_id", userTreeDetailModel.getData().getUser_tree().getUser_tree_id() + "");
                                        startActivity(intent);
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
                Intent intent1 = new Intent(this, BigGiftBagActivity.class);
                intent1.putExtra("tree_id", getIntent().getStringExtra("tree_id"));
                startActivity(intent1);
                break;
            case R.id.ll_watering:
                grow("1");
                break;
            case R.id.rl_tree:
                ScaleAnimation sa = new ScaleAnimation(1f, 1.0f, 1.0f, 1.1f, ScaleAnimation.RELATIVE_TO_SELF, 0.0f, ScaleAnimation.RELATIVE_TO_SELF, 1.0f);
                // 设置动画播放的时间
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
                        // 设置动画播放的时间
                        sa.setDuration(500);
                        sa.setFillAfter(true);
                        rlTree.startAnimation(sa);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                rlTree.startAnimation(sa);
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
                                animation1.setDuration(800);//动画的持续的时间
                                animation1.setRepeatCount(1);
                                ivWaterDrop.startAnimation(animation1);

                                Animation animation2 = new AlphaAnimation(0f, 1.0f);
                                animation2.setDuration(800);//动画的持续的时间
                                animation2.setRepeatCount(1);
                                ivWaterDrop1.startAnimation(animation2);

                                Animation animation3 = new AlphaAnimation(0f, 1.0f);
                                animation3.setDuration(800);//动画的持续的时间
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
                                        animation1.setDuration(1000);//动画的持续的时间
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
                                animation1.setDuration(800);//动画的持续的时间
                                animation1.setRepeatCount(1);
                                ivFertilizer1.startAnimation(animation1);

                                Animation animation2 = new AlphaAnimation(0f, 1.0f);
                                animation2.setDuration(800);//动画的持续的时间
                                animation2.setRepeatCount(1);
                                ivFertilizer2.startAnimation(animation2);

                                Animation animation3 = new AlphaAnimation(0f, 1.0f);
                                animation3.setDuration(800);//动画的持续的时间
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
                                        animation1.setDuration(1000);//动画的持续的时间
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