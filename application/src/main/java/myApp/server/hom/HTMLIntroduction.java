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

public class HTMLIntroduction implements javax.servlet.Servlet {

	private String actionCode = "retrieve";
	private Integer INTWIDTH = 700;
	private Integer INTLEFT = 300;
	private Integer INTRIGHT = 400;

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
		
		String rowHeader = "<br>저희 <strong>【웰빙히트텍】</strong>은 <span style='color:#0000fe; font-weight: 600;'>탄소잉크 배합기술</span>"
				+	"과 <span style='color:#0000fe; font-weight: 600;'>패턴 디자인 기술</span>을 기반으로 5V, 7.4V, 12V, 24V 등<br>"
				+	"다양한 DC로 제작된 Fabric Heating Pad (면상발열체) 을 판매하고 있습니다. <br><br>"
				+	"고객과 협력회사가 원하는 좋은 제품을 지속 개발하여 보다 더 큰만족을 드리도록<br>"
				+	"노력하겠습니다. <br><br>"
				;

		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		String rowLeft = "<font color='#606060' >"
			 	+	"<img src='img/introduction.png' width='263' height='260'>"
			 	;
	
		String rowRight = "<font color='#606060' >"
				+	"<img src='img/smallTitle.png'>"
				+	"<span style=\"font-weight:bold;\"> 탄소발열섬유 (Fabric Heating Pad)</span><br>"
				+	"<span style=\"font-size:1.0em;\">1) 5V DC용 Heating Pad</span><br>"
				+	"<span style=\"font-size:1.0em;\">- 규격 : 30 cm X 30 cm, 30 cm X 20 cm</span><br>"
				+	"<span style=\"font-size:1.0em;\">- 용도 : 조끼, 복대, 담요, 방석 등</span><br>"
				+	"<span style=\"font-size:1.0em;\">2) 12V DC용 Heating Pad</span><br>"
				+	"<span style=\"font-size:1.0em;\">- 규격 : 30 cm X 50 cm</span><br>"
				+	"<span style=\"font-size:1.0em;\">- 용도 : 휴대용 매트, 침낭, 소파용 시트 등 캠핑레져용</span><br>"
				+	"<span style=\"font-size:1.0em;\">3) 24V DC용 Heating Pad</span><br>"
				+	"<span style=\"font-size:1.0em;\">- 규격 : 50 cm X 150 cm<br>"
				+	"<span style=\"font-size:1.0em;\">- 용도 : 침대용 매트, 이불( Single, Double Mat )</span><br><br>"
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
