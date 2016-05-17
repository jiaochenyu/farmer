package com.example.farmer.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmer.R;
import com.example.farmer.beans.SortContent;
import com.example.farmer.beans.SortContentContent;

import java.util.List;

/**
 * Created by jqchen on 2016/5/17.
 */
public class Sort_ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public static final int ITEM_TYPE_ONE = 1;
    public static final int ITEM_TYPE_TWO = 2;
    //数据源
    List<SortContent> mList;
    Context mContext;

    public Sort_ContentAdapter(Context mContext, List<SortContent> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    //获取布局的类型种类，我用了两种

    @Override
    public int getItemViewType(int position) {
        return position%2==0? ITEM_TYPE_ONE : ITEM_TYPE_TWO;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_ONE){
            //分类的二级标题
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_content_title,parent,false);
            ItemOneViewHolder itemOneViewHolder = new ItemOneViewHolder(view);
            return itemOneViewHolder;
        }else if (viewType == ITEM_TYPE_TWO){
            //分类的详细内容
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_content_content,parent,false);
            ItemTwoViewHolder itemTwoViewHolder = new ItemTwoViewHolder(view);
            return itemTwoViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemOneViewHolder){
            ItemOneViewHolder one= (ItemOneViewHolder) holder;
            one.mTextView.setText(mList.get(position/2).getContent());
        }else if (holder instanceof ItemTwoViewHolder){
            ItemTwoViewHolder two = (ItemTwoViewHolder) holder;
            //获得分类详细的内容，list集合
            List<SortContentContent> list = mList.get((position-1)/2).getmList();
            //初始化适配器
            Sort_ContentContentAdapter contentAdapter  = new Sort_ContentContentAdapter(list);
            //新建布局管理器
            GridLayoutManager grid  = new GridLayoutManager(mContext,3);
            //绑定布局器
            two.mRecyclerView.setLayoutManager(grid);
            //绑定适配器
            two.mRecyclerView.setAdapter(contentAdapter);
            //对适配器进行监听
            contentAdapter.setmOnItemClickListener(new Sort_ContentContentAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, SortContentContent scc) {
                    Log.e("jqchen",scc.getConten());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size()*2;
    }


    public class ItemOneViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ItemOneViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.sort_content_title);
        }
    }
    public class ItemTwoViewHolder extends RecyclerView.ViewHolder {
        //详细分类，有三类
        RecyclerView mRecyclerView;
        public ItemTwoViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.sort_content_content);
        }
    }
}
