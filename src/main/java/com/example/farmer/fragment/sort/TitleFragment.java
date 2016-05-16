package com.example.farmer.fragment.sort;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.farmer.R;

/**
 * Created by jqchen on 2016/5/14.
 */
public class TitleFragment extends Fragment {
    ListView mListView;
    View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListItemClick = (ListItemClick) context;
    }

    ListItemClick mListItemClick = (ListItemClick) getParentFragment();
    //回调：简单的观察者模式
    public interface ListItemClick{
        public abstract void setOnListItemClickListener(String text);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.sort_title,null);
        mListView = (ListView) mView.findViewById(R.id.sort_title);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                mListItemClick.setOnListItemClickListener(text);
            }
        });
        return mView;
    }
}
