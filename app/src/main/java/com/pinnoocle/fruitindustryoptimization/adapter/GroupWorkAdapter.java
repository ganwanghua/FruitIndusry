package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.ActiveDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupWorkAdapter extends BaseAdapter<ActiveDetailModel.DataBeanX.DetailBean.UsersBean, GroupWorkAdapter.VH> {

    public GroupWorkAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_group_work, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (mDatas.get(position).getUser() != null) {
            Glide.with(mContext).load(mDatas.get(position).getUser().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.ivAvatar);
            holder.tvName.setText(mDatas.get(position).getUser().getNickName());
        }
        if (mDatas.get(position).getIs_creator() == 1) {
            holder.tvChief.setVisibility(View.VISIBLE);
        } else {
            holder.tvChief.setVisibility(View.GONE);
        }

    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_chief)
        TextView tvChief;
        @BindView(R.id.tv_name)
        TextView tvName;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
