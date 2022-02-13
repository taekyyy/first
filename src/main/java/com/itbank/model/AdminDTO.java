package com.itbank.model;

public class AdminDTO {
	
	private String adminemail, adminname, adminpw;
	private int membercnt, travelcnt, boardcnt, wishcnt;
	
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpw() {
		return adminpw;
	}
	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}
	public int getMembercnt() {
		return membercnt;
	}
	public void setMembercnt(int membercnt) {
		this.membercnt = membercnt;
	}
	public int getTravelcnt() {
		return travelcnt;
	}
	public void setTravelcnt(int travelcnt) {
		this.travelcnt = travelcnt;
	}
	public int getBoardcnt() {
		return boardcnt;
	}
	public void setBoardcnt(int boardcnt) {
		this.boardcnt = boardcnt;
	}
	public int getWishcnt() {
		return wishcnt;
	}
	public void setWishcnt(int wishcnt) {
		this.wishcnt = wishcnt;
	}

}
