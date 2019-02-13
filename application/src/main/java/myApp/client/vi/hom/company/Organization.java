package myApp.client.vi.hom.company;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.hom.StartPage;

public class Organization extends ContentPanel {
	
	SimpleHTMLTemplate htmlTemplate = GWT.create(SimpleHTMLTemplate.class);
	
	private String actionCode = "retrieve" ;
	private HtmlLayoutContainer htmlLayoutContainer ; 
	
	public interface SimpleHTMLTemplate extends XTemplates {
		@XTemplate(source="HTMLOrganization.html") 
		SafeHtml setParam(String actionCode);
	}
	
	public Organization() {
		this.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				resize();
			}
		});
		resize();
	}
	
	private void resize() {
//	public YourWay() {

		this.setHeaderVisible(false);

		VBoxLayoutContainer gridVBox = new VBoxLayoutContainer();
		gridVBox.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);

		Margins getTextMargins = new Margins(0, 0, 15, 0);
		Margins totalHBarMargins = new Margins(5, 0, 5, 30);
		Margins lineBar0Margins = new Margins(10, 0, 20, 30);

		Image lineBar0 = new Image(ResourceIcon.INSTANCE.verticalTitle());

		VBoxLayoutContainer rightVBox = new VBoxLayoutContainer();
		rightVBox.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);

		HBoxLayoutContainer totalHBar = new HBoxLayoutContainer();
		totalHBar.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);

		this.htmlLayoutContainer = new HtmlLayoutContainer(htmlTemplate.setParam(this.actionCode));

		htmlLayoutContainer.setWidth(StartPage.CURRENTWIDTH);
		StartPage.CURRENTHEIGHT = Window.getClientHeight() - StartPage.SNOTE_HEIGHT;
		htmlLayoutContainer.setHeight(StartPage.CURRENTHEIGHT);

		totalHBar.add(htmlLayoutContainer, new BoxLayoutData(totalHBarMargins));
		
		gridVBox.add(StartPage.getTextContents("조직도"), new BoxLayoutData(getTextMargins));
		gridVBox.add(lineBar0, new BoxLayoutData(lineBar0Margins));
		gridVBox.add(totalHBar, new BoxLayoutData(new Margins(1, 0, 1, 0)));

		this.add(gridVBox);

	}
}
