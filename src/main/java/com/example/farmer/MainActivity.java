package com.example.farmer;
<<<<<<< HEAD
=======


>>>>>>> 15fe07a70fad8d4bf2d3c8f156af3bd09a63db2c


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.farmer.fragment.CarFragment;
import com.example.farmer.fragment.EventFragment;
import com.example.farmer.fragment.HomeFragment;
import com.example.farmer.fragment.SortFragment;
import com.example.farmer.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

///cjq commit

    ///fwfwfw

	//caofujun


/// cfjjjj       


    private static final int HOME = 0;
    private static final int EVENT = 1;
    private static final int SORT = 2;
    private static final int CAR = 3;
    private static final int USER = 4;
    RadioGroup mRadioGroup;
    FrameLayout mFrameLayout;


    HomeFragment mHomeFragment;
    EventFragment mEventFragment;
    SortFragment mSortFragment;
    CarFragment mCarFragment;
    UserFragment mUserFragment;

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initListeners();

    }

    //初始化组件
    private void initViews() {
        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        mRadioGroup = (RadioGroup) findViewById(R.id.group);
    }

    //初始化数据
    private void initData() {

        mFragmentManager = getSupportFragmentManager();

        //设置home 为默认页面
        showFragment(HOME);
    }

    //不让fragment 实例化，先隐藏然后添加。
    //隐藏fragment
    public void hideFragment(FragmentTransaction ft) {
        if (mHomeFragment != null) {
            ft.hide(mHomeFragment);
        }
        if (mEventFragment != null) {
            ft.hide(mEventFragment);
        }
        if (mSortFragment != null) {
            ft.hide(mSortFragment);
        }
        if (mCarFragment != null) {
            ft.hide(mCarFragment);
        }
        if (mUserFragment != null) {
            ft.hide(mUserFragment);
        }
    }

    //显示fragment
    public void showFragment(int index) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        //隐藏
        hideFragment(mFragmentTransaction);
        /**
         * 如果Fragment为空，就新建一个实例
         * 如果不为空，就将它从栈中显示出来
         */
        switch (index) {
            case HOME:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    mFragmentTransaction.add(R.id.fragment_container, mHomeFragment);
                } else {
                    mFragmentTransaction.show(mHomeFragment);
                }
                break;
            case EVENT:
                if (mEventFragment == null) {
                    mEventFragment = new EventFragment();
                    mFragmentTransaction.add(R.id.fragment_container, mEventFragment);
                } else {
                    mFragmentTransaction.show(mEventFragment);
                }

                break;
            case SORT:
                if (mSortFragment == null) {
                    mSortFragment = new SortFragment();
                    mFragmentTransaction.add(R.id.fragment_container, mSortFragment);
                } else {
                    mFragmentTransaction.show(mSortFragment);
                }
                break;
            case CAR:
                if (mCarFragment == null) {
                    mCarFragment = new CarFragment();
                    mFragmentTransaction.add(R.id.fragment_container, mCarFragment);
                } else {
                    mFragmentTransaction.show(mCarFragment);
                }
                break;
            case USER:
                if (mUserFragment == null) {
                    mUserFragment = new UserFragment();
                    mFragmentTransaction.add(R.id.fragment_container, mUserFragment);
                } else {
                    mFragmentTransaction.show(mUserFragment);
                }
                break;

        }
        mFragmentTransaction.commit();

    }


    private void initListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //选定界面
                resetPager(checkedId);
            }
        });
    }

    //选定界面
    private void resetPager(int checkedId) {
        switch (checkedId) {
            case R.id.home:
                showFragment(HOME);
                break;
            case R.id.event:
               showFragment(EVENT);
                break;
            case R.id.sort:
                showFragment(SORT);
                break;
            case R.id.car:
                showFragment(CAR);
                break;
            case R.id.user:
                showFragment(USER);
                break;
            default:
                break;
        }
    }
}
