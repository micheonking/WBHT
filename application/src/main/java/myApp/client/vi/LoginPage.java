package myApp.client.vi;

import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.hom.StartPage;
import myApp.client.vi.sys.Sys00_Admin;
import myApp.client.vi.sys.model.Sys02_UserModel;

import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.form.TextField;
 
public class LoginPage implements InterfaceServiceCall {
	
	private TextField firstName = new TextField();
    private CenterLayoutContainer container = new CenterLayoutContainer();
    private Viewport viewport = new Viewport();

    private String companyCode = ""; 

    public LoginPage(String url){

    	this.companyCode = url; 
		this.companyCode = this.companyCode.replaceAll("http://", ""); 
		this.companyCode = this.companyCode.replaceAll("https://", "");
		this.companyCode = this.companyCode.substring(0, companyCode.indexOf(".")); 
//		Info.display("companyCode = "+ this.companyCode, url);
    }
	
	public void open() {
		firstName.setText(this.companyCode);

		// admin id & pw 관리필요. 
		if("admin".equals(firstName.getText())) {
			// 바로 관리자 화면을 오픈한다.
			this.viewport.remove(container);
			viewport.add(new Sys00_Admin(), new MarginData(0, 0, 0, 0));
			RootPanel.get().add(viewport);
			return;
		} 
		else {
//			ServiceRequest request = new ServiceRequest("sys.Sys02_User.getLoginAdminInfo");
//			request.putLongParam  ("companyId", (long)2062721);	//2000940:한국펀드서비스
//			request.putStringParam("otpNumber", "1111");//otpNumber.getValue());
//			ServiceCall service = new ServiceCall(); 
//			service.execute(request, this);
			this.viewport.remove(container);
			viewport.add(new StartPage(), new MarginData(0, 0, 0, 0));
			
			RootPanel.get().add(viewport);
		}
	}
	
	@Override
	public void getServiceResult(ServiceResult result) {
		
		if(result.getStatus() == 10 ) { // 일반사용자 접속
			// get userModel
			this.viewport.remove(container);
			viewport.add(new StartPage(), new MarginData(0, 0, 0, 0));
			
			RootPanel.get().add(viewport);
		}
		else if(result.getStatus() == 20) { // 회사관리자 접속
			// get userModel
			Sys02_UserModel userModel = (Sys02_UserModel) result.getResult(0); 
			LoginUser.setUserModel(userModel); 
		}
		else { // 로그인 정보를 찾을 수 없다.  
			new SimpleMessage("로그인 정보 확인", result.getMessage());
			return ; 
		}
		
	}
	
}

