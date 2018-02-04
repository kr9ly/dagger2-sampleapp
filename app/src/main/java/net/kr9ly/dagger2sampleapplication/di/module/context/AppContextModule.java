package net.kr9ly.dagger2sampleapplication.di.module.context;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {

    private final Context appContext;

    public AppContextModule(Context appContext) {
        this.appContext = appContext;
    }

    @Singleton
    @Provides
    public Context provide() {
        return appContext;
    }
}
