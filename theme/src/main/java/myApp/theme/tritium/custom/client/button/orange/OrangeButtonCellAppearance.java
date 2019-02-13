package myApp.theme.tritium.custom.client.button.orange;

import com.google.gwt.core.client.GWT;

import myApp.theme.tritium.client.base.button.Css3ButtonCellAppearance;

public class OrangeButtonCellAppearance<M> extends Css3ButtonCellAppearance<M> {

	public interface OrangeCss3ButtonStyle extends Css3ButtonStyle {
	}

	public interface BlueCss3ButtonResources extends Css3ButtonResources {
		@Override
		@Source({ "myApp/theme/tritium/client/base/button/Css3ButtonCell.gss",
				"myApp/theme/tritium/client/base/button/Css3ButtonCellToolBar.gss", "OrangeButton.gss" })
		OrangeCss3ButtonStyle style();
	}

	public OrangeButtonCellAppearance() {
		super(GWT.<Css3ButtonResources>create(BlueCss3ButtonResources.class));
	}

}