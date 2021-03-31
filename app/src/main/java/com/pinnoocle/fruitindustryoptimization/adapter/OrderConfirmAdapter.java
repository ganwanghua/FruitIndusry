package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.BuyNowModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderConfirmAdapter extends BaseAdapter<BuyNowModel.DataBean.GoodsListBean, OrderConfirmAdapter.VH> {



    public OrderConfirmAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order_confirm, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getGoods_image()).into(holder.ivGoodsPic);
        holder.tvGoodsTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvPrice.setText("￥"+mDatas.get(position).getTotal_price());
        holder.tvNums.setText("x"+mDatas.get(position).getTotal_num());
//        holder.tvSpec.setText(mDatas.get(position).getg);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_goods_title)
        TextView tvGoodsTitle;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_spec)
        TextView tvSpec;
        @BindView(R.id.tv_nums)
        TextView tvNums;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
