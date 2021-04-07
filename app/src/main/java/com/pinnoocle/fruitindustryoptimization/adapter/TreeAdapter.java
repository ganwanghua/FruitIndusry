package com.pinnoocle.fruitindustryoptimization.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.UserTreesModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<UserTreesModel.DataBean.TreesBean> mShowItems = new ArrayList<>();

    public TreeAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_tree, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setText(mShowItems.get(position).getName());
        holder.tvTime.setText("期限：" + mShowItems.get(position).getStart_time() + "至" + mShowItems.get(position).getEnd_time());
        holder.tvVarieties.setText("品种：" + mShowItems.get(position).getTypename());
        holder.llWatering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void setData(List<UserTreesModel.DataBean.TreesBean> mShowItems) {
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
        private final TextView tvName, tvVarieties, tvTime;
        private final LinearLayout llWatering;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvVarieties = (TextView) itemView.findViewById(R.id.tv_varieties);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            llWatering = (LinearLayout) itemView.findViewById(R.id.ll_watering);
        }
    }
}
