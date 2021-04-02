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
import com.pinnoocle.fruitindustryoptimization.bean.GroupWorkListModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class GroupWorkListAdapter extends RecyclerView.Adapter<GroupWorkListAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<GroupWorkListModel.DataBeanX.ListBean.DataBean> mShowItems = new ArrayList<>();

    public GroupWorkListAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    protected BaseAdapter.OnItemDataClickListener mOnItemDataClickListener;

    public void setOnItemDataClickListener(BaseAdapter.OnItemDataClickListener mOnItemDataClickListener) {
        this.mOnItemDataClickListener = mOnItemDataClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_group_work_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getGoods_image()).into(holder.ivGoodsPic);
        holder.tvTitle.setText(mShowItems.get(position).getGoods_name());
        holder.tvNum.setText(mShowItems.get(position).getPeople() + "人团");
        holder.tvMoney.setText("￥" + mShowItems.get(position).getGoods_min_price());
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mShowItems.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<GroupWorkListModel.DataBeanX.ListBean.DataBean> dataBeans) {
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

        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
