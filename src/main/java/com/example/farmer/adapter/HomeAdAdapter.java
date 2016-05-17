package com.example.farmer.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.farmer.fragment.HomeFragment;

import java.util.List;

/**
 * Created by huangjiechun on 16/5/16.
 */
public class HomeAdAdapter extends PagerAdapter{
    List<View> mViewList;

    public HomeAdAdapter(List<View> viewList, HomeFragment mainActivity) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        //设定为最大值,确保能一直轮播
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //viewGroup是装在图片布局的容器
        position %= mViewList.size();
        if (position<0){
            position += mViewList.size();
        }
        View view = mViewList.get(position);
        ViewParent parent = view.getParent();
        if (parent!=null){
            ViewGroup vg = (ViewGroup) parent;
            vg.removeView(view);
        }
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
