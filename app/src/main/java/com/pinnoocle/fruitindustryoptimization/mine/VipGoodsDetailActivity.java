package com.pinnoocle.fruitindustryoptimization.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.CustomProgressBar;
import com.pinnoocle.fruitindustryoptimization.widget.DialogShopCar;
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

public class VipGoodsDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener {


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
    @BindView(R.id.ll_vip_price)
    LinearLayout llVipPrice;
    @BindView(R.id.tv_vip_money)
    TextView tvVipMoney;
    @BindView(R.id.tv_line_money)
    DrawLineTextView tvLineMoney;
    @BindView(R.id.ll_vip)
    LinearLayout llVip;
    @BindView(R.id.cpb_progresbar)
    CustomProgressBar cpbProgresbar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_sales)
    TextView tvSales;
    @BindView(R.id.tv_surplus)
    TextView tvSurplus;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_specifications)
    TextView tvSpecifications;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.ll_collection)
    LinearLayout llCollection;
    @BindView(R.id.ll_shop)
    LinearLayout llShop;
    @BindView(R.id.tv_add_cart)
    TextView tvAddCart;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_buy)
    RelativeLayout rlBuy;
    @BindView(R.id.tv_surplus1)
    TextView tvSurplus1;
    private DataRepository dataRepository;
    private List<String> imagesBeans = new ArrayList<>();
    private GoodsDetailModel.DataBean dataBean;
    private BasePopupView selectDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_goods_detail);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        goodsDetail();
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

    @OnClick({R.id.iv_back, R.id.ll_collection, R.id.ll_shop, R.id.tv_add_cart, R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_collection:
                userCollect();
                break;
            case R.id.ll_shop:
                finish();
                EventBus.getDefault().post("to_shop_cart");
                break;
            case R.id.tv_add_cart:
            case R.id.tv_buy:
                showSelectDialog();
                break;
        }
    }

    private void showSelectDialog() {
        if (dataBean != null) {
            selectDialog = new XPopup.Builder(this)
                    .enableDrag(false)
                    .asCustom(new DialogShopCar(this, getSupportFragmentManager(), dataBean));
            selectDialog.show();

        }
    }

    public class ImageHolderCreator implements HolderCreator {
        @Override
        public View createView(final Context context, final int index, Object o) {
            ImageView iv = new ImageView(context);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(iv).load(o).into(iv);
            //????????????????????????
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
                    dataBean = goodsDetailModel.getData();
                    for (int i = 0; i < goodsDetailModel.getData().getImages().size(); i++) {
                        imagesBeans.add(goodsDetailModel.getData().getImages().get(i).getFile_path());
                    }
                    initBanner();
                    tvMoney.setText(goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price());
                    tvName.setText(goodsDetailModel.getData().getDetail().getGoods_name());
                    tvLineMoney.setText("???" + goodsDetailModel.getData().getDetail().getGoods_sku().getLine_price());
                    cpbProgresbar.setMaxProgress(goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_sales());
                    tvSurplus1.setText("??????:" + goodsDetailModel.getData().getDetail().getGoods_sku().getStock_num() + "???");
                    tvSales.setText("??????:" + goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_sales() + "???");
                    tvSurplus.setText("??????:" + goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_sales() + "???");

                    if (goodsDetailModel.getData().getDetail().getCollect() == 1) {
                        tvCollection.setText("?????????");
                    } else {
                        tvCollection.setText("??????");
                    }
                    RichText.from(translation(goodsDetailModel.getData().getDetail().getContent())).bind(this)
                            .showBorder(false)
                            .autoPlay(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tvContent);

                }
            }
        });
    }

    private void userCollect() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/user/collect");
        map.put("wxapp_id", "10001");
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
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
                    goodsDetail();
                }
            }
        });

    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "??");
    }
}