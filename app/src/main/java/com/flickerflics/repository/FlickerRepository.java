package com.flickerflics.repository;

import com.flickerflics.FlickerImageSearchService;
import com.flickerflics.common.BaseRepository;
import com.flickerflics.entity.BaseAsset;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.entity.PhotoWrapperAsset;
import com.flickerflics.interfaces.FlickRepoType;
import com.flickerflics.interfaces.FlickerRepoListeners;
import com.flickerflics.mappers.BaseAssetToPhotoAssetMapper;

import java.util.List;

import retrofit2.Call;
import surveyapp.com.common.entity.PageEntity;
import surveyapp.com.common.utils.Logger;
import surveyapp.com.network.RetrofitAdapter;
import surveyapp.com.network.utils.CallbackState;

public class FlickerRepository extends BaseRepository<BaseAsset<PhotoWrapperAsset>, List<PhotoAsset>>
        implements FlickRepoType {
    final String TAG = FlickerRepository.class.getSimpleName();
    private final FlickerRepoListeners listeners;
    private FlickerImageSearchService flickerService;


    public FlickerRepository(FlickerRepoListeners listeners) {
        this.listeners = listeners;
        if (this.flickerService == null) {
            init();
        }
    }

    private void init() {
        flickerService = RetrofitAdapter.Factory
                .Companion.getRestService(FlickerImageSearchService.class, null);
    }


    @Override
    public void searchForImage(final PageEntity pageEntity) {
        //do normal api hit
        if (flickerService == null) {
            throw new NullPointerException("service is null");
        }

        cancel(false);

        if (pageEntity.getQuery() == null || pageEntity.getQuery().isEmpty()) {
            throw new NullPointerException("search term is empty or null");
        }

        Call<BaseAsset<PhotoWrapperAsset>> call = flickerService.searchImage(pageEntity.getQuery(),
                pageEntity.getPage(), pageEntity.getPageSize());


        setCallback(call, new CallbackState<BaseAsset<PhotoWrapperAsset>>() {
            @Override
            public void onSuccess(BaseAsset<PhotoWrapperAsset> value) {
                pageEntity.increment();
                execute(value);
            }

            @Override
            public void onError(Throwable error) {
                Logger.error(error);
                if (listeners != null) {
                    listeners.errroInStream(error);
                }
            }
        });


    }

    public boolean isHalted() {
        return isCancelled();
    }

    public void cancelCall() {
        cancel(true);
    }

    @Override
    protected List<PhotoAsset> doInBackground(BaseAsset<PhotoWrapperAsset>... baseAssets) {
        //obj conversions
        if (baseAssets == null || baseAssets.length == 0) {
            throw new NullPointerException("need input to perform background operartion");
        }
        return new BaseAssetToPhotoAssetMapper().to(baseAssets[0].getPhotos());
    }

    @Override
    protected void onPostExecute(List<PhotoAsset> photoAssets) {
        // push to presenter

        if (listeners == null) {
            Logger.error(TAG, "mapping to another object completed. But no listeners to pass asset");
        }
        if (listeners != null && !isCancelled()) {
            listeners.streamOfImages(photoAssets);
        }
    }

    @Override
    public void close() {

    }
}
