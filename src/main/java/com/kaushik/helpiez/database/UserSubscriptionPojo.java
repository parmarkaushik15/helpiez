package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
public class UserSubscriptionPojo implements Serializable{

	private Integer userSubscribeId;
	private Date userSubscribeDate;
	private String userSubscribeStatus;
	
	@JsonBackReference
	private NgoRegistrationPojo ngoRegistrationPojo;
	@JsonBackReference
	private UserRegistrationPojo userRegistrationPojo;
	
	public Integer getUserSubscribeId() {
		return userSubscribeId;
	}
	public void setUserSubscribeId(Integer userSubscribeId) {
		this.userSubscribeId = userSubscribeId;
	}
	public Date getUserSubscribeDate() {
		return userSubscribeDate;
	}
	public void setUserSubscribeDate(Date userSubscribeDate) {
		this.userSubscribeDate = userSubscribeDate;
	}
	public String getUserSubscribeStatus() {
		return userSubscribeStatus;
	}
	public void setUserSubscribeStatus(String userSubscribeStatus) {
		this.userSubscribeStatus = userSubscribeStatus;
	}
	public NgoRegistrationPojo getNgoRegistrationPojo() {
		return ngoRegistrationPojo;
	}
	public void setNgoRegistrationPojo(NgoRegistrationPojo ngoRegistrationPojo) {
		this.ngoRegistrationPojo = ngoRegistrationPojo;
	}
	public UserRegistrationPojo getUserRegistrationPojo() {
		return userRegistrationPojo;
	}
	public void setUserRegistrationPojo(UserRegistrationPojo userRegistrationPojo) {
		this.userRegistrationPojo = userRegistrationPojo;
	}
	
	
	
}
