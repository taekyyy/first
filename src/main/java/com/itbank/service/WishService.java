package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.WishDAO;
import com.itbank.model.WishDTO;

@Service
public class WishService {

	@Autowired private WishDAO dao;

	public List<WishDTO> selectWish(HashMap<String, Object> ret) {
		return dao.selectWish(ret);
	}

	public int insert(HashMap<String, Object> ret) {
		return dao.insert(ret);
	}

	public int delete(HashMap<String, Object> ret) {
		return dao.delete(ret);
	}

	public int countWishListAll() {
		return dao.countWishListAll();
	}

	public int countWishWriter(String useremail) {
		
		return dao.countWishWriter(useremail);
	}

	public List<WishDTO> selectUser(String useremail) {
		return dao.selectUser(useremail);
	}

	/* 위시리스트 하트*/
	public int selectWish1(HashMap<String, Object> ret) {
		return dao.selectWish1(ret);
	}

	

}
