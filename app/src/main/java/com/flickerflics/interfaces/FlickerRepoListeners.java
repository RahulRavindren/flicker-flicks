package com.flickerflics.interfaces;

import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.network.exceptions.BaseError;

import java.util.List;

/**
 * @Author rahulravindran
 */
public interface FlickerRepoListeners {
    void streamOfImages(List<PhotoAsset> imageStream);

    void errroInStream(BaseError t);
}
