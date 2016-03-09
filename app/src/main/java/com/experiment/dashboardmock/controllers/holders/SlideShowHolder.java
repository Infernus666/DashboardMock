package com.experiment.dashboardmock.controllers.holders;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.experiment.dashboardmock.R;
import com.experiment.dashboardmock.model.Element;
import com.experiment.dashboardmock.model.Item;
import com.experiment.dashboardmock.utils.DimensionStore;

/**
 * Created by Infernus on 08/03/16.
 */
public class SlideShowHolder extends BaseHolder {
    private SliderLayout slider;

    public SlideShowHolder(View itemView) {
        super(itemView);
        slider = (SliderLayout) itemView.findViewById(R.id.slide_show_view);

        // Setting height of slideshow view to 2/3rd of screen width.
        // This is assuming that this image is going to be of 3:2 aspect
        // ratio.
        ViewGroup.LayoutParams params = slider.getLayoutParams();
        params.height = (int) ((float) DimensionStore.getScreenDimension().getWidth() *  2.0f/3.0f);
        slider.setLayoutParams(params);
    }

    @Override
    public void setupForElement(final Element element) {
        // Clear and fill SliderLayout with new slides created from items
        // in the element.
        slider.removeAllSliders();
        for(final Item item : element.getItems()) {
            slider.addSlider(new DefaultSliderView(slider.getContext()).image(item.getImageUrl()).setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getWebUrl()));
                    slider.getContext().startActivity(browserIntent);
                }
            }));
        }

        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);

        // Restore page position using stateInfo.
        slider.setCurrentPosition(element.getStateInfo());

        // Record Page position as stateInfo whenever page changes.
        slider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                element.setStateInfo(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
