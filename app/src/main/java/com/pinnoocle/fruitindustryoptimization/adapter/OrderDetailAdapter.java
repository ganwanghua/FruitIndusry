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
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.bean.OrderListModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.mine.OrderDetailActivity;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class OrderDetailAdapter extends BaseAdapter<OrderDetailModel.DataBean.OrderBean.GoodsBeanX, OrderDetailAdapter.VH> {


    public OrderDetailAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getGoods_attr());
        holder.tvNum.setText("x" + mDatas.get(position).getTotal_num());
        holder.tvPrice.setText("￥" + mDatas.get(position).getGoods_price());

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemViewClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_num)
        TextView tvNum;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}