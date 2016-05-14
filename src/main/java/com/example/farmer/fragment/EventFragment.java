package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmer.MainActivity;
import com.example.farmer.R;

/**
 * Created by jcy on 2016/5/8.
 */
public class EventFragment extends Fragment {
    private static final String PATH = "https://s-media-cache-ak0.pinimg.com/564x/47/ab/21/47ab210b9840baa3601e8daefdc412bc.jpg";
    MainActivity mMainActivity;
    View view;
    ViewPager mViewPager ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity= (MainActivity) getActivity();
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event,null);


        //缓存图片
        //Glide.with(mMainActivity).load(PATH).into(mImageView);
        return view;
    }



    private void initViews(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.event, null);


    }






}
