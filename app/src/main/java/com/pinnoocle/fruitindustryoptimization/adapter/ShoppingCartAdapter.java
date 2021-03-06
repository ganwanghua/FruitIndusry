package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CartListsModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.event.CanSettlement;
import com.pinnoocle.fruitindustryoptimization.event.CartAllCheckedEvent;
import com.pinnoocle.fruitindustryoptimization.home.GoodsDetailsActivity;
import com.pinnoocle.fruitindustryoptimization.widget.NumberButtonExt;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends BaseAdapter<CartListsModel.DataBean.GoodsListBean, ShoppingCartAdapter.VH> {


    public ShoppingCartAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods_cart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.mCheckedCb.setChecked(mDatas.get(position).isIs_select());
        Glide.with(mContext).load(mDatas.get(position).getGoods_image()).centerCrop().into(holder.mGoodsIconIv);
        holder.mGoodsPriceTv.setText(mDatas.get(position).getGoods_sku().getGoods_price());
        holder.mGoodsDescTv.setText(mDatas.get(position).getGoods_name());
        holder.mGoodsCountBtn
//                .setBuyMax(buy_limit)
                .setCurrentNumber(mDatas.get(position).getTotal_num());
//                .setInventory(stock)
//                .setOnWarnListener(new NumberButton.OnWarnListener() {
//                    @Override
//                    public void onWarningForInventory(int inventory) {
//                        ToastUtils.showToast("????????????:" + inventory);
//                    }
//
//                    @Override
//                    public void onWarningForBuyMax(int buyMax) {
//                        ToastUtils.showToast("?????????????????????:" + buyMax);
//                    }
//                });
        holder.rlCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = !holder.mCheckedCb.isChecked();
                mDatas.get(position).setIs_select(flag);
                holder.mCheckedCb.setChecked(flag);
                final boolean isAllChecked = isAllchecked(holder, position);
                isOnechecked(holder, position);
                EventBus.getDefault().post(new CartAllCheckedEvent(isAllChecked));
            }
        });

        holder.mGoodsCountBtn.setViewClick(view -> {
            holder.mCheckedCb.setChecked(true);
            mDatas.get(position).setIs_select(true);
            isOnechecked(holder, position);

            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(view,position,mDatas.get(position));
            }

        });
        holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, GoodsDetailsActivity.class);
                intent.putExtra("goods_id", mDatas.get(position).getGoods_id() + "");
                mContext.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    private boolean isAllchecked(@NonNull VH holder, int position) {
        for (int i = 0; i < mDatas.size(); i++) {
            if (!mDatas.get(i).isIs_select()) {
                return false;
            }
        }
        return true;
    }

    private void isOnechecked(@NonNull VH holder, int position) {
        for (int i = 0; i < mDatas.size(); i++) {
            if (mDatas.get(i).isIs_select()) {
                EventBus.getDefault().post(new CanSettlement(true));
                return;
            }
        }
        EventBus.getDefault().post(new CanSettlement(false));
    }

    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.mCheckedCb)
        CheckBox mCheckedCb;
        @BindView(R.id.rl_check_box)
        RelativeLayout rlCheckBox;
        @BindView(R.id.mGoodsIconIv)
        ImageView mGoodsIconIv;
        @BindView(R.id.mGoodsDescTv)
        TextView mGoodsDescTv;
        @BindView(R.id.mGoodsSkuTv)
        TextView mGoodsSkuTv;
        @BindView(R.id.mGoodsPriceTv)
        TextView mGoodsPriceTv;
        @BindView(R.id.mGoodsCountBtn)
        NumberButtonExt mGoodsCountBtn;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
