package com.flickerflics.common;

import com.flickerflics.interfaces.ViewBase;

public abstract class BasePresenter<V extends ViewBase>{
  protected V view;

  public BasePresenter(V view) {
    this.view = view;
  }

    public abstract void start();

    public abstract void stop();
}
