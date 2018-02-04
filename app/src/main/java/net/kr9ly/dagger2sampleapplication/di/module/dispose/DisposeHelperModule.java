package net.kr9ly.dagger2sampleapplication.di.module.dispose;

import android.arch.lifecycle.LifecycleOwner;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.dispose.DisposeHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class DisposeHelperModule {

    private final LifecycleOwner lifecycleOwner;

    public DisposeHelperModule(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    @ViewScope
    @Provides
    DisposeHelper provideDisposeHelper() {
        return new DisposeHelper(lifecycleOwner);
    }
}
