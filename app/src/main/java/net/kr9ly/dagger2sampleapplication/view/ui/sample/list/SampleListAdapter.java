package net.kr9ly.dagger2sampleapplication.view.ui.sample.list;

import net.kr9ly.dagger2sampleapplication.view.widget.recycler.BaseRecyclerAdapter;

public class SampleListAdapter extends BaseRecyclerAdapter<SampleListViewModelProviders, SampleListViewType> {

    @Override
    protected SampleListViewType[] getViewTypes() {
        return SampleListViewType.values();
    }
}
