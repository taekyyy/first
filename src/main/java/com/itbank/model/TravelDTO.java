package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//idx           number            default travel_seq.nextval primary key,
//continent     varchar2(200)     not null,
//country       varchar2(200)     not null,
//city          varchar2(200)     unique,
//wishCnt       number            default 0,
//timeD         number            not null,
//lati          number            not null,
//longi         number            not null,
//visa          varchar2(200)     not null,
//content       varchar2(2000)    not null,
//mainImg       varchar2(500)     not null,
//subImg1       varchar2(500)     not null,
//subImg2       varchar2(500)     not null,
//subImg3       varchar2(500)     not null,
//subImg4       varchar2(500)     not null,
//subImg5       varchar2(500)     not null,
//resignState   number            default 1

public class TravelDTO {
	private int idx, wishCnt, timeD, resignState, boardCnt;
	private double lati, longi;
	
	private String continent, country, city, visa, content, mainImg;
	private String subImg1, subImg2, subImg3, subImg4, subImg5;
	private MultipartFile uploadMain;
	private MultipartFile uploadSub1, uploadSub2, uploadSub3, uploadSub4, uploadSub5;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getWishCnt() {
		return wishCnt;
	}
	public void setWishCnt(int wishCnt) {
		this.wishCnt = wishCnt;
	}
	public int getTimeD() {
		return timeD;
	}
	public void setTimeD(int timeD) {
		this.timeD = timeD;
	}

	public int getResignState() {
		return resignState;
	}
	public void setResignState(int resignState) {
		this.resignState = resignState;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	public String getSubImg1() {
		return subImg1;
	}
	public void setSubImg1(String subImg1) {
		this.subImg1 = subImg1;
	}
	public String getSubImg2() {
		return subImg2;
	}
	public void setSubImg2(String subImg2) {
		this.subImg2 = subImg2;
	}
	public String getSubImg3() {
		return subImg3;
	}
	public void setSubImg3(String subImg3) {
		this.subImg3 = subImg3;
	}
	public String getSubImg4() {
		return subImg4;
	}
	public void setSubImg4(String subImg4) {
		this.subImg4 = subImg4;
	}
	public String getSubImg5() {
		return subImg5;
	}
	public void setSubImg5(String subImg5) {
		this.subImg5 = subImg5;
	}
	public int getBoardCnt() {
		return boardCnt;
	}
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}
	public double getLati() {
		return lati;
	}
	public void setLati(double lati) {
		this.lati = lati;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public MultipartFile getUploadMain() {
		return uploadMain;
	}
	public void setUploadMain(MultipartFile uploadMain) {
		this.uploadMain = uploadMain;
	}
	public MultipartFile getUploadSub1() {
		return uploadSub1;
	}
	public void setUploadSub1(MultipartFile uploadSub1) {
		this.uploadSub1 = uploadSub1;
	}
	public MultipartFile getUploadSub2() {
		return uploadSub2;
	}
	public void setUploadSub2(MultipartFile uploadSub2) {
		this.uploadSub2 = uploadSub2;
	}
	public MultipartFile getUploadSub3() {
		return uploadSub3;
	}
	public void setUploadSub3(MultipartFile uploadSub3) {
		this.uploadSub3 = uploadSub3;
	}
	public MultipartFile getUploadSub4() {
		return uploadSub4;
	}
	public void setUploadSub4(MultipartFile uploadSub4) {
		this.uploadSub4 = uploadSub4;
	}
	public MultipartFile getUploadSub5() {
		return uploadSub5;
	}
	public void setUploadSub5(MultipartFile uploadSub5) {
		this.uploadSub5 = uploadSub5;
	}
	
	
	
}
