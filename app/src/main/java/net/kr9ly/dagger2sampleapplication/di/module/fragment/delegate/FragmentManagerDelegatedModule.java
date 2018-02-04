package net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate;


import android.support.v4.app.FragmentManager;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentManagerDelegatedModule {

    private final FragmentManagerDelegate delegate;

    public FragmentManagerDelegatedModule(FragmentManagerDelegate delegate) {
        this.delegate = delegate;
    }

    @ViewScope
    @Provides
    FragmentManager provideFragmentManager() {
        return delegate.provide();
    }
}
