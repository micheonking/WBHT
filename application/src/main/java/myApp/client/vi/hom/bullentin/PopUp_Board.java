package myApp.client.vi.hom.bullentin;

import java.util.Date;

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
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.vi.hom.company.model.Hom02_BoardModel;
import myApp.client.vi.sys.Sys10_Lookup_MultiFile;

public class PopUp_Board extends Window implements Editor<Hom02_BoardModel>, InterfaceServiceCall {
	
	Hom02_BoardModel model = new Hom02_BoardModel();
	Sys10_Lookup_MultiFile fileForm = new Sys10_Lookup_MultiFile(null, "Y", 120);

	interface EditDriver extends SimpleBeanEditorDriver<Hom02_BoardModel, PopUp_Board> {
	}
	EditDriver editDriver = GWT.create(EditDriver.class);
	ContentPanel contentPanel  = new ContentPanel();
	
	private String	actionName;
	private Long	boardId;
	private boolean	admin;
	private String 	boardType;
	
	private String	winWidth  = "840";
	private String	winHeight = "700";
	private InterfaceCallbackResult callback;

	private	TextButton 	updateButton = new TextButton("저장");
	private	TextButton 	cancelButton = new TextButton("닫기");

	TextField	titleName = new TextField();
	DateField	settleDate = new DateField();
	HtmlEditor contents = new HtmlEditor();
	
	public void open (Long boardId, boolean admin, String boardType, InterfaceCallbackResult callback) {
		
		contentPanel.mask("Loading");
		
		this.boardId = boardId;
		this.admin = admin;
		this.boardType = boardType;
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
		if (admin) {
			//저장 버튼ADD
			updateButton.setWidth(50);
			updateButton.addSelectHandler(new SelectHandler() {
				@Override
				public void onSelect(SelectEvent event) {
					update();
				}
			});
			this.addButton(updateButton);
		}
		
		//닫기 버튼ADD
		cancelButton.setWidth(50);
		cancelButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				updateCount();
			}
		});
		this.addButton(cancelButton);
	}

	private ContentPanel getEditor() {
		
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setSize(winWidth, winHeight);
		
		HorizontalLayoutData labelLayout = new HorizontalLayoutData( 90, -1, new Margins(10,0,0,0));
		HorizontalLayoutData fieldLayout = new HorizontalLayoutData(700, -1, new Margins(0,0,0,0));
		HorizontalLayoutData dateLayout  = new HorizontalLayoutData(170, -1, new Margins(0,0,0,0));
		HorizontalLayoutData htmlLayout  = new HorizontalLayoutData(700, -1, new Margins(0,0,0,0));
		HorizontalLayoutData fileLayout  = new HorizontalLayoutData(700, -1, new Margins(0,0,0,0));

		//제목
		HorizontalLayoutContainer rowTitle = new HorizontalLayoutContainer();
		rowTitle.add(new LabelToolItem("제목 : "), labelLayout);
		rowTitle.add(titleName, fieldLayout);

		//작성일
		HorizontalLayoutContainer rowDate = new HorizontalLayoutContainer();
		rowDate.add(new LabelToolItem("작성일 : "), labelLayout);
		rowDate.add(settleDate, dateLayout);

		//내용
		HorizontalLayoutContainer rowContents = new HorizontalLayoutContainer();
		rowContents.add(new LabelToolItem("내용 : "), labelLayout);
		contents.setHeight(350);
		rowContents.add(contents, htmlLayout);

		//첨부파일
		HorizontalLayoutContainer rowFile = new HorizontalLayoutContainer();
		rowFile.add(new LabelToolItem("첨부파일 : "), labelLayout);
		FieldSet fileSet = new FieldSet();
		fileSet.setCollapsible(false);
		fileSet.add(fileForm);
		rowFile.add(fileSet, fileLayout);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(rowTitle	, new VerticalLayoutData(1,  35, new Margins(20, 0, 0, 0)));
		vlc.add(rowDate		, new VerticalLayoutData(1,  35, new Margins(22, 0, 0, 0)));
		vlc.add(rowContents	, new VerticalLayoutData(1, 350, new Margins(24, 0, 0, 0)));
		vlc.add(rowFile		, new VerticalLayoutData(1, 100, new Margins(20, 0, 0, 0)));

		contentPanel.setWidget(vlc);
		return contentPanel;
	}

	protected void retrieve() {
		actionName = "retrieve";
		if(this.boardId == null) {
			init();
		}
		else {
			if (!admin) {
				titleName.setReadOnly(true);
				settleDate.setReadOnly(true);
	//			contents.setEnabled(false);
				fileForm.changeViewLayout();
			}
			fileForm.retrieve(this.boardId);
	
			ServiceRequest request = new ServiceRequest("hom.Hom02_Board.selectById");
			request.putLongParam("boardId", this.boardId);
			
			ServiceCall service = new ServiceCall();
			service.execute(request, this);
		}
	}

	private void init() {
		Hom02_BoardModel tmpModel = new Hom02_BoardModel();
		tmpModel.setTypeCode(boardType);
		tmpModel.setSettleDate(new Date());
		tmpModel.setWriter("ADMIN");
		editDriver.edit(tmpModel);
		contentPanel.unmask();
	}

	protected void updateCount() {
		//조회수 +1
		actionName = "updateCount";
		ServiceRequest request = new ServiceRequest("hom.Hom02_Board.updateCnt");
		request.putModelParam("boardModel", editDriver.flush());
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	protected void update() {
		actionName = "update";
		model = editDriver.flush();
		ServiceRequest request = new ServiceRequest("hom.Hom02_Board.insert");
		request.putModelParam("boardModel", model);
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if (actionName.equals("retrieve")) {
			model = (Hom02_BoardModel)result.getResult(0);
			editDriver.edit(model);
			contentPanel.unmask();
		}
		else if (actionName.equals("updateCount")) {
			callback.execute(this);
			hide();
		}
		else if (actionName.equals("update")) {
			if(result.getStatus() > 0) {
				callback.execute(this);
				hide();
			}
		}
	}
}
