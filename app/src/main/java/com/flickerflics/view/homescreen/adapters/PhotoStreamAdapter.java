package com.flickerflics.view.homescreen.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.flickerflics.R;
import com.flickerflics.common.BaseAdapter;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.view.homescreen.viewholder.PhotoItemVIewHolder;

import java.util.List;

/**
 * @Author rahulravindran
 */
public class PhotoStreamAdapter extends BaseAdapter<PhotoAsset,PhotoItemVIewHolder>{

    public PhotoStreamAdapter(List<PhotoAsset> dataItems) {
        super(dataItems);
    }

    @Override
    protected PhotoItemVIewHolder createItem(LayoutInflater inflator, ViewGroup viewGroup,
                                             int viewType) {
        return new PhotoItemVIewHolder(inflator.inflate(R.layout.photo_stream_item, viewGroup,
            false));
    }

    @Override
    protected void bindItem(PhotoItemVIewHolder holder, int position, PhotoAsset object) {
            if (holder != null) {

            }
    }

    @Override
    protected void viewTearDown(PhotoItemVIewHolder holder) {

    }
}
