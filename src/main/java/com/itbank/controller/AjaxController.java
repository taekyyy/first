package com.itbank.controller;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.Hash;
import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDTO;
import com.itbank.model.ReplyDTO;
import com.itbank.model.TravelDTO;
import com.itbank.model.WishDTO;
import com.itbank.service.BoardService;
import com.itbank.service.MailService;
import com.itbank.service.MemberService;
import com.itbank.service.ReplyService;
import com.itbank.service.TravelService;
import com.itbank.service.WishService;

@RestController
public class AjaxController {
	
	@Autowired private TravelService ts;
	@Autowired private MemberService ms;
	@Autowired private Hash hash;
	@Autowired private BoardService bs;
	@Autowired private MailService mailService;
	@Autowired private WishService ws;
	@Autowired private ReplyService rs;
	
	@GetMapping("/myboardSelectOne/{idx}")
	public BoardDTO myboardSearch(@PathVariable int idx) {
		return bs.myboardSelectOne(idx);
	}
	
	@GetMapping("/mypage_update")
	public List<MemberDTO> selectUserList(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		MemberDTO login = (MemberDTO) session.getAttribute("login");
		MemberDTO info = ms.login(login);
		mav.addObject("info", info);

		return ms.selectUserList(info.getUseremail());
	}

	@PostMapping("/mypage_update")
	public int updateUserList(@RequestBody MemberDTO dto, HttpSession session) {
		System.out.println(dto.getUseremail());
		String encPw = hash.getHash(dto.getUserpw()).substring(0, 12);
		dto.setUserpw(encPw);
		dto.setResignState(1);
		int row = ms.update(dto);
		if (row == 1)	session.removeAttribute("login");
		return row;
	}
	
	@GetMapping("/mypage_delete")
	public int deleteUser(HttpSession session) {
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.println(login.getResignState());
		login.setResignState(0);
		int row = ms.update(login);
		return row;
	}
	
    @PostMapping("/newPass/{email:.+}")
    public int newPass(@PathVariable String email, @RequestBody String newPass) {
    	System.out.println(email);
    	System.out.println(newPass);
    	MemberDTO dto = new MemberDTO();
    	dto.setUseremail(email);
    	String encPw = hash.getHash(newPass).substring(0,12);
    	dto.setUserpw(encPw);
    	dto.setResignState(1);
    	int row = ms.update(dto);
    	return row;
    }
    
    @GetMapping("/cities/{idx}")
    public HashMap<String, Object> selectOne(@PathVariable int idx, HttpSession session) {
       HashMap<String, Object> ret = new HashMap<String, Object>();
       TravelDTO travel = ts.selectOne(idx);
       MemberDTO login = (MemberDTO) session.getAttribute("login");
       
       System.out.println(travel);
       if(login == null ) {
          ret.put("msg", "로그인이 필요합니다");
       }
       else {
          ret.put("wisher", login.getUseremail());
          ret.put("wishCity", travel.getCity());
          
          int wishChk = ws.selectWish1(ret);
          System.out.println(wishChk);
          ret.put("wishChk", wishChk);
          ret.put("wishCnt", travel.getWishCnt());
          ret.put("travel", travel);
       }
       return ret;
    }
	
	@GetMapping(value = "/wish/{city}", produces = "application/json;charset=utf-8")
	public HashMap<String, Object> wish(@PathVariable String city, HttpSession session) {
		HashMap<String, Object> ret = new HashMap<String, Object>();
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		TravelDTO travel = ts.selectCity(city);
		
			// wish디비에 유저/city가 있는지 확인
			ret.put("wisher", login.getUseremail());
			ret.put("wishCity", city);
			ret.put("wishCountry", travel.getCountry());
			ret.put("wishImg", travel.getMainImg());
			int wishChk = ws.selectWish1(ret);
			System.out.println(wishChk);
			
			// 있으면 delete
			if (wishChk == 1) {
				int row = ws.delete(ret);
				if (row == 1) {
					login.setWishCnt(login.getWishCnt() - 1);
					travel.setWishCnt(travel.getWishCnt() - 1);
					int row2 = ms.updateWishCnt(login);
					int row3 = ts.updateWishCnt(travel);
				}
			}
			// 없으면 insert
			else {
				int row = ws.insert(ret);
				if (row == 1) {
					login.setWishCnt(login.getWishCnt() + 1);
					travel.setWishCnt(travel.getWishCnt() + 1);
					int row2 = ms.updateWishCnt(login);
					int row3 = ts.updateWishCnt(travel);
					
				}
			}
		ret.put("wishChk", wishChk);
		ret.put("wishCnt", travel.getWishCnt());
		return ret;
	}
	
