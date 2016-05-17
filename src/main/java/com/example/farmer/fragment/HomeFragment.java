package com.example.farmer.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.adapter.HomeAdAdapter;

import java.util.ArrayList;

/**
 * Created by jcy on 2016/5/8.
 */
public class HomeFragment extends Fragment {

    MainActivity mMainActivity;
    View view;
    public static final int IMAGE_UPDATE = 1;
    public static final int REFRESHTIME = 3 * 1000;
    public static final int IMAGE_CHANGED = 2;
    ViewPager mViewPager;
    ArrayList<View> mViewList;
    int mCurrentItem = Integer.MAX_VALUE / 2;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.home, null);
        mMainActivity = (MainActivity) getActivity();
        initView();
        initData(savedInstanceState);
        setLinstener();
        HomeAdAdapter myAdapter = new HomeAdAdapter(mViewList,this);
        mViewPager.setAdapter(myAdapter);
        mViewPager.setCurrentItem(mCurrentItem);
        mHandler.sendEmptyMessageDelayed(IMAGE_UPDATE,REFRESHTIME);
        return view;
    }

    private void setLinstener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //手动滑到这个广告的时候,发送改位置的值
                mHandler.sendMessage(Message.obtain(mHandler,IMAGE_CHANGED,position,0));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData(Bundle savedInstanceState) {
        mViewList = new ArrayList<View>();
        int[] imageId = {R.drawable.ad_a, R.drawable.ad_b,R.drawable.ad_a,R.drawable.ad_b};
        for (int i = 0; i < imageId.length; i++) {
            View view = getLayoutInflater(savedInstanceState).inflate(R.layout.home_ad_item, null);
            ImageView mItemIvContent = (ImageView) view.findViewById(R.id.item_iv_content);
            mItemIvContent.setImageResource(imageId[i]);
            mViewList.add(view);
        }
    }

    private void initView() {
        mViewPager = (ViewPager) view.findViewById(R.id.main_ad_show);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int action = msg.what;
            if (mHandler.hasMessages(IMAGE_UPDATE)){
                mHandler.removeMessages(IMAGE_UPDATE);
            }
            switch (action){
                case IMAGE_UPDATE:
                    //轮播图经行更新
                    mCurrentItem +=1;
                    mViewPager.setCurrentItem(mCurrentItem);
                    mHandler.sendEmptyMessageDelayed(IMAGE_UPDATE, REFRESHTIME);
                    break;
                case IMAGE_CHANGED:
                    //手动滑了广告
                    mCurrentItem = msg.arg1;
                    mViewPager.setCurrentItem(mCurrentItem);
                    mHandler.sendEmptyMessageDelayed(IMAGE_UPDATE,REFRESHTIME);
                    break;
            }
        }
    };
}
