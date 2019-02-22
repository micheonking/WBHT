package myApp.client.vi.hom.admin.model;


import myApp.client.utils.GridDataModel;

public class Adm02_MenuModel implements GridDataModel {
	private	Long	menuId;
	private	String	menuName;
	private	Long	seq;
	private	Long	parentId;
	private	String	className;

	@Override
	public void setKeyId(Long id) {
		this.setMenuId(id);
	}
	@Override
	public Long getKeyId() {
		return this.getMenuId(); 
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

}
