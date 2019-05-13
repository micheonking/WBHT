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

public class HTMLCore implements javax.servlet.Servlet {

	private String actionCode = "retrieve";
	private Integer INTWIDTH = 700;
	private Integer INTLEFT = 150;
	private Integer INTRIGHT = 550;

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
		
		String rowHeader = "<br>저희 <strong>【웰빙히트텍】</strong>은 특화된 <span style='color:#0000fe; font-weight: 600;'>카본페이스트</span>"
				+	"의 배합기술과 제품특성에 따른 "
				+	"<span style='color:#0000fe; font-weight: 600;'>패턴 디자인</span>과<br>"
				+	"<span style='color:#0000fe; font-weight: 600;'>PTC 면상발열기술</span>을 "
				+	"통해 다양한 소재와 다양한 용도에 맞게 제품을 구현할 수 있는 기술력을 <br>"
				+	"보유하고 있습니다.<br><br>"
				;

		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		String rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 상한온도 설정방식</span><br>"
			 	;
	
		String rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">탄소발열페이스트의 핵심분자의 혼합 비율을 조절하므로서, 제품 </span><br>"
				+	"<span style=\"font-size:1.0em;\">용도에 필요한 Maximum온도를 원천적으로 발열패드등의 소재에</span><br>"
				+	"<span style=\"font-size:1.0em;\">설정하여 과열, 저온 화상, 화재등의 가능성을 원천 봉쇄하는 </span><br>"
				+	"<span style=\"font-size:1.0em;\">핵심기술임.<br><br>"
				+	"<span style=\"font-size:1.0em;\">제품용도(침구용,군사용,의료용, 건축자재용,아웃도어용등)에 </span><br>"
				+	"<span style=\"font-size:1.0em;\">따라서 탄소발열 페이스트 혼합비율을 조절하여 인쇄하면 해당 </span><br>"
				+	"<span style=\"font-size:1.0em;\">제품은 정해진 온도이상 올라가지 않음.</span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 독립셀 방식<br>(Independent Cell)</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">독립셀 방식이란 Cell별로 독립적으로 가동되도록 Cell의 규격, 간격 등을 디자인 (특허의 중요한 사항임)하여 절전효과,</span><br>"
				+	"<span style=\"font-size:1.0em;\">내구성 등을 높이는 핵심기술임.</span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> PTC 면상 발열 방식<br>(Positive Temperature Coefficient)</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">섬유( 매트 )의 발열과 동시에 소비전력이 감소되는 발열방식으로 </span><br>"
				+	"<span style=\"font-size:1.0em;\">절전효과가 탁월함.<br></span><br>"
				+	"<span style=\"font-size:1.0em;\"> => 전선,탄소선의 20% 정도만 소요<br></span><br>"
				+	"<span style=\"font-size:1.0em;\">외부 물체(주로 인체) 접촉시 자동으로 온도가 변환(탄소 열전도율</span><br>"
				+	"<span style=\"font-size:1.0em;\">특성)되어 인체에 거부감(Hot heat)이 없는 쾌적한 온도를 유지해 줌.<br></span><br>"
				+	"<span style=\"font-size:1.0em;\">* PTC ( 정특성 온도계수 )"
				+	"<span style=\"font-size:1.0em;\">- 임계온도 이하에서  전기흐름을 양호하게하고 임계온도에 이르면 전류 흐름을 감소시킴.</span><br>"
				+	"<span style=\"font-size:1.0em;\">   </span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowString = "";
		rowHeader = "";
		rowHeader = "<div><img src='img/core_graph1.png' width='680' height='350'></div> <br>"
				;
		rowString += this.tdColSpan(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		rowString = "";
		rowHeader = "";
		rowHeader = "<font color='#606060' ><br>"
			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 탄소의 원적외선 효능</span><br><br>"
				;
		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		rowLeft = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 탄소<br>(Carbon)</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">탄소는 우리 일상 생활을 구성하는 모든 물질의 대부분은 물론, 우리몸</span><br>"
				+	"<span style=\"font-size:1.0em;\">(18.5%)의  단백질과  DNA도 탄소로 이루어져 있음.</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">동소체(같은 원소이나 모양과 성질이 다름)로는 흑연과 탄소나노튜브,</span><br>"
				+	"<span style=\"font-size:1.0em;\">다이아몬드가 있으며 모든 물질 중에서 가장 높은 열전도율을 가지며 </span><br>"
				+	"<span style=\"font-size:1.0em;\">다른 원소와 비교해서 수 많은 화합물과 결합가능하여  탄소를 “원소</span><br>"
				+	"<span style=\"font-size:1.0em;\">의 왕자” 라 함.<br></span><br>"
				+	"<span style=\"font-size:1.0em;\">탄소의  큰효능은  원적외선방출로 신진대사를 활성화시키는 역할을 함.</span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowLeft = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 원적외선<br>(far infrared ray)</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">전자기파( Electromagnetic wave )의 일종으로 전기장과 자기장이 </span><br>"
				+	"<span style=\"font-size:1.0em;\">물결처럼 퍼져나가는 것을 말하며, 특징으로는 열작용이 크며</span><br>"
				+	"<span style=\"font-size:1.0em;\">침투력이 강하여  피부에 따뜻함을 전달하는 성질이 있음.</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">  ( 화학,해양과학,전기전자,광물자원 용어사전 등의 정의 )</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">또한 유기화합물질에 대한 공진과 공명작용이 강하여 MRI 등 의료</span><br>"
				+	"<span style=\"font-size:1.0em;\">분야 및 다양한 산업분야(원적외선 마스크, 아이패취 등)에 응용됨</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">원적외선 자체가 이로운 성분,성질을 자체적으로 가지고 있는 것은 </span><br>"
				+	"<span style=\"font-size:1.0em;\">아니며(대부분 사람들이 오해하고 있음), 원적외선은 피부로 3~4cm</span><br>"
				+	"<span style=\"font-size:1.0em;\">까지 열을 전달하여 세포의 수분 및 단백질에 1분에 2000회 미세하게</span><br>"
				+	"<span style=\"font-size:1.0em;\">진동을 주므로써  신진대사 촉진, 통증 완화,숙면,탈취,제습,방균등의</span><br>"
				+	"<span style=\"font-size:1.0em;\">효과를 발휘하게함. </span><br><br>"
				+	"<span style=\"font-size:1.0em;\"> * 서울대 지철근교수의  탄소원적외선에 대한 연구(한국전기학회지)</span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 

		rowString = "";
		rowHeader = "";
		rowHeader = "<font color='#606060' ><br>"
			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 은나노 효능</span><br><br>"
				;
		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		rowLeft = "";
		rowRight = "";
		rowLeft = "<font color='#606060' >"
//			 	+	"<img src='img/smallTitle.png'>"
			 	+	"<span style=\"font-weight:bold;\"> 은나노<br>(Nano Silver)</span><br>"
			 	;
	
		rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> 주요이력 </span><br>"
				+	"<span style=\"font-size:1.0em;\">유해균,곰팡이균,무좀균,알르레기성균 등에 억제 및 제균기능이 탁월하고 </span><br>"
				+	"<span style=\"font-size:1.0em;\">노폐물에 의해 번식하는 세균의 증식을 막고 제균을 하여 악취를 </span><br>"
				+	"<span style=\"font-size:1.0em;\">근복적으로 막아줌.</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">몸에 해로운 자외선과 전자파를 차단해 주는 기능</span><br><br>"
				+	"<span style=\"font-size:1.0em;\">특히 정전기 발생을 방지하고 항온. 단열 효과도 있어 옷에도 널리 </span><br>"
				+	"<span style=\"font-size:1.0em;\">사용되고 있음.</span><br><br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 


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
