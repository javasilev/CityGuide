package com.javasilev.cityguide.data.base;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public abstract class BaseRealmDataSource<T extends RealmObject> implements IDataSource<T> {
    public static final String ID = "mId";

    protected Realm mRealm = Realm.getDefaultInstance();

    private final Class<T> mType;

    public BaseRealmDataSource(Class<T> type) {
        mType = type;
    }

    @Override
    public T createOrUpdate(T t) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(t);
        mRealm.commitTransaction();
        return t;
    }

    @Override
    public T getItem(long itemId) {
        return mRealm.where(mType).equalTo(ID, itemId).findFirst();
    }

    @Override
    public void deleteItem(long itemId) {
        mRealm.beginTransaction();
        mRealm.where(mType).equalTo(ID, itemId).findFirst().deleteFromRealm();
        mRealm.commitTransaction();
    }

    @Override
    public List<T> getAll() {
        return mRealm.where(mType).findAll();
    }
}
