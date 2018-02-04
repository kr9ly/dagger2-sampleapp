package net.kr9ly.dagger2sampleapplication.view.ui.sample.list;

import net.kr9ly.dagger2sampleapplication.R;
import net.kr9ly.dagger2sampleapplication.view.widget.recycler.ViewType;

public enum SampleListViewType implements ViewType<SampleListViewModelProviders> {
    ITEM {
        @Override
        public int getLayoutRes() {
            return R.layout.row_list_item;
        }

        @Override
        public Object getViewModel(SampleListViewModelProviders viewModelProviders) {
            return viewModelProviders.listItemViewModelProvider.get();
        }
    }
}
