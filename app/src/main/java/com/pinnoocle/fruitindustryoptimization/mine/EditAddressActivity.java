package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.AddressListModel;
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.event.AddAddressEvent;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;
import com.pinnoocle.fruitindustryoptimization.utils.StatusBarUtil;


import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EditAddressActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ed_area)
    TextView edArea;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_address)
    EditText edAddress;

    CityPickerView mPicker = new CityPickerView();
    String address_id;
    private String districtName;
    private String cityName;
    private String provinceName;
    private DataRepository dataRepository;
    private AddressListModel.DataBean.ListBean dataBean;
    private String is_default;
    private int default_id;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_edit_addresss);
        ButterKnife.bind(this);
        initView();
        mPicker.init(this);
        initData();
    }


    private void initView() {
        Serializable serializableExtra = getIntent().getSerializableExtra("dataBean");
        default_id = getIntent().getIntExtra("default_id", -1);
        dataBean = (AddressListModel.DataBean.ListBean) serializableExtra;
        edName.setText(dataBean.getName().trim());
        edPhone.setText(dataBean.getPhone().trim());
        edAddress.setText(dataBean.getDetail().trim());
        address_id = String.valueOf(dataBean.getAddress_id());
        provinceName = dataBean.getRegion().getProvince();
        cityName = dataBean.getRegion().getCity();
        districtName = dataBean.getRegion().getRegion();
        edArea.setText(provinceName + cityName + districtName);


    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);

    }

    private void addressEdit() {
        if (TextUtils.isEmpty(address_id)) {
            return;
        }
        ViewLoading.show(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("s", "/api/address/edit");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("address_id", address_id);
        map.put("name", edName.getText().toString().trim());
        map.put("phone", edPhone.getText().toString().trim());
        map.put("region", provinceName + "," + cityName + "," + districtName);
        map.put("detail", edAddress.getText().toString().trim());

        dataRepository.addressEdit(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(EditAddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(EditAddressActivity.this);
                StatusModel resultModel = (StatusModel) data;
                if (resultModel.getCode() == 1) {
                    EventBus.getDefault().post(new AddAddressEvent());
                    finish();
                }
                ToastUtils.showToast(resultModel.getMsg());
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.ed_area, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ed_area:
                showCitiesDialog();
                break;
            case R.id.tv_save:
                if (edName.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("????????????????????????");
                } else if (edPhone.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("??????????????????????????????");
                } else if (edArea.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("??????????????????");
                } else if (edAddress.getText().toString().trim().equals("")) {
                    ToastUtils.showToast("???????????????????????????");
                } else {
                    String telRegex = "[1][3456789]\\d{9}";
                    boolean matches = edPhone.getText().toString().matches(telRegex);
                    if (matches == false) {
                        ToastUtils.showToast("???????????????????????????");
                    } else {
                        //????????????????????????
//                        getAreaId();
                        addressEdit();
                    }
                }
                break;
        }

    }

    private void showCitiesDialog() {
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);

//???????????????????????????????????????
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                edArea.setText(province.getName() + " " + city.getName() + " " + district.getName());
                address_id = district.getId();
                provinceName = province.getName();
                cityName = city.getName();
                districtName = district.getName();
                //??????province
                //??????city
                //??????district
            }

            @Override
            public void onCancel() {

            }
        });

        //??????
        mPicker.showCityPicker();
    }

}
