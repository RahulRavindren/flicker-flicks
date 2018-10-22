package com.flickerflics.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.flickerflics.R;

public class BaseActivity extends AppCompatActivity {
  private ConstraintLayout mBaseParentLayout;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_base_layout);
  }

  private void initView() {
    mBaseParentLayout = findViewById(R.id.base_parent);
  }

  @Override
  public void setContentView(int layoutResID) {
    LayoutInflater inflater =
        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    //fixed layout hence know the position to be added
    View rootView = inflater.inflate(layoutResID, mBaseParentLayout);
    mBaseParentLayout.addView(rootView, 1);
  }

  private void assertBundleNull(Intent intent) {
    return intent.getExtras() == null;
  }

}
