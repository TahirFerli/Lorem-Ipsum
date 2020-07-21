package com.tahirferli.loremipsum.dagger;

import com.tahirferli.loremipsum.ui.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface LoremComponent {
    void inject(MainFragment fragment);
}