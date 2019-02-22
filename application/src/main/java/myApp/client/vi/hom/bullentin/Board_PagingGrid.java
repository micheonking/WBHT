package myApp.client.vi.hom.bullentin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.BeforeLoadEvent;
import com.sencha.gxt.data.shared.loader.BeforeLoadEvent.BeforeLoadHandler;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;

import myApp.client.resource.ResourceIcon;
import myApp.client.service.GridPageService;
import myApp.client.service.GridPageServiceAsync;
import myApp.client.service.GridPagingConfirmableLoader;
import myApp.client.service.GridRetrieveData;
import myApp.client.vi.hom.StartPage;
import myApp.client.vi.hom.company.model.Hom02_BoardModel;
import myApp.client.vi.hom.company.model.Hom02_BoardModelProperties;

public class Board_PagingGrid extends ContentPanel {
	
	TextField searchText = new TextField();
	TextButton searchButton = new TextButton();
	Grid<Hom02_BoardModel> grid;
	private Long setRow = (long)10;
	
	public Board_PagingGrid() {

		this.setHeaderVisible(false);
		searchButton.setText("검색");
		searchButton.setIcon(ResourceIcon.INSTANCE.search16Button());
		searchButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
//				retrieve();
			}
		});
		
		searchText.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == 13) { // enter key event
//                    retrieve();
                }				
			}
        });
		searchText.setWidth(400);
		
		HBoxLayoutContainer hblc = new HBoxLayoutContainer();
		hblc.add(searchText, new BoxLayoutData(new Margins(0,5,0,0)));
		hblc.add(searchButton, new BoxLayoutData(new Margins(0,0,0,0)));
		
		VBoxLayoutContainer gridVBox = new VBoxLayoutContainer();
		gridVBox.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);

		Margins getTextMargins = new Margins(0, 0, 15, 0);
//		Margins totalHBarMargins = new Margins(20, 0, 5, 30);
		Margins lineBar0Margins = new Margins(10, 0, 20, 30);

		Image lineBar0 = new Image(ResourceIcon.INSTANCE.verticalTitle());
		
		gridVBox.add(StartPage.getTextContents("게시판"),new BoxLayoutData(getTextMargins));
		gridVBox.add(lineBar0,new BoxLayoutData(lineBar0Margins));
		gridVBox.add(hblc, new BoxLayoutData(new Margins(0,20,0,277)));
		gridVBox.add(pagingGrid(),new BoxLayoutData(new Margins(5,0,0,30)));
		
		this.add(gridVBox);
//		retrieve();
	}

	private Widget pagingGrid() {
		
		final GridPageServiceAsync service = GWT.create(GridPageService.class);
		
		RpcProxy<PagingLoadConfig, PagingLoadResult<Hom02_BoardModel>> rpxProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<Hom02_BoardModel>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<Hom02_BoardModel>> callback) {
				loadConfig.setLimit(10);
				loadConfig.setOffset(0);
				service.getData(loadConfig, callback);
			}
		};

		Hom02_BoardModelProperties properties = GWT.create(Hom02_BoardModelProperties.class);
		
		ListStore<Hom02_BoardModel> list = new ListStore<Hom02_BoardModel>(new ModelKeyProvider<Hom02_BoardModel>() {
			@Override
			public String getKey(Hom02_BoardModel item) {
				return "" + item.getKeyId();
			}
		});

		final GridPagingConfirmableLoader loader = new GridPagingConfirmableLoader(rpxProxy);
		loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, Hom02_BoardModel, PagingLoadResult<Hom02_BoardModel>>(list));
		loader.addBeforeLoadHandler(new BeforeLoadHandler<PagingLoadConfig>() {
			boolean initalLoad = true;
			@Override
			public void onBeforeLoad(BeforeLoadEvent<PagingLoadConfig> event) {
				if (!initalLoad) {
					event.setCancelled(true);
					loader.loadData(loader.getLastLoadConfig());
				}
				initalLoad = false;
			}
		});
		
		IdentityValueProvider<Hom02_BoardModel> identity = new IdentityValueProvider<Hom02_BoardModel>();
		CheckBoxSelectionModel<Hom02_BoardModel> selectionModel = new CheckBoxSelectionModel<Hom02_BoardModel>(identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				// this code selects all rows when paging if the header checkbox is selected
				if (isSelectAllChecked()) {
					selectAll();
				}
				super.onRefresh(event);
		    }
		};
		
		ColumnConfig<Hom02_BoardModel, String> titleName  = new ColumnConfig<Hom02_BoardModel, String>(properties.titleName() , 100, "제목");
		ColumnConfig<Hom02_BoardModel, Date  > settleDate = new ColumnConfig<Hom02_BoardModel, Date  >(properties.settleDate(), 100, "작성일");
		ColumnConfig<Hom02_BoardModel, Long  > cnt        = new ColumnConfig<Hom02_BoardModel, Long  >(properties.cnt()       , 100, "조회수");
		
		settleDate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
//		settleDate.setCell(new DateCell(DateTimeFormat.getFormat("yyyy-MM-dd")));
		
		settleDate.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		cnt.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER );
		
		List<ColumnConfig<Hom02_BoardModel, ?>> columns = new ArrayList<ColumnConfig<Hom02_BoardModel,?>>();
		columns.add(selectionModel.getColumn());
		columns.add(titleName);
		columns.add(settleDate);
		columns.add(cnt);
		
		ColumnModel<Hom02_BoardModel> cm = new ColumnModel<Hom02_BoardModel>(columns);
		
		grid = new Grid<Hom02_BoardModel>(list, cm) {
	        @Override
	        protected void onAfterFirstAttach() {
	        	super.onAfterFirstAttach();
	        	Scheduler.get().scheduleDeferred(new ScheduledCommand() {
	        		@Override
	        		public void execute() {
	        			loader.load();
	        		}
	        	});
	        }
		};
		
		grid.setSelectionModel(selectionModel);
		grid.getView().setAutoExpandColumn(titleName);
		grid.setLoadMask(true);
		grid.setLoader(loader);
		grid.setColumnReordering(true);

		StartPage.CURRENTHEIGHT = Window.getClientHeight() - StartPage.SNOTE_HEIGHT - 80;
		if(StartPage.CURRENTHEIGHT > 360) {
			grid.setHeight(360);
		} else {
			grid.setHeight(StartPage.CURRENTHEIGHT);
		}

		PagingToolBar toolBar = new PagingToolBar(10);
		toolBar.setBorders(false);
		toolBar.bind(loader);
		
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(grid   , new VerticalLayoutData(1,1));
		vlc.add(toolBar, new VerticalLayoutData(1,-1));
		
		ContentPanel panel = new ContentPanel();
	    panel.add(vlc);
	    panel.setHeaderVisible(false);
	    return panel;
	}

	public void retrieve() {
		GridRetrieveData<Hom02_BoardModel> service = new GridRetrieveData<Hom02_BoardModel>(grid.getStore());
//		Hom02_BoardModel boardModel = new Hom02_BoardModel();
//		service.addParam("boardId",boardModel.getBoardId());
//		service.addParam("typeCode", "notice");
//		service.addParam("setCount", setRow);
//		service.addParam("startRowNum", (long)0);
		service.addParam("titleName",searchText.getText());
		service.retrieve("hom.Hom02_Board.selectByTypeCode");
	}
}
