package net.kr9ly.dagger2sampleapplication.di.module.fragment.dynamic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentManagerDynamicModule {

    private final Object scopeObject;

    public FragmentManagerDynamicModule(Object scopeObject) {
        this.scopeObject = scopeObject;
    }

    @ViewScope
    @Provides
    FragmentManager provideFragmentManager() {
        if (scopeObject instanceof FragmentActivity) {
            return ((FragmentActivity) scopeObject).getSupportFragmentManager();
        } else if (scopeObject instanceof Fragment) {
            return ((Fragment) scopeObject).getChildFragmentManager();
        }
        throw new IllegalStateException();
    }
}