	@GetMapping("/mypage_default/{city}")
	public List<TravelDTO> selectCityInfo(@PathVariable String city, HttpSession session) {
		return ts.selectCityInfo(city);
	}
	
	@PostMapping("/party")
	public int insertBoard(@RequestBody BoardDTO dto, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		
		System.out.println(login.getWriteCnt());
		login.setWriteCnt(login.getWriteCnt() + 1);
		int row = bs.insertBoard(dto);
		if(row == 1) {
			int row2 = ms.updateWriteCnt(login);
			System.out.println(dto.getCity());
			TravelDTO travel = ts.selectCity(dto.getCity());
			travel.setBoardCnt(travel.getBoardCnt() + 1);
			int row3 = ts.updateBoardCnt(travel);
			System.out.println("수정 성공!");
			
		}
		
		return row;
	}
	
	@PostMapping("/replyInsert")
	public int insertReply(@RequestBody ReplyDTO dto) {

		return rs.insertReply(dto);
	}
	
	@DeleteMapping("/deleteReply/{idx}")
	public int deleteReply(@PathVariable int idx) {
		return rs.deleteReply(idx);
	}
	
	@GetMapping("/deleteBoard/{idx}")
	public int deleteBoard(@PathVariable int idx, HttpSession session) {
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		BoardDTO board = bs.selectOne(idx);
		TravelDTO travel = ts.selectCity(board.getCity());
		int row = bs.deleteBoard(idx);
		if(row == 1) {
			System.out.println(login.getWriteCnt());
			login.setWriteCnt(login.getWriteCnt() - 1);
			travel.setBoardCnt(travel.getBoardCnt() - 1);
			int row2 = ms.updateWriteCnt(login);
			int row3 = ts.updateBoardCnt(travel);
			System.out.println("수정 성공!");
		}
		return row;
	}
	
	@PostMapping("/emailDuplicate")
	public int EmailDuplication(@RequestBody String email) {
		System.out.println(email);
		System.out.println(ms.EmailChk(email));
		
		return ms.EmailChk(email);
	}
	
	 @GetMapping("/emailDuplicate/{email:.+}/")
	   public HashMap<String, String> mailto(@PathVariable String email, HttpSession session) throws IOException {
		   HashMap<String, String> ret = new HashMap<String, String>();
		   System.out.println("인증받을 email : " + email);
		   if(ms.EmailChk(email) == 0) {
			   System.out.println("가입되지 않은 메일입니다");
			   ret.put("status", "Fail");
			   ret.put("message","가입되지 않은 계정 정보 입니다");
			   return ret;
		   }

		   String authNumber = mailService.getAuthNumber();
		   System.out.println("인증번호 : " + authNumber);
		   String hashNumber = hash.getHash(authNumber);
		   session.setAttribute("hashNumber", hashNumber);
		   
		   String account = null;
		   String filePath = session.getServletContext().getRealPath("/WEB-INF/data/account.dat");
		   
		   File f= new File(filePath);
		   if(f.exists() == false) {
			   System.out.println("메일을 전송하는 계정이 없습니다");
			   return null;
		   }
		   
		   Scanner sc = new Scanner(f);
		   while(sc.hasNextLine()) {
			   account = sc.nextLine();
		   }
		   sc.close();
		   
		   String result = mailService.sendMail(email, authNumber, account);
		   
		   if(result.equals(authNumber)) {
			   ret.put("status","OK");
			   ret.put("message","인증번호가 발송되었습니다");
		   }
		   else {
			   ret.put("status","Fail");
			   ret.put("message","인증번호 발송을 실패하였습니다");
		   }
		   return ret;
	   }

	   @GetMapping("/getCodeChkResult/{checkNumber}/")
	   public HashMap<String, String> getCodeChkResult(@PathVariable String checkNumber, HttpSession session) {
		   String sessionHash = (String) session.getAttribute("hashNumber");
		   String userHash = hash.getHash(checkNumber);
		   boolean flag = userHash.equals(sessionHash);
		   
		   HashMap<String, String> ret = new HashMap<String, String>();
		   ret.put("status",flag ? "OK" : "Fail");
		   ret.put("message", flag? "인증완료" : "인증번호를 다시 확인해주세요");
		   
		   return ret;
	   }
}
