package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.Evaluation2Adapter;
import com.pinnoocle.fruitindustryoptimization.adapter.EvaluationAdapter;
import com.pinnoocle.fruitindustryoptimization.bean.GoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.bean.VipIntroModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.orchard.AdoptionAgreementActivity;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.DialogShopCar;
import com.pinnoocle.fruitindustryoptimization.widget.VerticalMarqueeLayout;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnViewClickListener;
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
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
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
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.ll_look)
    LinearLayout llLook;
    @BindView(R.id.rl_server)
    RelativeLayout rlServer;
    @BindView(R.id.tv_evaluation)
    TextView tvEvaluation;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.rl_appraise)
    RelativeLayout rlAppraise;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    private DataRepository dataRepository;
    private List<String> imagesBeans = new ArrayList<>();
    private GoodsDetailModel.DataBean dataBean;
    private BasePopupView selectDialog;
    private EvaluationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_details);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        initView();
        goodsDetail();
        goodsComment();

    }

    private void initView() {
        adapter = new EvaluationAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    tvOldMoney.setText("￥" + decimalFormat.format(Double.parseDouble(goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price()) * 0.9));
                    tvLineMoney.setText("￥" + goodsDetailModel.getData().getDetail().getGoods_sku().getLine_price());
                    tvMoney1.setText("" + decimalFormat.format(Double.parseDouble(goodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price()) * 0.1));
                    tvSellingPoint.setText(goodsDetailModel.getData().getDetail().getSelling_point());
                    tvNum.setText("剩余:" + goodsDetailModel.getData().getDetail().getGoods_sku().getStock_num() + "件");
                    tvCoupon.setText(goodsDetailModel.getData().getCoupon().getName());
                    if (goodsDetailModel.getData().getDetail().getCollect() == 1) {
                        tvCollection.setText("已收藏");
                    } else {
                        tvCollection.setText("收藏");
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

    private void goodsComment() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/comment/lists");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("scoreType", "-1");
        map.put("page", "1");
        dataRepository.goodsComment(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {
                MyCommentModel myCommentModel = (MyCommentModel) data;
                if (myCommentModel.getCode() == 1) {
                    tvEvaluation.setText("评价（" + myCommentModel.getData().getTotal().getAll() + "条）");

                    List<MyCommentModel.DataBeanX.ListBean.DataBean> comments = new ArrayList<>();
                    List<MyCommentModel.DataBeanX.ListBean.DataBean> dataBeans = myCommentModel.getData().getList().getData();
                    for (int i = 0; i < dataBeans.size(); i++) {
                        if (i > 1) {
                            break;
                        }
                        comments.add(dataBeans.get(i));
                    }
                    adapter.setData(comments);
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

    private void vipIntro() {
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/goods/vip_intro");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.vipIntro(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
            }

            @Override
            public void onSuccess(Object data) {

                VipIntroModel vipIntroModel = (VipIntroModel) data;
                if (vipIntroModel.getCode() == 1) {
                    Intent intent1 = new Intent(mContext, AdoptionAgreementActivity.class);
                    intent1.putExtra("content", vipIntroModel.getData().getVip_intro());
                    intent1.putExtra("title", "兵团优选");
                    startActivity(intent1);
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

    private void showSelectDialog() {
        if (dataBean != null) {
            selectDialog = new XPopup.Builder(this)
                    .enableDrag(false)
                    .asCustom(new DialogShopCar(this, getSupportFragmentManager(), dataBean));
            selectDialog.show();

        }
    }


    @OnClick({R.id.iv_back, R.id.ll_message, R.id.ll_collection, R.id.ll_shop, R.id.tv_add_cart, R.id.tv_buy, R.id.ll_look, R.id.rl_server, R.id.tv_more, R.id.rl_coupon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_message:
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
            case R.id.ll_look:
                vipIntro();
                break;
            case R.id.rl_server:
                showServerDialog();
                break;
            case R.id.tv_more:
                Intent intent = new Intent(this, EvaluationActivity.class);
                intent.putExtra("goods_id", getIntent().getStringExtra("goods_id"));
                startActivity(intent);
                break;
            case R.id.rl_coupon:
                    startActivity(new Intent(mContext, CouponsCenterActivity.class));
                break;
        }
    }

    private void showServerDialog() {
        new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.server_dialog)
                .setScreenWidthAspect(mContext, 1f)
                .setGravity(Gravity.BOTTOM)
                .setCancelableOutside(true)
                .addOnClickListener(R.id.tv_sure)
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()) {
                            case R.id.tv_sure:
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()
                .show();
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