package ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet(name = "Movie", urlPatterns = { "/movie" })
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String targetDt = request.getParameter("targetDt");
		String key="2d1960a325f72e312330c46c40440bb2";
		String url="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		String result = Jsoup.connect(url)				//지정url로 요청
							.data("key",key)			//매개변수 key
							.data("targetDt",targetDt)	//매개변수 targetDt
							.userAgent("Mozilla")		//접속 브라우저 설정
							.ignoreContentType(true)	//리턴 데이터타입 무관
							.execute()					//요청
							.body();					//결과를 문자열 형태로 반환
		System.out.println(result);
		JsonParser parser = new JsonParser();	//문자열을 json으로 변환해줄 객체
		JsonObject movieRank = (JsonObject)parser.parse(result);	//result문자열을 json타입으로 변환
		JsonObject boxOffice = (JsonObject)movieRank.get("boxOfficeResult");
		JsonArray movieList = (JsonArray)boxOffice.get("dailyBoxOfficeList");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(movieList,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
