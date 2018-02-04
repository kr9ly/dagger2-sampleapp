package net.kr9ly.dagger2sampleapplication.di.component;

import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.scope.Lifecycle;

import dagger.Subcomponent;

@Lifecycle
@Subcomponent(
        modules = {
                FragmentManagerDelegatedModule.class
        }
)
public interface LifecycleComponent {
}
