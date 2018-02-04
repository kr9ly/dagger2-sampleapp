package net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AacLifecycleModule {

    private final LifecycleOwner lifecycleOwner;

    public AacLifecycleModule(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    @ViewScope
    @Provides
    Lifecycle provideAacLifecycle() {
        return lifecycleOwner.getLifecycle();
    }
}
