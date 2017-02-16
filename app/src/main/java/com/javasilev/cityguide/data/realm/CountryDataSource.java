package com.javasilev.cityguide.data.realm;

import java.util.List;

import com.javasilev.cityguide.data.base.BaseRealmDataSource;
import com.javasilev.cityguide.models.City;
import com.javasilev.cityguide.models.Country;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class CountryDataSource extends BaseRealmDataSource<Country> {
    private static CountryDataSource sInstance;

    public static CountryDataSource getInstance() {
        if (sInstance == null) {
            synchronized (CountryDataSource.class) {
                if (sInstance == null) {
                    sInstance = new CountryDataSource(Country.class);
                }
            }
        }
        return sInstance;
    }

    private CountryDataSource(Class<Country> type) {
        super(type);
    }

    @Override
    public List<Country> find(String searchQuery) {
        return super.getAll();
    }

    public City getCity(long id) {
        return mRealm.where(City.class).equalTo(City.Columns.ID, id).findFirst();
    }
}
