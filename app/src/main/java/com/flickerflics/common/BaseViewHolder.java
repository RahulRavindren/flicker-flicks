package com.flickerflics.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flickerflics.interfaces.ViewHolderType;

/**
 * @Author rahulravindran
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements ViewHolderType {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}
