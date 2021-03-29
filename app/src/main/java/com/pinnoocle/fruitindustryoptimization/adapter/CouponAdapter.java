package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.haozhang.lib.SlantedTextView;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CouponListsModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CouponAdapter extends BaseAdapter<CouponListsModel.DataBean.ListBean, CouponAdapter.VH> {

    public CouponAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_coupon, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvMoney.setText(mDatas.get(position).getReduce_price());
        holder.tvDiscount.setText("满" + mDatas.get(position).getMin_price() + "元使用");
        holder.tvName.setText(mDatas.get(position).getName());
        holder.tvValidity.setText(mDatas.get(position).getStart_time().getText() + "~" + mDatas.get(position).getEnd_time().getText());
        holder.tvCoupon.setText(mDatas.get(position).getCoupon_type().getText());
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_discount)
        TextView tvDiscount;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_validity)
        TextView tvValidity;
        @BindView(R.id.tv_coupon)
        SlantedTextView tvCoupon;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
