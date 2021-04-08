package com.pinnoocle.fruitindustryoptimization.orchard;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.adapter.GroupWorkListAdapter;
import com.pinnoocle.fruitindustryoptimization.adapter.VideoAdapter;
import com.pinnoocle.fruitindustryoptimization.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class VideoFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private List<String> videos = new ArrayList<>();
    private VideoAdapter videoAdapter;

    public VideoFragment(List<String> videos) {
        this.videos = videos;
    }

    @Override
    protected int LayoutId() {
        return R.layout.video;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        videoAdapter = new VideoAdapter(getActivity());
        recycleView.setAdapter(videoAdapter);
        videoAdapter.setData(videos);
    }
}
