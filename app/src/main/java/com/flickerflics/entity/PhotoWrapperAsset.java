package com.flickerflics.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author rahulravindran
 */
public final class PhotoWrapperAsset implements Serializable {
    private int page;
    private int pages;
    private String total;
    private Set<Photo> photo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Set<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(Set<Photo> photo) {
        this.photo = photo;
    }
}
