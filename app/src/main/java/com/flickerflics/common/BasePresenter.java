package com.flickerflics.common;

import com.flickerflics.interfaces.ViewBase;

public abstract class BasePresenter<V extends ViewBase>{
  protected V view;

  public BasePresenter(V view) {
    this.view = view;
  }

  protected abstract void start();
  protected abstract void stop();
}
