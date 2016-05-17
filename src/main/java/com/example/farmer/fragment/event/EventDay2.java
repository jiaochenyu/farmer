package com.example.farmer.fragment.event;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.farmer.MainActivity;
import com.example.farmer.R;

/**
 * Created by jcy on 2016/5/14.
 */
public class EventDay2 extends Fragment {
    MainActivity mMainActivity;
    View view;
    ImageView mImageView;
    Button mButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event_day2, null);
        mImageView = (ImageView) view.findViewById(R.id.image);
        mButton = (Button) view.findViewById(R.id.buttontest);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(mMainActivity).load("https://s-media-cache-ak0.pinimg.com/564x/47/ab/21/47ab210b9840baa3601e8daefdc412bc.jpg").into(mImageView);
            }
        });

        return view;
    }


}
