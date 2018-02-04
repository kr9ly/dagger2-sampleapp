package net.kr9ly.dagger2sampleapplication.view.ui.sample.list;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;

import net.kr9ly.dagger2sampleapplication.app.usecase.list.SampleListUseCase;
import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.list.item.SampleListItemRow;
import net.kr9ly.dagger2sampleapplication.view.widget.recycler.RecyclerRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class SampleListViewModel extends BaseObservable implements LifecycleObserver {

    public final SampleListViewModelProviders viewModelProviders;

    public final LinearLayoutManager listLayoutManager;

    public final SampleListAdapter listAdapter = new SampleListAdapter();

    private final SampleListUseCase useCase;

    private List<SampleListItemEntity> itemEntities = Collections.emptyList();

    @Inject
    public SampleListViewModel(
            Lifecycle lifecycle,
            SampleListUseCase useCase,
            SampleListViewModelProviders viewModelProviders,
            LinearLayoutManager listLayoutManager
    ) {
        this.useCase = useCase;
        this.viewModelProviders = viewModelProviders;
        this.listLayoutManager = listLayoutManager;

        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        useCase.requestList()
                .subscribe(new Consumer<List<SampleListItemEntity>>() {
                    @Override
                    public void accept(List<SampleListItemEntity> entities) throws Exception {
                        itemEntities = entities;
                        notifyChange();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // do nothing.
                    }
                });
    }

    @Bindable
    public List<RecyclerRow<?>> getListRows() {
        List<RecyclerRow<?>> newRows = new ArrayList<>();
        for (SampleListItemEntity itemEntity : itemEntities) {
            newRows.add(new SampleListItemRow(itemEntity));
        }
        return newRows;
    }
}
