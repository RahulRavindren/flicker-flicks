package com.flickerflics.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.flickerflics.interfaces.ViewHolderDefinition;

/**
 * @Author rahulravindran
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements ViewHolderDefinition {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    private void onAttach() {

    }

    private void onDetach() {

    }

}
