package com.example.farmer.fragment.sort;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmer.R;

/**
 * Created by jqchen on 2016/4/28.
 */
public class ContentFragment extends Fragment {
    TextView mTextView;
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView =  inflater.inflate(R.layout.sort_content,null);
        mTextView = (TextView) mView.findViewById(R.id.sort_content);
        setTextContent("");
        return mView;
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
