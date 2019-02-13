package myApp.client.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import myApp.client.utils.GridDataModel;

public class ServiceResult implements IsSerializable {
	
	private String serviceName; 
	private int  status=0; 
	private String message=""; 
	private List<GridDataModel> list = new ArrayList<GridDataModel>();
	private Long seq ;  
	private String jsonString; 
	
	public Long getSeq(){
		return seq ; 
	}
	
	public void setSeq(Long seq){
		this.seq = seq; 
	}
	
	public ServiceResult(){
	}

	public List<GridDataModel> getResult() {
		return list;
	}

	public void setResult(List<GridDataModel> list) {
		this.list = list;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addResult(GridDataModel object){
		list.add(object); 
	}

	public GridDataModel getResult(int i){
		return list.get(i); 
	}
	
	public void setRetrieveResult(int status, String message, List<GridDataModel> result){
		this.setStatus(status);
		this.setMessage(message);
		this.setResult(result); 
	}
	
	public void setModel(int status, String message, GridDataModel result){
		this.setStatus(status);
		this.setMessage(message);
		if(this.list != null) {
			this.list.clear(); // 기존에 등록되어 있는 자료는 지운다.
		}
		this.list.add(result);
		
		System.out.println(this.serviceName + " Result : " + message); 
	}

	public void fail(int status, String message){
		this.setStatus(status);
		this.setMessage(message);
		if(this.list != null) {
			this.list.clear(); // 기존에 등록되어 있는 자료는 지운다.
		}
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setJosnResult(String jsonString){
		this.jsonString = jsonString;
	}
	
	public String getJsonResult(){
		//조회된 결과를 JSON으로 리턴한다.
		
		return this.jsonString ;  
	}
	
}
