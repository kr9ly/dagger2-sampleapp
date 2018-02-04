package net.kr9ly.dagger2sampleapplication.view.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.kr9ly.dagger2sampleapplication.di.ApplicationComponentManager;
import net.kr9ly.dagger2sampleapplication.di.component.LifecycleComponent;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerActivityDelegate;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac.AacLifecycleRegistryModule;

public abstract class DaggerBaseActivity extends AppCompatActivity {

    private LifecycleComponent lifecycleComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lifecycleComponent = ApplicationComponentManager.get(this).lifecycleComponent(
                new FragmentManagerDelegatedModule(new FragmentManagerActivityDelegate(this)),
                new AacLifecycleRegistryModule(this)
        );
    }

    protected abstract void onComponentPrepared(LifecycleComponent component, @Nullable Bundle savedInstanceState);
}
