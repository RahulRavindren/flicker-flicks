package com.flickerflics.entity;

import java.io.Serializable;

/**
 * @Author rahulravindran
 */
public class BaseAsset<T> implements Serializable {

    private T photos;
    private String stat;


    public T getPhotos() {
        return photos;
    }

    public void setPhotos(T photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
