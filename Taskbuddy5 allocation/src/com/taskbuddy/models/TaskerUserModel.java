package com.taskbuddy.models;

public class TaskerUserModel {
	private int loginid;
	private int taskerid;
	private String userFirstName;
	private String userLastName;
	private String contactno;
	private double charge;
	private int rating;
	
	
	
	public TaskerUserModel() 
	{
		this(0,0,"","","",0.0,0);
	}

	public TaskerUserModel(int loginid,int taskerid,String userFirstName, String userLastName, String contactno, double charge, int rating) {
		this.loginid=loginid;
		this.taskerid=taskerid;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.contactno = contactno;
		this.charge = charge;
		this.rating=rating;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public int getTaskerid() {
		return taskerid;
	}

	public void setTaskerid(int taskerid) {
		this.taskerid = taskerid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "TaskerUserModel [loginid=" + loginid + ", taskerid=" + taskerid + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", contactno=" + contactno + ", charge=" + charge + ", rating="
				+ rating + "]";
	}
	
}
