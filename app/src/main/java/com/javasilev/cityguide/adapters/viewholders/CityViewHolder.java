package com.javasilev.cityguide.adapters.viewholders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.base.BaseViewHolder;
import com.javasilev.cityguide.models.City;
import com.javasilev.cityguide.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class CityViewHolder extends BaseViewHolder<City> {
    @BindView(R.id.item_city_viewholder_linear_layout_root)
    LinearLayout mRootLinearLayout;

    @BindView(R.id.item_city_viewholder_image_view_icon)
    ImageView mIconImageView;

    @BindView(R.id.item_city_viewholder_text_view_name)
    TextView mNameTextView;

    @BindView(R.id.item_city_viewholder_button_action)
    ImageButton mActionImageButton;

    private boolean mFavorite;

    @Override
    public void bind(City city) {
        mNameTextView.setText(city.getName());
        Picasso.with(mContext)
                .load(city.getImageLink())
                .transform(new CircleTransform())
                .error(android.R.drawable.ic_dialog_alert)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(mIconImageView);
        mActionImageButton.setFocusable(false);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mIconImageView.getLayoutParams();
        layoutParams.setMargins((int) mContext.getResources().getDimension(R.dimen.rich), 0, (int) mContext.getResources().getDimension(R.dimen.minor), 0);
        mIconImageView.setLayoutParams(layoutParams);
    }

    public void setDrawable(Drawable drawable) {
        mActionImageButton.setImageDrawable(drawable);
    }

    public void setButtonOnClickListener(View.OnClickListener listener) {
        mActionImageButton.setOnClickListener(listener);
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean favorite) {
        mFavorite = favorite;
    }
}
