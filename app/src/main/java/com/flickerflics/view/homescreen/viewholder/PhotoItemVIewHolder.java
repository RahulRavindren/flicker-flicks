package com.flickerflics.view.homescreen.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.flickerflics.R;
import com.flickerflics.basecommons.BaseViewHolder;
import com.flickerflics.entity.PhotoAsset;

/**
 * @Author rahulravindran
 */
public class PhotoItemVIewHolder extends BaseViewHolder implements SizeReadyCallback {
    private PhotoAsset asset;
    private ImageView mItemImage;
    private TextView mItemTitle;


    public PhotoItemVIewHolder(@NonNull View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        mItemImage = itemView.findViewById(R.id.item_image);
        mItemTitle = itemView.findViewById(R.id.item_desc);
    }


    @Override
    public void onBindData(Object value, int position) {
        if (value != null) {
            asset = (PhotoAsset) value;
        }

        if (asset == null) {
            return;
        }
        Glide.with(itemView.getContext()).load(asset.getPhotoUrl())
                .into(mItemImage).getSize(this);
        mItemTitle.setText(asset.getTitle());
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void onDestory() {

    }


    @Override
    public void onSizeReady(int width, int height) {

    }
}
