package com.experiment.dashboardmock.controllers.holders;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.model.Element;
import com.experiment.dashboardmock.utils.DimensionStore;
import com.squareup.picasso.Picasso;

/**
 * Created by Infernus on 09/03/16.
 */
public class FullWidthImageHolder extends BaseHolder {

    private ImageView imageView;

    public FullWidthImageHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.full_width_image);

        // Setting height of banner image view to be half of screen width
        // This is assuming that this image is going to be of 2:1 aspect
        // ratio.
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.height = (int) ((float) DimensionStore.getScreenDimension().getWidth() / 2.0f);
        imageView.setLayoutParams(params);
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
