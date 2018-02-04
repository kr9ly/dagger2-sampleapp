package net.kr9ly.dagger2sampleapplication.di.module.arguments;

import android.support.v4.app.Fragment;

import net.kr9ly.dagger2sampleapplication.infra.arguments.ArgumentsProvider;
import net.kr9ly.dagger2sampleapplication.infra.arguments.FragmentArgumentsProvider;

public class ArgumentsProviderFragmentDelegate implements ArgumentsProviderDelegate {

    private final Fragment fragment;

    public ArgumentsProviderFragmentDelegate(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public ArgumentsProvider provide() {
        return new FragmentArgumentsProvider(fragment);
    }
}
