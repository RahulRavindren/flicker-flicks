package com.flickerflics.view.homescreen.adapters;

import com.flickerflics.common.BaseAdapter;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.view.homescreen.viewholder.PhotoItemVIewHolder;

import java.util.List;

/**
 * @Author rahulravindran
 */
public class PhotoStreamAdapter extends BaseAdapter<PhotoAsset, PhotoItemVIewHolder> {

    public PhotoStreamAdapter(List<PhotoAsset> dataItems) {
        super(dataItems);
    }


}
