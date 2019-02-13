package myApp.client.vi.hom;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.hom.company.Greetings;
import myApp.client.vi.hom.company.Outline;
import myApp.client.vi.hom.company.History;
import myApp.client.vi.hom.company.Organization;
import myApp.client.vi.hom.company.YourWay;
import myApp.client.vi.hom.company.YourWay2;
import myApp.theme.tritium.custom.client.button.whiteGrey.WhiteGreyButtonCellAppearance;

public class TabCompany extends ContentPanel {

	private Greetings tabGreetings  = new Greetings();
	private Outline tabOutline  = new Outline();
	private History tabHistory  = new History();
	private Organization tabOrganization  = new Organization();
	private YourWay tabYourWay  = new YourWay();
	private YourWay2 tabYourWay2  = new YourWay2();

	ContentPanel contentPanel  = new ContentPanel();

	public TabCompany() {
		this.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				resize();
			}
		});
		resize();
	}
	
	private void resize() {
		this.setHeaderVisible(false);
		this.setBorders(false);

		VBoxLayoutContainer headerVBox = new VBoxLayoutContainer();
		headerVBox.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);

		VBoxLayoutContainer centerVBox = new VBoxLayoutContainer();
		centerVBox.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);

		HBoxLayoutContainer totalHBar = new HBoxLayoutContainer();
		totalHBar.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);

		HBoxLayoutContainer menuHBar = new HBoxLayoutContainer();
		menuHBar.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);

		BoxLayoutData boxLayoutData = new BoxLayoutData();

		VBoxLayoutContainer menuVBox = new VBoxLayoutContainer();
		menuVBox.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);

		Margins lineImageMargins = new Margins(0, 0, 0, 0);
		Margins buttonMargins = new Margins(0, 0, 0, 0);
		
		Image lineImage0 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage1 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage2 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage3 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage4 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage5 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage6 = new Image(ResourceIcon.INSTANCE.verticalBar());

		SafeHtml button1Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍCEO 인사말　　　　　</font></div> ");
		SafeHtml button2Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ회사개요　　　　　　</font></div> ");
		SafeHtml button3Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ회사연혁　　　　　　</font></div> ");
		SafeHtml button4Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ조직도　　　　　　　</font></div> ");
		SafeHtml button5Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ본사약도　　　　　　</font></div> ");
		SafeHtml button6Html = SafeHtmlUtils.fromTrustedString("<left><div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍR&D 센터약도　　　　</font></div> ");

		TextButton menuButton1 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));
		TextButton menuButton2 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));
		TextButton menuButton3 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));
		TextButton menuButton4 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));
		TextButton menuButton5 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));
		TextButton menuButton6 = new TextButton(new TextButtonCell(new WhiteGreyButtonCellAppearance<>()));

		// 타이틀 넣기
		menuVBox.add(StartPage.getLabelToolItem("회사소개"));
		menuVBox.add(lineImage0, new BoxLayoutData(new Margins(20, 0, 0, 0)));

		menuButton1.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton1.setHTML(button1Html);
//		menuButton1.addStyleName(style);
//		menuButton1.setBorders(true);
		menuButton1.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getCeoGreeting();
			}
		});
		menuVBox.add(menuButton1, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage1, new BoxLayoutData(lineImageMargins));

		menuButton2.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton2.setHTML(button2Html);
//		menuButton2.setBorders(true);
		menuButton2.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getCompanyOpening();
			}
		});
		menuVBox.add(menuButton2, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage2, new BoxLayoutData(lineImageMargins));

		menuButton3.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton3.setHTML(button3Html);
//		menuButton3.setBorders(true);
		menuButton3.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getCompanyHistory();
			}
		});
		menuVBox.add(menuButton3, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage3, new BoxLayoutData(lineImageMargins));

		menuButton4.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton4.setHTML(button4Html);
//		menuButton4.setBorders(true);
		menuButton4.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getOrganizationChart();
			}
		});
		menuVBox.add(menuButton4, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage4, new BoxLayoutData(lineImageMargins));

		menuButton5.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton5.setHTML(button5Html);
//		menuButton5.setBorders(true);
		menuButton5.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getYourWay();
			}
		});
		menuVBox.add(menuButton5, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage5, new BoxLayoutData(lineImageMargins));

		menuButton6.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton6.setHTML(button6Html);
//		menuButton6.setBorders(true);
		menuButton6.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getYourWay2();
			}
		});
		menuVBox.add(menuButton6, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage6, new BoxLayoutData(lineImageMargins));

		menuHBar.add(menuVBox, boxLayoutData);
//		menuHBar.setBorders(true);

		totalHBar.add(menuHBar);
		switch (StartPage.CURRENTPAGE) {
		case "1" :
			totalHBar.add(getCeoGreeting());
			break;
		case "2" :
			totalHBar.add(getCompanyOpening());
			break;
		case "3" :
			totalHBar.add(getCompanyHistory());
			break;
		case "4" :
			totalHBar.add(getOrganizationChart());
			break;
		case "5" :
			totalHBar.add(getYourWay());
			break;
		default :
			totalHBar.add(getCeoGreeting());
			break;
		}
		centerVBox.add(totalHBar);
		headerVBox.add(centerVBox);
		this.add(headerVBox);
	}

	private ContentPanel getCeoGreeting() {

		StartPage.CURRENTPAGE = "1";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabGreetings);

		return contentPanel;
	}

	private ContentPanel getCompanyOpening() {

		StartPage.CURRENTPAGE = "2";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabOutline);

		return contentPanel;
	}
	
	private ContentPanel getCompanyHistory() {

		StartPage.CURRENTPAGE = "3";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabHistory);

		return contentPanel;
	}

	private ContentPanel getOrganizationChart() {

		StartPage.CURRENTPAGE = "4";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabOrganization);

		return contentPanel;
	}
	
	private ContentPanel getYourWay() {

		StartPage.CURRENTPAGE = "5";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabYourWay);

		return contentPanel;
	}
	
	private ContentPanel getYourWay2() {

		StartPage.CURRENTPAGE = "6";
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabYourWay2);

		return contentPanel;
	}
	
}