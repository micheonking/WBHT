package myApp.client.vi;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.info.Info;

public class MenuOpener {

	private Widget createTab(String className) {

		// 시스템 관리 - 시스템관리자용으로 변경하였음.
		// if("Sys01_Tab_Company.class".equals(className)) {
		// return (Widget) GWT.create(myApp.client.sys.Sys01_Tab_Company.class) ;
		// }

		if ("Sys02_Tab_User.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys02_Page_User.class);
		}

		if ("Sys04_Tab_Role.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys04_Tab_Role.class);
		}

		if ("Sys05_Tab_UserRole.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys05_Tab_EmpRole.class);
		}

		if ("Sys06_Tab_Menu.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys06_Tab_Menu.class);
		}

		if ("Sys07_Tab_RoleMenu.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys07_Tab_RoleMenu.class);
		}

		if ("Sys08_Tab_CodeKind".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys08_CodeKind.class);
		}

		if ("Sys12_Tab_Calendar.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys12_Tab_Calendar.class);
		}
		//개선사항 및 오류점검 처리내역
		if ("Sys90_Tab_AfterService.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys90_Tab_AfterService.class);
		}

		if ("Dbm01_Tab_TabComments".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.dbm.Dbm01_Tab_TabComments.class);
		}

		if("Tab_LicenseCode".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys21_Tab_LicenseCode.class) ;
		}

		if ("Tab_LicenseCode".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys21_Tab_LicenseCode.class);
		}

		if ("Bbs01_Tab_BoardManager.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.bbs.Bbs01_Tab_BoardManager.class);
		}
		if ("Bbs01_Tab_Board.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.bbs.Bbs01_Tab_Board.class);
		}

		// RD 테스트
		if ("Dbm01_RD_TabComments.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.dbm.Dbm01_RD_TabComments.class);
		}
		if ("Dbm99_Tab_RDTest.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.dbm.Dbm99_Tab_RDTest.class);
		}
		
		return null;
	}

	public void openTab(TabPanel tabPanel, String className, String pageName) {

		TabItemConfig tabItemConfig = new TabItemConfig(pageName, true);
		Widget tabPage = tabPanel.findItem(pageName, true);

		if (tabPage != null) {
			tabPanel.setActiveWidget(tabPage);
			return;
		}

		// not found tab page
		tabPage = createTab(className);

		if (tabPage != null) {
			tabPanel.add(tabPage, tabItemConfig);
			tabPanel.setActiveWidget(tabPage);
		} else {
			Info.display(pageName, "해당 오브젝트(" + className + ")가 시스템에 등록되어 있지 않습니다.");
		}
	}
}