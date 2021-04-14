package com.pinnoocle.fruitindustryoptimization.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.kaelli.niceratingbar.NiceRatingBar;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.MyCommentModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.widget.RoundImageView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Evaluation2Adapter extends BaseAdapter<MyCommentModel.DataBeanX.ListBean.DataBean, Evaluation2Adapter.VH> {
    public Evaluation2Adapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_appraise, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (!TextUtils.isEmpty(mDatas.get(position).getUser().getAvatarUrl())) {
            Glide.with(mContext).load(mDatas.get(position).getUser().getAvatarUrl()).centerCrop().into(holder.ivAvater);
        }
        holder.ivAvater.setVisibility(View.GONE);
        holder.niceRatingBar.setRating(mDatas.get(position).getScore());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
        holder.tvComment.setText(mDatas.get(position).getContent());
        holder.tvName.setText(mDatas.get(position).getUser().getNickName());

        if (mDatas.get(position).getIs_picture() == 1) {
            holder.nineGridImageView.setVisibility(View.VISIBLE);
            List<String> imageList = new ArrayList<>();
            for (int i = 0; i < mDatas.get(position).getImage().size(); i++) {
                imageList.add(mDatas.get(position).getImage().get(i).getFile_path());
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

        holder.ivAvater.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemViewClick(v,position);
            }
        });}

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(mContext, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        mContext.startActivity(imgIntent);
    }


    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avater)
        RoundImageView ivAvater;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.niceRatingBar)
        NiceRatingBar niceRatingBar;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.nineGridImageView)
        NineGridImageView nineGridImageView;
        @BindView(R.id.rv_child_comment)
        RecyclerView rvChildComment;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static String stampToDate(long lt) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(lt * 1000);
        res = simpleDateFormat.format(date);
        return res;
    }

}
