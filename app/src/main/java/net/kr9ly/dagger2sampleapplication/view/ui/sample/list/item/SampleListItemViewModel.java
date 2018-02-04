package net.kr9ly.dagger2sampleapplication.view.ui.sample.list.item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import net.kr9ly.dagger2sampleapplication.R;
import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.infra.resource.ResourceProvider;
import net.kr9ly.dagger2sampleapplication.infra.transition.TransitionHandler;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.detail.SampleDetailViewModel;

import javax.inject.Inject;

public class SampleListItemViewModel extends BaseObservable {

    private final TransitionHandler transitionHandler;

    private final ResourceProvider resourceProvider;

    private SampleListItemEntity itemEntity;

    @Inject
    public SampleListItemViewModel(
            TransitionHandler transitionHandler,
            ResourceProvider resourceProvider
    ) {
        this.transitionHandler = transitionHandler;
        this.resourceProvider = resourceProvider;
    }

    void update(SampleListItemEntity itemEntity) {
        this.itemEntity = itemEntity;
        notifyChange();
    }

    @Bindable
    public String getName() {
        return itemEntity.getName();
    }

    @Bindable
    public String getQuantity() {
        return resourceProvider.getString(R.string.sample_quantity_text, itemEntity.getQuantity());
    }

    public void onClick(View view) {
        transitionHandler.startActivity(SampleDetailViewModel.createDetailIntentBuilder(
                itemEntity.getId()
        ));
    }
}
