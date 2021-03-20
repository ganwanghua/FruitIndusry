package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassificationAdapter extends BaseAdapter<CategoryIndexModel.DataBeanX.ListBean, ClassificationAdapter.VH> {
    //item选中位置
    private int pos = 0;

    public ClassificationAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_classification, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.iv_rect.setVisibility(View.GONE);
        if(pos ==position){
            holder.iv_rect.setVisibility(View.VISIBLE);
        }
        holder.text.setText(mDatas.get(position).getName());
        if (position == pos) {
            holder.text.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            holder.text.setTextColor(mContext.getResources().getColor(R.color.light_red));
        } else {
            holder.text.setBackgroundColor(mContext.getResources().getColor(R.color.white1));
            holder.text.setTextColor(mContext.getResources().getColor(R.color.grey));
        }
        holder.text.setOnClickListener((v) -> {
            if (mOnItemDataClickListener != null) {
            mOnItemDataClickListener.onItemViewClick(v, position,mDatas.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setPos(int position) {
        pos = position;
        notifyDataSetChanged();
    }

    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView text;
        @BindView(R.id.iv_rect)
        ImageView iv_rect;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
