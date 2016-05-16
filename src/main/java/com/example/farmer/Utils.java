package com.example.farmer;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by jcy on 2016/5/16.
 */
public class Utils {
    /**
     * 获取屏幕分辨率
     * @param context
     * @return
     */
    public static int[] getScreenSize(Activity context) {
        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        return new int[]{width, height};
    }
}
