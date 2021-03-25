package com.pinnoocle.fruitindustryoptimization.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.TreeOrderModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class AdoptionOrderAdapter extends RecyclerView.Adapter<AdoptionOrderAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<TreeOrderModel.DataBean.OrdersBean> mShowItems = new ArrayList<>();

    public AdoptionOrderAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_adoption_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (mShowItems.get(position).getType() == 1) {
            holder.tvType.setText("果树认养");
        } else {
            holder.tvType.setText("果树续费");
        }
        Glide.with(context).load(mShowItems.get(position).getTree_pic()).into(holder.ivImage);
        holder.tvName.setText(mShowItems.get(position).getTree_name());
        holder.tvTime.setText("认养时间：" + mShowItems.get(position).getTime());
        holder.tvTime1.setText(mShowItems.get(position).getCreate_time());
        holder.tvMoney.setText("￥" + mShowItems.get(position).getPrice());
        holder.tvMoney1.setText("实付:  ￥" + mShowItems.get(position).getPay_price());
        holder.tvNum.setText("X " + mShowItems.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<TreeOrderModel.DataBean.OrdersBean> dataBeans) {
        this.mShowItems = dataBeans;
        notifyDataSetChanged();
    }

    //**********************itemClick************************
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.tv_time1)
        TextView tvTime1;
        @BindView(R.id.tv_money1)
        TextView tvMoney1;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
