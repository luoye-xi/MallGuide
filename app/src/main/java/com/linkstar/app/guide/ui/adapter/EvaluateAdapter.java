package com.linkstar.app.guide.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linkstar.app.guide.R;
import com.linkstar.app.guide.model.entity.EvaluateBean;
import com.linkstar.app.guide.widget.MessagePicturesLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class EvaluateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<EvaluateBean> list;
    private MessagePicturesLayout.Callback mCallback;

    public EvaluateAdapter(Context context, Activity activity, List<EvaluateBean> list) {
        this.context = context;
        this.list = list;
        mCallback = (MessagePicturesLayout.Callback) activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_evaluate, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
        ViewHolder holder = (ViewHolder) viewHolder;

        holder.picLayout.setCallback(mCallback);

        List<Uri> uriList = new ArrayList<>();
        uriList.add(Uri.parse("http://pic.58pic.com/58pic/17/29/00/39658PICknp_1024.jpg"));
        uriList.add(Uri.parse("http://pic65.nipic.com/file/20150425/13839354_210311767000_2.jpg"));
        uriList.add(Uri.parse("http://img.zcool.cn/community/013d5b56fe13946ac725794803ca4e.jpg"));
        holder.picLayout.set(uriList , uriList);

        holder.ratingBar.setRating(5f);
        holder.ratingBar.setClickable(false);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_head)
        AppCompatImageView ivHead;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_sku)
        TextView tvSku;
        @BindView(R.id.rating_bar)
        MaterialRatingBar ratingBar;
        @BindView(R.id.pic_layout)
        MessagePicturesLayout picLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}