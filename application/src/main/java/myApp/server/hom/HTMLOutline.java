package myApp.server.hom;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;

import myApp.server.utils.db.DatabaseFactory;

public class HTMLOutline implements javax.servlet.Servlet {

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
		
		List<String> rowList = new ArrayList<String>(); 
		
		SqlSession sqlSession = DatabaseFactory.openSession(); 
		
		String rowString = "";
		
		String rowText0 = "저희 웰빙히트텍은 카본페이스트의 핵심 기술을 기반으로 패턴 디자인을 다양화하고 사업협력 네트워크";
		String rowText1 = "구축을 통하여 사업협력 네트워크 구축을 통하여  지속적인 혁신성장을 구현하고자 하는 탄소발열체 "; 
		String rowText2 = "전문기업입니다.";
		String rowBlank = "<br>";
		
		String rowText3 = "<font color='#606060' >"
				+	"<div><img src='img/CompanyOutline1.png' width='700' height='396'></div>";
			 	;

		String rowLast1	=	"<span style='font-weight:bold;font-size:1.3em;'>주식회사 웰빙히트텍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>";
		String rowLast2	=	"<span style='font-weight:bold;font-size:1.3em;'>대표이사 &nbsp;한 상 재&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>";
		
		String rowText24 = "<strong style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #333; line-height: 25px;'>STEP ① 위탁계좌 개설 및 투자권유</strong><br>"
				+	" 증권회사를 방문하여 위탁계좌를 개설하고 투자일임서비스에 관한 투자권유내용을 확인합니다.<br><br>"
				+	" <strong style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #333; line-height: 25px;'>STEP ② 투자일임 계약</strong><br>"
				+	" <span style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #0078c9; line-height: 25px;'>"
				+	"Case1. 한국채권투자자문 홈페이지를 통해 투자일임계약을 맺는 경우</span>"
				+	" - 한국채권투자자문 홈페이지를 방문하여 투자일임계약서를 작성합니다.<br>"
				+	" ※ 이 경우에도, 계약서를 제외한 기타서류(개인정보동의서, 확인서, CMS출금동의서) 작성을 위해"
				+   " <span style='color: red; font-weight: 600;'>증권회사 방문은 반드시 필요합니다.</span>(위탁계좌 개설 시 작성)<br><br>"
				+	" <span style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #0078c9; line-height: 25px;'>"
				+	"Case2. 증권회사를 방문하여 투자일임계약을 맺는 경우 </span><br>"
				+	" 증권회사를 방문하여 투자일임계약서 및 기타서류(개인정보동의서, 확인서, CMS출금동의서)를 모두 작성합니다.<br><br>"
				+	" <strong style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #333; line-height: 25px;'>STEP ③ 계약금액 및 수수료 입금 </strong><br>"
				+	" 투자일임계약을 맺은 투자일임계좌에 계약금액 및 수수료를 입금합니다.<br><br>"
				+	" <strong style='margin-bottom: 5px; font-size: 16px; font-weight: 600; color: #333; line-height: 25px;'>STEP ④ 투자일임자산 운용 시작 </strong><br>"
				+	" 한국채권투자자문이 고객의 투자일임계좌에 대한 운용을 시작합니다.<br><br><br><br><br><br>"
				;

		rowString += this.tdData(rowText0, 90, 0);
		rowList.add(this.tr(rowString)) ; 

		rowString = "";
		rowString += this.tdData(rowText1, 90, 0);
		rowList.add(this.tr(rowString)) ; 
		
		rowString = "";
		rowString += this.tdData(rowText2, 90, 0);
		rowList.add(this.tr(rowString)) ; 
		
		rowString = "";
		rowString += this.tdData(rowBlank, 90, 0);
		rowList.add(this.tr(rowString)) ; 

		rowString = "";
		rowString += this.tdData(rowBlank, 90, 0);
		rowList.add(this.tr(rowString)) ; 

		rowString = "";
		rowString += this.tdData(rowText3, 90, 0);
		rowList.add(this.tr(rowString)) ; 
		
//		rowString = "";
//		rowString += this.tdData(rowText24, 90, 0);
//		rowList.add(this.tr(rowString)) ; 

		sqlSession.close();
		
		String tableString = "<table style='width:99%; margin:0px; font-size:15px; border-collapse:collapse; padding:5px;'>";
		
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

		return "<td style='width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdDataRight(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:right; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdData1(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
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
