package myApp.client.vi.hom;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class StartPageFooter extends ContentPanel {

	public StartPageFooter() {

		this.setHeaderVisible(false);
//		this.setBodyStyle("backgroundColor:rgb(51, 51, 51); color:#aaaaaa"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조
//		this.setBodyStyle("backgroundColor:#ffffff; color:#000000; border-bottom:4px solid #ffc000;"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조
		this.setBodyStyle("backgroundColor:white; color:#dddddd; border-top:1px solid #ffc000;"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조

		// 홈페이지 하단 회사 주소 페이지
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();

		Label textHTML = new HTML(
//				"<center><font size='2' color=#aaaaaa><p style='background-color: rgb(51, 51, 51);'>본사 : 경기도 안양시 동안구 시민대로 167 안양벤처텔 1203호  Tel : 1588-3499 / 031-383-6054  Fax : 031-383-6013"
				"<center><font size='2' color=#666666><p style='background-color: white;'>본사 : 경기도 안양시 동안구 시민대로 167 안양벤처텔 1203호  Tel : 1588-3499 / 031-383-6054  Fax : 031-383-6013"
						+ " R&D 센터 : 경기도 고양시 덕양구 통일로 140 삼송테크노밸리 BB166호  Tel : 02-388-0701  Fax : 02-388-0706"
						+ "<br> Copyright ⓒ Wellbeing HEAT TECH. All Rights Reserved.</p></font></center>");// e-mail : master@wellbeingheattech.com | 개인정보취급방침</p></font></center>");

		vlc.add(textHTML, new VerticalLayoutData(1, -1, new Margins(5, 0, 5, 0)));

		this.add(vlc);
	}
}