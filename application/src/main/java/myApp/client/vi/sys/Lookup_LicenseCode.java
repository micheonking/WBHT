package myApp.client.vi.sys;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.AbstractLookupWindow;
import myApp.client.grid.GridBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.utils.InterfaceLookupResult;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.sys.model.Sys21_LicenseCodeModel;
import myApp.client.vi.sys.model.Sys21_LicenseCodeModelProperties;

public class Lookup_LicenseCode extends AbstractLookupWindow {

	private Sys21_LicenseCodeModelProperties properties = GWT.create(Sys21_LicenseCodeModelProperties.class);
	private Grid<Sys21_LicenseCodeModel> grid = this.buildGrid();
	private InterfaceLookupResult lookupParent ;
	private TextField licenseName = new TextField(); //조회조건 
	
	public Lookup_LicenseCode(InterfaceLookupResult lookupParent){

		this.lookupParent = lookupParent; 
		
		this.setInit("자격면허 코드찾기", 600, 500); 
		this.addLabel(licenseName, "자격면허명", 150, 50, true) ;

		VerticalLayoutContainer vlc = new VerticalLayoutContainer(); 
		vlc.add(this.getSearchBar(), new VerticalLayoutData(1, 40)); // , new Margins(0, 0, 0, 5)));
		vlc.add(grid, new VerticalLayoutData(1, 1));
		this.add(vlc);
		
		this.retrieve();
	}
	
	private Grid<Sys21_LicenseCodeModel> buildGrid(){
		GridBuilder<Sys21_LicenseCodeModel> gridBuilder = new GridBuilder<Sys21_LicenseCodeModel>(properties.keyId());
		gridBuilder.setChecked(SelectionMode.SINGLE);
		
		gridBuilder.addText(properties.licenseCode(), 120, "자격면허코드") ;
		gridBuilder.addText(properties.licenseName(), 300, "자격면허명") ;
		gridBuilder.addText(properties.issueOrgName(), 200, "발급기관명") ;
		gridBuilder.addDate(properties.applyDate(), 100, "적용일") ;
		gridBuilder.addBoolean(properties.closeYnFlag(), 100, "사용여부");
		gridBuilder.addText(properties.note(), 200, "비고" );
	
		return gridBuilder.getGrid(); 
	}
	
	public void returnLicenseCodeModel(){
	}
	
	@Override
	public void retrieve(){
		GridRetrieveData<Sys21_LicenseCodeModel> service = new GridRetrieveData<Sys21_LicenseCodeModel>(grid.getStore());
		service.addParam("licenseName", licenseName.getText());
		service.retrieve("sys.LicenseCode.selectByName");
	}


	@Override
	public void confirm() {
		Sys21_LicenseCodeModel licenseCodeModel = grid.getSelectionModel().getSelectedItem(); 
		if(licenseCodeModel != null){
			lookupParent.setLookupResult(licenseCodeModel);
			hide(); 
		}
		else {
			new SimpleMessage("선택된 자격증이 없습니다.");
		}
	}

	@Override
	public void cancel() {
	}
}
