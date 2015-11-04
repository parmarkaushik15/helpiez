package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
public class LoginPojo implements Serializable{
	private Integer loginId;
	private String loginEmail;
	private String loginPassword;
	private String loginPasswordSalt;
	private String loginFirstTimeStatus;
	private Date loginLastDateTime;
	private String loginStatus;
	
	@JsonBackReference
	private RolePojo rolePojo;
	@JsonManagedReference
	private Set<UserRegistrationPojo> userRegistrationPojos;
	@JsonManagedReference
	private Set<NgoRegistrationPojo> ngoRegistrationPojos;
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getLoginPasswordSalt() {
		return loginPasswordSalt;
	}
	public void setLoginPasswordSalt(String loginPasswordSalt) {
		this.loginPasswordSalt = loginPasswordSalt;
	}
	public String getLoginFirstTimeStatus() {
		return loginFirstTimeStatus;
	}
	public void setLoginFirstTimeStatus(String loginFirstTimeStatus) {
		this.loginFirstTimeStatus = loginFirstTimeStatus;
	}
	public Date getLoginLastDateTime() {
		return loginLastDateTime;
	}
	public void setLoginLastDateTime(Date loginLastDateTime) {
		this.loginLastDateTime = loginLastDateTime;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public RolePojo getRolePojo() {
		return rolePojo;
	}
	public void setRolePojo(RolePojo rolePojo) {
		this.rolePojo = rolePojo;
	}
	public Set<UserRegistrationPojo> getUserRegistrationPojos() {
		return userRegistrationPojos;
	}
	public void setUserRegistrationPojos(
			Set<UserRegistrationPojo> userRegistrationPojos) {
		this.userRegistrationPojos = userRegistrationPojos;
	}
	public Set<NgoRegistrationPojo> getNgoRegistrationPojos() {
		return ngoRegistrationPojos;
	}
	public void setNgoRegistrationPojos(
			Set<NgoRegistrationPojo> ngoRegistrationPojos) {
		this.ngoRegistrationPojos = ngoRegistrationPojos;
	}
	
	
	
}
