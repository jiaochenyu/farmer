package com.example.farmer.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    private final int DAY1 = 1;
    private final int DAY2 = 2;
    private final int DAY3 = 3;
    private final int DAY4 = 4;
    private final int DAY5 = 5;
    private final int DAY6 = 6;
    private final int DAY7 = 7;

    MainActivity mMainActivity;
    View view;
    RadioGroup mRadioGroup;
    ViewPager mViewPager;
    List<Fragment> mFragemtnList;
    EventDay1 mEventDay1;
    EventDay2 mEventDay2;
    EventDay3 mEventDay3;
    EventDay4 mEventDay4;
    EventDay5 mEventDay5;
    EventDay6 mEventDay6;
    EventDay7 mEventDay7;
    EventFragmentAdapter mEventFragmentAdapter;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        mRadioGroup = (RadioGroup) view.findViewById(R.id.event_day_radioGroup);
    }

    private void initData() {
        mFragemtnList = new ArrayList<>();
        mEventDay1 = new EventDay1();
        mEventDay2 = new EventDay2();
        mEventDay3 = new EventDay3();
        mEventDay4 = new EventDay4();
        mEventDay5 = new EventDay5();
        mEventDay6 = new EventDay6();
        mEventDay7 = new EventDay7();

        mFragemtnList.add(mEventDay1);
        mFragemtnList.add(mEventDay2);
        mFragemtnList.add(mEventDay3);
        mFragemtnList.add(mEventDay4);
        mFragemtnList.add(mEventDay5);
        mFragemtnList.add(mEventDay6);
        mFragemtnList.add(mEventDay7);

        //初始化适配器
        mFragmentManager = getFragmentManager();
        mEventFragmentAdapter = new EventFragmentAdapter(mFragmentManager, mFragemtnList);
        mViewPager.setAdapter(mEventFragmentAdapter);

        //选择默认界面
        //showFragment(DAY1);
    }

    private void initListener() {
        //radioGroup 事件监听

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 resetViewPager(checkedId);
            }
        });

        // viewpager 事件监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetRadioButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //选定页面
    private void resetViewPager(int checkedId){
        switch (checkedId){
            case R.id.day1:
               // showFragment(DAY1);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.day2:
                //showFragment(DAY2);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.day3:
               // showFragment(DAY3);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.day4:
                //showFragment(DAY4);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.day5:
                //showFragment(DAY5);
                mViewPager.setCurrentItem(4);
                break;
            case R.id.day6:
                //showFragment(DAY6);
                mViewPager.setCurrentItem(5);
                break;
            case R.id.day7:
                mViewPager.setCurrentItem(6);
                //showFragment(DAY7);
                break;
        }
    }

    private void resetRadioButton(int position) {
        //获取position位置处对应的单选按钮
        RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(position);
        //设置当前单选按钮默认选中
        radioButton.setChecked(true);
    }



    //不让fragment 实例化，先隐藏然后添加。
    //隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (mEventDay1 != null) {
            ft.hide(mEventDay1);
        }
        if (mEventDay2 != null) {
            ft.hide(mEventDay2);
        }
        if (mEventDay3 != null) {
            ft.hide(mEventDay3);
        }
        if (mEventDay4 != null) {
            ft.hide(mEventDay4);
        }
        if (mEventDay5 != null) {
            ft.hide(mEventDay5);
        }
        if (mEventDay6 != null) {
            ft.hide(mEventDay6);
        }
        if (mEventDay7 != null) {
            ft.hide(mEventDay7);
        }
    }

    /*//显示fragment
    private void showFragment(int index) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //隐藏
        hideFragment(mFragmentTransaction);
        *//**
         * 如果Fragment为空，就新建一个实例
         * 如果不为空，就将它从栈中显示出来
         *//*
        switch (index){
            case DAY1:
                if (mEventDay1 == null){
                    mEventDay1 = new EventDay1();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay1);
                }else{
                    mFragmentTransaction.show(mEventDay1);
                }
                break;
            case DAY2:
                if (mEventDay2 == null){
                    mEventDay2 = new EventDay2();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay2);
                }else{
                    mFragmentTransaction.show(mEventDay2);
                }
                break;
            case DAY3:
                if (mEventDay3 == null){
                    mEventDay3 = new EventDay3();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay3);
                }else{
                    mFragmentTransaction.show(mEventDay3);
                }
                break;
            case DAY4:
                if (mEventDay4 == null){
                    mEventDay4 = new EventDay4();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay4);
                }else{
                    mFragmentTransaction.show(mEventDay4);
                }
                break;
            case DAY5:
                if (mEventDay5 == null){
                    mEventDay5 = new EventDay5();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay5);
                }else{
                    mFragmentTransaction.show(mEventDay5);
                }
                break;
            case DAY6:
                if (mEventDay6 == null){
                    mEventDay6 = new EventDay6();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay6);
                }else{
                    mFragmentTransaction.show(mEventDay6);
                }
                break;
            case DAY7:
                if (mEventDay7 == null){
                    mEventDay7 = new EventDay7();
                    mFragmentTransaction.add(R.id.event_content_viewpager,mEventDay7);
                }else{
                    mFragmentTransaction.show(mEventDay7);
                }
                break;

        }


    }*/


}
