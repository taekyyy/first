package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "main";
	}
		
	@GetMapping("/header")
	public void header() {}
	
	@GetMapping("/join")
	public void join() {}

	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/alert")
	public void alert() {}
	
	@GetMapping("/newPass")
	public void newPass() {}
		
	@GetMapping("/agreePopUp1")
	public void agreePopUp1() {}
	
	@GetMapping("/agreePopUp2")
	public void agreePopUp2() {}
	
	@GetMapping("/adminLogin")
	public void adminLogin() {}
	
	@GetMapping("/adminTravelAdd")
	public void adminTravelAdd() {}

	@GetMapping("/team3")
	public void team3() {}

}
