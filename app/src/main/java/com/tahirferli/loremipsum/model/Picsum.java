package com.tahirferli.loremipsum.model;

import com.google.gson.annotations.SerializedName;

public class Picsum {

    @SerializedName("id")
    private String picId;
    private String author;
    private int width;
    private int height;
    private String url;
    @SerializedName("download_url")
    private String downloadUrl;

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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}