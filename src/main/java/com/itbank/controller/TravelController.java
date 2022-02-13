package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.model.TravelDTO;
import com.itbank.model.WishDAO;
import com.itbank.model.WishDTO;
import com.itbank.service.TravelService;
import com.itbank.service.WishService;

@Controller
public class TravelController {
	
	@Autowired TravelService ts;
	@Autowired WishService ws;

	
//	@GetMapping("/cities")
//	public ModelAndView cities() {
//		ModelAndView mav = new ModelAndView();
//		List<TravelDTO> list = ts.selectList();
//		mav.addObject("list", list);
//		return mav;
//	}
	
	@GetMapping("/selectContinent/{continent}")
	public ModelAndView selectContinent(@PathVariable String continent) {
		
		System.out.println(continent);
		ModelAndView mav = new ModelAndView("cities");
		List<TravelDTO> list = ts.selectContinent(continent);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/cities")
	public ModelAndView searchName(String search, HttpSession session) {
		
//		System.out.println(search);

		ModelAndView mav = new ModelAndView("cities");
		
		List<TravelDTO> list = ts.searchName(search);
		
		mav.addObject("list", list);
	
		return mav;
	}	
	
	
}
