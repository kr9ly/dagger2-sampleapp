package net.kr9ly.dagger2sampleapplication.view.widget.recycler;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.kr9ly.dagger2sampleapplication.BR;
import net.kr9ly.dagger2sampleapplication.view.ui.sample.list.SampleListViewModelProviders;

import java.util.Collections;
import java.util.List;

public abstract class BaseRecyclerAdapter<VMP, VT extends ViewType<VMP>> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<RecyclerRow<VT>> rows = Collections.emptyList();

    private VMP viewModelProviders;

    protected abstract VT[] getViewTypes();

    @Override
    public int getItemViewType(int position) {
        return rows.get(position).getViewType().ordinal();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewTypeOrdinal) {
        VT viewType = getViewTypes()[viewTypeOrdinal];
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType.getLayoutRes(), parent, false);
        Object viewModel = viewType.getViewModel(viewModelProviders);
        binding.setVariable(BR.viewModel, viewModel);
        return new RecyclerViewHolder(binding, viewModel);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerRow<VT> row = rows.get(position);
        row.update(holder.getViewModel());
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void setRows(@NonNull final List<RecyclerRow<VT>> newRows) {
        if (rows.isEmpty()) {
            rows = newRows;
            notifyDataSetChanged();
            return;
        }
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return rows.size();
            }

            @Override
            public int getNewListSize() {
                return newRows.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return rows.get(oldItemPosition).areItemsTheSame(newRows.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return rows.get(oldItemPosition).areContentsTheSame(newRows.get(newItemPosition));
            }
        });
        rows = newRows;
        diffResult.dispatchUpdatesTo(this);
    }

    public void setViewModelProviders(VMP viewModelProviders) {
        this.viewModelProviders = viewModelProviders;
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter({"adapter", "viewModelProviders", "rows"})
    public static void bindRecyclerRows(RecyclerView recyclerView, BaseRecyclerAdapter adapter, SampleListViewModelProviders providers, List<RecyclerRow<?>> rows) {
        if (recyclerView.getAdapter() != adapter)  {
            recyclerView.setAdapter(adapter);
        }
        adapter.setViewModelProviders(providers);
        adapter.setRows(rows);
    }
}
