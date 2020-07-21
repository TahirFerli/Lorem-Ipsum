package com.tahirferli.loremipsum.repos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahirferli.loremipsum.model.Picsum;
import com.tahirferli.loremipsum.network.PicsumApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class PicsumRepo {
    private PicsumApi api;

    @Inject
    public PicsumRepo(PicsumApi api) {
        this.api = api;
    }

    public LiveData<List<Picsum>> getPicsumLiveData() {
        MutableLiveData<List<Picsum>> liveData = new MutableLiveData<List<Picsum>>();

        Call<List<Picsum>> call =  api.getPictures();
        call.enqueue(new Callback<List<Picsum>>() {
            @Override
            public void onResponse(Call<List<Picsum>> call, Response<List<Picsum>> response) {
                if(response.isSuccessful()) {
                    List<Picsum> picsumList = response.body();
                    liveData.setValue(picsumList);
                }
            }

            @Override
            public void onFailure(Call<List<Picsum>> call, Throwable t) {
                // What a Terrible Failure.
                Timber.wtf("Error fetching photos from network. %s",
                        t.getLocalizedMessage());
            }
        });

        return liveData;
    }
}
