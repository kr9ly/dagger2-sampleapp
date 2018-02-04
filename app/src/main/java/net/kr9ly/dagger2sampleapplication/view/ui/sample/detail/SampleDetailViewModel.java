package net.kr9ly.dagger2sampleapplication.view.ui.sample.detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import net.kr9ly.dagger2sampleapplication.R;
import net.kr9ly.dagger2sampleapplication.app.usecase.detail.SampleDetailUseCase;
import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.infra.arguments.ArgumentsProvider;
import net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks.LifecycleCallbackController;
import net.kr9ly.dagger2sampleapplication.infra.lifecycle.callbacks.OnStartCallback;
import net.kr9ly.dagger2sampleapplication.infra.resource.ResourceProvider;
import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;
import net.kr9ly.dagger2sampleapplication.infra.transition.intent.IntentBuilder;
import net.kr9ly.dagger2sampleapplication.infra.transition.intent.SimpleIntentBuilder;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class SampleDetailViewModel extends BaseObservable implements OnStartCallback {

    private static final String ARGUMENT_KEY_ID = "ID";

    public static IntentBuilder createDetailIntentBuilder(int id) {
        return new SimpleIntentBuilder(SampleDetailActivity.class)
                .putExtra(ARGUMENT_KEY_ID, id);
    }

    private final ResourceProvider resourceProvider;

    private final TransitionHandler transitionHandler;

    private final SampleDetailUseCase useCase;

    private final int id;

    private SampleListItemEntity entity;

    @Inject
    public SampleDetailViewModel(
            LifecycleCallbackController lifecycleCallbackController,
            ArgumentsProvider argumentsProvider,
            ResourceProvider resourceProvider,
            TransitionHandler transitionHandler,
            SampleDetailUseCase useCase
    ) {
        this.resourceProvider = resourceProvider;
        this.transitionHandler = transitionHandler;
        this.useCase = useCase;

        lifecycleCallbackController.register(this);

        id = argumentsProvider.getInt(ARGUMENT_KEY_ID, 0);
    }

    @Override
    public void onStart() {
        useCase.requestDetail(id)
                .subscribe(new Consumer<SampleListItemEntity>() {
                    @Override
                    public void accept(SampleListItemEntity sampleListItemEntity) throws Exception {
                        entity = sampleListItemEntity;
                        notifyChange();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // do nothing.
                    }
                });
    }

    public void onNavigationClick(View v) {
        transitionHandler.finish();
    }

    @Bindable
    public String getName() {
        if (entity == null) {
            return "";
        }
        return entity.getName();
    }

    @Bindable
    public String getQuantity() {
        if (entity == null) {
            return "";
        }
        return resourceProvider.getString(R.string.sample_quantity_text, entity.getQuantity());
    }

}
