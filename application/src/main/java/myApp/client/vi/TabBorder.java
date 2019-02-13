package myApp.client.vi;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;

public class TabBorder extends BorderLayoutContainer implements InterfaceGridOperate {
	
	public TabBorder() {

//		SearchBarBuilder searchbarBuilder = new SearchBarBuilder(this);
//		searchbarBuilder.addRetrieveButton();
		
//		BorderLayoutData northLayoutData = new BorderLayoutData();
//		northLayoutData.setSplit(false);
//		northLayoutData.setMargins(new Margins(0,0,2,0));
//		northLayoutData.setSize(50);
//		this.setNorthWidget(searchbarBuilder.getSearchBar(), northLayoutData);

		BorderLayoutData westLayoutData = new BorderLayoutData();
		westLayoutData.setSplit(true);
		westLayoutData.setMargins(new Margins(0,0,0,0));
		westLayoutData.setSize(950);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();

		BorderLayoutData centerLayoutData = new BorderLayoutData();
		centerLayoutData.setSplit(true);
		centerLayoutData.setMargins(new Margins(0));
		
		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.add(vlc);
		
		this.setCenterWidget(cp, centerLayoutData);
	}

	@Override
	public void retrieve() {
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertRow() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteRow() {
		// TODO Auto-generated method stub
	}
}