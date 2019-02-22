package myApp.client.vi.hom.bullentin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.GridBuilder;
import myApp.client.grid.InterfaceGridOperate;
import myApp.client.resource.ResourceIcon;
import myApp.client.service.GridRetrieveData;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.hom.StartPage;
import myApp.client.vi.hom.company.model.Hom02_BoardModel;
import myApp.client.vi.hom.company.model.Hom02_BoardModelProperties;

public class Board extends ContentPanel implements InterfaceGridOperate {

	TextField searchText = new TextField();
	TextButton searchButton = new TextButton();
	private Grid<Hom02_BoardModel> grid = this.buildGrid();

	public Board() {

		this.setHeaderVisible(false);
		searchButton.setText("검색");
		searchButton.setIcon(ResourceIcon.INSTANCE.search16Button());
		searchButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				retrieve();
			}
		});
		
		searchText.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == 13) { // enter key event
                    retrieve();
                }
			}
        });
		searchText.setWidth(250);
		
		HBoxLayoutContainer hblc = new HBoxLayoutContainer();
		hblc.add(searchText, new BoxLayoutData(new Margins(0,5,0,0)));
		hblc.add(searchButton, new BoxLayoutData(new Margins(0,0,0,0)));
		
		Image lineBar0 = new Image(ResourceIcon.INSTANCE.verticalTitle());

		VBoxLayoutContainer gridVBox = new VBoxLayoutContainer();
		gridVBox.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);

		Margins getTextMargins = new Margins(0, 0, 15, 0);
		Margins lineBar0Margins = new Margins(10, 0, 20, 30);

		gridVBox.add(StartPage.getTextContents("게시판"),new BoxLayoutData(getTextMargins));
		gridVBox.add(lineBar0,new BoxLayoutData(lineBar0Margins));
		gridVBox.add(hblc, new BoxLayoutData(new Margins(0,20,0,435)));
		gridVBox.add(makeBoard(),new BoxLayoutData(new Margins(5,0,0,30)));
		
		this.add(gridVBox);
		retrieve();
	}

	private IsWidget makeBoard() {

		StartPage.CURRENTHEIGHT = Window.getClientHeight() - StartPage.SNOTE_HEIGHT - 50;

		grid.addRowClickHandler(new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				int rownum = event.getRowIndex();
				Long boardId = grid.getStore().get(rownum).getBoardId();
				PopUp_Board popUpBoard = new PopUp_Board();
				popUpBoard.open(boardId, false, "notice", new InterfaceCallbackResult() {
					@Override
					public void execute(Object result) {
						retrieve();
					}
				});
			}
		});

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(grid, new VerticalLayoutData(730, StartPage.CURRENTHEIGHT));
		return vlc;
	}

	private Grid<Hom02_BoardModel> buildGrid() {

		Hom02_BoardModelProperties properties = GWT.create(Hom02_BoardModelProperties.class);
		GridBuilder<Hom02_BoardModel> gridBuilder = new GridBuilder<Hom02_BoardModel>(properties.keyId());

//		gridBuilder.setRowNumHidden(true);
//		gridBuilder.addLong(properties.boardId(), 50, "번호");
		gridBuilder.addText(properties.titleName(), 480, "제목");
		gridBuilder.addDate(properties.settleDate(), 100, "작성일");
		gridBuilder.addLong(properties.cnt(), 90, "조회수");
		
		return gridBuilder.getGrid();
	}

	@Override
	public void retrieve() {
		GridRetrieveData<Hom02_BoardModel> service = new GridRetrieveData<Hom02_BoardModel>(grid.getStore());
		Hom02_BoardModel boardModel = new Hom02_BoardModel();
		service.addParam("boardId",boardModel.getBoardId());
		service.addParam("typeCode", "notice");
		service.addParam("setCount", (long)0);
//		service.addParam("startRowNum", (long)0);
		service.addParam("searchText", searchText.getText());
		service.retrieve("hom.Hom02_Board.selectByTypeCode");
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
