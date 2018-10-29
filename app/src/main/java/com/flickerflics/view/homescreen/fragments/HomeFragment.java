package com.flickerflics.view.homescreen.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flickerflics.R;
import com.flickerflics.basecommons.BaseFragment;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.view.homescreen.HomeActivity;
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
    private ContentLoadingProgressBar mProgressBar;

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void showProgressSpinner(boolean status) {
        mProgressBar.setVisibility(status ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        //init searchview in activity
        ((HomeActivity) getActivity()).initSearchView();
    }

    private void initViews(View view) {
        mImageList = view.findViewById(R.id.image_list);
        mProgressBar = view.findViewById(R.id.pagination_progress);
        mImageList.initialState();
        mImageList.addPaginationListener(mPresenter);

    }

    @Override
    public void showImages(List<PhotoAsset> photoStream) {
        PhotoStreamAdapter adapter = (PhotoStreamAdapter) mImageList.getAdapter();
        int previousCount = adapter.getItemCount();
        adapter.setDataItems(photoStream);
        adapter.notifyItemRangeInserted(previousCount, photoStream.size());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearAdapters() {
        if (mImageList.getAdapter() != null) {
            PhotoStreamAdapter adapter = (PhotoStreamAdapter) mImageList.getAdapter();
            adapter.clearItems();
            adapter.notifyDataSetChanged();
        }
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
