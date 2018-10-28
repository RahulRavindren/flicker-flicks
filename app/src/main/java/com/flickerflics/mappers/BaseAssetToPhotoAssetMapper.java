package com.flickerflics.mappers;

import com.flickerflics.R;
import com.flickerflics.entity.Photo;
import com.flickerflics.entity.PhotoAsset;
import com.flickerflics.entity.PhotoWrapperAsset;
import com.flickerflics.interfaces.MapperBaseType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import surveyapp.com.common.utils.Utils;

/**
 * @Author rahulravindran
 */
public class BaseAssetToPhotoAssetMapper implements MapperBaseType<PhotoWrapperAsset, List<PhotoAsset>> {

    @Override
    public List<PhotoAsset> to(PhotoWrapperAsset value) {
        List<PhotoAsset> result = new ArrayList<>();
        for (Photo photo : value.getPhoto()) {
            PhotoAsset item = new PhotoAsset();
            item.setTitle(photo.getTitle());
            item.setPhotoUrl(Utils.Companion.getStringParams(R.string.image_base_url,
                    String.valueOf(photo.getFarm()), photo.getServer(), photo.getId(),
                    photo.getSecret()));
            result.add(item);
        }
        return Collections.unmodifiableList(result);
    }

    @Override
    public PhotoWrapperAsset from(List<PhotoAsset> value) {
        //no implementation
        return null;
    }
}
