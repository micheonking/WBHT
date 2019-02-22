package myApp.server.hom;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.GridDataModel;
import myApp.client.vi.hom.company.model.Hom02_BoardModel;
import myApp.server.utils.db.UpdateDataModel;

public class Hom02_Board {

	private String mapperName  = "hom02_board"; 

	public void selectById(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		Long boardId = request.getLongParam("boardId"); 
		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectById", boardId);
		result.setRetrieveResult(list.size(), "select ok", list);
	}

	public void selectByTypeCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {

		String searchText = request.getStringParam("searchText");
		if(searchText == null) {
			searchText = "%";
		} else {
			searchText = "%" + searchText + "%";
		}
		request.putStringParam("searchText", searchText);
		
		if (request.getLongParam("startRowNum") == null) {
			request.putLongParam("startRowNum", (long)0);
		}

		System.out.println("--------------------------------------------------");
		System.out.println("typeCode param: " + request.getStringParam("typeCode"));
		System.out.println("searchText param: " + request.getStringParam("searchText"));
		System.out.println("setCount param: " + request.getLongParam("setCount"));
		System.out.println("startRowNum param: " + request.getLongParam("startRowNum"));

		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectByTypeCode", request.getParam());
		System.out.println("list count : " + list.size());
		result.setRetrieveResult(1, "select ok", list);
	}
//	public void selectByTypeCode2(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		
//		request.putStringParam("typeCode", "%"+request.getStringParam("typeCode")+"%");
//		request.putLongParam("setCount", request.getLongParam("setCount"));
//		
//		System.out.println("typeCode param: " + request.getStringParam("typeCode"));
//		System.out.println("setCount param: " + request.getLongParam("setCount"));
//		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectByTypeCode2", request.getParam());
//		result.setRetrieveResult(1, "select ok", list);
//	}

//	public void selectByTypeCode(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		System.out.println("typeCode : " + param.get("typeCode"));
//		
//		param.put("typeCode", request.getStringParam("typeCode"));
//		List<GridDataModel> list = sqlSession.selectList(mapperName + ".selectByTypeCode", param);
//		result.setRetrieveResult(1, "select ok", list);
//	}

	public void updateCnt(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		Hom02_BoardModel boardModel = (Hom02_BoardModel)request.getModelParam("boardModel");
		sqlSession.update(mapperName + ".updateCnt", boardModel.getBoardId());
		result.setStatus(1);
	}

	public void insert(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		Hom02_BoardModel boardModel = (Hom02_BoardModel)request.getModelParam("boardModel");
		
		System.out.println("insert!! -------- boardId    : " + boardModel.getBoardId());
		System.out.println("insert!! -------- titleName  : " + boardModel.getTitleName());
		System.out.println("insert!! -------- settledate : " + boardModel.getSettleDate());
		System.out.println("insert!! -------- contents   : " + boardModel.getContents());
		
		sqlSession.update(mapperName + ".insert", boardModel);
		result.setStatus(1);
	}

	public void update(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		UpdateDataModel<Hom02_BoardModel> updateModel = new UpdateDataModel<Hom02_BoardModel>(); 
		updateModel.updateModel(sqlSession, request.getList(), mapperName, result);
	}

	public void delete(SqlSession sqlSession, ServiceRequest request, ServiceResult result) {
		// 사용중인 코드인지 체크 로직 추가 필요.  
		UpdateDataModel<Hom02_BoardModel> updateModel = new UpdateDataModel<Hom02_BoardModel>(); 
		updateModel.deleteModel(sqlSession, request.getList(), mapperName, result);
	}

}
