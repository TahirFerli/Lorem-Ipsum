package com.tahirferli.loremipsum;

import android.app.Application;

import timber.log.Timber;

class LoremApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
