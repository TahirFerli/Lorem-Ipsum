package com.tahirferli.loremipsum;

import android.app.Application;

import com.tahirferli.loremipsum.dagger.DaggerLoremComponent;
import com.tahirferli.loremipsum.dagger.LoremComponent;

import timber.log.Timber;

public class LoremApp extends Application {

    private LoremComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        component = DaggerLoremComponent.builder().build();
    }

    public LoremComponent getComponent() {
        return component;
    }
}
