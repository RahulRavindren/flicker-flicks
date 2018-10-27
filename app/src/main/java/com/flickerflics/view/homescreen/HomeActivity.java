package com.flickerflics.view.homescreen;

import android.os.Bundle;
import android.widget.SearchView;

import com.flickerflics.R;
import com.flickerflics.common.SingleFragmentActivity;
import com.flickerflics.widgets.SearchQueryListenerClass;

public class HomeActivity extends SingleFragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

      initSearchView();
  }

    private void initSearchView() {
        SearchView searchView = findViewById(R.id.image_search_view);
        if (searchView != null) {
            searchView.setActivated(false);
            searchView.onActionViewExpanded();
            searchView.setIconified(false);
            searchView.clearFocus();

            searchView.setOnQueryTextListener(new SearchQueryListenerClass(null));
        }
  }
}
