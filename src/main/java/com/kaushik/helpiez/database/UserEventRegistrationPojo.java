package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
public class UserEventRegistrationPojo implements Serializable{
	private Integer userEventRegistrationId;
	private Date userEventRegistrationDate;
	private String userEventRegistrationStatus;
	
	@JsonBackReference
	private NgoEventPojo ngoEventPojo;
	@JsonBackReference
	private UserRegistrationPojo userRegistrationPojo;
	
	public Integer getUserEventRegistrationId() {
		return userEventRegistrationId;
	}
	public void setUserEventRegistrationId(Integer userEventRegistrationId) {
		this.userEventRegistrationId = userEventRegistrationId;
	}
	public Date getUserEventRegistrationDate() {
		return userEventRegistrationDate;
	}
	public void setUserEventRegistrationDate(Date userEventRegistrationDate) {
		this.userEventRegistrationDate = userEventRegistrationDate;
	}
	public String getUserEventRegistrationStatus() {
		return userEventRegistrationStatus;
	}
	public void setUserEventRegistrationStatus(String userEventRegistrationStatus) {
		this.userEventRegistrationStatus = userEventRegistrationStatus;
	}
	public NgoEventPojo getNgoEventPojo() {
		return ngoEventPojo;
	}
	public void setNgoEventPojo(NgoEventPojo ngoEventPojo) {
		this.ngoEventPojo = ngoEventPojo;
	}
	public UserRegistrationPojo getUserRegistrationPojo() {
		return userRegistrationPojo;
	}
	public void setUserRegistrationPojo(UserRegistrationPojo userRegistrationPojo) {
		this.userRegistrationPojo = userRegistrationPojo;
	}
	
	
	
}
