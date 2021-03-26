package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.VerticalMarqueeLayout;
import com.to.aboomy.banner.Banner;
import com.to.aboomy.banner.HolderCreator;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailsActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

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
    TextView tvOldMoney;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_line_money)
    TextView tvLineMoney;
    @BindView(R.id.iv_discount)
    ImageView ivDiscount;
    @BindView(R.id.tv_money1)
    TextView tvMoney1;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_selling_point)
    TextView tvSellingPoint;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_content)
    TextView tvContent;
    private DataRepository dataRepository;
    private List<String> imagesBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        goodsDetail();
    }

    private void goodsDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/detail");
        map.put("wxapp_id", "10001");
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
//        map.put("is_rush", );
//        map.put("activity_id", );
        map.put("token", FastData.getToken());
        dataRepository.goodsDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                GoodsDetailModel goodsDetailModel = (GoodsDetailModel) data;
                if (goodsDetailModel.getCode() == 1) {
                    for (int i = 0; i < goodsDetailModel.getData().getImages().size(); i++) {
                        imagesBeans.add(goodsDetailModel.getData().getImages().get(i).getFile_path());
                    }
                    initBanner();
                    tvMoney.setText(goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price());
                    tvName.setText(goodsDetailModel.getData().getDetail().getGoods_name());
                    tvOldMoney.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getBalance_price());
                    tvLineMoney.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getLine_price());
                    tvMoney1.setText(goodsDetailModel.getData().getDetail().getFirst_money());
                    tvSellingPoint.setText(goodsDetailModel.getData().getDetail().getSelling_point());
                    tvNum.setText("剩余:" + goodsDetailModel.getData().getDetail().getGoods_sku().getStock_num() + "件");

                    RichText.from(translation(goodsDetailModel.getData().getDetail().getContent())).bind(this)
                            .showBorder(false)
                            .autoPlay(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tvContent);
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

    //举个栗子
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