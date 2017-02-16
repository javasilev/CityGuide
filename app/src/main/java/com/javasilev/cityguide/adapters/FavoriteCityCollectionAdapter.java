package com.javasilev.cityguide.adapters;

import java.util.Collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.base.CollectionAdapter;
import com.javasilev.cityguide.adapters.viewholders.FavoriteCityViewHolder;
import com.javasilev.cityguide.data.realm.CountryDataSource;
import com.javasilev.cityguide.data.realm.FavoriteCityDataSource;
import com.javasilev.cityguide.models.FavoriteCity;
import com.javasilev.cityguide.ui.CountriesFragment;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("unused")
public class FavoriteCityCollectionAdapter extends CollectionAdapter<FavoriteCity> {
    private CountryDataSource mCountryDataSource = CountryDataSource.getInstance();
    private FavoriteCityDataSource mFavoriteCityDataSource = FavoriteCityDataSource.getInstance();

    private CountriesFragment mFragment;

    public FavoriteCityCollectionAdapter(Context context) {
        super(context);
    }

    public FavoriteCityCollectionAdapter(Context context, Collection<? extends FavoriteCity> collection) {
        super(context, collection);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FavoriteCityViewHolder holder;
        View rootView;

        if (convertView == null) {

            holder = new FavoriteCityViewHolder();
            rootView = LayoutInflater.from(mContext).inflate(R.layout.item_city_viewholder, parent, false);

            holder.create(rootView);
            holder.getRoot().setTag(holder);
        } else {
            holder = (FavoriteCityViewHolder) convertView.getTag();
        }

        holder.setOnClickListener(v -> {
            mFavoriteCityDataSource.deleteItem(getItem(position).getId());
            removeItem(position);
            mFragment.load();
        });

        holder.bind(getItem(position));

        return holder.getRoot();
    }

    public void addItem(FavoriteCity favoriteCity) {
        mList.add(favoriteCity);
        notifyDataSetChanged();
    }

    public void setFragment(CountriesFragment fragment) {
        mFragment = fragment;
    }
}
