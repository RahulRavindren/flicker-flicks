package com.flickerflics.interfaces;

import com.flickerflics.entity.BaseAsset;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.entity.PhotoWrapperAsset;

/**
 * @Author rahulravindran
 */
public interface FlickRepoType extends RepositoryType<BaseAsset<PhotoWrapperAsset>, PhotoAsset> {
    void searchForImage(String searchTerm);
}
