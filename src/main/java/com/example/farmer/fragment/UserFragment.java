package com.example.farmer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.farmer.MainActivity;
import com.example.farmer.R;
import com.example.farmer.fragment.my_account_set.MyAccountSetActivity;

/**
 * Created by jcy on 2016/5/8.
 */
public class UserFragment extends Fragment {
    private MainActivity mMainActivity;
    LinearLayout my_person_set;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        view = inflater.inflate(R.layout.user,null);
        initView();
        Listener();
        return view;
    }

    private void Listener() {
        my_person_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyAccountSetActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        my_person_set= (LinearLayout) view.findViewById(R.id.my_person_set);

    }
}
