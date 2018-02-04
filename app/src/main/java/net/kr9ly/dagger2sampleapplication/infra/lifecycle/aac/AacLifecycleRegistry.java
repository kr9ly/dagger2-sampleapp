package net.kr9ly.dagger2sampleapplication.infra.lifecycle.aac;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;

public class AacLifecycleRegistry {

    private final Lifecycle lifecycle;

    public AacLifecycleRegistry(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public void register(LifecycleObserver observer) {
        lifecycle.addObserver(observer);
    }
}
