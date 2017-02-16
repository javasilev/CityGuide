package com.javasilev.cityguide.adapters.viewholders;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.base.BaseViewHolder;
import com.javasilev.cityguide.models.FavoriteCity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class FavoriteCityViewHolder extends BaseViewHolder<FavoriteCity> {

    @BindView(R.id.item_city_viewholder_image_view_icon)
    ImageView mIconImageView;

    @BindView(R.id.item_city_viewholder_text_view_name)
    TextView mNameTextView;

    @BindView(R.id.item_city_viewholder_button_action)
    ImageButton mActionImageButton;

    @Override
    public void bind(FavoriteCity favoriteCity) {
        mNameTextView.setText(favoriteCity.getName());
        mActionImageButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_clear_black_24dp));
        Picasso.with(mContext)
                .load(R.mipmap.ic_city)
                .into(mIconImageView);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        mActionImageButton.setOnClickListener(listener);
    }
}
