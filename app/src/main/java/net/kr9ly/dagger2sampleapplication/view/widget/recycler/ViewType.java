package net.kr9ly.dagger2sampleapplication.view.widget.recycler;

public interface ViewType<VMP> {

    int ordinal();

    int getLayoutRes();

    Object getViewModel(VMP viewModelProviders);
}
