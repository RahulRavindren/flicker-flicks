package com.flickerflics.repository;

import android.os.AsyncTask;

import com.flickerflics.basecommons.BaseRepository;
import com.flickerflics.common.entity.PageEntity;
import com.flickerflics.common.utils.Logger;
import com.flickerflics.entity.BaseAsset;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.entity.PhotoWrapperAsset;
import com.flickerflics.interfaces.FlickRepoType;
import com.flickerflics.interfaces.FlickerRepoListeners;
import com.flickerflics.mappers.BaseAssetToPhotoAssetMapper;
import com.flickerflics.network.RetrofitAdapter;
import com.flickerflics.network.exceptions.BaseError;
import com.flickerflics.network.utils.CallbackState;
import com.flickerflics.services.FlickerImageSearchService;

import java.util.List;

import retrofit2.Call;

public class FlickerRepository extends BaseRepository<BaseAsset<PhotoWrapperAsset>, List<PhotoAsset>>
        implements FlickRepoType {
    final String TAG = FlickerRepository.class.getSimpleName();
    private final FlickerRepoListeners listeners;
    private FlickerImageSearchService flickerService;
    private AsyncOperation asyncOperation;


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

        if (asyncOperation != null) {
            asyncOperation.cancel(true);
        }

        if (pageEntity.getQuery() == null || pageEntity.getQuery().isEmpty()) {
            return;
        }

        Call<BaseAsset<PhotoWrapperAsset>> call = flickerService.searchImage(pageEntity.getQuery(),
                pageEntity.getPage(), pageEntity.getPageSize());


        setCallback(call, new CallbackState<BaseAsset<PhotoWrapperAsset>>() {
            @Override
            public void onSuccess(BaseAsset<PhotoWrapperAsset> value) {
                pageEntity.increment();
                asyncOperation = new AsyncOperation();
                asyncOperation.execute(value);

            }

            @Override
            public void onError(BaseError error) {
                Logger.error(error);
                if (listeners != null) {
                    listeners.errroInStream(error);
                }
            }
        });


    }

    public boolean isHalted() {
        return asyncOperation.isCancelled();
    }

    public void cancelCall() {
        if (asyncOperation != null) {
            asyncOperation.cancel(true);
        }
    }

    @Override
    public void close() {

    }


    private class AsyncOperation extends AsyncTask<BaseAsset<PhotoWrapperAsset>, List<PhotoAsset>, List<PhotoAsset>> {

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
            if (listeners == null) {
                Logger.error(TAG, "mapping to another object completed. But no listeners to pass asset");
            }
            if (listeners != null && !isCancelled()) {
                listeners.streamOfImages(photoAssets);
            }
        }
    }
}
