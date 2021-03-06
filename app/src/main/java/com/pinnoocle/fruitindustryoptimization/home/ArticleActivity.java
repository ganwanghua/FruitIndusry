package com.pinnoocle.fruitindustryoptimization.home;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.ArticleModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseActivity;
import com.pinnoocle.fruitindustryoptimization.nets.DataRepository;
import com.pinnoocle.fruitindustryoptimization.nets.Injection;
import com.pinnoocle.fruitindustryoptimization.nets.RemotDataSource;
import com.pinnoocle.fruitindustryoptimization.utils.FastData;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArticleActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.webView)
    WebView mWebView;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        article();
    }

    private void article() {
        ViewLoading.show(this);
        Map<String, String> map = new HashMap<>();
        map.put("s", "/api/article/detail");
        map.put("wxapp_id", "10001");
        map.put("article_id", getIntent().getIntExtra("id", -1) + "");
        map.put("token", FastData.getToken());
        dataRepository.article(map, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                ArticleModel articleModel = (ArticleModel) data;
                if (articleModel.getCode() == 1) {
                    initWeb(translation(articleModel.getData().getDetail().getArticle_content()));
//                    tvArticle.setText(Html.fromHtml(translation(articleModel.getData().getDetail().getArticle_content()), new ImageGetterUtils.MyImageGetter(ArticleActivity.this, tvArticle), null));
                }
            }
        });
    }

    private void initWeb(String content) {

        // ??????WebView???????????????????????????????????????????????????????????????true???????????????
        mWebView.getSettings().setSupportZoom(false);

        // ??????WebView??????????????????????????????????????????????????????????????????????????????????????????false?????????????????????????????????
        mWebView.getSettings().setBuiltInZoomControls(true);

        // ??????????????????DOM??????API???????????????false????????????????????????true???WebView????????????DOM storage API
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        // ?????????????????????.??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        mWebView.requestFocus();
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // ???????????????,?????????????????????,??????webview?????????????????????
//        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mWebView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }

    private String translation(String content) {
        String replace = content.replace("&lt;", "<");
        String replace1 = replace.replace("&gt;", ">");
        String replace2 = replace1.replace("&amp;", "&");
        String replace3 = replace2.replace("&quot;", "\"");
        return replace3.replace("&copy;", "??");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}