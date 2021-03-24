package com.pinnoocle.fruitindustryoptimization.orchard;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.TreesDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.listener.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BannerImageFragment extends BaseFragment implements OnPageChangeListener {
    @BindView(R.id.goods_banner)
    Banner banner;
    @BindView(R.id.banner_indicator)
    TextView bannerIndicator;
    private List<TreesDetailModel.DataBean.TreeBean.ImagesBean> images = new ArrayList<>();

    public BannerImageFragment(List<TreesDetailModel.DataBean.TreeBean.ImagesBean> images) {
        this.images = images;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_banner_image;
    }

    @Override
    protected void initView() {
        initBanner();
    }

    private void initBanner() {
        banner.isAutoLoop(true)
                .setAdapter(new BannerImageAdapter<TreesDetailModel.DataBean.TreeBean.ImagesBean>(images) {
                    @Override
                    public void onBindView(BannerImageHolder holder, TreesDetailModel.DataBean.TreeBean.ImagesBean data, int position, int size) {
                        //图片加载自己实现
                        Glide.with(holder.itemView)
                                .load(data.getFile_path())
                                .into(holder.imageView);
                    }
                })
                .addOnPageChangeListener(this);
        bannerIndicator.setText("1/" + images.size());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int realposition = position + 1;
        bannerIndicator.setText(realposition + "/" + images.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
