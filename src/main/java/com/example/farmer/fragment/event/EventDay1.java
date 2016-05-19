package com.example.farmer.fragment.event;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.adapter.EventRecycleViewAdapter;
import com.example.farmer.beans.EventPortTest;
import com.example.farmer.utils.XUtils3Application;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcy on 2016/5/14.
 */
public class EventDay1 extends Fragment {
    MainActivity mMainActivity;
    ImageView mImageView ;
    View view;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;//下拉刷新
    //适配器
    EventRecycleViewAdapter mEventRecycleViewAdapter;
    static List<EventPortTest> mList  = new ArrayList<>();
    String Path;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.event_day1, null);
        initViews();

        initData();
        //设置下拉刷新;
        initRefesh();
        return view;
    }


    private void initViews() {
       /* Bundle bundle = getArguments();
        mTextView.setText(bundle.getString("args",""));*/
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.event_day1_swipeRefreshLayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.event_day1_RView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mMainActivity, 2));
        mImageView = (ImageView) view.findViewById(R.id.imageviewjjjjjjjjj);
    }

    // 请求网络
    public void getHttp(View view){
        RequestParams params = new RequestParams(Path);
        params.addQueryStringParameter("size","7");
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //Type type = new TypeToken<List<EventPortTest>>(){}.getType();
                //Type type = new TypeToken<List<EventPortTest>>(){}.getType();
               // mList = gson.fromJson(result, type);
                //EventPortTest mEventPortTest = gson.fromJson(result,EventPortTest.class);
                try {
                    JSONObject object = new JSONObject(result);
                    JSONArray goods = object.getJSONArray("goods");
                    for(int i=0;i<goods.length();i++){
                        EventPortTest m = gson.fromJson(goods.getJSONObject(i).toString(),EventPortTest.class);
                        mList.add(m);
                        Log.e("    xutls  方法 list集合 长度",mList.size()+"");
                    }
                    mEventRecycleViewAdapter = new EventRecycleViewAdapter(mList, mMainActivity);
                    mRecyclerView.setAdapter(mEventRecycleViewAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //mList.add(mEventPortTest);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("打印错误原因",ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initData() {

        //初始化数据
        XUtils3Application mXUtils3Application = new XUtils3Application();
        Path = mXUtils3Application.getTestUrl();
        getHttp(view);
        //Log.e("list集合 长度",mList.size()+"");
        /*mEventRecycleViewAdapter = new EventRecycleViewAdapter(mList, mMainActivity);
        mRecyclerView.setAdapter(mEventRecycleViewAdapter);*/

       // Glide.with(getContext()).load(mList.get(1).getPic()).into(mImageView);

    }


    //下拉刷新
    private void initRefesh() {
       mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       mSwipeRefreshLayout.setRefreshing(false);
                       Toast.makeText(mMainActivity, "下拉刷新", Toast.LENGTH_SHORT).show();
                   }
               },2000);
           }
       });
    }


}
