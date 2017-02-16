package com.javasilev.cityguide.adapters.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "FieldCanBeLocal", "unused"})
public abstract class CollectionAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mList = new ArrayList<>();

    public CollectionAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public CollectionAdapter(Context context, Collection<? extends T> collection) {
        this(context);

        if (collection != null) {
            mList.addAll(collection);
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    public void removeItem(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setCollection(Collection<? extends T> collection) {
        mList.clear();

        if (collection != null) {
            mList.addAll(collection);
        }

        notifyDataSetChanged();
    }

    public void clearCollection() {
        mList.clear();
        notifyDataSetChanged();
    }
}
