package com.taskbuddy.entities;
// Generated 8 Dec, 2016 8:35:06 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Operation generated by hbm2java
 */
@Entity
@Table(name = "OPERATION", catalog = "taskbuddy")
public class Operation implements java.io.Serializable {

	private Integer opid;
	private Logininfo logininfo;
	private Taskerinfo taskerinfo;
	private String addressdetails;
	private String reveiw;
	private int rating;
	private String date;

	public Operation() {
	}

	public Operation(Logininfo logininfo, Taskerinfo taskerinfo,String addressdetails, String reveiw, int rating, String date) {
		this.logininfo = logininfo;
		this.taskerinfo = taskerinfo;
		this.addressdetails=addressdetails;
		this.reveiw = reveiw;
		this.rating = rating;
		this.date = date;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OPID", unique = true, nullable = false)
	public Integer getOpid() {
		return this.opid;
	}

	public void setOpid(Integer opid) {
		this.opid = opid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOGINID", nullable = false)
	public Logininfo getLogininfo() {
		return this.logininfo;
	}

	public void setLogininfo(Logininfo logininfo) {
		this.logininfo = logininfo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TASKERID", nullable = false)
	public Taskerinfo getTaskerinfo() {
		return this.taskerinfo;
	}

	public void setTaskerinfo(Taskerinfo taskerinfo) {
		this.taskerinfo = taskerinfo;
	}

	@Column(name = "REVEIW", nullable = false, length = 65535)
	public String getReveiw() {
		return this.reveiw;
	}

	public void setReveiw(String reveiw) {
		this.reveiw = reveiw;
	}

	@Column(name = "RATING", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "DATE", nullable = false, length = 20)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name = "ADDRESSDETAIL", nullable = false, length = 65535)
	public String getAddressdetails() {
		return addressdetails;
	}

	public void setAddressdetails(String addressdetails) {
		this.addressdetails = addressdetails;
	}

	@Override
	public String toString() {
		return "Operation [opid=" + opid + ", logininfo=" + logininfo + ", taskerinfo=" + taskerinfo
				+ ", addressdetails=" + addressdetails + ", reveiw=" + reveiw + ", rating=" + rating + ", date=" + date
				+ "]";
	}

	
	
}
