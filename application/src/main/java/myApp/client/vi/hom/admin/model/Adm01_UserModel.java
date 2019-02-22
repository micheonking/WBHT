package myApp.client.vi.hom.admin.model;


import myApp.client.utils.GridDataModel;

public class Adm01_UserModel implements GridDataModel {
	private	Long	userId;
	private	String	userName;

	@Override
	public void setKeyId(Long id) {
		this.setUserId(id);
	}

	@Override
	public Long getKeyId() {
		return this.getUserId(); 
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
