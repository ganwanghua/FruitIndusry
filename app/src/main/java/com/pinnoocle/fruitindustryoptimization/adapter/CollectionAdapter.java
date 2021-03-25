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
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CollectModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class CollectionAdapter extends BaseAdapter<CollectModel.DataBean.ListBean, CollectionAdapter.VH> {

    public CollectionAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_collection, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getGoods().getImage().get(0).getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivPicture);
        holder.tvName.setText(mDatas.get(position).getGoods().getGoods_name());
        holder.tvSpec.setText("已售"+mDatas.get(position).getGoods().getSku().get(0).getGoods_sales()+"件");
        holder.tvMoney.setText("￥" + mDatas.get(position).getGoods().getSku().get(0).getGoods_price());
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_picture)
        ImageView ivPicture;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_spec)
        TextView tvSpec;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
