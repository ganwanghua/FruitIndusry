package com.pinnoocle.fruitindustryoptimization.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import ren.qinc.numberbutton.NumberButton;

public class NumberButtonExt extends NumberButton {
    public void setViewClick(ViewClick viewClick) {
        this.viewClick = viewClick;
    }

    private ViewClick viewClick;

    public NumberButtonExt(Context context) {
        super(context);
    }

    public NumberButtonExt(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (viewClick != null) {
            viewClick.onViewClick(v);
        }
    }

    public interface ViewClick {
        void onViewClick(View view);
    }
}
