package net.kr9ly.dagger2sampleapplication.view.ui.sample.list;

import net.kr9ly.dagger2sampleapplication.view.ui.sample.list.item.SampleListItemViewModel;

import javax.inject.Inject;
import javax.inject.Provider;

public class SampleListViewModelProviders {

    final Provider<SampleListItemViewModel> listItemViewModelProvider;

    @Inject
    public SampleListViewModelProviders(Provider<SampleListItemViewModel> listItemViewModelProvider) {
        this.listItemViewModelProvider = listItemViewModelProvider;
    }
}
