package com.javasilev.cityguide.data.base;

import java.util.List;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"unused", "WeakerAccess"})
public interface IDataSource<Data> {
    Data createOrUpdate(Data data);

    Data getItem(long itemId);

    void deleteItem(long itemId);

    List<Data> getAll();

    List<Data> find(String searchQuery);
}
