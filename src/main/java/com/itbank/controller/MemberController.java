package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.Hash;
import com.itbank.model.AdminDTO;
import com.itbank.model.MemberDTO;
import com.itbank.model.WishDTO;
import com.itbank.service.BoardService;
import com.itbank.service.JoinService;
import com.itbank.service.MemberService;
import com.itbank.service.ReplyService;
import com.itbank.service.WishService;

@Controller
public class MemberController {
	
	@Autowired private MemberService ms;
	@Autowired private Hash hash;
	@Autowired private BoardService bs;
	@Autowired private JoinService js;
	@Autowired private WishService ws;
	@Autowired private ReplyService rs;
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		String encPw = hash.getHash(dto.getUserpw()).substring(0, 12);
		dto.setUserpw(encPw);
		int row = ms.join(dto);
		System.out.println(row == 1 ? "성공" : "실패");
		return "redirect:/login";
	}

	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpSession session, String url) {
		 
		 String encPw = hash.getHash(dto.getUserpw()).substring(0, 12);
		   dto.setUserpw(encPw);
		   MemberDTO login = ms.login(dto);
		   session.setAttribute("login", login);
		   System.out.println(login == null ? "실패" : "성공 : " + login.getUseremail());
		   if(login == null) {
			   
			   return "redirect:/login";
		   }
		   return (url == null) ? "redirect:/" : "redirect:" + url;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		session.removeAttribute("adminLogin");
		return "redirect:/";
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(AdminDTO dto, HttpSession session) {
		 AdminDTO adminLogin = ms.adminLogin(dto);
		 session.setAttribute("adminLogin", adminLogin);
		 return "redirect:/admin";
	}
	
	@GetMapping("/mypage_default")
	public ModelAndView mypage_default(HttpSession session) {
		ModelAndView mav = new ModelAndView("/mypage_default");
		MemberDTO user = (MemberDTO)session.getAttribute("login");
		List<WishDTO> list = ws.selectUser(user.getUseremail());
		
		int wishCount = ws.countWishWriter(user.getUseremail());
		int boardCount = bs.countBoardWriter(user.getUseremail());
		int joinCount = js.countJoinCount(user.getUseremail());

		
		int pageState = 2;
		
		mav.addObject("pageState", pageState);
		mav.addObject("user", user);
		mav.addObject("boardCount", boardCount);
		mav.addObject("joinCount", joinCount);
		mav.addObject("wishCount", wishCount);
		mav.addObject("list", list);
		
		
		return mav;
	}

	

}
