package com.example.farmer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jcy on 2016/5/10.
 */
public class EventFragmentAdapter extends FragmentPagerAdapter {
    /*
    *活动日期 viewpaper绑定 fragment
    * */
    List<Fragment> mListfragment;
    List<String> mTitleList;


    public EventFragmentAdapter(FragmentManager fm, List<Fragment> list , List<String> titleList) {
        super(fm);
        mListfragment = list;
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mListfragment.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return (mTitleList.size() > position ? mTitleList.get(position) : "");
    }

    @Override
    public int getCount() {
        return mListfragment.size();
    }
}
