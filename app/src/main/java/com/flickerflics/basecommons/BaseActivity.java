package com.flickerflics.basecommons;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.flickerflics.R;


public class BaseActivity extends AppCompatActivity {
    private LinearLayout mBaseParentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView() {
        mBaseParentLayout = findViewById(R.id.application_container);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base_layout);
        initView();
        LayoutInflater.from(this).inflate(layoutResID, mBaseParentLayout);
    }

    private boolean assertBundleNull(Intent intent) {
        return intent.getExtras() == null;
    }

}
