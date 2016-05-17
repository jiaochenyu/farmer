package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.farmer.R;
import com.example.farmer.adapter.Sort_TitleAdapter;
import com.example.farmer.beans.SortTitle;
import com.example.farmer.fragment.sort.ContentFragment;
import com.example.farmer.utils.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/8.
 */
public class SortFragment extends Fragment{
    View view;
    RecyclerView mRecyclerView;
    //适配器
    Sort_TitleAdapter titleAdapter;
    //处理事务
    List<SortTitle> mList;
    LinearLayoutManager liner;
    FragmentManager mFragmentManager;
    FragmentTransaction mTransaction;
    ContentFragment mContentFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sort,null);
        //初始化数据
        initData();
        //初始化适配器
        initView();
        //这是监听
        initAdapter();
        //初始化布局
        initListener();
        //初始化碎片
        initFragment();
        return view;
    }

    private void initAdapter() {
        titleAdapter = new Sort_TitleAdapter(mList);
        mRecyclerView.setAdapter(titleAdapter);
    }

    private void initData() {
        //以及标题
        mList = new ArrayList<>();
        SortTitle s1 = new SortTitle(1,"蔬菜豆菇",true);
        SortTitle s2 = new SortTitle(2,"新鲜蔬果",false);
        SortTitle s3 = new SortTitle(3,"鲜肉蛋类",false);
        SortTitle s4 = new SortTitle(4,"水产海鲜",false);
        SortTitle s5 = new SortTitle(5,"速冻冻品",false);
        SortTitle s6 = new SortTitle(6,"牛奶面点",false);
        SortTitle s7 = new SortTitle(7,"粮油副食",false);
        SortTitle s8 = new SortTitle(8,"零食酒水",false);
        SortTitle s9 = new SortTitle(9,"进口食品",false);
        SortTitle s10 = new SortTitle(10,"厨房用品",false);
        mList.add(s1);
        mList.add(s2);
        mList.add(s3);
        mList.add(s4);
        mList.add(s5);
        mList.add(s6);
        mList.add(s7);
        mList.add(s8);
        mList.add(s9);
        mList.add(s10);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.sort_title);
        liner = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(liner);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
    }

    private void initListener() {
        titleAdapter.setmOnItemClickListener(new Sort_TitleAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, SortTitle sortTitle) {
                mTransaction = mFragmentManager.beginTransaction();
                mContentFragment = new ContentFragment();

                Bundle bundle = new Bundle();
                bundle.putString("values",sortTitle.getContent());
                mContentFragment.setArguments(bundle);
                mTransaction.replace(R.id.right,mContentFragment);
                mTransaction.commit();

            }

        });
    }

    private void show(String text) {
        Toast.makeText(getContext(),"内容："+text,Toast.LENGTH_SHORT).show();
    }

    private void initFragment() {
        mFragmentManager = getChildFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mContentFragment = new ContentFragment();
        mTransaction.add(R.id.right,mContentFragment);
        mTransaction.commit();
    }

}
