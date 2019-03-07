package myApp.server.hom;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.hom.company.model.Hom04_HistoryModel;
import myApp.server.utils.db.UpdateDataModel;

public class Hom04_History {

	private String mapperName  = "hom04_history"; 

	public void selectById(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		Long boardId = request.getLongParam("historyId"); 
		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectById", boardId);
		result.setRetrieveResult(list.size(), "select ok", list);
	}

	public void selectByTypeCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectByCompanyId", request.getParam());
		result.setRetrieveResult(1, "select ok", list);
	}
	
	public void selectByAll(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectByAll", request.getParam());
		System.out.println("list count : " + list.size());
		result.setRetrieveResult(1, "select ok", list);
	}

	public void insert(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		Hom04_HistoryModel historyModel = (Hom04_HistoryModel)request.getModelParam("historyModel");
		sqlSession.update(mapperName + ".insert", historyModel);
		result.setStatus(1);
	}
	
	public void deleteRow(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		
		Hom04_HistoryModel historyModel = (Hom04_HistoryModel)request.getModelParam("historyModel");
		List<GridDataModel> deleteList = new ArrayList<GridDataModel>();
		deleteList.add(historyModel);

		UpdateDataModel<GridDataModel> deleteData = new UpdateDataModel<GridDataModel>();
		deleteData.deleteModel(sqlSession, deleteList, "hom04_history", result);
		
		result.setStatus(1);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Hom04_HistoryModel> updateModel = new UpdateDataModel<Hom04_HistoryModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), mapperName, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		// 사용중인 코드인지 체크 로직 추가 필요.  
		UpdateDataModel<Hom04_HistoryModel> updateModel = new UpdateDataModel<Hom04_HistoryModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), mapperName, result);
	}

}
