package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.TravelDAO;
import com.itbank.model.TravelDTO;

@Service
public class TravelService {
	
	@Autowired TravelDAO dao;

	public TravelDTO selectOne(int idx) {
		return dao.selectOne(idx);
	}

	public List<TravelDTO> selectList(String search, int start, int end) {
		return dao.selectList(search, start, end);
	}
	
	public TravelDTO selectCity(String city) {
		return dao.selectCity(city);
	}

	public List<TravelDTO> selectContinent(String continent) {
		return dao.selectContinent(continent);
	}
	
	public List<TravelDTO> searchName(String search) {
		return dao.searchName(search);
	}

	public TravelDTO selectCityName(int idx) {
		
		return dao.selectCityName(idx);
	}

	public List<TravelDTO> selectCityInfo(String city) {
		
		return dao.selectCityInfo(city);
	}
	
	public int countTravelListAll() {
		return dao.countTravelListAll();
	}

	public int updateWishCnt(TravelDTO travel) {
		
		return dao.updateWishCnt(travel);
	}

	public int updateBoardCnt(TravelDTO travel) {
		return dao.updateBoardCnt(travel);
	}

	public List<TravelDTO> selectListAll(int start, int end) {
		return dao.selectListAll(start, end);
	}
	
	// 관리자 페이지에서 도시, 대륙, 나라 이름으로 검색하면 나오는 리스트의 수
	public int countTravelList(String search) {
		
		return dao.countTravelList(search);
	}


}
