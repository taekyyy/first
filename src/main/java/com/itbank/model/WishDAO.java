package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WishDAO {

	@Select("select * from wish where wisher=#{wisher} and wishCity=#{wishCity}")
	List<WishDTO> selectWish(HashMap<String, Object> ret);

	@Insert("insert into wish (wisher,wishCountry,wishCity,wishImg) values (#{wisher},#{wishCountry},#{wishCity},#{wishImg})")
	int insert(HashMap<String, Object> ret);

	@Delete("delete wish where wisher=#{wisher} and wishCity = #{wishCity}")
	int delete(HashMap<String, Object> ret);

	@Select("select count(*) from wish")
	int countWishListAll();

	@Select("select count(*) from wish where wisher=#{useremail}")
	int countWishWriter(String useremail);

	@Select("select * from wish where wisher=#{useremail}")
	List<WishDTO> selectUser(String useremail);

	@Select("select count(*) from wish where wisher=#{wisher} and wishCity=#{wishCity}")
	int selectWish1(HashMap<String, Object> ret);

}
