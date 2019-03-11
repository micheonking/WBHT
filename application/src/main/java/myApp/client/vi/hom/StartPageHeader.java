package myApp.client.vi.hom;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.LoginPage;
import myApp.theme.tritium.custom.client.button.orange.OrangeButtonCellAppearance;
import myApp.theme.tritium.custom.client.button.white.WhiteButtonCellAppearance;

public class StartPageHeader extends BorderLayoutContainer {

	Viewport viewport = new Viewport();

	public StartPageHeader(StartPage startPage) {

		VBoxLayoutContainer center = new VBoxLayoutContainer();
		center.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);

		HBoxLayoutContainer header = new HBoxLayoutContainer();
		header.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);

//		Image borderBox = new Image(ResourceIcon.INSTANCE.borderBox());
//		Image lineImage1 = new Image(ResourceIcon.INSTANCE.horizontalTitle());
//		Image lineImage2 = new Image(ResourceIcon.INSTANCE.horizontalTitle());
//		Image lineImage3 = new Image(ResourceIcon.INSTANCE.horizontalTitle());

		// 홈페이지 상단 회사로고 style='border-bottom: 5px solid orange;' 
		SafeHtml logoHtml = SafeHtmlUtils.fromTrustedString("<left><div><img src='img/_WBHTLogo1.png' width='138' height='50'></img></div>");
		
	    TextButton logoButton = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
//		logoButton.setIconAlign(IconAlign.TOP);
//		logoButton.setIcon(ResourceIcon.INSTANCE.getLogo());
		logoButton.setSize("151", "58");
		logoButton.setHTML(logoHtml);
		logoButton.setBorders(false);
//		logoButton.setLayoutData(new BoxLayoutData(new Margins(1, 1, 1, 1)));
//		logoButton.getElement().getMargins(Side.LEFT);
		logoButton.getElement().setMargins(new Margins(0, 0, 0, 0));
		logoButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
//				startPage.openTabPage(startPage.tabPanel, "");
//				int xPosition = logoButton.getAbsoluteLeft();
				startPage.changePage("0");
			}
		});
		header.add(logoButton, new BoxLayoutData(new Margins(3, 1, 5, 1)));
		
		SafeHtml safeLabelHtml = SafeHtmlUtils.fromTrustedString(
					"<div style='background-color: transparent; line-height:1.3em;'>"
				+	"<font color='#606060' style='font-family:NamumGothic; font-size:1.2em;font-weight:bold'>"
				+	"<span style='color:#c00000;'>탄소발열섬유 전문기업</span>"
				+	"<br>"
				+	"주식회사 웰빙히트텍"
				+	"</font></div>");
		LabelToolItem labelToolItem = new LabelToolItem(safeLabelHtml);
		header.add(labelToolItem, new BoxLayoutData(new Margins(20, 220, 5, 1)));
		
		// 버튼생성
		SafeHtml button1Html = SafeHtmlUtils.fromTrustedString(
				"<div style='background-color: transparent;'><font color='#606060' style='font-family:NamumGothic; font-size:1.2em;font-weight:bold'>회사소개</font></div>");
		SafeHtml button2Html = SafeHtmlUtils.fromTrustedString(
				"<div style='background-color: transparent;'><font color='#606060' style='font-family:NamumGothic; font-size:1.2em;font-weight:bold'>제    품</font></div>");
		SafeHtml button3Html = SafeHtmlUtils.fromTrustedString(
				"<div style='background-color: transparent;'><font color='#606060' style='font-family:NamumGothic; font-size:1.2em;font-weight:bold'>기    술</font></div>");
		SafeHtml button4Html = SafeHtmlUtils.fromTrustedString(
				"<div style='background-color: transparent;'><font color='#606060' style='font-family:NamumGothic; font-size:1.2em;font-weight:bold'>공지사항</font></div>");

		BoxLayoutData boxLayoutData = new BoxLayoutData(new Margins(20, 35, 0, 0));
		BoxLayoutData boxLayoutData1 = new BoxLayoutData(new Margins(30, 25, 0, 0));

		// WhiteButton
	    TextButton textButton1 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
	    TextButton textButton2 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
	    TextButton textButton3 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
	    TextButton textButton4 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));

		textButton1.setHTML(button1Html);
		textButton1.setSize(StartPage.WBTN_WIDTH, StartPage.WBTN_HEIGHT);
//		textButton1.setBorders(true);
//		textButton1.getElement().getStyle().setProperty("color", "#606060"); // font color 변경
//		textButton1.getElement().getStyle().setProperty("fontWeight", "bold"); // font color 변경
//		textButton1.getElement().getStyle().setProperty("fontSize", "16px"); // font color 변경
		header.add(textButton1, boxLayoutData);
//		header.add(lineImage1, boxLayoutData1);
		textButton1.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				startPage.changePage("1");
			}
		});
		textButton2.setHTML(button2Html);
		textButton2.setSize(StartPage.WBTN_WIDTH, StartPage.WBTN_HEIGHT);
//		textButton2.setBorders(true);
		header.add(textButton2, boxLayoutData);
//		header.add(lineImage2, boxLayoutData1);
		textButton2.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				startPage.changePage("2");
			}
		});
		textButton3.setHTML(button3Html);
		textButton3.setSize(StartPage.WBTN_WIDTH, StartPage.WBTN_HEIGHT);
//		textButton3.setBorders(true);
		header.add(textButton3, boxLayoutData);
//		header.add(lineImage3, boxLayoutData1);
		textButton3.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				startPage.changePage("3");
			}
		});
		textButton4.setHTML(button4Html);
		textButton4.setSize(StartPage.WBTN_WIDTH, StartPage.WBTN_HEIGHT);
//		textButton4.setBorders(true);
		header.add(textButton4, boxLayoutData);
		textButton4.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
//				StartPage.newsPage = 1;
				startPage.changePage("4");
			}
		});


		center.add(header);
//		center.add(borderBox, new BoxLayoutData(new Margins(0, 0, 0, 0)));
		
		ContentPanel cp = new ContentPanel();
		cp.setBodyStyle("backgroundColor:#ffffff; color:#000000; border-bottom:4px solid #ffc000;"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조

		cp.add(center);
		
		cp.forceLayout();
		cp.setHeaderVisible(false);
//		cp.setBorders(true);
//		cp.setHeight(70);
		cp.getButtonBar().setHeight(0);
		
		this.add(cp);
	}
}