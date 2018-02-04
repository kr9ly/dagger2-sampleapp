package net.kr9ly.dagger2sampleapplication.di.module.transition;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class TransitionHandlerModule {

    private final TransitionHandlerDelegate delegate;

    public TransitionHandlerModule(TransitionHandlerDelegate delegate) {
        this.delegate = delegate;
    }

    @ViewScope
    @Provides
    public TransitionHandler provideTransitionHandler() {
        return delegate.provide();
    }
}
