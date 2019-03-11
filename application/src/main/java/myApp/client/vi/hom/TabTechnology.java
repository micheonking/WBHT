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
import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.hom.technology.Certification;
import myApp.client.vi.hom.technology.Core;
import myApp.client.vi.hom.technology.Patent;
import myApp.theme.tritium.custom.client.button.white.WhiteButtonCellAppearance;

public class TabTechnology extends ContentPanel {

	private Core tabCore  = new Core();
	private Patent tabPatent  = new Patent();
	private Certification tabCertification  = new Certification();
	
	ContentPanel contentPanel  = new ContentPanel();

	public TabTechnology() {
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
		Margins buttonMargins = new Margins(1, 3, 1, 3);

		Image lineImage0 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage1 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage2 = new Image(ResourceIcon.INSTANCE.verticalBar());
		Image lineImage3 = new Image(ResourceIcon.INSTANCE.verticalBar());

		menuVBox.add(StartPage.getLabelToolItem("기술"));

		menuVBox.add(lineImage0, new BoxLayoutData(new Margins(20, 0, 0, 0)));
		SafeHtml button1Html = SafeHtmlUtils.fromTrustedString("<div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ핵심기술　　　　　　</font></div> ");
		SafeHtml button2Html = SafeHtmlUtils.fromTrustedString("<div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ특허·지적재산권　　　</font></div> ");
		SafeHtml button3Html = SafeHtmlUtils.fromTrustedString("<div style='background-color: transparent;'><font color='#606060' style='font-size:14px;'>ㆍ기술·제품인증　　　　</font></div> ");

		TextButton menuButton1 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
		TextButton menuButton2 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));
		TextButton menuButton3 = new TextButton(new TextButtonCell(new WhiteButtonCellAppearance<>()));

//		CellButtonBase menuButton1 = new CellButtonBase<>();
		menuButton1.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton1.setHTML(button1Html);
//		menuButton1.setBorders(true);
		menuButton1.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getCore();
			}
		});
		menuVBox.add(menuButton1, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage1, new BoxLayoutData(lineImageMargins));

//		CellButtonBase menuButton2 = new CellButtonBase<>();
		menuButton2.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton2.setHTML(button2Html);
//		menuButton2.setBorders(true);
		menuButton2.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getPatent();
			}
		});
		menuVBox.add(menuButton2, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage2, new BoxLayoutData(lineImageMargins));

//		CellButtonBase menuButton3 = new CellButtonBase<>();
		menuButton3.setSize(StartPage.BTN_WIDTH, StartPage.BTN_HEIGHT);
		menuButton3.setHTML(button3Html);
//		menuButton3.setBorders(true);
		menuButton3.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				getCertification();
			}
		});
		menuVBox.add(menuButton3, new BoxLayoutData(buttonMargins));
		menuVBox.add(lineImage3, new BoxLayoutData(lineImageMargins));

//		menuVBox.setWidth(StartPage.MENU_WIDTH);
//		menuVBox.setHeight(StartPage.CON_HEIGHT);
		menuHBar.add(menuVBox, boxLayoutData);

		totalHBar.add(menuHBar);

		switch (StartPage.page) {
		case 1 :
			totalHBar.add(getCore());
			break;
		case 2 :
			totalHBar.add(getPatent());
			break;
		case 3 :
			totalHBar.add(getCertification());
			break;
		default :
			totalHBar.add(getCore());
			break;
		}
//		totalHBar.add(getCore());
		centerVBox.add(totalHBar);

		headerVBox.add(centerVBox);
		this.add(headerVBox);

	}

	private ContentPanel getCore() {

		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabCore);

		return contentPanel;
	}

	private ContentPanel getPatent() {
		
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabPatent);

		return contentPanel;
	}

	private ContentPanel getCertification() {
		
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setWidth(StartPage.CON_WIDTH);
		contentPanel.setHeight(Window.getClientHeight() - StartPage.NOTE_HEIGHT);
		contentPanel.setWidget(tabCertification);

		return contentPanel;
	}

}
