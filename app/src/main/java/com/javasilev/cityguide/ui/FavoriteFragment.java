package com.javasilev.cityguide.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.FavoriteCityCollectionAdapter;
import com.javasilev.cityguide.data.realm.FavoriteCityDataSource;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aleksei Vasilev.
 */

public class FavoriteFragment extends Fragment {
    @BindView(R.id.fragment_favorite_list_view_favorites)
    ListView mListView;

    @BindView(R.id.item_favorites_empty_view_text_view)
    TextView mEmptyTextView;

    private FavoriteCityCollectionAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new FavoriteCityCollectionAdapter(getActivity());
        mAdapter.setFragment(((MainActivity) getActivity()).getCountriesFragment());

        mListView.setEmptyView(mEmptyTextView);

        load();
    }

    public void load() {
        FavoriteCityDataSource dataSource = FavoriteCityDataSource.getInstance();
        mAdapter.setCollection(dataSource.getAll());
        mListView.setAdapter(mAdapter);
    }
}
