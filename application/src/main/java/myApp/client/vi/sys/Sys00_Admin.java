package myApp.client.vi.sys;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;

import myApp.client.vi.hom.bullentin.AdminBoard;

public class Sys00_Admin extends ContentPanel {
	
	public Sys00_Admin() {

		this.setHeading("시스템 관리자");
		this.setBorders(true);
		SafeHtml button1Html = SafeHtmlUtils.fromTrustedString(
				"<div style='border: 1px solid white; padding: 15px; height: auto; '><font color='#ffffff' style='font-size:20px;font-weight:bold'>시스템 관리자</font></div>");

		this.setHeading(button1Html);
		TabPanel tabPanel = new TabPanel();

		AdminBoard tabAdmin = new AdminBoard();
		tabPanel.add(tabAdmin, "게시판관리");

		this.add(tabPanel, new MarginData(3));
	}
}