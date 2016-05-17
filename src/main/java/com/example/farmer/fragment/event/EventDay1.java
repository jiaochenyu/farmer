package com.example.farmer.fragment.event;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmer.MainActivity;
import com.example.farmer.R;

/**
 * Created by jcy on 2016/5/14.
 */
public class EventDay1 extends Fragment {
    MainActivity mMainActivity;
    View view;
    TextView mTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event_day1,null);
        initViews();
        return view;
    }

    private void initViews() {
        mTextView = (TextView) view.findViewById(R.id.texttest);
        Bundle bundle = getArguments();
        mTextView.setText(bundle.getString("args",""));
    }
}
