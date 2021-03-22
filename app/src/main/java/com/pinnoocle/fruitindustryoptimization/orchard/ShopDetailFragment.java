package com.pinnoocle.fruitindustryoptimization.orchard;

import android.text.Html;
import android.webkit.WebSettings;
import android.widget.TextView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;
import com.pinnoocle.fruitindustryoptimization.widget.ImageGetterUtils;

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
        tvContent.setText(Html.fromHtml(translation(detail1), new ImageGetterUtils.MyImageGetter(getActivity(), tvContent), null));
    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "©");
    }
}