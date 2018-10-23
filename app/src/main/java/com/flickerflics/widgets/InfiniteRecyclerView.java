package com.flickerflics.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @Author rahulravindran
 */
public class InfiniteRecyclerView extends RecyclerView implements RecyclerView.ChildDrawingOrderCallback,
        RecyclerView.OnSystemUiVisibilityChangeListener {

    public InfiniteRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public InfiniteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        setClipToPadding(true);
        setHasFixedSize(true);
        setFitsSystemWindows(true);

        setOnScrollListener(new ScrollListener());
        setChildDrawingOrderCallback(this);
        setOnSystemUiVisibilityChangeListener(this);
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
