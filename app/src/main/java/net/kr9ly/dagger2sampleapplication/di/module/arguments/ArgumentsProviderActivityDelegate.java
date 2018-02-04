package net.kr9ly.dagger2sampleapplication.di.module.arguments;

import android.support.v4.app.FragmentActivity;

import net.kr9ly.dagger2sampleapplication.infra.arguments.ActivityArgumentsProvider;
import net.kr9ly.dagger2sampleapplication.infra.arguments.ArgumentsProvider;

public class ArgumentsProviderActivityDelegate implements ArgumentsProviderDelegate {

    private final FragmentActivity fragmentActivity;

    public ArgumentsProviderActivityDelegate(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public ArgumentsProvider provide() {
        return new ActivityArgumentsProvider(fragmentActivity);
    }
}
