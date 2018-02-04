package net.kr9ly.dagger2sampleapplication.view.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.kr9ly.dagger2sampleapplication.di.ApplicationComponentManager;
import net.kr9ly.dagger2sampleapplication.di.component.ViewScopeComponent;
import net.kr9ly.dagger2sampleapplication.di.module.arguments.ArgumentsProviderActivityDelegate;
import net.kr9ly.dagger2sampleapplication.di.module.arguments.ArgumentsProviderModule;
import net.kr9ly.dagger2sampleapplication.di.module.dispose.DisposeHelperModule;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerActivityDelegate;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac.AacLifecycleModule;
import net.kr9ly.dagger2sampleapplication.di.module.transition.TransitionHandlerActivityDelegate;
import net.kr9ly.dagger2sampleapplication.di.module.transition.TransitionHandlerModule;
import net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks.LifecycleCallbackController;

public abstract class DaggerBaseActivity extends AppCompatActivity {

    private LifecycleCallbackController lifecycleCallbackController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewScopeComponent viewScopeComponent = ApplicationComponentManager
                .get(this)
                .lifecycleComponent(
                        new FragmentManagerDelegatedModule(new FragmentManagerActivityDelegate(this)),
                        new AacLifecycleModule(this),
                        new ArgumentsProviderModule(new ArgumentsProviderActivityDelegate(this)),
                        new TransitionHandlerModule(new TransitionHandlerActivityDelegate(this)),
                        new DisposeHelperModule(this)
                );

        lifecycleCallbackController = viewScopeComponent
                .lifecycleCallbackController();

        onComponentPrepared(viewScopeComponent, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        lifecycleCallbackController.onStart();
    }

    protected abstract void onComponentPrepared(ViewScopeComponent component, @Nullable Bundle savedInstanceState);
}
