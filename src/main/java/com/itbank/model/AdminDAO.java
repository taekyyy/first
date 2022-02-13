package com.itbank.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO {
	
	@Select("select * from admin")
	AdminDTO admin(AdminDTO dto);

	@Update("update admin set membercnt=#{membercnt},wishcnt=#{wishcnt},travelcnt=#{travelcnt},boardcnt=#{boardcnt}")
	int update(AdminDTO dto);
	
	@Insert("insert into travel (continent, country, city, timeD, lati, longi, visa, content, mainImg, subImg1, subImg2, subImg3, subImg4, subImg5)"
			+ " values (#{continent}, #{country}, #{city}, #{timeD}, #{lati}, #{longi}, #{visa}, #{content}, #{mainImg}, #{subImg1}, #{subImg2}, #{subImg3}, #{subImg4}, #{subImg5})")
	int insert(TravelDTO dto);
	
	@Delete("delete travel where idx=#{idx}")
	int deleteTravel(int idx);

}
