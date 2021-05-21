package kh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kh.model.dao.Dao;
import kh.model.vo.Kh;

/**
 * Servlet implementation class AjaxSelectServlet
 */
@WebServlet(name = "AjaxSelect", urlPatterns = { "/ajaxSelect" })
public class AjaxSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String khId = request.getParameter("khId");
		Kh k = new Dao().selectOneKh(khId);
		JSONObject result = null;
		if(k!=null) {
			result = new JSONObject();
			result.put("khNo", k.getKhNo());
			result.put("fax", k.getFax());
			result.put("khName", URLEncoder.encode(k.getKhName(),"utf-8"));	//한글을 인코딩 안한 경우
			result.put("addr", URLEncoder.encode(k.getAddr(),"utf-8")); //한글 처리
			
			
		}
		response.setContentType("application/json");//되돌려주는 데이터의 타입이 json임을 명시
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();//버퍼링 되어 아직 기록되지 않은 데이터를 출력스트림으로 모두 출력
		out.close();//출력되지 않은 데이터가 있으면 출력하고 스트림 종료
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
