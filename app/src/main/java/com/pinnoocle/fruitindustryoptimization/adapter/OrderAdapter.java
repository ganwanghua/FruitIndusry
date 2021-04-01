package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.OrderListModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends BaseAdapter<OrderListModel.DataBeanX.ListBean.DataBean, OrderAdapter.VH> {


    public OrderAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvStatus.setText(mDatas.get(position).getState_text());
        holder.tvTotalNum.setText("共" + mDatas.get(position).getGoods().size() + "件商品，实付:");
//        if(mDatas.get(position).getIs_vip_order()==1){
//            holder.tvPrice.setText( mDatas.get(position).getPay_price()+"金豆");
//        }else {
        holder.tvPayMoney.setText("￥" + mDatas.get(position).getPay_price());
//        }
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        List<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean> goods = mDatas.get(position).getGoods();
        InnerOrderAdapter adapter = new InnerOrderAdapter(mContext);
        adapter.setData(goods);
        holder.recyclerView.setAdapter(adapter);
        holder.tvCancel.setVisibility(View.VISIBLE);
        ;
        switch (mDatas.get(position).getState_text()) {
            case "待付款":
                holder.rlPanel.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(0xffFF5126);
                holder.tvCancel.setText("取消");
                holder.tvPay.setText("去付款");
                break;
            case "待发货":
                holder.rlPanel.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(0xff00D572);
                break;
            case "待收货":
                holder.rlPanel.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(0xffFFB400);
                holder.tvCancel.setText("联系客服");
                holder.tvPay.setText("确认收货");
                break;
            case "已完成":
                if (mDatas.get(position).getIs_comment() == 0) {
                    holder.rlPanel.setVisibility(View.VISIBLE);
                    holder.tvStatus.setTextColor(0xff666666);
                    holder.tvCancel.setVisibility(View.GONE);
                    holder.tvPay.setText("去评价");
                } else {
                    holder.rlPanel.setVisibility(View.GONE);
                    holder.tvStatus.setTextColor(0xff666666);
                }

                break;
            case "已评价":
            case "已取消":
                holder.rlPanel.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(0xff666666);
                break;

        }
        holder.tvPay.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        holder.tvCancel.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

//        holder.itemView.setOnClickListener(v ->
//        {
//            Intent intent = new Intent(mContext, OrderDetailActivity.class);
//            intent.putExtra("order_id", mDatas.get(position).getOrder_id());
//            mContext.startActivity(intent);
//        });
//        adapter.setOnItemClickListener((v, pos) -> {
//            Intent intent = new Intent(mContext, OrderDetailActivity.class);
//            intent.putExtra("order_id", mDatas.get(position).getOrder_id());
//            mContext.startActivity(intent);
//
//        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class VH extends RecyclerView.ViewHolder {


        @BindView(R.id.ll_free_shipping)
        LinearLayout llFreeShipping;
        @BindView(R.id.tv_type)
        TextView tvType;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_total_num)
        TextView tvTotalNum;
        @BindView(R.id.tv_pay_money)
        TextView tvPayMoney;
        @BindView(R.id.tv_after_sales)
        TextView tvAfterSales;
        @BindView(R.id.tv_cancel)
        TextView tvCancel;
        @BindView(R.id.tv_pay)
        TextView tvPay;
        @BindView(R.id.rl_panel)
        RelativeLayout rlPanel;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
