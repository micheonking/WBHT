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

public class HTMLCeo implements javax.servlet.Servlet {

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
		
		String header = ""; //"대표전화 번호 " + "1588-3499<br>";  
		
		List<String> rowList = new ArrayList<String>(); 
		
		SqlSession sqlSession = DatabaseFactory.openSession(); 
		
//		List<Long> companyList = sqlSession.selectList("hom03_operating.selectByComanyId");
		
		String rowString = "";

		String ceoimage = "<div><img src='img/_WBHTCeo.jpg' width='190' height='266'></div>";

		String content = "<font color='#606060' >"
				+	"<span style=\"font-weight:bold;font-size:1.2em;\">안녕하십니까<br></span>"
				+	"<span style=\"font-weight:normal;font-size:0.9em;\">"
				+	"<br>"
				+	"먼저 방문해주신 고객님께 진심으로 감사드립니다.<br>"
				+	"<br>"
				+	"저희는 “탄소발열체”의 R&D를 전문적으로 하는 회사로서<br>"
				+	"Welling for Humanbeing이라는 슬로건아래 지난 20여년간 <br>"
				+	"인류의 편안한 삶을 위한 제품을 연구개발하고 생산하는데<br>"
				+	"총력을 기울여 왔습니다.<br>"
				+	"<br>"
				+	"저희는 발열소재를 혁신적으로 발전시켜 세계 최초로 탄소페이스트와 <br>"
//				+	"은나노를 천에 Printing하여 발열시키는 기술을 개발하여<br>"
				+	"매트, 조끼, 복대 등의 침구류와 의류 등에 적용할 수 있는<br>"
				+	"제품을 연구개발하여 완성하였습니다.<br>"
				+	"그리고 시트등 침구류에도 적용할 수 있도록 지속적인 개발을 하고 있습니다.<br>"
				+	"<br>"
				+	"저희는 그동안 축적해온 탄소발열체에 대한 전문화된 능력과 노하우를<br>"
				+	"바탕으로 제품혁신과 가격경쟁력에 주력하여 제품의 세계화를 통한 <br>"
				+	"Wellbeing for Humanbeing(인류복지)증진에<br>"
				+	"최선을 다하겠습니다.<br>"
				+	"<br>"
				+	" 감사합니다.<br><br><br></span>"
				+	"<span style=\"font-weight:bold;font-size:1.2em;\">주식회사 웰빙히트텍 대표이사 한상재</span>"
				;
		
		String education = "<font color='#606060' >"
					+	"<br>"
				 	+	"<img src='img/smallTitle.png'>"
				 	+	"<span style=\"font-weight:bold;\"> 학력 및 자격사항</span><br>"
				 	+	"<span style=\"font-size:0.8em;\">ㆍCISA, ISO9001 책임심사원</span><br>"
				 	+	"<span style=\"font-size:0.8em;\">ㆍ전문투자형 운용전문인력</span><br>"
				 	+	"<span style=\"font-size:0.8em;\">ㆍ홍익대학교 이학석사</span><br>"
				 	;
		
		String career = "<font color='#606060' >"
					+	"<br>"
					+	"<img src='img/smallTitle.png'>"
					+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
					+	"<span style=\"font-size:0.8em;\">現) 한국펀드서비스(주) 대표이사</span><br>"
					+	"<span style=\"font-size:0.8em;\">前) 한국채권투자자문 전략본부장</span><br>"
					+	"<span style=\"font-size:0.8em;\">前) 신한BNP자산운용 운용지원본부장</span><br>"
					+	"<span style=\"font-size:0.8em;\">前) 펀드넷 및 정보화 허브 자문위원</span><br>"
					+	"<span style=\"font-size:0.8em;\">前) 대한투자신탁(주)</span><br>"
					;
		
		rowString += this.tdRowSpan(3, content, 500, "left", 0);
		rowString += this.tdData1(ceoimage, 220, 0);
		rowList.add(this.tr(rowString)) ; 
		rowString = "";
		rowString += this.tdData1(education, 220, 0); 
		rowList.add(this.tr(rowString)) ;
		rowString = "";
		rowString += this.tdData1(career, 220, 0); 
		rowList.add(this.tr(rowString)) ; 
		sqlSession.close();
		
		String tableString = "<table style='width:99%; margin:0px; font-size:16px; border-collapse:collapse; padding:0px;'>";
		
		for(String rowString1 : rowList) {
			tableString += rowString1; 
		}
		
		tableString += "</table>" ; 
		
		String returnHtml = header + tableString ; 
		
		return returnHtml; 
	}

	
	private String tr(String data) {
		return "<tr style='height:auto;'>" + data + "</tr>"; 
	}

	private String tdData(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='width:" + width + "px;" + rowChange + "padding:0px 0px 0px 20px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdData1(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='width:" + width + "px;" + rowChange + "padding:0px 0px 0px 20px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdCenter(String data, int width, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td style='text-align:center; width:" + width + "px;" + rowChange + "padding:0px 0px 0px 20px; height:auto; word-wrap:break-word;' >" + data + "</td>" ; 
	}

	private String tdRowSpan(int rowSpan, String data, int width, String align, int rowcount) {
		
		int rs = rowSpan; 
		if(rs<1) rs = 1 ;
		
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td rowspan=" + rs 
				+ " style='text-align:" + align + "; width:" + width 
				+ "px;" + rowChange + "padding:0px 0px 0px 0px; height:auto; word-wrap:break-word;' >" + data 
				+ "</td>" ; 
	}
	
	private String tdGrey(String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 

		return "<td bgcolor='#ebebec' style='text-align:" + align + "; width:" + width
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
