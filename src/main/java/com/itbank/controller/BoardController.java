package com.itbank.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.AdminDTO;
import com.itbank.model.BoardDTO;
import com.itbank.model.JoinDTO;
import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.ReplyDTO;
import com.itbank.model.TravelDTO;
import com.itbank.service.BoardService;
import com.itbank.service.JoinService;
import com.itbank.service.MemberService;
import com.itbank.service.ReplyService;
import com.itbank.service.TravelService;
import com.itbank.service.WishService;

@Controller
public class BoardController {
	
	@Autowired private BoardService bs;
	@Autowired private TravelService ts;
	@Autowired private JoinService js;
	@Autowired private ReplyService rs;
	@Autowired private WishService ws;
	@Autowired private MemberService ms;
	
	@GetMapping("/party/{city}")
	public ModelAndView party(PagingDTO page
							, @PathVariable String city
							, @RequestParam(value="nowPage", required=false)String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		ModelAndView mav = new ModelAndView("party");
		
		int total = bs.countBoard(city);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "14";
		} else if (nowPage == null) {
			nowPage ="1";
		} else if (cntPerPage == null) {
			cntPerPage = "14";
		}
		
		page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
		List<BoardDTO> list = bs.selectBoardCity(city, page.getStart(), page.getEnd());
		TravelDTO dto = ts.selectCity(city);
		
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.addObject("paging", page);
		
