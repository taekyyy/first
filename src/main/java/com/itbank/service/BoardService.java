package com.itbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.BoardDTO;
import com.itbank.model.MemberDAO;
import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.TravelDAO;
import com.itbank.model.TravelDTO;

@Service
public class BoardService {
	
	@Autowired private BoardDAO dao;
	@Autowired private MemberDAO mdao;
	@Autowired private TravelDAO tdao;
	
	
	public BoardDTO myboardSearch(int idx) {
		return dao.myboardSearch(idx);
	}
	
	public BoardDTO myboardSelectOne(int idx) {
		return dao.myboardSelectOne(idx);
	}


	public int myboardUpdate(BoardDTO dto) {
		return dao.myboardUpdate(dto);
	}
	

	public int insertBoard(BoardDTO dto) {
		
		return dao.insert(dto);
	}

	public List<BoardDTO> selectCity(String city) {
		return dao.selectCity(city);
	}

	public BoardDTO selectOne(int idx) {

		return dao.selectOne(idx);
	}
	
	public int countBoard(String city) {
		return dao.countBoard(city);
	}
	
	
	public int update(BoardDTO board) {
		return dao.update(board);
	}

	public int updateMember(BoardDTO board) {
		
		return dao.updateMember(board);
	}

	public int deleteBoard(int idx) {
		
		return dao.deleteBoard(idx);
	}
	
	public List<BoardDTO> selectBoard(PagingDTO page) {
		return dao.selectBoard(page);
	}
	
	public int countBoardAll() {
		return dao.countBoardAll();
	}
	
	public List<BoardDTO> selectBoardCity(String city, int start, int end) {
		
		return dao.selectBoardCity(city, start, end);
	}

	public int countBoardWriter(String useremail) {
		
		return dao.countBoardWriter(useremail);
	}

	public ArrayList<BoardDTO> writeList(String useremail, int start, int end) {
		
		return dao.writeList(useremail, start, end);
	}

	public int myBoardDelete(String[] boardChk) {
	       int row = 0;  
	      for(String boardChkIdx : boardChk) {
	         int idx = Integer.parseInt(boardChkIdx);
	         System.out.println(idx);
	         BoardDTO dto = dao.myboardSelectOne(idx);
	         MemberDTO login = mdao.selectUsers(dto.getWriter());
	         TravelDTO travel = tdao.selectCity(dto.getCity());
	          row = dao.myBoardDelete(idx);
	          
	          if(row == 1) {
	             login.setWriteCnt(login.getWriteCnt() - 1);
	             travel.setBoardCnt(travel.getBoardCnt() - 1);
	             int row2 = mdao.updateWriteCnt(login);
	             int row3 = tdao.updateBoardCnt(travel);
	          }
	         }
	       return row;
	   }
	
	public List<BoardDTO> selectBoardAll(int start, int end) {
		return dao.selectBoardAll(start, end);
	}

	public int countSearchList(String search) {
		return dao.countSearchList(search);
	}

	public List<BoardDTO> searchBoardList(String search, int start, int end) {
		return dao.searchBoardList(search, start, end);
	}


	
}
