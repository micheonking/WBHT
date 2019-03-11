package myApp.client.vi.hom.bullentin;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.StringComboBox;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.grid.SearchBarBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.hom.company.model.Hom02_BoardModel;
import myApp.client.vi.hom.company.model.Hom02_BoardModelProperties;

public class AdminBoard extends VerticalLayoutContainer implements InterfaceGridOperate {

	private Grid<Hom02_BoardModel> grid = this.buildGrid();
	private StringComboBox boardTypeCombo= new StringComboBox();
	private String boardType = "notice";

	public AdminBoard() {
		
		SearchBarBuilder searchBar = new SearchBarBuilder(this);

		boardTypeCombo.getStore().add("게시판");
		boardTypeCombo.getStore().add("홍보자료");
		boardTypeCombo.setTriggerAction(TriggerAction.ALL);
		boardTypeCombo.setText("게시판");
		boardTypeCombo.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				StringComboBox combo = (StringComboBox) event.getSource();
				if (boardTypeCombo.getText().equals("게시판")) {
					boardType = "notice";
				} else {
					boardType = "release";
				}
				retrieve();
			}
		});
		FieldLabel boardTypeField = new FieldLabel(boardTypeCombo, "▶ 구 분 ");
		boardTypeField.setLabelWidth(70);
		boardTypeField.setWidth(250);

		searchBar.getSearchBar().add(boardTypeField);
		searchBar.addRetrieveButton();
		searchBar.addInsertButton();
		this.add(searchBar.getSearchBar());

		grid.addRowClickHandler(new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				int rownum = event.getRowIndex();
				Long boardId = grid.getStore().get(rownum).getBoardId();
				PopUp_Board popUpBoard = new PopUp_Board();
				popUpBoard.open(boardId, true, boardType, new InterfaceCallbackResult() {
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

	private Grid<Hom02_BoardModel> buildGrid(){
		Hom02_BoardModelProperties properties = GWT.create(Hom02_BoardModelProperties.class);
		GridBuilder<Hom02_BoardModel> gridBuilder = new GridBuilder<Hom02_BoardModel>(properties.keyId());  

		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addLong(properties.boardId(), 70, "ID");
		gridBuilder.addText(properties.titleName(), 300, "제목");
		gridBuilder.addDate(properties.settleDate(), 100, "작성일");
		gridBuilder.addLong(properties.cnt(), 70, "조회수");

		return gridBuilder.getGrid(); 
	}

	@Override
	public void retrieve() {
//		String boardType;
//		if (boardTypeCombo.getText().equals("게시판")) {
//			boardType = "notice";
//		} else {
//			boardType = "release";
//		}

		GridRetrieveData<Hom02_BoardModel> service = new GridRetrieveData<Hom02_BoardModel>(grid.getStore());
		service.addParam("typeCode", boardType);
		service.addParam("setCount", (long)0);
		service.retrieve("hom.Hom02_Board.selectByTypeCode");
	}

	@Override
	public void update(){
	}
	
	@Override
	public void insertRow(){
		PopUp_Board popUpBoard = new PopUp_Board();
		popUpBoard.open(null, true, boardType, new InterfaceCallbackResult() {
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