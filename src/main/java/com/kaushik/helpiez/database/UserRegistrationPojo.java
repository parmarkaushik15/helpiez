package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@SuppressWarnings("serial")
public class UserRegistrationPojo implements Serializable{
	private Integer userId;
	private Date userRegistrationDate;
	private String userFirstName;
	private String userLastName;
	private String userEmailId;
	private Date userDateofBirth;
	private String userContactNumber;
	private String userCountry;
	private String userStatus;
	
	@JsonBackReference
	private LoginPojo loginPojo;
	
	@JsonManagedReference
	private Set<UserEventRegistrationPojo> eventRegistrationPojos;
	@JsonManagedReference
	private Set<UserSubscriptionPojo> userSubscriptionPojos;
	
	
	
	public Date getUserRegistrationDate() {
		return userRegistrationDate;
	}
	public void setUserRegistrationDate(Date userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public Date getUserDateofBirth() {
		return userDateofBirth;
	}
	public void setUserDateofBirth(Date userDateofBirth) {
		this.userDateofBirth = userDateofBirth;
	}
	public String getUserContactNumber() {
		return userContactNumber;
	}
	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public LoginPojo getLoginPojo() {
		return loginPojo;
	}
	public void setLoginPojo(LoginPojo loginPojo) {
		this.loginPojo = loginPojo;
	}
	public Set<UserEventRegistrationPojo> getEventRegistrationPojos() {
		return eventRegistrationPojos;
	}
	public void setEventRegistrationPojos(
			Set<UserEventRegistrationPojo> eventRegistrationPojos) {
		this.eventRegistrationPojos = eventRegistrationPojos;
	}
	public Set<UserSubscriptionPojo> getUserSubscriptionPojos() {
		return userSubscriptionPojos;
	}
	public void setUserSubscriptionPojos(
			Set<UserSubscriptionPojo> userSubscriptionPojos) {
		this.userSubscriptionPojos = userSubscriptionPojos;
	}
	
	
}
