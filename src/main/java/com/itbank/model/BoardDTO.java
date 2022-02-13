package com.itbank.model;

import java.sql.Date;

//idx           number            default board_seq.nextval primary key,
//writer        varchar2(500)     not null,
//country       varchar2(200)     not null,
//city          varchar2(200)     not null,
//title         varchar2(500)     not null,
//writeDate     date              default sysdate,
//meetDate      date              not null,
//purpose       varchar2(500)     not null,
//content       varchar2(2000)    not null,
//maxMember     number            not null,
//nowMember     number            default 1,


public class BoardDTO {
	
	private int idx, maxMember, nowMember, startIndex, cntPerPage;
	private String writer, country, city, title, purpose, content;
	private Date writeDate, meetDate;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}
	public int getNowMember() {
		return nowMember;
	}
	public void setNowMember(int nowMember) {
		this.nowMember = nowMember;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	
	

}
