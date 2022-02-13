package com.itbank.model;

//idx           number            default member_seq.nextval primary key,
//useremail     varchar2(500)     unique,
//username      varchar2(500)     not null,
//userpw        varchar2(500)     not null,
//resignState   number            default 1,
//writeCnt      number            default 0,
//joinCnt       number            default 0,
//wishCnt       number            default 0


public class MemberDTO {
	
	private int idx, resignState, writeCnt, joinCnt, wishCnt;
	private String useremail, username, userpw;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getResignState() {
		return resignState;
	}
	public void setResignState(int resignState) {
		this.resignState = resignState;
	}
	public int getWriteCnt() {
		return writeCnt;
	}
	public void setWriteCnt(int writeCnt) {
		this.writeCnt = writeCnt;
	}
	public int getJoinCnt() {
		return joinCnt;
	}
	public void setJoinCnt(int joinCnt) {
		this.joinCnt = joinCnt;
	}
	public int getWishCnt() {
		return wishCnt;
	}
	public void setWishCnt(int wishCnt) {
		this.wishCnt = wishCnt;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	

}
