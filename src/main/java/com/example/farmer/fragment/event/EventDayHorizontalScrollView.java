package com.example.farmer.fragment.event;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;


/**
 * Created by jcy on 2016/5/16.
 */

public class EventDayHorizontalScrollView extends HorizontalScrollView {
    OnTabChangeListener mOnTabChangeListener;

    public EventDayHorizontalScrollView(Context context) {
        super(context);
        //初始化数据
        initData();
    }


    public EventDayHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDayHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private void initData() {
    }

    public interface OnTabChangeListener {
        public void onTabChange(int index);
    }
}