		return mav;
	}
	
	@GetMapping("/partyInf/{idx}")
	public ModelAndView partyInf(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView("partyInf");

		MemberDTO login = (MemberDTO) session.getAttribute("login");
		BoardDTO board = bs.selectOne(idx);					// 게시글 번호를 파라미터로 받아 그 게시글 번호에 맞는 게시글 정보를 불러온다
		TravelDTO dto = ts.selectCity(board.getCity());		// 게시글에 입력된 도시의 값을 받아 여행지 DB속 상세 이미지를 불러온다
		List<JoinDTO> list = js.selectJoiner(idx);			// 게시글 번호를 파라미터로 받아 JoinDB속 (boardIdx=idx) 참여자 이메일을 불러온다
		List<ReplyDTO> reply = rs.selectReplyList(idx);		// 게시글 번호를 받아서 그 게시글에 달린 댓글들을 불러온다
		
		
		int joinState = 0;
		JoinDTO joiner = js.searchJoin(login.getUseremail(), idx);
		
		if(joiner == null) {
			joinState = 1;		// 참여하기 버튼
		} else {
			joinState = 2;		// 참여취소 버튼
		}

		mav.addObject("dto", dto);
		mav.addObject("board", board);
		mav.addObject("list", list);
		mav.addObject("joinState", joinState);
		mav.addObject("reply", reply);
		
		return mav;
	}
	

	// 마이페이지 작성글 페이지 게시글
	@GetMapping("/mypage_default/myWrite")
	public ModelAndView mypage_default1(PagingDTO page
			   					, @RequestParam(value="nowPage", required=false)String nowPage
			   					, @RequestParam(value="cntPerPage", required=false)String cntPerPage
			   					, HttpSession session) {
	      
		ModelAndView mav = new ModelAndView("/mypage_default");	      
	    MemberDTO user = (MemberDTO)session.getAttribute("login");
	      
	      
	    int wishCount = ws.countWishWriter(user.getUseremail());
	    int boardCount = bs.countBoardWriter(user.getUseremail());	// 로그인한 유저의 게시글 총 갯수
	    int joinCount = js.countJoinCount(user.getUseremail());		// 로그인한 유저의 참여글 총 갯수

	      
	    int pageState = 1;	// 작성글, 참여글 과 위시리스트를 구분      
	    int boardState = 1;	// 작성글과 참여글을 구분
	    int total = 0;		// 게시글 갯수
	      
	    if(nowPage == null && cntPerPage == null) {
	    	nowPage = "1";
	    	cntPerPage = "7";
	    } else if (nowPage == null) {
	    	nowPage ="1";
	    } else if (cntPerPage == null) {
	    	cntPerPage = "7";
	    }
	      
	    total = bs.countBoardWriter(user.getUseremail());
	    page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
	    ArrayList<BoardDTO> myBoard = bs.writeList(user.getUseremail(), page.getStart(), page.getEnd());
	      
	    mav.addObject("pageState", pageState);
	    mav.addObject("boardState", boardState);
	    mav.addObject("myBoard", myBoard);
	    mav.addObject("paging", page);
	    mav.addObject("user", user);
	    mav.addObject("boardCount", boardCount);
	    mav.addObject("joinCount", joinCount);
	    mav.addObject("wishCount", wishCount);

	    return mav;
	  }
	
	//마이페이지 참여글 페이지 게시글
	@GetMapping("/mypage_default/myJoin")
	public ModelAndView mypage_default2(PagingDTO page
				, @RequestParam(value="nowPage", required=false)String nowPage
				, @RequestParam(value="cntPerPage", required=false)String cntPerPage
				, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("/mypage_default");	      
	    MemberDTO user = (MemberDTO)session.getAttribute("login");
	      
	      
	    int wishCount = ws.countWishWriter(user.getUseremail());
	    int boardCount = bs.countBoardWriter(user.getUseremail());	// 로그인한 유저의 게시글 총 갯수
	    int joinCount = js.countJoinCount(user.getUseremail());		// 로그인한 유저의 참여글 총 갯수

	      
	    int pageState =  1;	// 작성글, 참여글 과 위시리스트를 구분      
	    int boardState = 2;	// 작성글과 참여글을 구분
	    int total = 0;		// 게시글 갯수
	      
	    if(nowPage == null && cntPerPage == null) {
	    	nowPage = "1";
	    	cntPerPage = "7";
	    } else if (nowPage == null) {
	    	nowPage ="1";
	    } else if (cntPerPage == null) {
	    	cntPerPage = "7";
	    }
	    
	    total = js.countJoinCount(user.getUseremail());
	    page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
        ArrayList<JoinDTO> myJoin = js.joinList(user.getUseremail(), page.getStart(), page.getEnd());
        
        mav.addObject("pageState", pageState);
        mav.addObject("paging", page);
        mav.addObject("myJoin", myJoin);	  
        mav.addObject("user", user);
        mav.addObject("boardState", boardState);
	    mav.addObject("boardCount", boardCount);
	    mav.addObject("joinCount", joinCount);
	    mav.addObject("wishCount", wishCount);
	    
		
		return mav;
	}
	
	// 마이페이지 내가 쓴 댓글 페이지
	@GetMapping("/mypage_default/myReply")
	public ModelAndView mypage_default3(PagingDTO page
				, @RequestParam(value="nowPage", required=false)String nowPage
				, @RequestParam(value="cntPerPage", required=false)String cntPerPage
				, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("/mypage_default");	      
	    MemberDTO user = (MemberDTO)session.getAttribute("login");
	      
	      
	    int wishCount = ws.countWishWriter(user.getUseremail());
	    int boardCount = bs.countBoardWriter(user.getUseremail());	// 로그인한 유저의 게시글 총 갯수
	    int joinCount = js.countJoinCount(user.getUseremail());		// 로그인한 유저의 참여글 총 갯수
	    int replyCount = rs.selectWrite(user.getUseremail());

	      
	    int pageState =  1;	// 작성글, 참여글 과 위시리스트를 구분      
	    int boardState = 3;	// 작성글과 참여글, 댓글 페이지를 구분
	    int total = 0;		// 게시글 갯수
	      
	    if(nowPage == null && cntPerPage == null) {
	    	nowPage = "1";
	    	cntPerPage = "7";
	    } else if (nowPage == null) {
	    	nowPage ="1";
	    } else if (cntPerPage == null) {
	    	cntPerPage = "7";
	    }
	    
	    total = js.countReplyCount(user.getUseremail());
	    page = new PagingDTO(total, Integer.parseInt(nowPage) , Integer.parseInt(cntPerPage));
        ArrayList<ReplyDTO> myReply = rs.replyList(user.getUseremail(), page.getStart(), page.getEnd());
        
        mav.addObject("pageState", pageState);
        mav.addObject("paging", page);
        mav.addObject("myReply", myReply);
        mav.addObject("user", user);
        mav.addObject("boardState", boardState);
	    mav.addObject("boardCount", boardCount);
	    mav.addObject("joinCount", joinCount);
	    mav.addObject("wishCount", wishCount);
		mav.addObject("replyCount", replyCount);
	    
		return mav;
	}

	/* 작성글 삭제 */
    @PostMapping("/mypage_default/myWrite")
    public ModelAndView myBoardDelete(String[] boardChk, HttpSession session) {
       ModelAndView mav = new ModelAndView("/alert");
       MemberDTO login = (MemberDTO) session.getAttribute("login");
       
       //작성글 삭제
       if(boardChk != null) {
          int myBoardDelete = bs.myBoardDelete(boardChk); 
          
          String boardIdxArr = Arrays.toString(boardChk);
          
          if(myBoardDelete == 1) {
             mav.addObject("msg", boardIdxArr + "번 게시물을 삭제하였습니다");
             login.setWriteCnt(login.getWriteCnt() - 1);
             int row = ms.updateWriteCnt(login);
          }
          else {
             mav.addObject("msg", "삭제 실패");
          }
       }
       mav.addObject("url", "mypage_default/myWrite");
       return mav;
    }
    
    @PostMapping("/mypage_default/myWrite/modify")
    public ModelAndView myboardUpdate(BoardDTO dto) {
       
       ModelAndView mav = new ModelAndView("/alert");
       
       int myboardUpdate = bs.myboardUpdate(dto);
      
       if(dto != null) {
          if(myboardUpdate == 1) {
             int boardIdx = dto.getIdx();
             bs.myboardUpdate(dto);
             
             mav.addObject("msg", boardIdx + "번 게시물이 수정 되었습니다");
          }
          else {
             mav.addObject("msg", "수정 실패");
          }
      }
      mav.addObject("url", "mypage_default/myWrite");
       return  mav;
    }

	
	// 참여글 참여취소
	@GetMapping("/myJoinOut/{idx}")
	public ModelAndView myJoinDelete(@PathVariable int idx, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		BoardDTO board = bs.selectOne(idx);

		int row = js.deleteJoin(login.getUseremail(), idx);
		
		if(row == 1) {
			board.setNowMember(board.getNowMember() - 1);
			login.setJoinCnt(login.getJoinCnt() - 1);
			int row2 = bs.updateMember(board);
			int row3 = ms.updateJoinCnt(login);
		}
		mav.setViewName("redirect:/mypage_default/myJoin");
		return mav;
	}

}
