package com.javasilev.cityguide.models;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("unused")
public class FavoriteCity extends RealmObject implements Serializable {

    @PrimaryKey
    private int mId;
    private String mName;

    public FavoriteCity() {
    }

    public FavoriteCity(int id) {
        mId = id;
    }

    public FavoriteCity(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public static class Columns {
        public static final String ID = "mId";
        public static final String NAME = "mName";
    }
}
