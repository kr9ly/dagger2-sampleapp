package net.kr9ly.dagger2sampleapplication.view.widget.recycler;


public abstract class RecyclerRow<T extends ViewType> {

    private final T viewType;

    protected RecyclerRow(T viewType) {
        this.viewType = viewType;
    }

    public T getViewType() {
        return viewType;
    }

    public abstract void update(Object viewModelObject);

    public abstract boolean areItemsTheSame(RecyclerRow<?> other);

    public abstract boolean areContentsTheSame(RecyclerRow<?> other);
}
