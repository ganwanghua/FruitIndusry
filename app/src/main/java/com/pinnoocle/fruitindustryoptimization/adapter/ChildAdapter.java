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
import com.pinnoocle.fruitindustryoptimization.bean.CategoryIndexModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChildAdapter extends BaseAdapter<CategoryIndexModel.DataBeanX.ListBean.GoodsBean.DataBean, ChildAdapter.VH> {


    public ChildAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_child, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getGoods_image()).into(holder.ivGoodsPic);
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvDesc.setText(mDatas.get(position).getSelling_point());
        holder.tvSales.setText("已售" + mDatas.get(position).getGoods_sku().getGoods_sales() + "件");
        holder.tvPrice.setText("￥" + mDatas.get(position).getGoods_sku().getGoods_old_price());
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        holder.ivAddCart.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_sales)
        TextView tvSales;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.iv_add_cart)
        ImageView ivAddCart;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
