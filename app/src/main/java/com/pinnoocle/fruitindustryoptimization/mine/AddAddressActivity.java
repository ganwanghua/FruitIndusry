package com.pinnoocle.fruitindustryoptimization.mine;

import android.os.Bundle;
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
import com.pinnoocle.fruitindustryoptimization.bean.StatusModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.event.AddAddressEvent;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends BaseActivity {
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
    String area_id;
    private String districtName;
    private String cityName;
    private String provinceName;
    private String is_default = "0";
    private DataRepository dataRepository;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_add_addresss);
        ButterKnife.bind(this);
        initView();
        mPicker.init(this);
        initData();
    }


    private void initView() {

    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
    }

    private void saveUserShip() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/address/add");
        map.put("wxapp_id", "10001");
        map.put("token", FastData.getToken());
        map.put("name", edName.getText().toString().trim());
        map.put("phone", edPhone.getText().toString().trim());
        map.put("detail", edAddress.getText().toString().trim());
        map.put("region", provinceName + "," + cityName + "," + districtName);

        dataRepository.addressAdd(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(AddAddressActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(AddAddressActivity.this);
                StatusModel resultModel = (StatusModel) data;
                if (resultModel.getCode() == 1) {
                    ToastUtils.showToast(resultModel.getMsg());
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
                        saveUserShip();
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
                area_id = district.getId();
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
