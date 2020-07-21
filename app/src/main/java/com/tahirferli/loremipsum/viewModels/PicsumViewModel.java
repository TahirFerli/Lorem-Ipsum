package com.tahirferli.loremipsum.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.tahirferli.loremipsum.model.Picsum;
import com.tahirferli.loremipsum.repos.PicsumRepo;

import java.util.List;

public class PicsumViewModel extends ViewModel {

    private PicsumRepo repo;

    public PicsumViewModel(PicsumRepo repo) {
        this.repo = repo;
    }

    public LiveData<List<Picsum>> getPicsumListLive() {
        return repo.getPicsumLiveData();
    }
}
