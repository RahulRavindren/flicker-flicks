package com.flickerflics.view.homescreen.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.flickerflics.R;
import com.flickerflics.common.BaseAdapter;
import com.flickerflics.common.BaseViewHolder;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.view.homescreen.viewholder.PhotoItemVIewHolder;
import com.flickerflics.view.homescreen.viewholder.ProgressOnlyViewHolder;

import java.util.List;

/**
 * @Author rahulravindran
 */
public class PhotoStreamAdapter extends BaseAdapter<PhotoAsset, BaseViewHolder> {
    private final int PHOTO_ITEM = 100;
    private final int PROGRESS_ITEM = 101;


    public PhotoStreamAdapter(List<PhotoAsset> dataItems) {
        super(dataItems);
    }


    @Override
    protected BaseViewHolder createItem(LayoutInflater inflator, ViewGroup viewGroup, int viewType) {
        if (viewType == PHOTO_ITEM) {
            return new PhotoItemVIewHolder(inflator.inflate(R.layout.photo_stream_item, viewGroup, false));
        } else {
            return new ProgressOnlyViewHolder(inflator.inflate(R.layout.progress_item, viewGroup, false));
        }

    }

    @Override
    protected void bindItem(BaseViewHolder holder, int position, PhotoAsset object) {
        if (holder != null) {
            holder.onBindData(object, position);
        }
    }

    @Override
    protected void viewTearDown(BaseViewHolder holder) {
        if (holder != null) {
            holder.onDestory();
        }
    }

    @Override
    protected int viewType(int position) {
        if (getItemAtPosition(position) == null) {
            return PROGRESS_ITEM;
        }
        return PHOTO_ITEM;
    }
}
