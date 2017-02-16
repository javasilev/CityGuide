package com.javasilev.cityguide.adapters;

import java.util.Collection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.base.CollectionAdapter;
import com.javasilev.cityguide.adapters.viewholders.CityViewHolder;
import com.javasilev.cityguide.data.realm.FavoriteCityDataSource;
import com.javasilev.cityguide.models.City;
import com.javasilev.cityguide.models.FavoriteCity;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("unused")
public class CityCollectionAdapter extends CollectionAdapter<City> {
    private FavoriteCityDataSource mDataSource = FavoriteCityDataSource.getInstance();

    public CityCollectionAdapter(Context context) {
        super(context);
    }

    public CityCollectionAdapter(Context context, Collection<? extends City> collection) {
        super(context, collection);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityViewHolder holder;
        View rootView;

        if (convertView == null) {

            holder = new CityViewHolder();
            rootView = LayoutInflater.from(mContext).inflate(R.layout.item_city_viewholder, parent, false);

            holder.create(rootView);
            holder.getRoot().setTag(holder);
        } else {
            holder = (CityViewHolder) convertView.getTag();
        }

        int cityId = getItem(position).getId();

        final boolean isFavorite = null != mDataSource.getItem(cityId);
        holder.setDrawable(getFavoriteDrawable(isFavorite));
        holder.setButtonOnClickListener(v -> {
            if (isFavorite) {
                mDataSource.deleteItem(cityId);
                holder.setDrawable(getFavoriteDrawable(false));
            } else {
                mDataSource.createOrUpdate(new FavoriteCity(cityId, getItem(position).getName()));
                holder.setDrawable(getFavoriteDrawable(true));
            }
        });

        holder.bind(getItem(position));

        return holder.getRoot();
    }

    private Drawable getFavoriteDrawable(boolean isFavorite) {
        return isFavorite ?
               ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_black_24dp) :
               ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_border_black_24dp);
    }
}
