package com.javasilev.cityguide.ui;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.CountryCollectionAdapter;
import com.javasilev.cityguide.models.Country;
import com.javasilev.cityguide.models.Response;
import com.javasilev.cityguide.network.CountryService;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aleksei Vasilev.
 */

public class CountriesFragment extends Fragment implements Observer<Response> {
    public static final String SELECTED = "selected";

    @BindView(R.id.fragment_countries_linear_layout_progress)
    LinearLayout mProgress;

    @BindView(R.id.activity_main_list_view_countries)
    ExpandableListView mCountriesListView;

    private CountryCollectionAdapter mAdapter;
    private SharedPreferences mPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new CountryCollectionAdapter(getActivity());
        mAdapter.setFavoriteFragment(((MainActivity) getActivity()).getFavoriteFragment());

        mPreferences = getContext().getSharedPreferences(getContext().getString(R.string.selected_prefs), Context.MODE_PRIVATE);

        mCountriesListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        mCountriesListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            mPreferences.edit().putInt(SELECTED, mAdapter.getChild(groupPosition, childPosition).getId()).apply();
            int index = parent.getFlatListPosition(ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
            parent.setItemChecked(index, true);
            return true;
        });

        mCountriesListView.setAdapter(mAdapter);

        showProgress();
        load();
    }

    public void load() {
        CountryService service = new CountryService(getActivity());
        service.createCountryClient().getCountryApiResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    public void setCollection(List<Country> list) {
        mAdapter.setCollection(list);
    }

    @Override
    public void onCompleted() {
        hideProgress();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Response response) {
        setCollection(response.getCountryList());
    }
}
