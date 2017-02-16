package com.javasilev.cityguide.adapters.base;

import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseViewHolder<T> {
    protected Context mContext;
    protected View mRootView;

    public void create(View rootView) {
        mRootView = rootView;
        mContext = rootView.getContext();
        ButterKnife.bind(this, rootView);
    }

    public abstract void bind(T model);

    public View getRoot() {
        return mRootView;
    }
}
