package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.AdminDTO;
import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.ReplyDTO;
import com.itbank.model.TravelDTO;
import com.itbank.service.AdminService;
import com.itbank.service.BoardService;
import com.itbank.service.MemberService;
import com.itbank.service.ReplyService;
import com.itbank.service.TravelService;
import com.itbank.service.WishService;

@Controller
public class AdminController {
	
	@Autowired private AdminService as;
	@Autowired private WishService ws;
	@Autowired private BoardService bs;
	@Autowired private MemberService ms;
	@Autowired private TravelService ts;
	@Autowired private ReplyService rs;
	
	
	@GetMapping("/admin")
	public ModelAndView admin(String search 
							, HttpSession session
							, PagingDTO page
							, @RequestParam(value="nowPage", required=false)String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		
		ModelAndView mav = new ModelAndView("/admin");
		mav.addObject("adminState",1);
		AdminDTO admin = (AdminDTO) session.getAttribute("adminLogin");
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		admin.setBoardcnt(bs.countBoardAll());
		admin.setMembercnt(ms.countMemberListAll());
		admin.setWishcnt(ws.countWishListAll());
		admin.setTravelcnt(ts.countTravelListAll());
		int row = as.update(admin);
		
		if(search == null) {
			int total = bs.countBoardAll();
			
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<BoardDTO> bDto = bs.selectBoardAll(page.getStart(), page.getEnd());
			
			mav.addObject("board",bDto);
			mav.addObject("paging", page);
			
		}
		else if(search != null) {
			int total = bs.countSearchList(search);
			
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<BoardDTO> bDto = bs.searchBoardList(search, page.getStart(), page.getEnd());
			
			mav.addObject("board",bDto);
			mav.addObject("paging", page);
			
		}
		mav.addObject("admin",admin);

		return mav;
	}
	
	@GetMapping("/admin/memberAll")
	public ModelAndView adminMember(String search
								, HttpSession session
								, PagingDTO page
								, @RequestParam(value="nowPage", required=false)String nowPage
								, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		ModelAndView mav = new ModelAndView("/admin");
		AdminDTO admin = (AdminDTO) session.getAttribute("adminLogin");
		
		admin.setBoardcnt(bs.countBoardAll());
		admin.setMembercnt(ms.countMemberListAll());
		admin.setWishcnt(ws.countWishListAll());
		admin.setTravelcnt(ts.countTravelListAll());
		int row = as.update(admin);
		
		if(search == null) {
			int total = ms.countMemberListAll();
			
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<MemberDTO> list = ms.selectMemberAll(page.getStart(), page.getEnd());
			
			mav.addObject("list", list);
			mav.addObject("paging", page);
		}
		else if(search != null) {
			int total = ms.countMember(search);
			
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<MemberDTO> list = ms.selectMember(search, page.getStart(), page.getEnd());
			
			mav.addObject("list", list);
			mav.addObject("paging", page);
		}
		
		

		mav.addObject("adminState", 2);
		mav.addObject("admin",admin);
		mav.addObject("paging", page);
		
		return mav;
	}
	
	@GetMapping("/admin/travelAll")
	public ModelAndView adminTravel(String search
							, HttpSession session
							, PagingDTO page
							, @RequestParam(value="nowPage", required=false)String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		ModelAndView mav = new ModelAndView("/admin");
		System.out.println(search);
		AdminDTO admin = (AdminDTO) session.getAttribute("adminLogin");
		
		
		admin.setBoardcnt(bs.countBoardAll());
		admin.setMembercnt(ms.countMemberListAll());
		admin.setWishcnt(ws.countWishListAll());
		admin.setTravelcnt(ts.countTravelListAll());
		int row = as.update(admin);
		
		if(search == null) {
			int total = ts.countTravelListAll();
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<TravelDTO> tDto = ts.selectListAll(page.getStart(), page.getEnd());
			
			mav.addObject("travel",tDto);
			mav.addObject("paging", page);
		}
		else if(search != null) {
			int total = ts.countTravelList(search);
			
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "8";
			} else if (nowPage == null) {
				nowPage ="1";
			} else if (cntPerPage == null) {
				cntPerPage = "8";
			}
			
			page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
			List<TravelDTO> tDto = ts.selectList(search, page.getStart(), page.getEnd());
			
			
			mav.addObject("travel",tDto);
			mav.addObject("paging", page);
		}
		
		
		mav.addObject("adminState", 3);
		mav.addObject("admin",admin);
		return mav;
	}
	
	@PostMapping("/admin")
	public String boardDelete(String[] boardChk) {
		int row = bs.myBoardDelete(boardChk);
		
		if(row == 1) {
			System.out.println("삭제성공");
		}
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/memberAll")
	public String memberDelete(String[] boardChk) {
		int row = ms.memberDelete(boardChk);
		
		if(row == 1) {
			System.out.println("삭제성공");
		}
		return "redirect:/admin/memberAll";
	}
	
	@PostMapping("/adminTravelAdd")
	public String upload(TravelDTO dto) throws Exception {
		int row = as.uploadFiles(dto);
		System.out.println(row);
		return "redirect:/admin/travelAll";
	}
	
	@PostMapping("/admin/travelAll")
	public String travelDelete(String[] boardChk) {
		int row = as.deleteTravel(boardChk);
		
		if(row == 1) {
			System.out.println("삭제성공");
		}
		return "redirect:/admin/travelAll";
	}
	


	@GetMapping("/memberDetails/{idx}")
	public ModelAndView memberDetails(PagingDTO page
			   						, @PathVariable int idx
			   						, @RequestParam(value="nowPage", required=false)String nowPage
									, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
	    ModelAndView mav = new ModelAndView("memberDetails");
	    
	    MemberDTO dto = ms.selectUser(idx);
	    
	    
	    int total = rs.selectWrite(dto.getUseremail());
	    
	    if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "8";
		} else if (nowPage == null) {
			nowPage ="1";
		} else if (cntPerPage == null) {
			cntPerPage = "8";
		}
	    
	    page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
	    ArrayList<ReplyDTO> list = rs.replyList(dto.getUseremail(), page.getStart(), page.getEnd());
	    
	    
	    mav.addObject("dto", dto);
	    mav.addObject("paging", page);
	    mav.addObject("list", list);
	    mav.addObject("total", total);
	    
	    return mav;
	}
	
	@PostMapping("/memberDetails")
	public String replyDelete(String[] boardChk) {
		int row = rs.deleteMyReply(boardChk);
		
		if(row == 1) {
			System.out.println("삭제성공");
		}
		return "redirect:/";
	}
	

}
