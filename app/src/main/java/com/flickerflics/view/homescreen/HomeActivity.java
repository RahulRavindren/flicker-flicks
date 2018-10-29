package com.flickerflics.view.homescreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;

import com.flickerflics.R;
import com.flickerflics.basecommons.SingleFragmentActivity;
import com.flickerflics.view.homescreen.fragments.HomeFragment;
import com.flickerflics.widgets.SearchQueryListenerClass;

public class HomeActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFragment(null, HomeFragment.getInstance(), HomeFragment.TAG);
    }


    public void initSearchView() {
        SearchView searchView = findViewById(R.id.image_search_view);
        if (searchView != null) {
            searchView.setActivated(false);
            searchView.onActionViewExpanded();
            searchView.setIconified(false);
            searchView.clearFocus();

            Fragment fragment = getCurrentFragmentVisible();
            if (fragment != null) {

                searchView.setOnQueryTextListener(
                        new SearchQueryListenerClass(((HomeFragment) fragment).getSearchListener()));
            }
        }
    }
}
