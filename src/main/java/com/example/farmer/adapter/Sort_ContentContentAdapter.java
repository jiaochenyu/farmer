package com.example.farmer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farmer.R;
import com.example.farmer.beans.SortContentContent;

import java.util.List;

/**
 * Created by jqchen on 2016/5/17.
 */
public class Sort_ContentContentAdapter extends RecyclerView.Adapter<Sort_ContentContentAdapter.MyViewHolder> implements View.OnClickListener{
    private List<SortContentContent> mList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    //定义监听接口
    public static interface OnRecyclerViewItemClickListener{

        void onItemClick(View view,SortContentContent scc);
    }
    public void setmOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }
    public Sort_ContentContentAdapter(List<SortContentContent> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_content_content_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        //注册监听事件
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getConten());
        holder.mImageView.setImageURI(mList.get(position).getUri());
        holder.itemView.setTag(mList.get(position));
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(v, (SortContentContent) v.getTag());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.sort_content_content_image);
            mTextView = (TextView) itemView.findViewById(R.id.sort_content_content_textview);
        }
    }
}
