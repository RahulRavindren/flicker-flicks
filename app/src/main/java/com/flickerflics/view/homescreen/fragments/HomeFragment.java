package com.flickerflics.view.homescreen.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flickerflics.R;
import com.flickerflics.common.BaseFragment;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.view.homescreen.adapters.PhotoStreamAdapter;
import com.flickerflics.view.homescreen.interfaces.HomeView;
import com.flickerflics.view.homescreen.interfaces.SearchListener;
import com.flickerflics.view.homescreen.presenter.HomePresenter;
import com.flickerflics.widgets.InfiniteRecyclerView;

import java.util.List;

/**
 * @Author rahulravindran
 */
public class HomeFragment extends BaseFragment implements HomeView {
    public static final String TAG = HomeFragment.class.getSimpleName();

    private InfiniteRecyclerView mImageList;
    private HomePresenter mPresenter;
    private PhotoStreamAdapter adapter;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Nullable
    public SearchListener getSearchListener() {
        return (SearchListener) mImageList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);
        mPresenter.start();
    }

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
        mImageList.initialState();

    }

    @Override
    public void showImages(List<PhotoAsset> photoStream) {
        PhotoStreamAdapter adapter = (PhotoStreamAdapter) mImageList.getAdapter();
        adapter.setDataItems(photoStream);
    }

    @Override
    public void showError(String message) {
        //TODO: toast show for error for errorview

    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.stop();
    }
}
