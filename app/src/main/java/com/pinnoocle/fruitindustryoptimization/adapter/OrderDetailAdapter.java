package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.text.TextUtils;
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
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class OrderDetailAdapter extends BaseAdapter<OrderDetailModel.DataBean.OrderBean.GoodsBeanX, OrderDetailAdapter.VH> {
    private boolean show = false;

    public void setShow(boolean show) {
        this.show = show;
    }

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
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        if(show){
            holder.tvAfterSale.setVisibility(View.VISIBLE);
        }else {
            holder.tvAfterSale.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(mDatas.get(position).getRefund())) {
            if(show) {
                holder.tvAfterSale.setVisibility(View.VISIBLE);
            }
            holder.tvAfterSaleText.setVisibility(View.GONE);
        }else {
            holder.tvAfterSale.setVisibility(View.GONE);
            holder.tvAfterSaleText.setVisibility(View.VISIBLE);
        }

        holder.tvAfterSale.setOnClickListener(v -> {
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
        @BindView(R.id.tv_after_sale_text)
        TextView tvAfterSaleText;
        @BindView(R.id.tv_after_sale)
        TextView tvAfterSale;
        @BindView(R.id.rl_after_sale)
        RelativeLayout rlAfterSale;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}