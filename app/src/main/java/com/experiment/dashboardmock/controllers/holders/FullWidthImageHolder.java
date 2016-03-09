package com.experiment.dashboardmock.controllers.holders;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.model.Element;
import com.squareup.picasso.Picasso;

/**
 * Created by Infernus on 09/03/16.
 */
public class FullWidthImageHolder extends BaseHolder {

    private ImageView imageView;

    public FullWidthImageHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.full_width_image);
    }

    @Override
    public void setupForElement(final Element element) {
        imageView.setImageResource(R.drawable.placeholder);
        if(element.getItems().size() > 0) {
            Picasso.with(imageView.getContext()).load(element.getItems().get(0).getImageUrl()).into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(element.getItems().get(0).getWebUrl()));
                    imageView.getContext().startActivity(browserIntent);
                }
            });
        }
    }
}
