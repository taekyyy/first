package com.itbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReplyDAO;
import com.itbank.model.ReplyDTO;

@Service
public class ReplyService {
		
	@Autowired private ReplyDAO dao;
	public List<ReplyDTO> selectReplyList(int idx) {
		
		return dao.selectReplyList(idx);
	}
	public int insertReply(ReplyDTO dto) {
		
		return dao.insertReply(dto);
	}
	public int deleteReply(int idx) {
		
		return dao.deleteReply(idx);
	}
	public ArrayList<ReplyDTO> replyList(String useremail, int start, int end) {
		
		return dao.replyList(useremail, start, end);
	}
		
	public int selectWrite(String useremail) {
		return dao.selectWrite(useremail);
	}
	public int deleteMyReply(String[] boardChk) {
		int row = 0;  
		for(String travelChkIdx : boardChk) {
			int idx = Integer.parseInt(travelChkIdx);
			System.out.println(idx);
	    	 row =  dao.deleteReply(idx);
	      }
		return row;
	}

}
