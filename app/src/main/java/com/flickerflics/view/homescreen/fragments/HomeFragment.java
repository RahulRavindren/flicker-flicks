package com.flickerflics.view.homescreen.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flickerflics.R;
import com.flickerflics.common.BaseFragment;

/**
 * @Author rahulravindran
 */
public class HomeFragment extends BaseFragment {
    private RecyclerView mImageList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return inflater.inflate(R.layout.fragment_home, container, false);
        } else {
            return container;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mImageList = view.findViewById(R.id.image_list);
    }

}
