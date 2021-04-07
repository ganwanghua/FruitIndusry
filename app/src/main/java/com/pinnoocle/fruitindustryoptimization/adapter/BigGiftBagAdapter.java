package com.pinnoocle.fruitindustryoptimization.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.TreePacketModel;
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.widget.TagTextView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class BigGiftBagAdapter extends RecyclerView.Adapter<BigGiftBagAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<TreePacketModel.DataBean.GoodsBean> mShowItems = new ArrayList<>();

    public BigGiftBagAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_big_gift_bag, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).into(holder.iv_image);
        holder.tv_sub_title.setText(mShowItems.get(position).getGoods_name());
        holder.tv_name.setText(mShowItems.get(position).getGoods_name());
        holder.tv_money.setText(mShowItems.get(position).getGoods_sku().getGoods_price());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setData(List<TreePacketModel.DataBean.GoodsBean> mShowItems) {
        this.mShowItems = mShowItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
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
        private ImageView iv_image;
        private final TextView tv_sub_title, tv_money, tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_sub_title = (TextView) itemView.findViewById(R.id.tv_sub_title);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
