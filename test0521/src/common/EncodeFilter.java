package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/EncodeFilter")
public class EncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//필터가 소멸될때 자동으로 호출되는 메소드
		System.out.println("필터 소멸~!");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//chain.doFilter()메소드 이전은 서블릿 적용전 동작로직
		request.setCharacterEncoding("utf-8");
		System.out.println("1. 인코딩완료");
		chain.doFilter(request, response);	//다음 필터를 적용, 다음필터가 없으면 Servlet호출
		System.out.println("5. 서블릿 완료 후 사용자 화면으로 이동");
		//chaon.doFilter()메소드 이후는 서블릿 적용후 동작로직
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//필터가 생성될 때 자동으로 호출되는 메소드
		System.out.println("인코딩 필터생성완료!!");
	}

}
