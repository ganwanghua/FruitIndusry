package com.pinnoocle.fruitindustryoptimization.orchard;

import android.text.Html;
import android.widget.TextView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.widget.ImageGetterUtils;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;

public class ShopDetailFragment extends BaseFragment {

    @BindView(R.id.tv_content)
    TextView tvContent;
    private String detail1;

    public ShopDetailFragment(String detail1) {
        this.detail1 = detail1;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_shop_detail;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        RichText.from(translation(detail1)).bind(this)
                .showBorder(false)
                .autoPlay(false)
                .size(ImageHolder.MATCH_PARENT, ImageHolder.WRAP_CONTENT)
                .into(tvContent);
    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "©");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RichText.clear(getActivity());
    }
}