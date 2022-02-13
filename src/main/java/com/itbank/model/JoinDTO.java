package com.itbank.model;

import java.sql.Date;

//idx           number           default join_seq.nextval primary key,
//joiner        varchar2(500)    not null,
//boardIdx      number           not null,
//writer        varchar2(500)    not null,
//title         varchar2(500)    not null,
//playDate      date             not null,
//city          varchar2(500)    not null,

public class JoinDTO {
	private int idx, boardIdx;
	private String joiner, writer, title, city;
	private Date playDate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getJoiner() {
		return joiner;
	}
	public void setJoiner(String joiner) {
		this.joiner = joiner;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	
	
}
