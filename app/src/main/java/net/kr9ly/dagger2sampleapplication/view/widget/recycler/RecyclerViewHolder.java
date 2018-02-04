package net.kr9ly.dagger2sampleapplication.view.widget.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    private final Object viewModel;

    public RecyclerViewHolder(ViewDataBinding binding, Object viewModel) {
        super(binding.getRoot());
        this.binding = binding;
        this.viewModel = viewModel;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public Object getViewModel() {
        return viewModel;
    }
}
