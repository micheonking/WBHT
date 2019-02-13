package myApp.server.hom;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.sencha.gxt.widget.core.client.info.Info;

import myApp.client.vi.hom.company.model.Hom04_HistoryModel;
import myApp.server.utils.db.DatabaseFactory;

public class HTMLHistory implements javax.servlet.Servlet {

	private String actionCode = "retrieve"; 

	private String nullString(String data) {
		if("null".equals(data) || data == null) {
			return ""; 
		}
		else {
			String str = data.replaceAll("\r", "<br>"); 
			str = str.replaceAll("\n", "<br>");
			return  str; 
		}
	}
	
	private String getHtml() {
		
		String header = ""; //"대표전화 번호 " + "02-782-5100<br>";  
		
		List<String> rowList = new ArrayList<String>(); 
		
		SqlSession sqlSession = DatabaseFactory.openSession(); 
		
		List<Hom04_HistoryModel> list = sqlSession.selectList("hom04_history.selectByCompanyId",2000940L);
		
		String rowString = "";	
//		
//		rowString += this.tdGrayBold("년도", 100, "center",1); 	
//		rowString += this.tdGrayBold("성명/직책", 400, "center",1); 
//		rowString += this.tdGray("담당증권사", 90, "center",1);
//		rowString += this.tdGray("주요경력", 150, "center",1);
//		rowString += this.tdGray("학력/자격증", 155, "center",1);
//		rowString += this.tdGray("연락처", 75, "center",1);
//		
		rowList.add(this.tr(rowString)) ; 

		for(int i = 0 ; i<list.size(); i++) {
			
			Hom04_HistoryModel operatingModel = list.get(i);
			
			rowString = "";	
			
			rowString += this.tdCenterBold(operatingModel.getHistoryYm(), 100, 1);
			rowString += this.tdData(operatingModel.getCareerNote(), 400, 1); 

			rowList.add(this.tr(rowString)) ; 
		}
		
		sqlSession.close();
		
		String tableString = "<table border=1 style='width:99%; margin:0px; font-size:15px; border-top: 2px solid #023d69; border-bottom:2px solid #ddd;"
							+	"border-left: 1px solid white; border-right: 1px solid white; border-collapse:collapse; padding:0px;'>";
		
		for(String rowString1 : rowList) {
			tableString += rowString1; 
		}
		
		tableString += "</table>" ; 
		
		String returnHtml = header + tableString ; 
		
		return returnHtml; 
	}

//	tr 만들기	/////////////////////////////////////////////////////////////////////////////////////////	
	private String tr(String data) {
		return "<tr style='height:auto;'>" + data + "</tr>"; 
	}

//	td 만들기	/////////////////////////////////////////////////////////////////////////////////////////	
	private String tdData(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#ffffff; "; 

		return "<td style='width:" + width + "px;" + rowChange + "padding:10px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdCenter(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:10px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdRowSpan(int rowSpan, String data, int width, String align, int rowcount) {
		
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
		
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:10px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
	private String tdGray(String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:10px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

//	td Bold 만들기	/////////////////////////////////////////////////////////////////////////////////////////	

	private String tdColSpanGray(int colSpan, String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' colSpan =" + colSpan
				+ " style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
	private String tdRowSpanGray(int rowSpan, String data, int width, String align, int rowcount) {
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
	
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	private String tdDataBold(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='width:" + width + "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdCenterBold(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdRowSpanBold(int rowSpan, String data, int width, String align, int rowcount) {
		
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
		
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
	private String tdGrayBold(String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	private String tdColSpanGrayBold(int colSpan, String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' colSpan =" + colSpan
				+ " style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	private String tdRowSpanGrayBold(int rowSpan, String data, int width, String align, int rowcount) {
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
	
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:10px; font-weight:bold; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
//	tr:td 만들기	/////////////////////////////////////////////////////////////////////////////////////////	
	
		 
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		arg1.setContentType("text/html");
		arg1.setCharacterEncoding("UTF-8");
		
		this.actionCode = arg0.getParameter("actionCode");
		String empId = arg0.getParameter("empId");
		String evalTargetId = arg0.getParameter("evalTargetId");
		
		System.out.println("actionCode : " + actionCode);
		System.out.println("evalTargetId : " + evalTargetId);
		System.out.println("empId : "  + empId);
		
		String returnHtml = this.getHtml();
		
		PrintWriter out = arg1.getWriter();
		out.println(returnHtml);
		
	}
	@Override
	public void destroy() { 
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
	}
}
