package com.itbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.JoinDAO;
import com.itbank.model.JoinDTO;

@Service
public class JoinService {

	@Autowired private JoinDAO dao;
	
	public int insertJoin(JoinDTO dto) {
		
		return dao.insert(dto);
	}
	
	public List<JoinDTO> selectJoiner(int idx) {
		return dao.selectJoiner(idx);
	}
	
	public List<JoinDTO> myJoin(String joinWriter) {
		return dao.myJoin(joinWriter);
	}

	public int updateState(String useremail, int idx) {
		
		return dao.updateState(useremail, idx);
	}

	public JoinDTO searchJoin(String useremail, int idx) {
		
		return dao.searchJoin(useremail, idx);
	}

	public int deleteJoin(String useremail, int idx) {
		
		return dao.deleteJoin(useremail, idx);
	}
	
	/*마이페이지  참여글 찾기*/
	public ArrayList<JoinDTO> joinList(String userEmail, int start, int end) {
		return dao.joinList(userEmail, start, end);
	}

	public int countJoinCount(String useremail) {
		
		return dao.countJoinCount(useremail);
	}

	public int countReplyCount(String useremail) {
		
		return dao.countReplyCount(useremail);
	}



}
