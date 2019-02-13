package myApp.client.vi.dbm.model;

import myApp.client.utils.GridDataModel;

public class Dbm02_ColCommentsModel implements GridDataModel {

	private	Long	columnId;	
	private	String	columnName;	
	private	String	dataType;	
	private	String	columnComment;	
	private	String	nullAble;	
	private	String	columnLength;	
	private	String	tableName;	

	@Override
	public void setKeyId(Long id) {
		this.setColumnId(id);
	}

	@Override
	public Long getKeyId() {
		return this.getColumnId(); 
	}

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getNullAble() {
		return nullAble;
	}

	public void setNullAble(String nullAble) {
		this.nullAble = nullAble;
	}

	public String getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(String columnLength) {
		this.columnLength = columnLength;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}

