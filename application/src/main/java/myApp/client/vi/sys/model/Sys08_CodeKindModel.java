package myApp.client.vi.sys.model;

import myApp.client.utils.GridDataModel;

public class Sys08_CodeKindModel implements GridDataModel {
	private Long	codeKindId;
	private String 	kindCode ;
	private String 	kindName ;
	private String  sysYn ;
	private Boolean sysYnFlag ; 
	private String 	note;

	@Override
	public void setKeyId(Long id) {
		this.setCodeKindId(id);
	}
	@Override
	public Long getKeyId() {

		return getCodeKindId();
	}

	public Long getCodeKindId() {
		return codeKindId;
	}
	public void setCodeKindId(Long codeKindId) {
		this.codeKindId = codeKindId;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSysYn() {
		return sysYn;
	}
	public void setSysYn(String sysYn) {
		this.sysYn = sysYn;
	}
	public Boolean getSysYnFlag() {
		this.sysYnFlag = "true".equals(this.sysYn);
		return sysYnFlag; 
		
	}
	public void setSysYnFlag(Boolean sysYnFlag) {
		this.sysYnFlag = sysYnFlag;
		this.sysYn = sysYnFlag.toString(); 
	}
	

}
