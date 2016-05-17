package com.example.farmer.fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.adapter.EventFragmentAdapter;
import com.example.farmer.fragment.event.EventDay1;
import com.example.farmer.fragment.event.EventDay2;
import com.example.farmer.fragment.event.EventDay3;
import com.example.farmer.fragment.event.EventDay4;
import com.example.farmer.fragment.event.EventDay5;
import com.example.farmer.fragment.event.EventDay6;
import com.example.farmer.fragment.event.EventDay7;
import com.example.farmer.fragment.event.EventSyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/8.
 */
public class EventFragment extends Fragment {
    // PATH 测试
    private static final String PATH = "https://s-media-cache-ak0.pinimg.com/564x/47/ab/21/47ab210b9840baa3601e8daefdc412bc.jpg";

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
    private EventSyncHorizontalScrollView mEventSyncHorizontalScrollView;
    private RelativeLayout mRelativeLayout;
    private ImageView mImageViewIndicator;
    private ImageView mImageViewScrollLeft;
    private ImageView mImageViewScrollRight;
    private int indicatorWidth;  // 下划线宽度（位移）
    public static String[] tabTitle = {"A1", "B2", "C3", "D4", "E5", "F6", "G7"};
    private LayoutInflater mInflater;
    private int currentIndicatorLeft = 0;  // 当前下划线和左面的距离

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
        //mRadioGroup = (RadioGroup) view.findViewById(R.id.event_day_radioGroup);
       // mEventDayHorizontalScrollView = (EventDayHorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.event_day_radiogroup);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.event_day_relativeLayout);
        mEventSyncHorizontalScrollView = (EventSyncHorizontalScrollView) view.findViewById(R.id.horizontalScrollView);
        mImageViewIndicator = (ImageView) view.findViewById(R.id.event_day_indicator);
        mImageViewScrollLeft = (ImageView) view.findViewById(R.id.event_day_scroll_left);
        mImageViewScrollRight = (ImageView) view.findViewById(R.id.event_day_scroll_right);

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

        DisplayMetrics dm = new DisplayMetrics(); //获取屏幕分辨率
        mMainActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);

        indicatorWidth = dm.widthPixels / 4;  //显示四个标题

        //设置标签下划线的属性
        ViewGroup.LayoutParams cursor_Params = mImageViewIndicator.getLayoutParams();
        cursor_Params.width = indicatorWidth;/// 初始化滑动下标的宽
        mImageViewIndicator.setLayoutParams(cursor_Params);
        //将
        mEventSyncHorizontalScrollView.setSomeParam(mRelativeLayout, mImageViewScrollLeft, mImageViewScrollRight, mMainActivity);
        //获取布局填充器
        mInflater = LayoutInflater.from(mMainActivity);
        //标签在horizonScrollView中应该移动的位置
        initNavigationHSV();
        mFragmentManager = getFragmentManager();
        //初始化适配器
        mEventFragmentAdapter = new EventFragmentAdapter(mFragmentManager, mFragemtnList);
        mViewPager.setAdapter(mEventFragmentAdapter);
        mViewPager.setOffscreenPageLimit(6);


    }

    //标签在horizonScrollView中应该移动的位置
    private void initNavigationHSV() {
        mRadioGroup.removeAllViews();
        for(int i=0;i<tabTitle.length;i++){
            RadioButton rb = (RadioButton) mInflater.inflate(R.layout.event_day_radiogroup_item, null);
            rb.setId(i);
            rb.setText(tabTitle[i]);
            rb.setLayoutParams(new ViewGroup.LayoutParams(indicatorWidth,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            mRadioGroup.addView(rb);
        }

    }

    private void initListener() {

        //radioGroup 事件监听
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (mRadioGroup.getChildAt(checkedId) != null) {
                    //将按钮移动
                    TranslateAnimation animation = new TranslateAnimation(
                            currentIndicatorLeft,
                            (mRadioGroup.getChildAt(checkedId)).getLeft(), 0f, 0f);
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setDuration(100);
                    animation.setFillAfter(true);

                    //执行位移动画
                    mImageViewIndicator.startAnimation(animation);
                    mViewPager.setCurrentItem(checkedId);    //ViewPager 跟随一起 切换
                    //记录当前 下标的距最左侧的 距离
                    currentIndicatorLeft = ( mRadioGroup.getChildAt(checkedId)).getLeft();

                    mEventSyncHorizontalScrollView.smoothScrollTo(
                            (checkedId > 1 ? ( mRadioGroup.getChildAt(checkedId)).getLeft() : 0) - ( mRadioGroup.getChildAt(2)).getLeft(), 0);
                }
            }

        });

        // viewpager 事件监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int position) {
                if (mRadioGroup != null && mRadioGroup.getChildCount() > position) {
                    ( mRadioGroup.getChildAt(position)).performClick();
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }


}





// 结束  下面注释掉的函数 可能会用到。





   /* //不让fragment 实例化，先隐藏然后添加。
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


    //显示fragment
    private void showFragment(int index) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //隐藏
        hideFragment(mFragmentTransaction);
        *//**
         如果Fragment为空，就新建一个实例
         如果不为空，就将它从栈中显示出来
         *//*
        switch (index) {
            case DAY1:
                if (mEventDay1 == null) {
                    mEventDay1 = new EventDay1();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay1);
                } else {
                    mFragmentTransaction.show(mEventDay1);
                }
                break;
            case DAY2:
                if (mEventDay2 == null) {
                    mEventDay2 = new EventDay2();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay2);
                } else {
                    mFragmentTransaction.show(mEventDay2);
                }
                break;
            case DAY3:
                if (mEventDay3 == null) {
                    mEventDay3 = new EventDay3();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay3);
                } else {
                    mFragmentTransaction.show(mEventDay3);
                }
                break;
            case DAY4:
                if (mEventDay4 == null) {
                    mEventDay4 = new EventDay4();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay4);
                } else {
                    mFragmentTransaction.show(mEventDay4);
                }
                break;
            case DAY5:
                if (mEventDay5 == null) {
                    mEventDay5 = new EventDay5();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay5);
                } else {
                    mFragmentTransaction.show(mEventDay5);
                }
                break;
            case DAY6:
                if (mEventDay6 == null) {
                    mEventDay6 = new EventDay6();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay6);
                } else {
                    mFragmentTransaction.show(mEventDay6);
                }
                break;
            case DAY7:
                if (mEventDay7 == null) {
                    mEventDay7 = new EventDay7();
                    mFragmentTransaction.add(R.id.event_content_viewpager, mEventDay7);
                } else {
                    mFragmentTransaction.show(mEventDay7);
                }
                break;

        }


    }*/






