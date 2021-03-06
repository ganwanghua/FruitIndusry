package com.pinnoocle.fruitindustryoptimization;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.fruitindustryoptimization.adapter.MainAdapter;
import com.pinnoocle.fruitindustryoptimization.classification.ClassificationFragment;
import com.pinnoocle.fruitindustryoptimization.common.AppManager;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.home.HomeFragment;
import com.pinnoocle.fruitindustryoptimization.mine.MineFragment;
import com.pinnoocle.fruitindustryoptimization.orchard.OrchardFragment;
import com.pinnoocle.fruitindustryoptimization.shoppingcart.ShoppingCartFragment;
import com.pinnoocle.fruitindustryoptimization.utils.DensityUtil;
import com.pinnoocle.fruitindustryoptimization.widget.NoScrollViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    private List<Fragment> mList;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        AppManager.getInstance().addActivity(this);
        initBottomNavigationBar();
        initViewPager();

        if (getIntent().getIntExtra("pos", -1) == 1) {
            bottomNavigationBar.selectTab(2);
        }
    }


    private void initBottomNavigationBar() {
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        BottomNavigationItem shopCartItem = new BottomNavigationItem(R.mipmap.shopcart_select, "?????????")
                .setInactiveIconResource(R.mipmap.shopcart_unselect)
                .setActiveColorResource(R.color.light_red)
                .setInActiveColorResource(R.color.grey);
//        shopCartItem.setBadgeItem(new TextBadgeItem().setText("99"));
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home_select, "??????")
                        .setInactiveIconResource(R.mipmap.home_unselect)
                        .setActiveColorResource(R.color.light_red)
                        .setInActiveColorResource(R.color.grey)

                )
                .addItem(new BottomNavigationItem(R.mipmap.all_select, "??????")
                        .setInactiveIconResource(R.mipmap.all_unselect)
                        .setActiveColorResource(R.color.light_red)
                        .setInActiveColorResource(R.color.grey)
                )
                .addItem(new BottomNavigationItem(R.mipmap.tree_select, "??????")
                        .setInactiveIconResource(R.mipmap.tree_unselect)
                        .setActiveColorResource(R.color.light_red)
                        .setInActiveColorResource(R.color.grey)
                )

                .addItem(shopCartItem)
                .addItem(new BottomNavigationItem(R.mipmap.mine_select, "??????")
                        .setInactiveIconResource(R.mipmap.mine_unselect)
                        .setActiveColorResource(R.color.light_red)
                        .setInActiveColorResource(R.color.grey)
                )
                .setFirstSelectedPosition(0)
                .initialise();
        setBottomNavigationItem(4, 22);

    }

    private void setBottomNavigationItem(int space, int imgLen) {
        float contentLen = 36;
        Class barClass = bottomNavigationBar.getClass();
        Field[] fields = barClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            if (field.getName().equals("mTabContainer")) {
                try { //???????????? mTabContainer
                    LinearLayout mTabContainer = (LinearLayout) field.get(bottomNavigationBar);
                    for (int j = 0; j < mTabContainer.getChildCount(); j++) {
                        //??????????????????????????? Tab
                        View view = mTabContainer.getChildAt(j);
                        //?????????Tab????????????????????????
                        // ?????????Tab??????????????????
                        TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                        //?????????????????????DP???????????????setTextSize??????????????????????????????????????????????????????????????????????????????????????????????????????????????????*??????2?????????????????????????????????DP???????????????????????????
                        labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (float) (Math.sqrt(2) * (contentLen - imgLen - space)));
                        //?????????Tab??????????????????
                        ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                        //??????????????????????????????MethodUtils.dip2px()?????????dp???
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) DensityUtil.dip2px(this, imgLen), (int) DensityUtil.dip2px(this, imgLen));
                        params.gravity = Gravity.CENTER;
                        iconView.setLayoutParams(params);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initViewPager() {
        mList = new ArrayList<>();
        homeFragment = new HomeFragment();
        mList.add(homeFragment);
        mList.add(new ClassificationFragment());
        mList.add(new OrchardFragment());
        mList.add(new ShoppingCartFragment());
        mList.add(new MineFragment());


        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(mList.size());
        viewPager.setOnPageChangeListener(this);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), mList);
        viewPager.setAdapter(mainAdapter); //?????????????????????
        viewPager.setNoScroll(true);
    }


    @Override
    public void onTabSelected(int position) {

        viewPager.setCurrentItem(position, false);
    }


    @Override
    public void onTabUnselected(int position) {
        if (position == 3) {
            EventBus.getDefault().post("refreshEditStatus");
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0 || position == 4) {
            initRed();
        } else {
            initWhite();
        }
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //???ui???????????????????????????100
    public void onEvent(String event) {
        if (event.equals("2")) {
            bottomNavigationBar.selectTab(2);
        } else if (event.equals("to_shop_cart")) {
            bottomNavigationBar.selectTab(3);
        } else if (event.equals("3")) {
            bottomNavigationBar.selectTab(0);
        }
    }

    /**
     * ?????????????????????
     */
    long firstTime = 0;

    @Override
    public void onBackPressed() {
        if (homeFragment != null) {
            homeFragment.onBackPressed();
        }
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 800) { // ????????????????????????800??????????????????
            ToastUtils.showToast("????????????????????????");
            firstTime = secondTime; // ??????firstTime
        } else {
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }
}