package com.tahirferli.loremipsum.model;

import com.google.gson.annotations.SerializedName;

public class Picsum {

    @SerializedName("id")
    String picId;
    String author;
    String url;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
