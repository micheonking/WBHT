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

public class HTMLCompetitiveness implements javax.servlet.Servlet {

	private String actionCode = "retrieve";
	private Integer INTWIDTH = 700;
	private Integer INTLEFT = 200;
	private Integer INTRIGHT = 500;

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
		
		String rowHeader = "<br>저희 <strong>【발열섬유패드】</strong>제품은 자사가 보유하고 있는 핵심 기술 및 섬유소재를 활용하여 <span style='color:#0000fe; font-weight: 600;'>작업편리성</span>"
				+	", <br><span style='color:#0000fe; font-weight: 600;'>사용편리성</span>, <span style='color:#0000fe; font-weight: 600;'>건강기능성</span>과 경제성, 안전성, 내구성을 가진 뛰어난 "
				+	"제품입니다. <br><br>"
				;

		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		String rowLeft = "<font color='#606060' >"
			 	+	"<img src='img/competitiveness.png' width='200' height='400'>"
			 	;
	
		String rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\"> </span><br>"
				+	"<span style=\"font-size:1.0em;\">탄소발열섬유에 바느질,자수등 작업을 해도 발열기능에는 문제가 없음.</span><br>"
				+	"<span style=\"font-size:1.0em;\">표면에 완전 방수,방염 코팅이 되어있어 발열 성능,안전성 및</span><br>"
				+	"<span style=\"font-size:1.0em;\">내구성이 뛰어남.</span><br>"
				+	"<span style=\"font-size:1.0em;\">제품별 디자인,발열부위등 요구사항에 맞게 공급가능하여 다양한</span><br>"
				+	"<span style=\"font-size:1.0em;\">제품구성이 용이함.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">기존 제품에 비해 얇은 섬유소재는 제품 유연성이 우수하여,</span><br>"
				+	"<span style=\"font-size:1.0em;\">여러겹으로 접어서 보관할 수 있고 방수.방염코팅으로 내구성 및</span><br>"
				+	"<span style=\"font-size:1.0em;\">편리성이 뛰어남.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">탄소를 함유한 발열 페이스트와 은나노를 기본 물질로 활용하므로,<br>"
				+	"<span style=\"font-size:1.0em;\">원적외선을 방출하여 신진대사 활성화, 숙면, 항균, 탈취, 건습 기능</span><br>"
				+	"<span style=\"font-size:1.0em;\">등의 효과가 있음.</span><br>"
				+	"<br>"
				+	"<br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		sqlSession.close();
		
//		String tableString = "<table border=1 style='width:99%; margin:0px; font-size:15px; border-collapse:collapse; padding:5px; border:2px silver solid;'>";	//	font-family:Nanum Gothic; 
		String tableString = "<table style='width:99%; margin:0px; font-size:15px; border-collapse:collapse; padding:5px; '>";	//	font-family:Nanum Gothic; 
		
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

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:5px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
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
