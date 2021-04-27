package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class TotalMember
 */
@WebServlet(name = "total", urlPatterns = { "/allMember" })
public class TotalMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TotalMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDao dao = new MemberDao();
		ArrayList<Member> member = dao.selectTotalMember();
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.println("<html><head><title>전체회원조회</title></head><body>");
		out.println("<h1>전체회원조회</h2>");
		if(member==null) {
			out.println("<h2>조회실패</h2>");
		}else {
			for(int i=0;i<member.size();i++) {
				out.println("<span>["+member.get(i).getMemberId()+"], </span>");
				out.println("<span>["+member.get(i).getMemberName()+"], </span>");
				out.println("<span>["+member.get(i).getAddress()+"]</span><br>");
				
			}
			out.println("<script>alert('성공!');</script>");
		}
		out.println("</body></html>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
