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
    List<String> mList;
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
        mList = new ArrayList<>();
        mList.add("蔬菜豆菇");
        mList.add("新鲜蔬果");
        mList.add("鲜肉蛋类");
        mList.add("水产海鲜");
        mList.add("速冻冻品");
        mList.add("牛奶面点");
        mList.add("粮油副食");
        mList.add("零食酒水");
        mList.add("进口食品");
        mList.add("厨房用品");
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
            public void onItemClick(View view, String data) {
                //Log.e("jqchen",data);
                show(data);
                mTransaction = mFragmentManager.beginTransaction();
                mContentFragment = new ContentFragment();

                Bundle bundle = new Bundle();
                bundle.putString("values",data);
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
