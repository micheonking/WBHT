package myApp.client.vi.hom.bullentin;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.hom.company.model.Hom04_HistoryModel;
import myApp.client.vi.hom.company.model.Hom04_HistoryModelProperties;

public class AdminHistory extends VerticalLayoutContainer implements InterfaceGridOperate {

	private Grid<Hom04_HistoryModel> grid = this.buildGrid();

	public AdminHistory() {
		
		SearchBarBuilder searchBar = new SearchBarBuilder(this);

		searchBar.addRetrieveButton();
		searchBar.addInsertButton();
		this.add(searchBar.getSearchBar());

		grid.addRowClickHandler(new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				int rownum = event.getRowIndex();
				Long historyId = grid.getStore().get(rownum).getHistoryId();
				PopUp_History popUpHistory = new PopUp_History();
				popUpHistory.open(historyId, true, new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						retrieve();
					}
				});
			}
		});
		this.add(grid); 

		retrieve();
	}

	private Grid<Hom04_HistoryModel> buildGrid(){
		Hom04_HistoryModelProperties properties = GWT.create(Hom04_HistoryModelProperties.class);
		GridBuilder<Hom04_HistoryModel> gridBuilder = new GridBuilder<Hom04_HistoryModel>(properties.keyId());  
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.historyYm(), 200, "경력년도");
		gridBuilder.addText(properties.careerNote(), 200, "주요경력");

		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Hom04_HistoryModel> service = new GridRetrieveData<Hom04_HistoryModel>(grid.getStore());
		service.retrieve("hom.Hom04_History.selectByAll");
	}

	@Override
	public void update(){
	}
	
	@Override
	public void insertRow(){
		PopUp_History popUpHistory = new PopUp_History();
		popUpHistory.open(null, true,  new InterfaceCallbackResult() {
			@Override
			public void execute(Object result) {
				retrieve();
			}
		});
	}
	
	@Override
	public void deleteRow(){
	}
}