package com.flickerflics.widgets;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/*
* @Author rahulravindran
* Fixed span count GridLayoutManager
* */
public class PhotoStreamGridLayoutManager extends GridLayoutManager {
  private int FIXED_SPAN_COUNT = 3;


  public PhotoStreamGridLayoutManager(Context context, int spanCount) {
    super(context, spanCount);
  }

}
