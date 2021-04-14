package com.pinnoocle.fruitindustryoptimization.mine;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;

public class SecKillOrderFragment extends BaseFragment {
    private String dataType;

    public SecKillOrderFragment(String dataType) {
        this.dataType = dataType;
    }

    @Override
    protected int LayoutId() {
        return R.layout.sec_kill_order;
    }
}
