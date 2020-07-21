package com.tahirferli.loremipsum.dagger;

import com.tahirferli.loremipsum.network.PicsumApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class ApiModule {

    @Provides
    public GsonConverterFactory gsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonFactory){
        final String BASE_URL = "https://picsum.photos/";
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonFactory)
                .build();
    }

    @Provides
    public PicsumApi picsumApi(Retrofit retrofit) {
        return retrofit.create(PicsumApi.class);
    }
}