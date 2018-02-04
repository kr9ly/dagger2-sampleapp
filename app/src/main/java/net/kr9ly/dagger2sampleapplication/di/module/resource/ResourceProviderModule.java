package net.kr9ly.dagger2sampleapplication.di.module.resource;

import android.content.Context;

import net.kr9ly.dagger2sampleapplication.infra.resource.ResourceProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ResourceProviderModule {

    private final Context appContext;

    public ResourceProviderModule(Context appContext) {
        this.appContext = appContext;
    }

    @Singleton
    @Provides
    public ResourceProvider provideResourceProvider() {
        return new ResourceProvider(appContext);
    }
}
