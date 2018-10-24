package com.flickerflics.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.flickerflics.interfaces.PaginationListener;

import java.util.LinkedList;

/**
 * @Author rahulravindran
 */
public class InfiniteRecyclerView extends RecyclerView implements RecyclerView.ChildDrawingOrderCallback,
        RecyclerView.OnSystemUiVisibilityChangeListener {
    private LinkedList<PaginationListener> paginationListeners = new LinkedList<>();

    public InfiniteRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public InfiniteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearPaginationListeners();
    }

    private void init() {
        setClipToPadding(true);
        setHasFixedSize(true);
        setFitsSystemWindows(true);

        setOnScrollListener(new ScrollListener());
        setChildDrawingOrderCallback(this);
        setOnSystemUiVisibilityChangeListener(this);
    }

    public void addPaginationListener(PaginationListener listener) {
        paginationListeners.add(listener);
    }

    public void clearPaginationListeners() {
        paginationListeners.clear();
    }

    @Override
    public void onSystemUiVisibilityChange(int i) {

    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    @Override
    public int onGetChildDrawingOrder(int i, int i1) {
        return 0;
    }

    class ScrollListener extends RecyclerView.OnScrollListener {
        private int prevState;

        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {

            this.prevState = newState;
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            if (dy > 0) {
                Adapter adapter = recyclerView.getAdapter();
            }

            super.onScrolled(recyclerView, dx, dy);
        }
    }


}
