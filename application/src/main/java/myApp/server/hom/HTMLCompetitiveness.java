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
	private Integer INTWIDTH = 900;
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
		
//		SqlSession sqlSession = DatabaseFactory.openSession(); 
		
		String rowString = "";
		
		String rowHeader = "<br>저희 <strong>【발열섬유패드】</strong>제품은 자사가 보유하고 있는 핵심 기술 및 섬유소재를 활용하여 <span style='color:#0000fe; font-weight: 600;'>작업편리성</span>"
				+	", <br><span style='color:#0000fe; font-weight: 600;'>사용편리성</span>, <span style='color:#0000fe; font-weight: 600;'>건강기능성</span>과 경제성, 안전성, 내구성을 가진 뛰어난 "
				+	"제품입니다. <br><br>"
				;

		rowString += this.tdColSpanGrey(2, rowHeader, INTWIDTH, "left", 0);
		rowList.add(this.tr(rowString)) ;

		String rowLeft = "<font color='#606060' >"
			 	+	"<img src='img/competitiveness3.png' width='200' height='800'>"
			 	;

		String rowRight = "<font color='#606060' >"
//				+	"<img src='img/smallTitle.png'>"
//				+	"<span style=\"font-weight:bold;\"> </span><br>"
				+	"<span style=\"font-size:1.0em;\">탄소발열섬유에 바느질,자수등 작업을 해도 발열기능에는 문제가 없음.</span><br>"
				+	"<span style=\"font-size:1.0em;\">표면에 완전 방수,방염 코팅이 되어있어 발열 성능,안전성 및</span><br>"
				+	"<span style=\"font-size:1.0em;\">내구성이 뛰어남.</span><br>"
				+	"<span style=\"font-size:1.0em;\">제품별 디자인,발열부위등 요구사항에 맞게 공급가능하여 다양한</span><br>"
				+	"<span style=\"font-size:1.0em;\">제품구성이 용이함.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">기존 제품에 비해 얇은 섬유소재는 제품 유연성이 우수하여,</span><br>"
				+	"<span style=\"font-size:1.0em;\">여러겹으로 접어서 보관할 수 있고 방수.방염코팅으로 내구성 및</span><br>"
				+	"<span style=\"font-size:1.0em;\">편리성이 뛰어남.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">탄소를 함유한 발열 페이스트와 은나노를 기본 물질로 활용하므로,<br>"
				+	"<span style=\"font-size:1.0em;\">원적외선을 방출하여 신진대사 활성화, 숙면, 항균, 탈취, 건습 기능</span><br>"
				+	"<span style=\"font-size:1.0em;\">등의 효과가 있음.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">섬유소재 발열과 동시에 소비전력이 감소되는 방식으로 절전<br>"
				+	"<span style=\"font-size:1.0em;\">효과가 탁월함</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">상한온도를 설정하여 과열, 저온화상, 화재 가능성을 원천적으로<br>"
				+	"<span style=\"font-size:1.0em;\">억제하여 온열에 의한 위험성을 차단함.</span><br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<br>"
				+	"<span style=\"font-size:1.0em;\">독립셀 방식으로 일부 Cell이 훼손되어도(거의 훼손되지 않음)<br>"
				+	"<span style=\"font-size:1.0em;\">발열 기능에는 영향이 없음.</span><br>"
				+	"<br>"
				+	"<br>"
				;
		rowString = "";
		rowString += this.tdData(rowLeft, INTLEFT, 0); 
//		rowString += this.tdData(rowLeft2, INTLEFT, 0); 
		rowString += this.tdData1(rowRight, INTRIGHT, 0); 
		rowList.add(this.tr(rowString)) ; 
		
		String rowabc = " <table>\r\n" + 
				"      <thead>\r\n" + 
				"        <tr>\r\n" + 
				"          <th> </th>\r\n" + 
				"          <th>전기선</th>\r\n" + 
				"          <th>탄소 열선</th>\r\n" + 
				"          <th>탄소발열섬유패드</th>\r\n" + 
				"        </tr>\r\n" + 
				"      </thead>\r\n" + 
				"      <tbody>\r\n" + 
				"        <tr>\r\n" + 
				"          <th> &nbsp;&nbsp; </th>\r\n" +
				"          <td align=center><img src='img/cpt1.png' width='170' height='60'></td>\r\n" +
				"          <td align=center><img src='img/cpt2(1).png' width='95' height='60'>"
							+ "<img src='img/cpt2(2).png' width='95' height='60'></td>\r\n" + 
				"          <td align=center><img src='img/cpt3.png' width='170' height='60'></td>\r\n" + 
//				"          <td>이미지3</td>\r\n" + 
				"		  </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"          <th> </th>\r\n" + 
				"          <td align=center width=300><span style=\"font-size:15;\">"+
				"            전기선을 사용하여 발열하는\r\n<br>" + 
				"			 방식으로 발열성능이 낮고 \r\n<br>" + 
				"			저온화상등 안전성 문제\r\n<br>"+ 
				"			다양한 제품 제작 곤란\r\n<br>"+ 
				"			의류제품 사용 거의 안함.\r\n</span><br>"+ 
				"		</td>\r\n" + 
				"        <td align=center width=300><span style=\"font-size:15;\">" +
				"			탄소 열선이 훼손되면 안전성 <br>" +  
				"			문제  발생할 수 있음.\r\n<br>" +
				"			듬성듬성 열선이 설치되어 발열  \r\n<br>" + 
				"			효율이 떨어지고 원적외선에  \r\n<br>" + 
				"			의한 효과 미미함.\r\n<br>" + 
				"			제품 다양성 부족\r\n</span><br>" + 
				"			</td>\r\n" + 
				"		<td align=center width=300>\r\n" + 
				"			<span style=\"font-size:15;\">" +
				"			Maximum 온도설정되어\r\n<br>" + 
				"			화재 및 저온화상 발생 차단\r\n</span><br>" + 
				"			PTC 및 독립셀방식으로소비\r\n</span><br>" + 
				"			전력 감소 및 내구성이 높음\r\n</span><br>" + 
				"			발열량, 발열면적 및 원적외선\r\n</span><br>" + 
				"			다량 방출로 효과 최대.\r\n</span><br>" + 
				"			</td>\r\n" + 
				"        </tr> \r\n" + 
				"      </tbody>\r\n" + 
				"      <tfoot>\r\n" + 
				"      </tfoot>\r\n" + 
				"    </table>"
				;

		rowString = this.tdColSpanGrey2(2, rowabc, INTWIDTH, "center", 0);
		rowList.add(this.tr(rowString)) ;
		
		

//		sqlSession.close();
		
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
	private String tdColSpanGrey2(int colSpan, String data, int width, String align, int rowcount) {
		String rowChange = " ";
		if(rowcount == 1) rowChange = " background-color:#f5f5f5; "; 
		
		return "<td bgcolor='#ebebec' colSpan =" + colSpan
				+ " style='font-size:10;' text-align:" + align + "; width:" + width
				+ "px;" + rowChange + "padding:10px; height:auto; word-wrap:break-word;' >" + data 
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
