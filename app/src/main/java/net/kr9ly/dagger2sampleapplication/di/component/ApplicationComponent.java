package net.kr9ly.dagger2sampleapplication.di.component;

import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac.AacLifecycleRegistryModule;
import net.kr9ly.dagger2sampleapplication.di.module.resource.ResourceProviderModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ResourceProviderModule.class
        }
)
public interface ApplicationComponent {

    LifecycleComponent lifecycleComponent(
            FragmentManagerDelegatedModule fragmentManagerModule,
            AacLifecycleRegistryModule aacLifecycleRegistryModule
    );
}
