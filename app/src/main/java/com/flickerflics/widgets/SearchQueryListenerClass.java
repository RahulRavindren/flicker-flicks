package com.flickerflics.widgets;


import android.support.v7.widget.SearchView;

import com.flickerflics.common.utils.Logger;
import com.flickerflics.view.homescreen.interfaces.SearchListener;


/**
 * @Author rahulravindran
 */
public final class SearchQueryListenerClass implements SearchView.OnQueryTextListener {
    private static final String TAG = SearchQueryListenerClass.class.getSimpleName();
    private final SearchListener searchListener;

    public SearchQueryListenerClass(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if (searchListener != null) {
            Logger.debug(TAG, "search string for submit :: " + s);
            searchListener.finalSubmissionSearch(s);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if (searchListener != null) {
            Logger.debug(TAG, "current search  :: " + s);
            searchListener.onCancelAndSearch(s);
        }
        return true;
    }
}
