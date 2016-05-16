package com.example.farmer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;


/**
 * Created by jcy on 2016/5/16.
 */
public class EventBaseDayAdapter<T> extends BaseAdapter {
    private ArrayList<T> dataResource; //数据源

    public EventBaseDayAdapter(Context context) {
        dataResource = new ArrayList<T>();
    }

    public void addDataResource(ArrayList<T> data) {
        if (data == null || data.size() == 0) {
            return;
        }

        dataResource.addAll(data);
    }

    public ArrayList<T> getDataResource() {
        return dataResource;
    }

    @Override
    public int getCount() {
        return dataResource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataResource.get(position);

    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
