package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {

	@Select("select * from admin where adminpw=#{adminpw}")
	AdminDTO adminLogin(AdminDTO dto);

   @Select("select * from member where useremail=#{useremail} and userpw=#{userpw} and resignState=1")
   MemberDTO login(MemberDTO dto);
   
   @Select("select count(*) from member where useremail=#{useremail}")
   int EailChk(String email);

   int insert(MemberDTO dto);

   int update(MemberDTO dto);
   
   @Select("select * from member where useremail=#{useremail}")
   List<MemberDTO> selectUserList(String useremail);

   @Select("select count(*) from member")
   int countMemberListAll();
   
   int updateWishCnt(MemberDTO login);
   
   @Update("update member set writeCnt = #{writeCnt} where useremail=#{useremail}")
   int updateWriteCnt(MemberDTO login);
   
   @Update("update member set joinCnt = #{joinCnt} where useremail=#{useremail}")
   int updateJoinCnt(MemberDTO login);

   List<MemberDTO> selectMemberAll(@Param("start")int start, @Param("end")int end);

   @Select("select * from member where idx=#{idx}")
   MemberDTO selectUser(int idx);
   
   @Delete("delete member where idx=#{idx}")
   int deleteMember(int idx);

   @Select("select count(*) from member where useremail like '%${search}%' or username like '%${search}%'")
   int countMember(String search);

   List<MemberDTO> selectMember(@Param("search")String search, @Param("start")int start, @Param("end")int end);
   
   @Select("select * from member where useremail=#{writer}")
   MemberDTO selectUsers(String writer);

   
   
}