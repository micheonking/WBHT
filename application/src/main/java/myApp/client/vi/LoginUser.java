package myApp.client.vi;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;

import myApp.client.vi.sys.model.Sys02_UserModel;

public class LoginUser {

	// isAdmin -- 전체 시스템 관리자 
	// isManager -- 회사에 속한 관리자   
	
	public static Sys02_UserModel userModel = new Sys02_UserModel(); // admin user 

	public static Boolean isAdmin = false ; 
	public static Boolean isManager = false ; 

	
	public static void setIsAdmin(Boolean adminYn) {
		isAdmin = adminYn ; 
	}
	
	public static Boolean getIsAdmin() {
		return isAdmin ; 
	}
	
	public static void setIsManager(Boolean managerYn) {
		isManager = managerYn ; 
	}
	
	public static Boolean getIsMansger() {
		return isManager ; 
	}
	
	public static void setUserModel(Sys02_UserModel userInfo) {
		setIsManager(true); // 회사관리자이다.   
		userModel = userInfo; 
	}

 	public static long getCompanyId() {
 		
 		if(isAdmin) {
 			return 0 ; // admin은 사용자 정보가 없다.  
 		} 
 		else if(userModel.getCompanyId() != null) {
 			return userModel.getCompanyId();	
 		}
 		else {
 			return -1; 
 		}
	}
	
 	public static long getUserId() {

 		if(isAdmin) {
 			return 0 ; // admin은 사용자 정보가 없다.  
 		}
 		else if(isManager) { // 회사관리자. 
 			return userModel.getUserId();
 		} 
 		else { // 오류발생. 
 			return -1 ; 
 		}
	}

 	public static String getUserName() {
 			return userModel.getKorName(); 	
	}
 	
	public static String getYear(){
		return DateTimeFormat.getFormat( "yyyy" ).format( new Date()) ; 
	}
	
	public static String getTodayString(){
		return DateTimeFormat.getFormat( "yyyy-MM-dd" ).format(new Date()) ; 
	}
	
	public static Date getToday(){
		return DateTimeFormat.getFormat( "yyyy-MM-dd" ).parse(getTodayString()) ; 
	}
	
}
