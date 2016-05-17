package com.example.farmer.fragment.sort;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmer.R;
import com.example.farmer.adapter.Sort_ContentAdapter;
import com.example.farmer.beans.SortContent;
import com.example.farmer.beans.SortContentContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jqchen on 2016/4/28.
 */
public class ContentFragment extends Fragment {
    TextView mTextView;
    RecyclerView mRecyclerView;
    View mView;
    List<SortContent> mList;
    List<SortContentContent> mmList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.sort_content,null);
        //初始化布局
        initView();
        //初始化数据
        initData();
        //setTextContent("");
        initAdapter();
        return mView;
    }

    private void initAdapter() {
        Sort_ContentAdapter scAdapter = new Sort_ContentAdapter(getContext(),mList);
        mRecyclerView.setAdapter(scAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        mmList = new ArrayList<>();
        SortContentContent scc1 = new SortContentContent(1,null,"test1");
        SortContentContent scc2 = new SortContentContent(2,null,"test2");
        SortContentContent scc3 = new SortContentContent(3,null,"test3");
        SortContentContent scc4 = new SortContentContent(4,null,"test4");
        SortContentContent scc5 = new SortContentContent(5,null,"test5");
        SortContentContent scc6 = new SortContentContent(6,null,"test6");
        SortContentContent scc7 = new SortContentContent(7,null,"test7");
        mmList.add(scc1);
        mmList.add(scc2);
        mmList.add(scc3);
        mmList.add(scc4);
        mmList.add(scc5);
        mmList.add(scc6);
        mmList.add(scc7);
        SortContent sc1 = new SortContent(1,"二级标题1",mmList);
        SortContent sc2 = new SortContent(2,"二级标题2",mmList);
        SortContent sc3 = new SortContent(3,"二级标题3",mmList);
        mList.add(sc1);
        mList.add(sc2);
        mList.add(sc3);
    }

    private void initView() {
        mTextView = (TextView) mView.findViewById(R.id.sort_content);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.sort_content_recycler);
        LinearLayoutManager linear = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linear);
    }

    //动态刷新TextView的值
    public void setTextContent(String text){
        Bundle bundle = getArguments();
        if (bundle != null){
           String name = bundle.getString("values");
            mTextView.setText(name);
        }
    }
}
