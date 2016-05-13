package com.example.farmer.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.farmer.R;

public class HJCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hjc);
        jcy();
    }

    private void jcy() {
        Toast.makeText(HJCActivity.this, "JCY", Toast.LENGTH_SHORT).show();
    }

}
