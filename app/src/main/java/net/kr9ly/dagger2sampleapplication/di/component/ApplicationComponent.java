package net.kr9ly.dagger2sampleapplication.di.component;

import net.kr9ly.dagger2sampleapplication.di.module.arguments.ArgumentsProviderModule;
import net.kr9ly.dagger2sampleapplication.di.module.dispose.DisposeHelperModule;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac.AacLifecycleModule;
import net.kr9ly.dagger2sampleapplication.di.module.recycler.LayoutManagerModule;
import net.kr9ly.dagger2sampleapplication.di.module.resource.ResourceProviderModule;
import net.kr9ly.dagger2sampleapplication.di.module.transition.TransitionHandlerModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ResourceProviderModule.class,
                LayoutManagerModule.class
        }
)
public interface ApplicationComponent {

    ViewScopeComponent lifecycleComponent(
            FragmentManagerDelegatedModule fragmentManagerModule,
            AacLifecycleModule aacLifecycleModule,
            ArgumentsProviderModule argumentsProviderModule,
            TransitionHandlerModule transitionHandlerModule,
            DisposeHelperModule disposeHelperModule
    );
}
