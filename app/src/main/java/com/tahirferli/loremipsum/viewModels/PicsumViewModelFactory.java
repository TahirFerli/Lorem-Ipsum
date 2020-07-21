package com.tahirferli.loremipsum.viewModels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tahirferli.loremipsum.repos.PicsumRepo;

public class PicsumViewModelFactory extends  ViewModelProvider.NewInstanceFactory{

    private PicsumRepo repo;

    public PicsumViewModelFactory(PicsumRepo repo) {
        this.repo = repo;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new PicsumViewModel(repo);
    }

}
