package com.flickerflics.widgets;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/*
* @Author rahulravindran
* Fixed span count GridLayoutManager
* */
public class PhotoStreamGridLayoutManager extends GridLayoutManager {
  public PhotoStreamGridLayoutManager(Context context, int spanCount) {
    super(context, spanCount);
  }

}
