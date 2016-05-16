package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmer.MainActivity;
import com.example.farmer.R;

/**
 * Created by jcy on 2016/5/14.
 */
public class EventDay4 extends Fragment {
    MainActivity mMainActivity;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event_day1,null);
        return view;
    }
}
