package com.example.farmer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmer.R;
import com.example.farmer.beans.SortTitle;

import java.util.List;

/**
 * Created by jqchen on 2016/5/16.
 */
public class Sort_TitleAdapter extends RecyclerView.Adapter<Sort_TitleAdapter.MyViewHolder> implements View.OnClickListener{
    //数据源
    List<SortTitle> mList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    //定义监听接口
    public static interface OnRecyclerViewItemClickListener{
        void onItemClick(View view,SortTitle sortTitle);
    }
    public void setmOnItemClickListener(OnRecyclerViewItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    public Sort_TitleAdapter(List<SortTitle> mList) {
        this.mList = mList;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_title_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        //注册监听事件
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getContent());
//        Log.e("jqchen",mList.get(position));
        //将对象保存在itemview的tag中，以便点击时进行获取
        holder.itemView.setTag(mList.get(position));
        //如果选中，背景颜色修改为content的背景颜色
        if (mList.get(position).isSeltcted()){
            //选中
            holder.itemView.setBackgroundResource(R.color.sort_content_background);
        }else {
            //未选中
            holder.itemView.setBackgroundResource(R.color.sort_title_background);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null){
            //getTag获取数据
            mOnItemClickListener.onItemClick(v, (SortTitle) v.getTag());
            mList.get(((SortTitle) v.getTag()).getId()).setSeltcted(true);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        //布局只有一行数据
        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            //使用自定义视图
            mTextView = (TextView) itemView.findViewById(R.id.tite_item);
        }
    }
}
