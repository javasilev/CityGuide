package com.javasilev.cityguide.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.SectionsPagerAdapter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindString(R.string.countries)
    String countries;
    @BindString(R.string.favorites)
    String favorites;
    @BindString(R.string.settings)
    String settings;

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.item_actionbar_text_view_title)
    TextView mTitleTextView;

    @BindView(R.id.activity_main_tabs_container)
    ViewPager mViewPager;

    @BindView(R.id.item_actionbar_tabs)
    TabLayout mTabLayout;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);
        ButterKnife.bind(this);

        mTitleTextView.setText(R.string.app_name);
        setSupportActionBar(mToolbar);

        setUpFragments();

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpFragments() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        CountriesFragment countriesFragment = new CountriesFragment();
        countriesFragment.setRetainInstance(true);
        mSectionsPagerAdapter.addFragment(countriesFragment, countries);

        FavoriteFragment favoriteFragment = new FavoriteFragment();
        favoriteFragment.setRetainInstance(true);
        mSectionsPagerAdapter.addFragment(favoriteFragment, favorites);

        SettingsFragment settingsFragment = new SettingsFragment();
        settingsFragment.setRetainInstance(true);
        mSectionsPagerAdapter.addFragment(settingsFragment, settings);
    }

    public CountriesFragment getCountriesFragment() {
        return (CountriesFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.activity_main_tabs_container + ":" + 0);
    }

    public FavoriteFragment getFavoriteFragment() {
        return (FavoriteFragment) getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.activity_main_tabs_container + ":" + 1);
    }
}
