package myApp.client.vi.sys;

import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;

import myApp.client.vi.hom.bullentin.AdminBoard;

public class Sys00_Admin extends ContentPanel {
	
	public Sys00_Admin() {

		this.setHeading("시스템 관리자");
		this.setBorders(true);

		PlainTabPanel tabPanel = new PlainTabPanel();

		AdminBoard tabAdmin = new AdminBoard();
		tabPanel.add(tabAdmin, "게시판관리");

		this.add(tabPanel, new MarginData(3));
	}
}