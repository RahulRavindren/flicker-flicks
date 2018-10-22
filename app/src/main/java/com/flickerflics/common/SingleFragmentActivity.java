package com.flickerflics.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.flickerflics.R;

public class SingleFragmentActivity extends BaseActivity implements
    FragmentManager.OnBackStackChangedListener {
  public static final String TAG = SingleFragmentActivity.class.getSimpleName();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_frag_container);
  }

  private void setFragment(Intent intent, Fragment fragment) {

  }


  @Override
  public void onBackPressed() {
    onBackStackChanged();
  }


  @Override
  public void onBackStackChanged() {

  }

}
