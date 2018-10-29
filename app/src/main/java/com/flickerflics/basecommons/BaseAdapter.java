package com.flickerflics.basecommons;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Author rahulravindran
 */
public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> dataItems;
    private LayoutInflater mInflator;
    private boolean showProgress;

    public BaseAdapter(List<T> dataItems) {
        super();
        this.dataItems = dataItems;
    }

    protected abstract VH createItem(LayoutInflater inflator, ViewGroup viewGroup, int viewType);

    protected abstract void bindItem(VH holder, int position, T object);

    protected abstract void viewTearDown(VH holder);

    protected abstract int viewType(final int position);


    @Override
    public int getItemViewType(int position) {
        return viewType(position);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflator == null) {
            mInflator = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        return createItem(mInflator, viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        bindItem(vh, i, dataItems.get(i));
    }

    @Override
    public int getItemCount() {
        if (showProgress) {
            return dataItems.size() + 1;
        } else {
            return dataItems.size();
        }
    }

    public void clearItems() {
        dataItems.clear();
    }

    public void setDataItems(List<T> items) {
        this.dataItems.addAll(items);
    }


    public T getItemAtPosition(int pos) {
        return dataItems.get(pos);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VH holder) {
        holder.setIsRecyclable(true);
        viewTearDown(holder);
    }

    protected void showProgress(boolean status) {
        if (dataItems.size() > 0) {
            showProgress = status;
            if (status) {
                dataItems.add(null);
                notifyItemInserted(dataItems.size() - 1);
            } else {
                int lastPos = dataItems.size() -1;
                dataItems.remove(lastPos);
                notifyItemRemoved(lastPos);
            }
        }
    }
}
