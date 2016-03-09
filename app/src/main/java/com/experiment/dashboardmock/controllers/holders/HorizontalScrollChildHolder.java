package com.experiment.dashboardmock.controllers.holders;

import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.model.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by Infernus on 09/03/16.
 */
public class HorizontalScrollChildHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView discountLabel;
    private TextView nameLabel;
    private TextView priceLabel;
    private TextView originalPriceLabel;

    public HorizontalScrollChildHolder(View itemView) {
        super(itemView);

        // Bind view references to relevant views
        imageView          = (ImageView) itemView.findViewById(R.id.horizontal_scroll_child_image);
        discountLabel      = (TextView)  itemView.findViewById(R.id.horizontal_scroll_child_discount_label);
        nameLabel          = (TextView)  itemView.findViewById(R.id.horizontal_scroll_child_name);
        priceLabel         = (TextView)  itemView.findViewById(R.id.horizontal_scroll_child_price);
        originalPriceLabel = (TextView)  itemView.findViewById(R.id.horizontal_scroll_child_original_price);
    }

    public void setupForItem(Item item) {
        imageView.setImageResource(R.drawable.placeholder);
        Picasso.with(imageView.getContext()).load(item.getImageUrl()).into(imageView);

        nameLabel.setText(item.getLabel());

        // Considering that original price will be dynamic over items, the strike-through
        // should refresh with change in text. For the current hard-coded text, the following
        // code could have been in constructor only.
        String originalPrice = "Rs xxxx";
        originalPriceLabel.setText(originalPrice, TextView.BufferType.SPANNABLE);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        Spannable spannable = (Spannable) originalPriceLabel.getText();
        spannable.setSpan(strikethroughSpan, 0, originalPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}
