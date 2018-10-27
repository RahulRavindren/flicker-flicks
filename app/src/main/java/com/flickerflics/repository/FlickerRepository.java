package com.flickerflics.repository;

import com.flickerflics.common.BaseRepository;
import com.flickerflics.entity.BaseAsset;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.entity.PhotoWrapperAsset;
import com.flickerflics.interfaces.FlickRepoType;

public class FlickerRepository extends BaseRepository<BaseAsset<PhotoWrapperAsset>, PhotoAsset>
        implements FlickRepoType {

    @Override
    public void searchForImage(String searchTerm) {
        if (searchTerm == null) {
            //do normal api hit
            return;
        }


    }
}
