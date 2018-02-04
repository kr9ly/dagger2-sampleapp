package net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac;

import android.arch.lifecycle.LifecycleOwner;

import net.kr9ly.dagger2sampleapplication.infra.lifecycle.aac.AacLifecycleRegistry;

public class AacLifecycleRegistryModule {

    private final LifecycleOwner lifecycleOwner;

    public AacLifecycleRegistryModule(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    AacLifecycleRegistry provideAacLifecycleRegistry() {
        return new AacLifecycleRegistry(lifecycleOwner.getLifecycle());
    }
}
