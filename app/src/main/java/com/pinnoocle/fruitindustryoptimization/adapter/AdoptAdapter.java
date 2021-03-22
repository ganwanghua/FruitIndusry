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
import com.pinnoocle.fruitindustryoptimization.bean.TreesModel;
import com.pinnoocle.fruitindustryoptimization.widget.TagTextView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class AdoptAdapter extends RecyclerView.Adapter<AdoptAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    List<String> tag = new ArrayList<>();
    private List<TreesModel.DataBean.TreesBean> mShowItems = new ArrayList<>();

    public AdoptAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_adopt, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getPath().get(0).getPath()).into(holder.iv_image);
        tag.clear();
        if (mShowItems.get(position).getType() == 1) {
            tag.add("个人专区");
        } else if (mShowItems.get(position).getType() == 2) {
            tag.add("企业专区");
        }
        holder.tv_title.setContentAndTag(mShowItems.get(position).getTree_title(), tag);
        holder.tv_sub_title.setText(mShowItems.get(position).getSub_title());
        holder.tv_money.setText("￥" + mShowItems.get(position).getPrice_show());
        holder.tv_day.setText(mShowItems.get(position).getCount_down() + "天");
        holder.tv_time.setText(mShowItems.get(position).getTime_name());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setData(List<TreesModel.DataBean.TreesBean> mShowItems) {
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
        private final TagTextView tv_title;
        private final CardView cardView;
        private ImageView iv_image;
        private final TextView tv_sub_title, tv_money, tv_day, tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TagTextView) itemView.findViewById(R.id.tv_title);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            tv_sub_title = (TextView) itemView.findViewById(R.id.tv_sub_title);
            tv_money = (TextView) itemView.findViewById(R.id.tv_money);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
