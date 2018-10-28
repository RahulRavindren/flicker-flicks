package com.flickerflics;

import com.flickerflics.entity.BaseAsset;
import com.flickerflics.entity.PhotoWrapperAsset;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author rahulravindran
 */
public interface FlickerImageSearchService {
    @GET("/services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1&safe_search=1")
    Call<BaseAsset<PhotoWrapperAsset>> searchImage(@Query("text") String searchString,
                                                   @Query("page") int page, @Query("per_page") int pageCap);
}
