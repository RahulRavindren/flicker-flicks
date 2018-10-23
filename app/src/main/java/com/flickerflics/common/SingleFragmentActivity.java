package com.flickerflics.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.flickerflics.R;

public class SingleFragmentActivity extends BaseActivity implements
    FragmentManager.OnBackStackChangedListener {
  public static final String TAG = SingleFragmentActivity.class.getSimpleName();
    private FrameLayout mFragContainer;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_frag_container);

      initView();
  }

    private void initView() {
        mFragContainer = findViewById(R.id.fragment_container);
    }

  private void setFragment(Intent intent, Fragment fragment) {
      if (fragment == null) {
          throw new NullPointerException("fragment cannot be null");
      }

      if (intent != null) {
          Bundle bundle = intent.getExtras();
          fragment.setArguments(bundle);
      }

      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction transaction = manager.beginTransaction();
      transaction.add(R.id.fragment_container, fragment);
      transaction.commit();
      transaction.runOnCommit(new Runnable() {
          @Override
          public void run() {
              // log fragment transactions
          }
      });
  }


  @Override
  public void onBackPressed() {
    onBackStackChanged();
  }


  @Override
  public void onBackStackChanged() {

  }

}
