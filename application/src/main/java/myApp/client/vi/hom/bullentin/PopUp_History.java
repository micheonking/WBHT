package myApp.client.vi.hom.bullentin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.hom.company.model.Hom04_HistoryModel;

public class PopUp_History extends Window implements Editor<Hom04_HistoryModel>, InterfaceServiceCall {
	
	Hom04_HistoryModel model = new Hom04_HistoryModel();

	interface EditDriver extends SimpleBeanEditorDriver<Hom04_HistoryModel, PopUp_History> {
	}
	EditDriver editDriver = GWT.create(EditDriver.class);
	ContentPanel contentPanel  = new ContentPanel();
	
	private String	actionName;
	private Long	historyId;
	
	private String	winWidth  = "840";
	private String	winHeight = "500";
	private InterfaceCallbackResult callback;

	private	TextButton 	updateButton = new TextButton("저장");
	private	TextButton 	cancelButton = new TextButton("닫기");
	private	TextButton 	deleteButton = new TextButton("삭제");

	TextField	historyYm = new TextField();
	HtmlEditor careerNote = new HtmlEditor();
	
	public void open (Long historyId, boolean admin, InterfaceCallbackResult callback) {
		
		contentPanel.mask("Loading");
		this.historyId = historyId;
		this.callback = callback;
		this.setModal(true);
		this.setBorders(false);
		this.setResizable(false);
		this.setPixelSize(Integer.parseInt(winWidth), Integer.parseInt(winHeight));
		this.setHeaderVisible(false);

		editDriver.initialize(this);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(this.getEditor(), new VerticalLayoutData(1,1,new Margins(15,15,0,15)));
		this.add(vlc);
		this.setButton();
		this.setButtonAlign(BoxLayoutPack.CENTER);
		this.show();

		retrieve();
	}

	private void setButton() {
			//저장 버튼ADD
			updateButton.setWidth(50);
			updateButton.addSelectHandler(new SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					update();
				}
			});
			this.addButton(updateButton);
		
		//닫기 버튼ADD
		cancelButton.setWidth(50);
		cancelButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
//				updateCount();
				hide();
			}
		});
		this.addButton(cancelButton);
		
		deleteButton.setWidth(50);
		deleteButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				delete();
			}
		});
		this.addButton(deleteButton);
	}

	private ContentPanel getEditor() {
		
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setSize(winWidth, winHeight);
		
		HorizontalLayoutData labelLayout = new HorizontalLayoutData( 90, -1, new Margins(10,0,0,0));
		HorizontalLayoutData fieldLayout = new HorizontalLayoutData(700, -1, new Margins(0,0,0,0));
		HorizontalLayoutData htmlLayout  = new HorizontalLayoutData(700, -1, new Margins(0,0,0,0));

		//경력년도
		HorizontalLayoutContainer rowTitle = new HorizontalLayoutContainer();
		rowTitle.add(new LabelToolItem("경력년도 : "), labelLayout);
		rowTitle.add(historyYm, fieldLayout);


		//주요경력
		HorizontalLayoutContainer rowContents = new HorizontalLayoutContainer();
		rowContents.add(new LabelToolItem("주요경력 : "), labelLayout);
		careerNote.setHeight(350);
		rowContents.add(careerNote, htmlLayout);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(rowTitle	, new VerticalLayoutData(1,  35, new Margins(20, 0, 0, 0)));
		vlc.add(rowContents	, new VerticalLayoutData(1, 350, new Margins(24, 0, 0, 0)));

		contentPanel.setWidget(vlc);
		return contentPanel;
	}

	protected void update() {
		actionName = "update";
		model = editDriver.flush();
		ServiceRequest request = new ServiceRequest("hom.Hom04_History.insert");
		request.putModelParam("historyModel", model);
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}
	
	protected void delete() {
		actionName = "delete";
		model = editDriver.flush();
		ServiceRequest request = new ServiceRequest("hom.Hom04_History.deleteRow");
		request.putModelParam("historyModel", model);
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}
	
	protected void retrieve() {
		actionName = "retrieve";
		if(this.historyId == null) {
			init();
		}
		else {
			ServiceRequest request = new ServiceRequest("hom.Hom04_History.selectById");
			request.putLongParam("historyId", this.historyId);
			ServiceCall service = new ServiceCall();
			service.execute(request, this);
		}
	}
	
	private void init() {
		Hom04_HistoryModel historyModel = new Hom04_HistoryModel();
		historyModel.setCompanyId((long)2000940);
		editDriver.edit(historyModel);
		contentPanel.unmask();
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if (actionName.equals("retrieve")) {
			model = (Hom04_HistoryModel)result.getResult(0);
			editDriver.edit(model);
			contentPanel.unmask();
		}
		else if (actionName.equals("updateCount")) {
			callback.execute(this);
			hide();
		}
		else {
			if(result.getStatus() > 0) {
				callback.execute(this);
				hide();
			}
		}
	}
}
