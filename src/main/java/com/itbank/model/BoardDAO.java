package com.itbank.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO {
	
	@Insert("insert into board (writer, country, city, title, meetDate, purpose, content, maxMember) values"
			+ "(#{writer}, #{country}, #{city}, #{title}, #{meetDate}, #{purpose}, #{content}, #{maxMember})")
	int insert(BoardDTO dto);
	
	
	@Select("select * from board where city=#{city} order by writeDate desc offset 1 rows fetch first 5 rows only ")
	List<BoardDTO> selectCity(String city);

	
	@Select("select * from board where idx=#{idx}")
	BoardDTO selectOne(int idx);

	int update(BoardDTO board);

	int updateMember(BoardDTO board);

	@Delete("delete board where idx=#{idx}")
	int deleteBoard(int idx);
	
	@Select("select count(*) from board where city=#{city}")
	int countBoard(String city);

	
	// 전체 게시글 리스트 수 (반환형 숫자)
	@Select("select count(*) from board")
	int countBoardAll();
	
	// 전체 게시글 리스트 페이징(반환형 리스트)
	List<BoardDTO> selectBoard(PagingDTO page);
	
	// 도시별 게시글 리스트 페이징(반환형 리스트)
	List<BoardDTO> selectBoardCity(@Param("city")String city, @Param("start")int start, @Param("end")int end);

	@Select("select count(*) from board where writer=#{useremail}")
	int countBoardWriter(String useremail);
	
	@Delete("delete board where idx=#{idx}")
	int myBoardDelete(int idx);
	
	// 관리자 게시글 리스트 페이징()
	List<BoardDTO> selectBoardAll(@Param("start")int start, @Param("end")int end);
	
	ArrayList<BoardDTO> writeList(@Param("useremail")String useremail, @Param("start")int start, @Param("end")int end);
	
	@Select("select * from board where idx = #{idx}")
	BoardDTO myboardSearch(int idx);

	@Update("update board set writeDate=sysdate, meetDate=#{meetDate}, purpose=#{purpose}, content=#{content}, maxMember=#{maxMember} where idx=#{idx}")
	int myboardUpdate(BoardDTO dto);
	
	@Select("select * from board where idx = #{idx}")
	BoardDTO myboardSelectOne(int idx);

	@Select("select count(*) from board where content like '%${search}%' or writer like '%${search}%'")
	int countSearchList(String search);
	
	List<BoardDTO> searchBoardList(@Param("search")String search, @Param("start")int start, @Param("end")int end);
}
