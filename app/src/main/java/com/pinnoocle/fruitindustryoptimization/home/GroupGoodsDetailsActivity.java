package com.pinnoocle.fruitindustryoptimization.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.MainActivity;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.GroupRuleModel;
import com.pinnoocle.fruitindustryoptimization.bean.SharingGoodsDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.DrawLineTextView;
import com.pinnoocle.fruitindustryoptimization.widget.GroupDialogShopCar;
import com.pinnoocle.fruitindustryoptimization.widget.VerticalMarqueeLayout;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
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

public class GroupGoodsDetailsActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

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
    @BindView(R.id.ic_money)
    TextView icMoney;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.tv_line_money)
    DrawLineTextView tvLineMoney;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_rule_content)
    TextView tvRuleContent;
    @BindView(R.id.tv_rule)
    TextView tvRule;
    @BindView(R.id.tv_service)
    TextView tvService;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.ll_shop)
    LinearLayout llShop;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_group_price)
    TextView tvGroupPrice;
    @BindView(R.id.tv_group_buy)
    TextView tvGroupBuy;
    @BindView(R.id.rl_buy)
    RelativeLayout rlBuy;
    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.ll_group_buy)
    LinearLayout llGroupBuy;
    private DataRepository dataRepository;
    private List<String> imagesBeans = new ArrayList<>();
    private SharingGoodsDetailModel.DataBean dataBean;
    private BasePopupView selectDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_group_details);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);

        sharingGoodsDetail();
    }

    private void sharingGoodsDetail() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.goods/detail");
        map.put("wxapp_id", "10001");
        map.put("goods_id", getIntent().getStringExtra("goods_id"));
        map.put("token", FastData.getToken());
        dataRepository.sharingGoodsDetail(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                SharingGoodsDetailModel sharingGoodsDetailModel = (SharingGoodsDetailModel) data;
                if (sharingGoodsDetailModel.getCode() == 1) {
                    dataBean = sharingGoodsDetailModel.getData();
                    for (int i = 0; i < sharingGoodsDetailModel.getData().getDetail().getImage().size(); i++) {
                        imagesBeans.add(sharingGoodsDetailModel.getData().getDetail().getImage().get(i).getFile_path());
                    }
                    initBanner();
                    tvMoney.setText(sharingGoodsDetailModel.getData().getDetail().getGoods_sku().getSharing_price());
                    tvPrice.setText(sharingGoodsDetailModel.getData().getDetail().getGoods_sku().getGoods_price());
                    tvGroupPrice.setText(sharingGoodsDetailModel.getData().getDetail().getGoods_sku().getSharing_price());
                    tvName.setText(sharingGoodsDetailModel.getData().getDetail().getGoods_name());

                    tvLineMoney.setText("￥" + sharingGoodsDetailModel.getData().getDetail().getGoods_sku().getLine_price());
                    llGroup.setVisibility(View.GONE);

                    RichText.from(translation(sharingGoodsDetailModel.getData().getDetail().getContent())).bind(this)
                            .showBorder(false)
                            .autoPlay(false)
                            .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                            .into(tvContent);

                }
            }
        });
    }


    private void groupRule() {

        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/sharing.setting/getAll");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        dataRepository.groupRule(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                GroupRuleModel groupRuleModel = (GroupRuleModel) data;
                if(groupRuleModel.getCode()==1){
                    String content = groupRuleModel.getData().getSetting().getBasic().getRule_detail();
                    showRuleDialog(content);
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

    private void showSelectDialog(int i) {
        if (dataBean != null) {
            selectDialog = new XPopup.Builder(this)
                    .enableDrag(false)
                    .asCustom(new GroupDialogShopCar(this, getSupportFragmentManager(), dataBean, i));
            selectDialog.show();

        }
    }


    @OnClick({R.id.iv_back, R.id.ll_message, R.id.ll_shop, R.id.ll_buy, R.id.ll_group_buy,R.id.rl_rule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_message:
                break;

            case R.id.ll_shop:
                startActivity(new Intent(mContext, MainActivity.class));
                EventBus.getDefault().post("to_shop_cart");
                finish();
                break;
            case R.id.ll_buy:
                showSelectDialog(10);
                break;
            case R.id.ll_group_buy:
                showSelectDialog(20);
                break;
            case R.id.rl_rule:
                groupRule();
                break;


        }
    }

    private void showRuleDialog(String content) {
        TDialog tDialog = new TDialog.Builder(getSupportFragmentManager())
                .setLayoutRes(R.layout.dialog_rule)
                //设置弹窗展示的xml布局
                .setCancelableOutside(false)
                .setScreenWidthAspect(this, 0.7f)
                .setGravity(Gravity.CENTER)     //设置弹窗展示位置
                .setOnBindViewListener(new OnBindViewListener() {
                    @Override
                    public void bindView(BindViewHolder viewHolder) {
                        TextView tv_content = viewHolder.itemView.findViewById(R.id.tv_content);
                        tv_content.setText(content);
                    }
                })
                .addOnClickListener(R.id.close)
                .setOnViewClickListener(new OnViewClickListener() {
                    @Override
                    public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                        switch (view.getId()){
                            case R.id.close:
                                tDialog.dismiss();
                                break;
                        }
                    }
                })
                .create()   //创建TDialog
                .show();//展示
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