package com.tahirferli.loremipsum.network;

import com.tahirferli.loremipsum.model.Picsum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PicsumApi {

    @GET("v2/list")
    Call<List<Picsum>> getPictures();
}
// https://picsum.photos/v2/list