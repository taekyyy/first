package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelDAO {
	
	// 전체 도시별 리스트 띄우기 (관리자 페이지, 페이징 적용)
	List<TravelDTO> selectList(@Param("search")String search, @Param("start")int start, @Param("end")int end);
	
	@Select("select * from travel where idx=#{idx}")
	TravelDTO selectOne(int idx);

	@Select("select * from travel where city=#{city}")
	TravelDTO selectCity(String city);

	@Select("select * from travel where continent=#{continent}")
	List<TravelDTO> selectContinent(String continent);
	
	@Select("select * from travel where continent like '%${search}%' or country like '%${search}%' or city like '%${search}%'")
	List<TravelDTO> searchName(String search);
	
	@Select("select * from travel where idx=#{idx}")
	TravelDTO selectCityName(int idx);
	
	@Select("select * from travel where city=#{city}")
	List<TravelDTO> selectCityInfo(String city);
	
	@Select("select count(*) from travel")
	int countTravelListAll();

	
	int updateWishCnt(TravelDTO travel);
	
	int updateBoardCnt(TravelDTO travel);
	
	List<TravelDTO> selectListAll(@Param("start")int start, @Param("end")int end);
	
	@Select("select count(*) from travel where continent like '%${search}%' or country like '%${search}%' or city like '%${search}%'")
	int countTravelList(String search);

}
