package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDao dao = new MemberDao();
		Member member = dao.selectOneMember(id,pw);
		//4.결과처리(jsp에게 데이터를 주면서 출력을 요청)
		// 결과를 처리할 페이지를 지정
		if(member!=null) {
			//결과를 처리할 페이지 지정
			RequestDispatcher rd = request.getRequestDispatcher("/view/loginSuccess.jsp");
			//화면을 구성하기 위한 데이터 등록
			request.setAttribute("memberName", member.getMemberName());
			//사용자 페이지 이동
			rd.forward(request, response);
		}
		else {
			//결과를 처리할 페이지 지정
			RequestDispatcher rd = request.getRequestDispatcher("/view/loginFail.jsp");
			//화면을 구성하기 위한 데이터 등록
			//사용자 페이지 이동
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
