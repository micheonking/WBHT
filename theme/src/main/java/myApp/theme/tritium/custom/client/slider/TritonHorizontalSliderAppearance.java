package myApp.theme.tritium.custom.client.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

import myApp.theme.tritium.client.base.slider.Css3HorizontalSliderAppearance;

public class TritonHorizontalSliderAppearance extends Css3HorizontalSliderAppearance {

  public interface TritonHorizontalSliderResources extends Css3HorizontalSliderResources {

    @Source({"myApp/theme/tritium/client/base/slider/Css3HorizontalSlider.gss",
            "TritonSlider.gss", "TritonHorizontalSlider.gss"})
    TritonHorizontalSliderStyle style();

    @ImageOptions(width = 20, height = 20)
    ImageResource sliderThumbHorizontal();
  }

  public interface TritonHorizontalSliderStyle extends Css3HorizontalSliderStyle {
  }

  public TritonHorizontalSliderAppearance() {
    this(GWT.<TritonHorizontalSliderResources> create(TritonHorizontalSliderResources.class));
  }

  public TritonHorizontalSliderAppearance(Css3HorizontalSliderResources resources) {
    super(resources);
  }
}
