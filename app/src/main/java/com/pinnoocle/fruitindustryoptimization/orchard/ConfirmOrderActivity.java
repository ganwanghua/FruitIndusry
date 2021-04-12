package com.pinnoocle.fruitindustryoptimization.orchard;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.BeforeBuyModel;
import com.pinnoocle.fruitindustryoptimization.bean.GeneTreeOrderModel;
import com.pinnoocle.fruitindustryoptimization.common.AppManager;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.mine.AddressActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.widget.NumberButton1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmOrderActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_adoption_agreement)
    TextView tvAdoptionAgreement;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.rl_buy)
    RelativeLayout rlBuy;
    @BindView(R.id.tv_authorized_phone)
    TextView tvAuthorizedPhone;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_sub_title)
    TextView tvSubTitle;
    @BindView(R.id.tv_all_money)
    TextView tvAllMoney;
    @BindView(R.id.number_button)
    NumberButton1 numberButton;
    @BindView(R.id.tv_remission_money)
    TextView tvRemissionMoney;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_tree_name)
    EditText edTreeName;
    @BindView(R.id.ed_wish)
    EditText edWish;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.iv_gps)
    ImageView ivGps;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone1)
    TextView tvPhone1;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    private DataRepository dataRepository;
    private BeforeBuyModel beforeBuyModel;
    private int num = 1;
    private boolean isSelect = true;
    private String address_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
        dataRepository = Injection.dataRepository(this);
        beforeBuy(num);

        final String linkWord1 = "《认养协议》";
        String word = "我已阅读并同意" + linkWord1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(word);
        int index1 = word.indexOf(linkWord1);
        spannableStringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent1 = new Intent(ConfirmOrderActivity.this, AdoptionAgreementActivity.class);
                intent1.putExtra("content", beforeBuyModel.getData().getTree().getRules());
                intent1.putExtra("title", "认养须知");
                startActivity(intent1);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(0xffDA251D);       //设置文件颜色
                ds.setUnderlineText(false);
            }
        }, index1, index1 + linkWord1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAdoptionAgreement.setText(spannableStringBuilder);
        tvAdoptionAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        tvAdoptionAgreement.setHighlightColor(getResources().getColor(R.color.transparent));

        numberButton.setOnNumberButtonListener(new NumberButton1.OnNumberButtonListener() {
            @Override
            public void onNumberButtonListener(View v) {
                beforeBuy(numberButton.getNumber());
            }
        });
    }

    private void beforeBuy(int num) {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/before_buy");
        map.put("wxapp_id", "10001");
        map.put("tree_id", getIntent().getStringExtra("id"));
        map.put("token", FastData.getToken());
        map.put("month", "12");
        map.put("number", num + "");
        map.put("address_id", "");
        dataRepository.beforeBuy(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                beforeBuyModel = (BeforeBuyModel) data;
                if (beforeBuyModel.getCode() == 1) {
                    tvTitle.setText(beforeBuyModel.getData().getTree().getTree_title());
                    tvArea.setText(beforeBuyModel.getData().getTree().getSub_title());
                    tvSubTitle.setText(beforeBuyModel.getData().getTree().getSub_title());
                    if (beforeBuyModel.getData().getTree().getType() == 1) {
                        tvType.setText("个人");
                    } else {
                        tvType.setText("企业");
                    }
                    tvAllMoney.setText("订单金额：￥" + beforeBuyModel.getData().getTree().getTotal_price());
                    if (beforeBuyModel.getData().getTree().getDiscount_price() == 0) {
                        tvRemissionMoney.setVisibility(View.GONE);
                    } else {
                        tvRemissionMoney.setVisibility(View.VISIBLE);
                        tvRemissionMoney.setText("待减免金额：￥" + beforeBuyModel.getData().getTree().getDiscount_price());
                    }
                    if (beforeBuyModel.getData().getUser().getAddress() != null) {
                        rlName.setVisibility(View.VISIBLE);
                        tvName.setText(beforeBuyModel.getData().getUser().getAddress().getName());
                        tvAddress.setText(beforeBuyModel.getData().getUser().getAddress().getRegion().getProvince() + beforeBuyModel.getData().getUser().getAddress().getRegion().getCity() + beforeBuyModel.getData().getUser().getAddress().getRegion().getRegion() + beforeBuyModel.getData().getUser().getAddress().getDetail());
                        tvPhone1.setText(beforeBuyModel.getData().getUser().getAddress().getPhone());
                        address_id = beforeBuyModel.getData().getUser().getAddress().getAddress_id() + "";
                    } else {
                        rlName.setVisibility(View.GONE);
                        tvAddress.setText("请选择配送地址");
                    }
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9 && resultCode == RESULT_OK) {
            if (data.getSerializableExtra("result") != null) {
                Serializable result = data.getSerializableExtra("result");
                AddressListModel.DataBean.ListBean userShipBean = (AddressListModel.DataBean.ListBean) result;
                if (userShipBean == null) {
                    beforeBuy(numberButton.getNumber());
                } else {
                    rlName.setVisibility(View.VISIBLE);
                    address_id = userShipBean.getAddress_id() + "";
                    tvName.setText(userShipBean.getName());
                    String phone = userShipBean.getPhone().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    tvPhone1.setText(phone);
                    tvAddress.setText(userShipBean.getRegion().getProvince() + userShipBean.getRegion().getCity() + userShipBean.getRegion().getRegion());
                }
            }
        }
        if (requestCode == 9 && resultCode == 1001) {
            beforeBuy(numberButton.getNumber());
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_buy, R.id.iv_select, R.id.rl_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                Intent intent = new Intent(this, AddressActivity.class);
                intent.putExtra("from", "from");
                startActivityForResult(intent, 9);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                geneTreeOrder();
                break;
            case R.id.iv_select:
                if (isSelect) {
                    ivSelect.setImageResource(R.mipmap.select);
                    isSelect = false;
                } else {
                    ivSelect.setImageResource(R.mipmap.unselect);
                    isSelect = true;
                }
                break;
        }
    }

    private void geneTreeOrder() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/tree/gene_tree_order");
        map.put("wxapp_id", "10001");
        map.put("tree_id", getIntent().getStringExtra("id"));
        map.put("token", FastData.getToken());
        map.put("spec", beforeBuyModel.getData().getTree().getType() + "");
        map.put("number", numberButton.getNumber() + "");
        map.put("time", beforeBuyModel.getData().getTree().getMonth());
        map.put("land_id", beforeBuyModel.getData().getTree().getLand_id() + "");
        map.put("name", edName.getText().toString());
        map.put("phone", edPhone.getText().toString());
        map.put("address_id", beforeBuyModel.getData().getUser().getAddress().getAddress_id() + "");
        map.put("tree_name", edTreeName.getText().toString());
        map.put("share_id", FastData.getUserId());
        map.put("wish", edWish.getText().toString());
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
                    Intent intent = new Intent(ConfirmOrderActivity.this, ECertActivity.class);
                    intent.putExtra("order_no",geneTreeOrderModel.getData().getOrder_no());
                    intent.putExtra("tree_id",getIntent().getStringExtra("id"));
                    intent.putExtra("pos", "2");
                    startActivity(intent);
                }
            }
        });
    }
}