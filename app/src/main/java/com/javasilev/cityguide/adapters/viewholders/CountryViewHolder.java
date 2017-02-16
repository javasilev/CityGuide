package com.javasilev.cityguide.adapters.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import com.javasilev.cityguide.R;
import com.javasilev.cityguide.adapters.base.BaseViewHolder;
import com.javasilev.cityguide.models.Country;
import com.javasilev.cityguide.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("WeakerAccess")
public class CountryViewHolder extends BaseViewHolder<Country> {

    @BindView(R.id.item_country_viewholder_text_view_name)
    TextView mNameTextView;

    @BindView(R.id.item_country_viewholder_image_view_icon)
    ImageView mIconImageView;

    @Override
    public void bind(Country country) {
        mNameTextView.setText(country.getName());
        Picasso.with(mContext)
//                .load(country.getImageLink())
                .load(getFlag(country.getId()))
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_dialog_alert)
                .transform(new CircleTransform())
                .into(mIconImageView);
    }

    private String getFlag(int id) {
        switch (id) {
            case 1:
                return "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/320px-Flag_of_Russia.svg.png";
            case 2:
                return "https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/320px-Flag_of_Germany.svg.png";
            case 3:
                return "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/320px-Flag_of_the_United_States.svg.png";
        }
        return "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/320px-Flag_of_Russia.svg.png";
    }
}
