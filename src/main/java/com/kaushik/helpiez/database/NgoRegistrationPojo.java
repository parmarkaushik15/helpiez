package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
public class NgoRegistrationPojo implements Serializable{
	private Integer ngoId;
	private Date ngoRegistrationDate;
	private String ngoName;
	private String ngoCause;
	private String ngoEmailId;
	private String ngoContactNumber;
	private String ngoAlternativeContactNumber;
	private String ngoHeadOfficeAddress1;
	private String ngoHeadOfficeAddress2;
	private String ngoHeadOfficeAddressCity;
	private String ngoHeadOfficeAddressState;
	private String ngoHeadOfficeAddressCountry;
	private String ngoHeadOfficeAddressPincode;
	private String ngoImageLogo;
	private String ngoLocationLongitude;
	private String ngoLocationLatitude;
	private String ngoStatus;
	
	@JsonBackReference
	private NgoCategoryPojo ngoCategoryPojo;
	@JsonBackReference
	private LoginPojo loginPojo;
	
	@JsonManagedReference
	private Set<NgoEventPojo> eventPojos;
	@JsonManagedReference
	private Set<UserSubscriptionPojo> userSubscriptionPojos;
	
	
	
	public Date getNgoRegistrationDate() {
		return ngoRegistrationDate;
	}
	public void setNgoRegistrationDate(Date ngoRegistrationDate) {
		this.ngoRegistrationDate = ngoRegistrationDate;
	}
	public String getNgoEmailId() {
		return ngoEmailId;
	}
	public void setNgoEmailId(String ngoEmailId) {
		this.ngoEmailId = ngoEmailId;
	}
	public String getNgoContactNumber() {
		return ngoContactNumber;
	}
	public void setNgoContactNumber(String ngoContactNumber) {
		this.ngoContactNumber = ngoContactNumber;
	}
	public String getNgoAlternativeContactNumber() {
		return ngoAlternativeContactNumber;
	}
	public void setNgoAlternativeContactNumber(String ngoAlternativeContactNumber) {
		this.ngoAlternativeContactNumber = ngoAlternativeContactNumber;
	}
	public Integer getNgoId() {
		return ngoId;
	}
	public void setNgoId(Integer ngoId) {
		this.ngoId = ngoId;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	public String getNgoCause() {
		return ngoCause;
	}
	public void setNgoCause(String ngoCause) {
		this.ngoCause = ngoCause;
	}
	public String getNgoHeadOfficeAddress1() {
		return ngoHeadOfficeAddress1;
	}
	public void setNgoHeadOfficeAddress1(String ngoHeadOfficeAddress1) {
		this.ngoHeadOfficeAddress1 = ngoHeadOfficeAddress1;
	}
	public String getNgoHeadOfficeAddress2() {
		return ngoHeadOfficeAddress2;
	}
	public void setNgoHeadOfficeAddress2(String ngoHeadOfficeAddress2) {
		this.ngoHeadOfficeAddress2 = ngoHeadOfficeAddress2;
	}
	public String getNgoHeadOfficeAddressCity() {
		return ngoHeadOfficeAddressCity;
	}
	public void setNgoHeadOfficeAddressCity(String ngoHeadOfficeAddressCity) {
		this.ngoHeadOfficeAddressCity = ngoHeadOfficeAddressCity;
	}
	public String getNgoHeadOfficeAddressState() {
		return ngoHeadOfficeAddressState;
	}
	public void setNgoHeadOfficeAddressState(String ngoHeadOfficeAddressState) {
		this.ngoHeadOfficeAddressState = ngoHeadOfficeAddressState;
	}
	public String getNgoHeadOfficeAddressCountry() {
		return ngoHeadOfficeAddressCountry;
	}
	public void setNgoHeadOfficeAddressCountry(String ngoHeadOfficeAddressCountry) {
		this.ngoHeadOfficeAddressCountry = ngoHeadOfficeAddressCountry;
	}
	public String getNgoHeadOfficeAddressPincode() {
		return ngoHeadOfficeAddressPincode;
	}
	public void setNgoHeadOfficeAddressPincode(String ngoHeadOfficeAddressPincode) {
		this.ngoHeadOfficeAddressPincode = ngoHeadOfficeAddressPincode;
	}
	public String getNgoImageLogo() {
		return ngoImageLogo;
	}
	public void setNgoImageLogo(String ngoImageLogo) {
		this.ngoImageLogo = ngoImageLogo;
	}
	public String getNgoLocationLongitude() {
		return ngoLocationLongitude;
	}
	public void setNgoLocationLongitude(String ngoLocationLongitude) {
		this.ngoLocationLongitude = ngoLocationLongitude;
	}
	public String getNgoLocationLatitude() {
		return ngoLocationLatitude;
	}
	public void setNgoLocationLatitude(String ngoLocationLatitude) {
		this.ngoLocationLatitude = ngoLocationLatitude;
	}
	public String getNgoStatus() {
		return ngoStatus;
	}
	public void setNgoStatus(String ngoStatus) {
		this.ngoStatus = ngoStatus;
	}
	public NgoCategoryPojo getNgoCategoryPojo() {
		return ngoCategoryPojo;
	}
	public void setNgoCategoryPojo(NgoCategoryPojo ngoCategoryPojo) {
		this.ngoCategoryPojo = ngoCategoryPojo;
	}
	public LoginPojo getLoginPojo() {
		return loginPojo;
	}
	public void setLoginPojo(LoginPojo loginPojo) {
		this.loginPojo = loginPojo;
	}
	public Set<NgoEventPojo> getEventPojos() {
		return eventPojos;
	}
	public void setEventPojos(Set<NgoEventPojo> eventPojos) {
		this.eventPojos = eventPojos;
	}
	public Set<UserSubscriptionPojo> getUserSubscriptionPojos() {
		return userSubscriptionPojos;
	}
	public void setUserSubscriptionPojos(
			Set<UserSubscriptionPojo> userSubscriptionPojos) {
		this.userSubscriptionPojos = userSubscriptionPojos;
	}
	
	
}
