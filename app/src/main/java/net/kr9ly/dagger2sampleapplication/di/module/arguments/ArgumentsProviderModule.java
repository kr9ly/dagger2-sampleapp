package net.kr9ly.dagger2sampleapplication.di.module.arguments;

import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.arguments.ArgumentsProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ArgumentsProviderModule {

    private final ArgumentsProviderDelegate delegate;

    public ArgumentsProviderModule(ArgumentsProviderDelegate delegate) {
        this.delegate = delegate;
    }

    @ViewScope
    @Provides
    ArgumentsProvider provideArgumentsProvider() {
        return delegate.provide();
    }
}
