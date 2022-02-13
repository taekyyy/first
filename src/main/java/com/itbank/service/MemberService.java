package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.AdminDTO;
import com.itbank.model.MemberDAO;
import com.itbank.model.MemberDTO;

@Service
public class MemberService {
   
   @Autowired private MemberDAO dao;

   public int join(MemberDTO dto) {
      int row = dao.insert(dto);
      return row;
   }

   public MemberDTO login(MemberDTO dto) {
      return dao.login(dto);
   }

   public int EmailChk(String email) {
      return dao.EailChk(email);
   }

   public int update(MemberDTO dto) {
      return dao.update(dto);
   }

   public List<MemberDTO> selectUserList(String useremail) {
      return dao.selectUserList(useremail);
   }

   public AdminDTO adminLogin(AdminDTO dto) {
		return dao.adminLogin(dto);
	}

	public int updateWishCnt(MemberDTO login) {
		
		return dao.updateWishCnt(login);
	}

	public int updateWriteCnt(MemberDTO login) {
		
		return dao.updateWriteCnt(login);
	}
	
	public int countMemberListAll() {
		return dao.countMemberListAll();
	}

	public int updateJoinCnt(MemberDTO login) {
		return dao.updateJoinCnt(login);
		
	}
	
//	public List<MemberDTO> selectMemberAll(String search) {
//		return dao.selectMemberAll(search);
//	}

	public List<MemberDTO> selectMemberAll(int start, int end) {
		
		return dao.selectMemberAll(start, end);
	}

	public MemberDTO selectUser(int idx) {
		
		return dao.selectUser(idx);
	}
	
	public int memberDelete(String[] boardChk) {
		  int row = 0;  
			for(String memberChkIdx : boardChk) {
				int idx = Integer.parseInt(memberChkIdx);
				System.out.println(idx);
		    	 row =  dao.deleteMember(idx);
		      }
		    return row;
	}

	public int countMember(String search) {
		
		return dao.countMember(search);
	}

	public List<MemberDTO> selectMember(String search, int start, int end) {
		return dao.selectMember(search ,start, end);
	}

}
