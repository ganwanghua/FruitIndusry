package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.PartakeModel;
import com.pinnoocle.fruitindustryoptimization.bean.SecKillDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.DrawLineTextView;
import com.pinnoocle.fruitindustryoptimization.widget.VerticalMarqueeLayout;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecKillDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.goods_banner)
    Banner goodsBanner;
    @BindView(R.id.marquee_root)
    VerticalMarqueeLayout marqueeRoot;
    @BindView(R.id.banner_indicator)
    TextView bannerIndicator;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_old_money)
    DrawLineTextView tvOldMoney;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_introduction)
    TextView tvIntroduction;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_secKill)
    TextView tvSecKill;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_buy)
    RelativeLayout rlBuy;
    private DataRepository dataRepository;
    private List<String> imagesBeans = new ArrayList<>();
    private SecKillDetailModel secKillDetailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_kill_detail);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        secKillDetail();
    }

    private void secKillDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.active/detail");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("active_id", getIntent().getStringExtra("active_id"));
        dataRepository.secKillDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                secKillDetailModel = (SecKillDetailModel) data;
                if (secKillDetailModel.getCode() == 1) {
                    for (int i = 0; i < secKillDetailModel.getData().getGoods().getImage().size(); i++) {
                        imagesBeans.add(secKillDetailModel.getData().getGoods().getImage().get(i).getFile_path());
                    }
                    initBanner();
                    tvMoney.setText(secKillDetailModel.getData().getActive().getFloor_price());
                    tvOldMoney.setText("￥" + secKillDetailModel.getData().getGoods().getGoods_sku().getGoods_price());
                    tvNumber.setText(secKillDetailModel.getData().getActive().getActive_sales() + "人已秒杀");
                    tvName.setText(secKillDetailModel.getData().getGoods().getGoods_name());
                    tvIntroduction.setText(secKillDetailModel.getData().getGoods().getSelling_point());

                    RichText.from(translation(secKillDetailModel.getData().getGoods().getContent())).bind(this)
                            .showBorder(false)
                            .autoPlay(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tvContent);
                    if (secKillDetailModel.getData().isIs_partake()) {
                        tvBuy.setText("继续秒杀");
                    } else {
                        tvBuy.setText("立即秒杀");
                    }
                }
            }
        });
    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "©");
    }

    @OnClick({R.id.iv_back, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                if (secKillDetailModel.getData().isIs_partake()) {
                    Intent intent = new Intent(SecKillDetailActivity.this, SecKillDetailsActivity.class);
                    intent.putExtra("task_id", secKillDetailModel.getData().getTask_id() + "");
                    startActivity(intent);
                    finish();
                } else {
                    partake();
                }
                break;
        }
    }

    private void partake() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/bargain.task/partake");
        map.put("wxapp_id", "10001");
        map.put("active_id", getIntent().getStringExtra("active_id"));
        map.put("token", FastData.getToken());
        map.put("goods_sku_id", "0");
        dataRepository.partake(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                PartakeModel partakeModel = (PartakeModel) data;
                if (partakeModel.getCode() == 1) {
                    Intent intent = new Intent(SecKillDetailActivity.this, SecKillDetailsActivity.class);
                    intent.putExtra("task_id", partakeModel.getData().getTask_id());
                    startActivity(intent);
                    EventBus.getDefault().post("12");
                    finish();
                }
            }
        });
    }

    public class ImageHolderCreator implements HolderCreator {
        @Override
        public View createView(final Context context, final int index, Object o) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(iv).load(o).into(iv);
            //内部实现点击事件
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, index + "", Toast.LENGTH_LONG).show();
                }
            });
            return iv;
        }
    }

    private void initBanner() {
        goodsBanner.setHolderCreator(new ImageHolderCreator())
                .setOuterPageChangeListener(this)
                .setPages(imagesBeans);

        bannerIndicator.setText("1/" + imagesBeans.size());
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int realposition = position + 1;
        bannerIndicator.setText(realposition + "/" + imagesBeans.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}