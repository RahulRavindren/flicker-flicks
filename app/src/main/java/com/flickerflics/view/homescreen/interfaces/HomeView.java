package com.flickerflics.view.homescreen.interfaces;


import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.interfaces.ViewBase;

import java.util.List;

public interface HomeView extends ViewBase {
    void showImages(List<PhotoAsset> photoStream);

    void showError(String message);
}
