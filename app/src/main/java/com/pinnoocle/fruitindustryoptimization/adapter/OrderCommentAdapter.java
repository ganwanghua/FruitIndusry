package com.pinnoocle.fruitindustryoptimization.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.pinnoocle.fruitindustryoptimization.R;
import com.pinnoocle.fruitindustryoptimization.bean.CommentBean;
import com.pinnoocle.fruitindustryoptimization.bean.OrderDetailModel;
import com.pinnoocle.fruitindustryoptimization.common.BaseAdapter;
import com.pinnoocle.fruitindustryoptimization.home.TaskBigImgActivity;
import com.pinnoocle.fruitindustryoptimization.mine.OrderCommentActivity;
import com.pinnoocle.fruitindustryoptimization.widget.GlideEngine;
import com.pinnoocle.fruitindustryoptimization.widget.GlideRoundTransform;
import com.pinnoocle.fruitindustryoptimization.widget.GridViewInScrollView;
import com.tbruyelle.rxpermissions3.RxPermissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class OrderCommentAdapter extends BaseAdapter<OrderDetailModel.DataBean.OrderBean.GoodsBeanX, OrderCommentAdapter.VH> {
    public Map<Integer,GridViewInScrollView> gridViewMap = new HashMap<>();
    public Map<Integer,OrderCommentAdapter.VH> vhMap = new HashMap<>();
    public Map<Integer, ArrayList<String>> mListMap = new HashMap<>();
    public Map<Integer, ArrayList<String>> cacheListMap = new HashMap<>();
    public Map<Integer, GridView3Adapter> adapterMap = new HashMap<>();
    public Map<Integer, CommentBean> commentMap = new HashMap<>();



    public OrderCommentAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getGoods_attr());
        holder.tvNum.setText("x" + mDatas.get(position).getTotal_num());
        holder.tvPrice.setText("￥" + mDatas.get(position).getGoods_price());
        if (commentMap.get(position) == null) {
            commentMap.put(position, new CommentBean());
        }
        commentMap.get(position).setScore("10");
        holder.llCommentGood.setOnClickListener(v -> {
            selectCommentType(holder.tvGood,holder.tvM,holder.tvBad,holder.ivGood,holder.ivM,holder.ivBad,holder.tvGood,holder.ivGood);
            commentMap.get(position).setScore("10");
        });
        holder.llCommentM.setOnClickListener(v -> {
            selectCommentType(holder.tvGood,holder.tvM,holder.tvBad,holder.ivGood,holder.ivM,holder.ivBad,holder.tvM,holder.ivM);
            commentMap.get(position).setScore("20");
        });
        holder.llCommentBad.setOnClickListener(v -> {
            selectCommentType(holder.tvGood,holder.tvM,holder.tvBad,holder.ivGood,holder.ivM,holder.ivBad,holder.tvBad,holder.ivBad);
            commentMap.get(position).setScore("30");
        });


        holder.rlGoods.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {

            }
        });
        if (mListMap.get(position) == null) {
            ArrayList<String> mList = new ArrayList<>();
            mListMap.put(position, mList);
        }
        grid(holder.gridView, position);
        if (gridResult != null) {
            gridResult.onSetGridResult(holder.gridView, mListMap.get(position),position);
        }
        gridViewMap.put(position,holder.gridView);
        vhMap.put(position,holder);
    }

    public void setResult(GridViewInScrollView gridView, ArrayList<String> mList, int pos) {
        if (cacheListMap.get(pos) == null) {
            ArrayList<String> cacheList = new ArrayList<>();
            cacheListMap.put(pos, cacheList);
        }
        cacheListMap.get(pos).addAll(mList);
        mListMap.put(pos,cacheListMap.get(pos));
        adapterMap.get(pos).setData(cacheListMap.get(pos));
    }




    public void grid(GridViewInScrollView gridView,int pos) {
        GridView3Adapter mGridViewAddImgAdapter = new GridView3Adapter(mContext,  mListMap.get(pos));
        adapterMap.put(pos, mGridViewAddImgAdapter);

        gridView.setAdapter(mGridViewAddImgAdapter);
        mGridViewAddImgAdapter.setOnItemClickListener(new GridView3Adapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                mListMap.get(pos).remove(position);
                mGridViewAddImgAdapter.notifyDataSetChanged();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                rxPermissionTest(gridView,pos);
            }
        });

    }

    private void rxPermissionTest(GridViewInScrollView gridView,int pos) {
        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) mContext);
        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                if (position == parent.getChildCount() - 1) {
                                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过5张，才能点击
                                    if (mListMap.get(pos).size() == 3) {
                                        viewPluImg(mListMap.get(pos), position);
                                    } else {
                                        //添加凭证图片
//                        selectPic();
                                        PictureSelector.create((OrderCommentActivity) mContext)
                                                .openGallery(PictureMimeType.ofImage())
                                                .selectionMode(PictureConfig.MULTIPLE)
                                                .maxSelectNum(3)
                                                .compress(true)
                                                .loadImageEngine(GlideEngine.createGlideEngine())
                                                .enableCrop(false)
                                                .forResult(1000+pos);
                                    }
                                } else {
                                    viewPluImg(mListMap.get(pos), position);
                                }
                            }
                        });

//                        PictureSelector
//                                .create(AdviseActivity.this, PictureSelector.SELECT_REQUEST_CODE)
//                                .selectPicture(true);

                    } else {
                        // Oups permission denied
                    }
                });
    }

    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(mContext, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        mContext.startActivity(imgIntent);
    }


    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    private GridResult gridResult;

    public void setGridResult(GridResult gridResult) {
        this.gridResult = gridResult;
    }

    private void selectCommentType(TextView tvGood,TextView tvM,TextView tvBad,ImageView ivGood,ImageView ivM,ImageView ivBad,TextView textView, ImageView imageView) {
        tvGood.setTextColor(mContext.getResources().getColor(R.color.grey_3));
        tvM.setTextColor(mContext.getResources().getColor(R.color.grey_3));
        tvBad.setTextColor(mContext.getResources().getColor(R.color.grey_3));

        ivGood.setImageResource(R.mipmap.praise_bad);
        ivM.setImageResource(R.mipmap.praise_bad);
        ivBad.setImageResource(R.mipmap.praise_bad);

        textView.setTextColor(mContext.getResources().getColor(R.color.light_red));
        imageView.setImageResource(R.mipmap.praise_good);
    }




    public interface GridResult{
        void onSetGridResult(GridViewInScrollView gridView, ArrayList<String> mList,int pos);
    }

    public static class VH extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.rl_goods)
        RelativeLayout rlGoods;
        @BindView(R.id.tv_good)
        TextView tvGood;
        @BindView(R.id.iv_good)
        ImageView ivGood;
        @BindView(R.id.ll_comment_good)
        LinearLayout llCommentGood;
        @BindView(R.id.tv_m)
        TextView tvM;
        @BindView(R.id.iv_m)
        ImageView ivM;
        @BindView(R.id.ll_comment_m)
        LinearLayout llCommentM;
        @BindView(R.id.tv_bad)
        TextView tvBad;
        @BindView(R.id.iv_bad)
        ImageView ivBad;
        @BindView(R.id.ll_comment_bad)
        LinearLayout llCommentBad;
        @BindView(R.id.ll_comment_type)
        LinearLayout llCommentType;
        @BindView(R.id.ll_grid)
        LinearLayout llGrid;
        @BindView(R.id.ed_advise)
        public EditText edAdvise;
        @BindView(R.id.gridView)
        GridViewInScrollView gridView;
        @BindView(R.id.tv_text_num)
        TextView tvTextNum;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
