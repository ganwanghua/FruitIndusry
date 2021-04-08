package com.pinnoocle.fruitindustryoptimization.orchard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.ImageAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.VideoAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PicFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private List<String> images = new ArrayList<>();
    private ImageAdapter imageAdapter;

    public PicFragment(List<String> images) {
        this.images = images;
    }

    @Override
    protected int LayoutId() {
        return R.layout.video;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        imageAdapter = new ImageAdapter(getActivity());
        recycleView.setAdapter(imageAdapter);
        imageAdapter.setData(images);
    }
}
