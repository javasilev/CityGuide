package com.javasilev.cityguide.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.viewholders.CityViewHolder;
import com.javasilev.cityguide.adapters.viewholders.CountryViewHolder;
import com.javasilev.cityguide.data.realm.FavoriteCityDataSource;
import com.javasilev.cityguide.models.City;
import com.javasilev.cityguide.models.Country;
import com.javasilev.cityguide.models.FavoriteCity;
import com.javasilev.cityguide.ui.CountriesFragment;
import com.javasilev.cityguide.ui.FavoriteFragment;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"unchecked", "unused", "FieldCanBeLocal"})
public class CountryCollectionAdapter extends BaseExpandableListAdapter {
    private FavoriteCityDataSource mDataSource = FavoriteCityDataSource.getInstance();
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Country> mTitles = new ArrayList<>();
    private Map<Country, List<City>> mCollection = new HashMap<>();

    private FavoriteFragment mFavoriteFragment;

    private SharedPreferences mPreferences;

    public CountryCollectionAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public CountryCollectionAdapter(Context context, @NonNull List<Country> titles, @NonNull Map<Country, List<City>> collection) {
        this(context);
        mTitles = titles;
        mCollection = collection;
    }

    @Override
    public int getGroupCount() {
        return mCollection.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mCollection.get(mTitles.get(groupPosition)).size();
    }

    @Override
    public Country getGroup(int groupPosition) {
        return mTitles.get(groupPosition);
    }

    @Override
    public City getChild(int groupPosition, int childPosition) {
        return mCollection
                .get(mTitles.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getChild(groupPosition, childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        CountryViewHolder holder;
        View rootView;

        if (convertView == null) {

            holder = new CountryViewHolder();
            rootView = LayoutInflater.from(mContext).inflate(R.layout.item_country_viewholder, parent, false);

            holder.create(rootView);
            holder.getRoot().setTag(holder);
        } else {
            holder = (CountryViewHolder) convertView.getTag();
        }

        holder.bind(getGroup(groupPosition));

        return holder.getRoot();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
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

        mPreferences = mContext.getSharedPreferences(mContext.getString(R.string.selected_prefs), Context.MODE_PRIVATE);

        final City city = getChild(groupPosition, childPosition);
        int selectedCityId = mPreferences.getInt(CountriesFragment.SELECTED, 0);

        if (selectedCityId == city.getId()) {
            int index = ((ExpandableListView) parent).getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
            ((ExpandableListView) parent).setItemChecked(index, true);
        }

        holder.setFavorite(null != mDataSource.getItem(city.getId()));
        holder.setDrawable(getFavoriteDrawable(holder.isFavorite()));
        holder.setButtonOnClickListener(v -> {
            if (holder.isFavorite()) {
                mDataSource.deleteItem(city.getId());
                holder.setFavorite(false);
                holder.setDrawable(getFavoriteDrawable(false));
            } else {
                mDataSource.createOrUpdate(new FavoriteCity(city.getId(), city.getName()));
                holder.setFavorite(true);
                holder.setDrawable(getFavoriteDrawable(true));
            }
            mFavoriteFragment.load();
        });

        holder.bind(city);

        return holder.getRoot();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setCollection(List<Country> countryList) {
        mTitles.clear();
        mCollection.clear();

        for (Country country : countryList) {
            mTitles.add(country);
            mCollection.put(country, country.getCityList());
        }

        notifyDataSetChanged();
    }

    private Drawable getFavoriteDrawable(boolean isFavorite) {
        return isFavorite ?
               ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_black_24dp) :
               ContextCompat.getDrawable(mContext, R.drawable.ic_favorite_border_black_24dp);
    }

    public void setFavoriteFragment(FavoriteFragment fragment) {
        mFavoriteFragment = fragment;
    }
}
