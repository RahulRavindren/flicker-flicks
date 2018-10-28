package com.flickerflics.view.homescreen.presenter;

import android.os.Handler;

import com.flickerflics.common.BasePresenter;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.interfaces.FlickerRepoListeners;
import com.flickerflics.interfaces.PaginationListener;
import com.flickerflics.repository.FlickerRepository;
import com.flickerflics.view.homescreen.interfaces.HomeView;

import java.util.List;

import surveyapp.com.common.entity.MethodType;
import surveyapp.com.common.entity.PageEntity;

public class HomePresenter extends BasePresenter<HomeView> implements FlickerRepoListeners, PaginationListener {
    private FlickerRepository flickerRepository;
    private PageEntity pageEntity;
    private Handler SEARCH_CHANGE = new Handler();
    private SearchExecuteDeplayedRunnable runnable;
    private String previousSearchTerm;

    public HomePresenter(HomeView view) {
        super(view);
        init();
    }

    private void init() {
        flickerRepository = new FlickerRepository(this);
    }


    @Override
    public void start() {
        pageEntity = PageEntity.Companion.getINITIAL();
    }

    private void searchImage(String searchTerm) {
        if (runnable == null) {
            runnable = new SearchExecuteDeplayedRunnable();
        }
        SEARCH_CHANGE.removeCallbacks(runnable);
        this.previousSearchTerm = searchTerm;
        SEARCH_CHANGE.postDelayed(runnable, 500);
    }

    @Override
    public void initialPage(String searchTerm) {
        searchImage(searchTerm);
    }

    @Override
    public void nextPage() {
        pageEntity.increment();
        searchImage(previousSearchTerm);
    }

    @Override
    public void stop() {
        flickerRepository.close();
    }

    @Override
    public void streamOfImages(List<PhotoAsset> imageStream) {
        if (!imageStream.isEmpty()) {
            view.showImages(imageStream);
        }
    }

    @Override
    public void errroInStream(Throwable t) {
        view.showError(t.getMessage());
    }

    private class SearchExecuteDeplayedRunnable implements Runnable {
        @Override
        public void run() {
            flickerRepository.cancelCall();
            pageEntity.setMethodType(MethodType.QUERY);
            pageEntity.setQuery(previousSearchTerm);
            flickerRepository.searchForImage(pageEntity);
        }
    }
}
