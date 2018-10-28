package com.flickerflics.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.flickerflics.R;
import com.flickerflics.view.homescreen.fragments.HomeFragment;

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

    protected void setFragment(Intent intent, Fragment fragment, String tag) {
      if (fragment == null) {
          throw new NullPointerException("fragment cannot be null");
      }

      if (intent != null) {
          Bundle bundle = intent.getExtras();
          fragment.setArguments(bundle);
      }

      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, fragment, tag);
      transaction.commit();
      transaction.runOnCommit(new Runnable() {
          @Override
          public void run() {
              // log fragment transactions
          }
      });
  }

    protected Fragment getCurrentFragmentVisible() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
        return fragment;
    }


  @Override
  public void onBackPressed() {
    onBackStackChanged();
  }


  @Override
  public void onBackStackChanged() {

  }

}
