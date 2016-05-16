package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.adapter.EventFragmentAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/8.
 */
public class EventFragment extends Fragment {
    private static final String PATH = "https://s-media-cache-ak0.pinimg.com/564x/47/ab/21/47ab210b9840baa3601e8daefdc412bc.jpg";
    MainActivity mMainActivity;
    View view;
    ViewPager mViewPager;
    List<Fragment> mFragemtnList;
    List<String> mTitleList;
    EventDay1 mEventDay1;
    EventDay2 mEventDay2;
    EventDay3 mEventDay3;
    EventFragmentAdapter mEventFragmentAdapter;
    FragmentManager mFragmentManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event, null);
        initViews();
        initData();
        initListener();

        //缓存图片
        //Glide.with(mMainActivity).load(PATH).into(mImageView);
        return view;
    }


    private void initViews() {
        mViewPager = (ViewPager) view.findViewById(R.id.event_content_viewpager);
    }

    private void initData() {
        mFragemtnList = new ArrayList<>();

        mEventDay1 = new EventDay1();
        mEventDay2 = new EventDay2();
        mEventDay3 = new EventDay3();
        mFragemtnList.add(mEventDay1);
        mFragemtnList.add(mEventDay2);
        mFragemtnList.add(mEventDay3);

        mTitleList = new ArrayList<>();
        mTitleList.add("da1");
        mTitleList.add("da2");
        mTitleList.add("da3");

        //初始化适配器
        mFragmentManager = getFragmentManager();
        mEventFragmentAdapter = new EventFragmentAdapter(mFragmentManager, mFragemtnList,mTitleList);
        mViewPager.setAdapter(mEventFragmentAdapter);

    }
    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



}
