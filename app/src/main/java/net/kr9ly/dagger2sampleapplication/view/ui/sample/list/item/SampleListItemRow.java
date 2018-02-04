package net.kr9ly.dagger2sampleapplication.view.ui.sample.list.item;

import net.kr9ly.dagger2sampleapplication.data.entity.SampleListItemEntity;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.list.SampleListViewType;
import net.kr9ly.dagger2sampleapplication.view.widget.recycler.RecyclerRow;

public class SampleListItemRow extends RecyclerRow<SampleListViewType> {

    private final SampleListItemEntity itemEntity;

    public SampleListItemRow(SampleListItemEntity itemEntity) {
        super(SampleListViewType.ITEM);

        this.itemEntity = itemEntity;
    }

    @Override
    public void update(Object viewModelObject) {
        SampleListItemViewModel viewModel = (SampleListItemViewModel) viewModelObject;
        viewModel.update(itemEntity);
    }

    @Override
    public boolean areItemsTheSame(RecyclerRow<?> other) {
        SampleListItemRow otherRow = (SampleListItemRow) other;
        return itemEntity.getId() == otherRow.itemEntity.getId();
    }

    @Override
    public boolean areContentsTheSame(RecyclerRow<?> other) {
        return true;
    }
}
