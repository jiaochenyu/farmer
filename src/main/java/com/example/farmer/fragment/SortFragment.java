package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.fragment.sort.ContentFragment;

/**
 * Created by jcy on 2016/5/8.
 */
public class SortFragment extends Fragment{
    MainActivity mMainActivity;
    View view;
    ListView mListView;
    //处理事务
    FragmentManager mFragmentManager;
    FragmentTransaction mTransaction;
    ContentFragment mContentFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.sort,null);
        mListView = (ListView) view.findViewById(R.id.sort_title);
        initListener();
        initFragment();
        return view;
    }

    private void initListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                mTransaction = mFragmentManager.beginTransaction();
                mContentFragment = new ContentFragment();

                Bundle bundle = new Bundle();
                bundle.putString("values",text);
                mContentFragment.setArguments(bundle);
                mTransaction.replace(R.id.right,mContentFragment);
                mTransaction.commit();
            }
        });
    }

    private void initFragment() {
        mFragmentManager = getChildFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mContentFragment = new ContentFragment();
        mTransaction.add(R.id.right,mContentFragment);
        mTransaction.commit();
    }

}
