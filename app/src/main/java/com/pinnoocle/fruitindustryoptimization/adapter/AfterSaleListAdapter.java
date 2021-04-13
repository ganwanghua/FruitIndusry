package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.RefundListsModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class AfterSaleListAdapter extends BaseAdapter<RefundListsModel.DataBeanX.ListBean.DataBean, AfterSaleListAdapter.VH> {


    public AfterSaleListAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_after_sale_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getOrder_goods().getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getOrder_goods().getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getOrder_goods().getGoods_attr());
        holder.tvNum.setText("x" + mDatas.get(position).getOrder_goods().getTotal_num());
        holder.tvPrice.setText("￥" + mDatas.get(position).getOrder_goods().getGoods_price());
        holder.tvPayPrice.setText("￥" + mDatas.get(position).getOrder_goods().getTotal_pay_price());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
        holder.tvStatus.setText(mDatas.get(position).getState_text());

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position,mDatas.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_price_1)
        TextView tvPrice1;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.ll_price)
        LinearLayout llPrice;
        @BindView(R.id.tv_pay_price_1)
        TextView tvPayPrice1;
        @BindView(R.id.tv_pay_price)
        TextView tvPayPrice;
        @BindView(R.id.ll_price_1)
        LinearLayout llPrice1;
        @BindView(R.id.tv_num)
        TextView tvNum;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
