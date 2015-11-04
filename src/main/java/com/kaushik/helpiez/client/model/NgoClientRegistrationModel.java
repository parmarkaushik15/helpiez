package com.kaushik.helpiez.client.model;

import org.springframework.web.multipart.MultipartFile;

public class NgoClientRegistrationModel {
	private String ngoCategory;
	private String ngoName;
	private String ngoCause;
	private String ngoEmail;
	private String ngoContact;
	private String ngoAlternativeContact;
	private String ngoAddressLine1;
	private String ngoAddressLine2;
	private String ngoAddressLineCountry;
	private String ngoAddressLineState;
	private String ngoAddressLineCity;
	private String ngoAddressLinePincode;
	private String ngoLocationLongitude;
	private String ngoLocationLatitude;
	private MultipartFile ngoImage;
	private String imageUrl;
	
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNgoCategory() {
		return ngoCategory;
	}
	public void setNgoCategory(String ngoCategory) {
		this.ngoCategory = ngoCategory;
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
	public String getNgoEmail() {
		return ngoEmail;
	}
	public void setNgoEmail(String ngoEmail) {
		this.ngoEmail = ngoEmail;
	}
	public String getNgoContact() {
		return ngoContact;
	}
	public void setNgoContact(String ngoContact) {
		this.ngoContact = ngoContact;
	}
	public String getNgoAlternativeContact() {
		return ngoAlternativeContact;
	}
	public void setNgoAlternativeContact(String ngoAlternativeContact) {
		this.ngoAlternativeContact = ngoAlternativeContact;
	}
	public String getNgoAddressLine1() {
		return ngoAddressLine1;
	}
	public void setNgoAddressLine1(String ngoAddressLine1) {
		this.ngoAddressLine1 = ngoAddressLine1;
	}
	public String getNgoAddressLine2() {
		return ngoAddressLine2;
	}
	public void setNgoAddressLine2(String ngoAddressLine2) {
		this.ngoAddressLine2 = ngoAddressLine2;
	}
	public String getNgoAddressLineCountry() {
		return ngoAddressLineCountry;
	}
	public void setNgoAddressLineCountry(String ngoAddressLineCountry) {
		this.ngoAddressLineCountry = ngoAddressLineCountry;
	}
	public String getNgoAddressLineState() {
		return ngoAddressLineState;
	}
	public void setNgoAddressLineState(String ngoAddressLineState) {
		this.ngoAddressLineState = ngoAddressLineState;
	}
	public String getNgoAddressLineCity() {
		return ngoAddressLineCity;
	}
	public void setNgoAddressLineCity(String ngoAddressLineCity) {
		this.ngoAddressLineCity = ngoAddressLineCity;
	}
	public String getNgoAddressLinePincode() {
		return ngoAddressLinePincode;
	}
	public void setNgoAddressLinePincode(String ngoAddressLinePincode) {
		this.ngoAddressLinePincode = ngoAddressLinePincode;
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
	public MultipartFile getNgoImage() {
		return ngoImage;
	}
	public void setNgoImage(MultipartFile ngoImage) {
		this.ngoImage = ngoImage;
	}
	
	
	
}
