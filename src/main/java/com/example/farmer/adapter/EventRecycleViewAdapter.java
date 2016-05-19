package com.example.farmer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.farmer.R;
import com.example.farmer.beans.EventPortTest;

import java.util.List;

/**
 * Created by jcy on 2016/5/18.
 */
public class EventRecycleViewAdapter extends RecyclerView.Adapter<EventRecycleViewAdapter.EventRecycleViewHolder> implements View.OnClickListener{
    private List<EventPortTest> mList;
    private  OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener = null;

    private Context mContext;

    // 生成构造方法
    public EventRecycleViewAdapter(List<EventPortTest> list, Context context) {
        mList = list;
        mContext = context;
    }


    // 实现点击事件
    @Override
    public void onClick(View v) {
       if(mOnRecyclerViewItemClickListener != null) {
            mOnRecyclerViewItemClickListener.OnItemClick(v, (EventPortTest) v.getTag());
       }

    }

    // 监听接口OnRecyclerViewItemClickListener
    public static interface OnRecyclerViewItemClickListener{
        void OnItemClick(View view, EventPortTest eventPortTest);
    }

    @Override
    public EventRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //定义一个View
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_content_item,parent,false);
        EventRecycleViewHolder eventRecycleViewHolder = new EventRecycleViewHolder(view);
        //注册监听事件
        //view.setOnClickListener(this);
        return eventRecycleViewHolder;
    }


    @Override
    public void onBindViewHolder(EventRecycleViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getPic()).into(holder.mImageView);
        holder.mTextView.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /* @Override
     public int getItemCount() {
         return mList.size();
     }*/
    //新建一个 eventRecycleViewHolder 类
    class EventRecycleViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTextView;
        public EventRecycleViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.evet_content_image);
            mTextView = (TextView) itemView.findViewById(R.id.event_content_textview);
        }
    }
}
