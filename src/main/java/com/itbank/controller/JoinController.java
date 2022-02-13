package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.model.JoinDTO;
import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.TravelDTO;
import com.itbank.service.BoardService;
import com.itbank.service.JoinService;
import com.itbank.service.MemberService;
import com.itbank.service.TravelService;

@Controller
public class JoinController {
	
	@Autowired private BoardService bs;
	@Autowired private TravelService ts;
	@Autowired private JoinService js;
	@Autowired private MemberService ms;
	
	@GetMapping("joinParty/{idx}")
	public ModelAndView joinParty(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView("partyInf");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		BoardDTO board = bs.selectOne(idx);
		TravelDTO dto = ts.selectCity(board.getCity());
		
		JoinDTO join = new JoinDTO();
		join.setBoardIdx(board.getIdx());
		join.setCity(board.getCity());
		join.setJoiner(login.getUseremail());
		join.setWriter(board.getWriter());
		join.setTitle(board.getTitle());
		join.setPlayDate(board.getMeetDate());
		
		if(board.getMaxMember() > board.getNowMember()) {
			int row = js.insertJoin(join);
			
			if(row == 1) {
				board.setNowMember(board.getNowMember() + 1);
				login.setJoinCnt(login.getJoinCnt() + 1);
				int row2 = bs.updateMember(board);
				int row3 = ms.updateJoinCnt(login);
				
				List<JoinDTO> list = js.selectJoiner(idx);
				int joinState = 2;
				
				mav.addObject("dto", dto);
				mav.addObject("board", board);
				mav.addObject("list", list);
				mav.addObject("joinState", joinState);
				System.out.println("참여 성공!!");
			}
			else {
				System.out.println("참여 실패 ...");
			}
			
		} 
		else {
			System.out.println("인원 초과!");
		}
		
		return mav;
	}
	
	
	@GetMapping("/outParty/{idx}")
	public ModelAndView outParty(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView("partyInf");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		BoardDTO board = bs.selectOne(idx);
		TravelDTO dto = ts.selectCity(board.getCity());
		
		int row = js.deleteJoin(login.getUseremail(), idx);
		
		if(row == 1) {
			board.setNowMember(board.getNowMember() - 1);
			login.setJoinCnt(login.getJoinCnt() - 1);
			int row2 = bs.updateMember(board);
			int row3 = ms.updateJoinCnt(login);
			
			List<JoinDTO> list = js.selectJoiner(idx);
			int joinState = 1;
			
			mav.addObject("dto", dto);
			mav.addObject("board", board);
			mav.addObject("list", list);
			mav.addObject("joinState", joinState);
			System.out.println("취소 성공!!");
		} else {
			System.out.println("취소 실패...");
		}
		return mav;
	}

	
}
