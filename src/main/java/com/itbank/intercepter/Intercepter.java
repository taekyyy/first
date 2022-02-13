package com.itbank.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.MemberDTO;

public class Intercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login");
//		System.out.println(login != null ? "로그인 : " + login.getUseremail() : "로그인 없음" );
		
		if(login != null) {
			return true;
		}
		
		String cpath = request.getContextPath();
		String url = request.getRequestURL().toString();

		response.sendRedirect(cpath + "/login?url=" + url);
		return false;	
						
	}
	
	
}
