package com.kaushik.helpiez.webservice.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class NgoRegistrationModel implements Serializable{
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
	//private MultipartFile ngoImageLogo;
	private String ngoLocationLongitude;
	private String ngoLocationLatitude;
	private String ngoCategory;
	
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
	/*
	public MultipartFile getNgoImageLogo() {
		return ngoImageLogo;
	}
	public void setNgoImageLogo(MultipartFile ngoImageLogo) {
		this.ngoImageLogo = ngoImageLogo;
	}*/
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
	public String getNgoCategory() {
		return ngoCategory;
	}
	public void setNgoCategory(String ngoCategory) {
		this.ngoCategory = ngoCategory;
	}
	
	
}
