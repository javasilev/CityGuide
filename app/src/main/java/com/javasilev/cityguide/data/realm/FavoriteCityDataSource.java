package com.javasilev.cityguide.data.realm;

import java.util.List;

import com.javasilev.cityguide.data.base.BaseRealmDataSource;
import com.javasilev.cityguide.models.FavoriteCity;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class FavoriteCityDataSource extends BaseRealmDataSource<FavoriteCity> {
    private static FavoriteCityDataSource sInstance;

    public static FavoriteCityDataSource getInstance() {
        if (sInstance == null) {
            synchronized (CountryDataSource.class) {
                if (sInstance == null) {
                    sInstance = new FavoriteCityDataSource(FavoriteCity.class);
                }
            }
        }
        return sInstance;
    }

    private FavoriteCityDataSource(Class<FavoriteCity> type) {
        super(type);
    }

    @Override
    public List<FavoriteCity> find(String searchQuery) {
        return super.getAll();
    }
}
