package com.flickerflics.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Author rahulravindran
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> dataItems;
    private LayoutInflater mInflator;


    public BaseAdapter(List<T> dataItems) {
        this.dataItems = dataItems;
    }


    abstract VH createItem(LayoutInflater inflator, ViewGroup viewGroup, int viewType);

    abstract void bindItem(VH holder, int position, T object);

    abstract void viewTearDown(VH holder);


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
        return dataItems.size();
    }

    public void clearItems() {
        dataItems.clear();
    }

    public void setDataItems(List<T> items) {
        this.dataItems = items;
    }


    public T getItemAtPosition(int pos) {
        return dataItems.get(pos);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull VH holder) {
        holder.setIsRecyclable(true);
        viewTearDown(holder);
    }
}
