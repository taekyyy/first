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
public interface JoinDAO {

	
	@Insert("insert into join (joiner, boardIdx, writer, title, playDate, city)"
			+ "values(#{joiner}, #{boardIdx}, #{writer}, #{title} ,#{playDate}, #{city})")
	int insert(JoinDTO dto);
	
	@Select("select * from join where boardIdx = #{idx}")
	List<JoinDTO> selectJoiner(int idx);

	@Update("update join set joinstate=1 where joiner=#{useremail} and boardIdx=#{idx}")
	int updateState(@Param("useremail")String useremail, @Param("idx")int idx);
	
	@Select("select * from join where joiner=#{useremail} and boardIdx=#{idx}")
	JoinDTO searchJoin(@Param("useremail")String useremail, @Param("idx")int idx);

	@Select("select * from join where writer = #{writer}")
	List<JoinDTO> myJoin(String joinWriter);
	
	@Delete("delete join where joiner=#{useremail} and boardidx=#{idx}")
	int deleteJoin(@Param("useremail")String useremail, @Param("idx")int idx);
	
	/*마이페이지 작성글 */
	@Select("select * from join where writer = #{useremail}")
	ArrayList<JoinDTO> writeList(String useremail);

	@Select("select count(*) from join where joiner = #{useremail}")
	int countJoinCount(String useremail);

	/*마이페이지 참여글 */
	ArrayList<JoinDTO> joinList(@Param("useremail")String userEmail, @Param("start")int start, @Param("end")int end);

	@Select("select count(*) from reply where writer = #{useremail}")
	int countReplyCount(String useremail);

}
