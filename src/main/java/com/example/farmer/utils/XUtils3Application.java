package com.example.farmer.utils;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by jcy on 2016/5/18.
 */
public class XUtils3Application extends Application {
    private String testUrl ="http://fuwuqi.guanweiming.top/headvip/json/testdata";
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    public String getTestUrl() {
        return testUrl;
    }
}
