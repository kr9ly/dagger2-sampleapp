package net.kr9ly.dagger2sampleapplication.di.component;

import net.kr9ly.dagger2sampleapplication.di.module.arguments.ArgumentsProviderModule;
import net.kr9ly.dagger2sampleapplication.di.module.dispose.DisposeHelperModule;
import net.kr9ly.dagger2sampleapplication.di.module.fragment.delegate.FragmentManagerDelegatedModule;
import net.kr9ly.dagger2sampleapplication.di.module.lifecycle.aac.AacLifecycleModule;
import net.kr9ly.dagger2sampleapplication.di.module.transition.TransitionHandlerModule;
import net.kr9ly.dagger2sampleapplication.di.scope.ViewScope;
import net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks.LifecycleCallbackController;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.detail.SampleDetailViewModel;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.list.SampleListViewModel;

import dagger.Subcomponent;

@ViewScope
@Subcomponent(
        modules = {
                FragmentManagerDelegatedModule.class,
                AacLifecycleModule.class,
                ArgumentsProviderModule.class,
                TransitionHandlerModule.class,
                DisposeHelperModule.class
        }
)
public interface ViewScopeComponent {

    LifecycleCallbackController lifecycleCallbackController();

    // ViewModel
    SampleListViewModel listViewModel();

    SampleDetailViewModel detailViewModel();
}
