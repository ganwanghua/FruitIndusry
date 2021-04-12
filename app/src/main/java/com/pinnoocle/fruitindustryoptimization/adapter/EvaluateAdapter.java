package com.pinnoocle.fruitindustryoptimization.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.kaelli.niceratingbar.NiceRatingBar;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<MyCommentModel.DataBeanX.ListBean.DataBean> mShowItems = new ArrayList<>();

    public EvaluateAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    protected BaseAdapter.OnItemDataClickListener mOnItemDataClickListener;

    public void setOnItemDataClickListener(BaseAdapter.OnItemDataClickListener mOnItemDataClickListener) {
        this.mOnItemDataClickListener = mOnItemDataClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_evaluate, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(mShowItems.get(position).getOrder_goods().getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(context))).into(holder.ivGoodsPic);
        holder.tvName.setText(mShowItems.get(position).getOrder_goods().getGoods_name());
        holder.tvTime.setText(mShowItems.get(position).getCreate_time());
        holder.niceRatingBar.setRating(mShowItems.get(position).getScore());
        holder.tvContent.setText(mShowItems.get(position).getContent());

        if (mShowItems.get(position).getIs_picture() == 1) {
            holder.nineGridImageView.setVisibility(View.VISIBLE);
            List<String> imageList = new ArrayList<>();
            for (int i = 0; i < mShowItems.get(position).getImage().size(); i++) {
                imageList.add(mShowItems.get(position).getImage().get(i).getFile_path());
            }
            holder.nineGridImageView.setAdapter(new NineGridImageViewAdapter<String>() {
                @Override
                protected void onDisplayImage(Context context, ImageView imageView, String o) {
                    Glide.with(context)
                            .load(o)
                            .into(imageView);
                }

                @Override
                protected void onItemImageClick(Context context, ImageView imageView, int index, List list) {
                    viewPluImg((ArrayList<String>) list, index);
                }
            });
            holder.nineGridImageView.setImagesData(imageList);
        } else {
            holder.nineGridImageView.setVisibility(View.GONE);
        }

        holder.ivGoodsPic.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(context, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        context.startActivity(imgIntent);
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public void setData(List<MyCommentModel.DataBeanX.ListBean.DataBean> dataBeans) {
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
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.niceRatingBar)
        NiceRatingBar niceRatingBar;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.nineGridImageView)
        NineGridImageView nineGridImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
