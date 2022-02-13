package com.itbank.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDAO {
	
	@Select("select * from reply where boardIdx=#{idx}")
	List<ReplyDTO> selectReplyList(int idx);
	
	@Insert("insert into reply (boardIdx, writer, content)"
			+ "values(#{boardIdx}, #{writer}, #{content})")
	int insertReply(ReplyDTO dto);

	@Delete("delete reply where idx=#{idx}")
	int deleteReply(int idx);

	ArrayList<ReplyDTO> replyList(@Param("useremail")String useremail, @Param("start")int start, @Param("end")int end);


	@Select("select count(*) from reply where writer=#{useremail}")
	int selectWrite(String useremail);

	
}
