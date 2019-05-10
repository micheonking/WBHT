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

import myApp.client.vi.hom.company.model.Hom03_OperatingModel;
import myApp.server.utils.db.DatabaseFactory;

public class HTMLPatent implements javax.servlet.Servlet {

	private String actionCode = "retrieve"; 
	private Integer INTWIDTH = 700;
	private Integer INTLEFT = 150;
	private Integer INTCENTER = 400;
	private Integer INTRIGHT = 150;


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
		
		List<String> rowList = new ArrayList<String>(); 
		
		SqlSession sqlSession = DatabaseFactory.openSession(); 
		
		String rowString = "";
//		
//		String rowHeader = "저희 <strong>【웰빙히트텍】</strong>은 특화된 <span style='color:#0000fe; font-weight: 600;'>카본페이스트</span>"
//				+	"의 배합기술과 제품특성에 따른 "
//				+	"<span style='color:#0000fe; font-weight: 600;'>패턴 디자인</span>과<br>"
//				+	"<span style='color:#0000fe; font-weight: 600;'>PTC 면상발열기술</span>을 "
//				+	"통해 다양한 소재와 다양한 용도에 맞게 제품을 구현할 수 있는 기술력을 <br>"
//				+	"보유하고 있습니다.<br>"
//				;
//
//		rowString += this.tdColSpan(2, rowHeader, INTWIDTH, "left", 0);
//		rowList.add(this.tr(rowString)) ;

		String rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 산업재산권(특허)</span><br>"
			 	;
	
		String rowCenter = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 명칭</span><br>"
			 	;
	
		String rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\"> 취득일자 </span><br>"
				;
		
		String rowRight2 = "<font color='#606060' >"
				+	"<span style=\"font-weight:bold;\"> 비고 </span><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData(rowCenter, INTCENTER, 0); 
		rowString += this.tdData(rowRight, INTRIGHT, 0); 
		rowString += this.tdData(rowRight2, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowCenter = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\">특허 제 10-2019-0040168 </span><br>"
			 	;
	
		rowCenter = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 직물원단의 표면에 발열카본잉크의 인쇄층이 형성된 온열시트</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\">(출원중) </span><br>"
				;
		rowRight2 = "<font color='#606060' >"
				+	"<span style=\"font-weight:bold;\">  </span><br>"
				;
		rowString = "";
		rowString += this.tdData1(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowCenter, INTCENTER, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowString += this.tdData1(rowRight2, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowCenter = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 특허 제 10-1543233</span><br>"
			 	;
	
		rowCenter = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 자동온도제어 특성이 우수한 난방필름 및 이의 제조방법</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\"> 2015. 8</span><br>"
				;
		
		rowRight2 = "<font color='#606060' >"
				+	"<span style=\"font-weight:bold;\"> 관계자 지원기술 </span><br>"
				;
		rowString = "";
		rowString += this.tdData1(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowCenter, INTCENTER, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowString += this.tdData1(rowRight2, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowCenter = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 특허 제 10-0712897</span><br>"
			 	;
	
		rowCenter = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 유연성을 갖는 면상 발열체</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\"> 2013. 12</span><br>"
				;
		
		rowRight2 = "<font color='#606060' >"
				+	"<span style=\"font-weight:bold;\"> 관계자 지원기술 </span><br>"
				;
		
		rowString = "";
		rowString += this.tdData1(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowCenter, INTCENTER, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowString += this.tdData1(rowRight2, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 


//		rowString = "";
//		rowHeader = "";
//		rowHeader = "<div><img src='img/core_graph1.png' width='680' height='350'></div> <br>"
//				;
//		rowString += this.tdColSpan(2, rowHeader, INTWIDTH, "left", 0);
//		rowList.add(this.tr(rowString)) ;
//
//		rowString = "";
//		rowHeader = "";
//		rowHeader = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
//			 	+	"<span style=\"font-weight:bold;\"> 탄소의 원적외선 효능</span><br>"
//				;
//		rowString += this.tdColSpan(2, rowHeader, INTWIDTH, "left", 0);
//		rowList.add(this.tr(rowString)) ;


		sqlSession.close();
		
		String tableString = "<table border=1 style='width:99%; margin:0px; font-size:15px; border-collapse:collapse; padding:5px; border:2px silver solid;'>";	//	font-family:Nanum Gothic; 
		
		for(String rowString1 : rowList) {
			tableString += rowString1; 
		}
		
		tableString += "</table>" ; 
		
		String returnHtml = tableString ; 
		
		return returnHtml; 
	}

	
	private String tr(String data) {
		return "<tr style='height:auto;'>" + data + "</tr>"; 
	}

	private String tdData(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' style='text-align:center; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdDataRight(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:right; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdData1(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdCenter(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdRowSpan(int rowSpan, String data, int width, String align, int rowcount) {
		
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
		
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
	private String tdGrey(String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:5px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	private String tdColSpan(int colSpan, String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ffffff' colSpan =" + colSpan
				+ " style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:5px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	
	private String tdColSpanGrey(int colSpan, String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' colSpan =" + colSpan
				+ " style='text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:5px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}

	
	private String tdRowSpanGrey(int rowSpan, String data, int width, String align, int rowcount) {
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
	
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:5px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
		 
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
