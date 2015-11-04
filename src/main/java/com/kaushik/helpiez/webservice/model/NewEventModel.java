package com.kaushik.helpiez.webservice.model;

import org.springframework.web.multipart.MultipartFile;

public class NewEventModel {
	private String ngoId;
	private String eventTitle;
	//private MultipartFile eventLogo;
	private String eventDescription;
	private String eventDate;
	private String eventOrganizerName;
	private String eventOrganizerEmail;
	private String eventOrganizerContact;
	private String eventAlternativeContact;
	private String eventAddress;
	private String eventAddressCountry;
	private String eventAddressState;
	private String eventAddressCity;
	private String eventAddressPincode;
	private String eventAddressLongitude;
	private String eventAddressLatitude;
	
	
	public String getNgoId() {
		return ngoId;
	}
	public void setNgoId(String ngoId) {
		this.ngoId = ngoId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	/*public MultipartFile getEventLogo() {
		return eventLogo;
	}
	public void setEventLogo(MultipartFile eventLogo) {
		this.eventLogo = eventLogo;
	}*/
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventOrganizerName() {
		return eventOrganizerName;
	}
	public void setEventOrganizerName(String eventOrganizerName) {
		this.eventOrganizerName = eventOrganizerName;
	}
	public String getEventOrganizerEmail() {
		return eventOrganizerEmail;
	}
	public void setEventOrganizerEmail(String eventOrganizerEmail) {
		this.eventOrganizerEmail = eventOrganizerEmail;
	}
	public String getEventOrganizerContact() {
		return eventOrganizerContact;
	}
	public void setEventOrganizerContact(String eventOrganizerContact) {
		this.eventOrganizerContact = eventOrganizerContact;
	}
	public String getEventAlternativeContact() {
		return eventAlternativeContact;
	}
	public void setEventAlternativeContact(String eventAlternativeContact) {
		this.eventAlternativeContact = eventAlternativeContact;
	}
	public String getEventAddress() {
		return eventAddress;
	}
	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}
	public String getEventAddressCountry() {
		return eventAddressCountry;
	}
	public void setEventAddressCountry(String eventAddressCountry) {
		this.eventAddressCountry = eventAddressCountry;
	}
	public String getEventAddressState() {
		return eventAddressState;
	}
	public void setEventAddressState(String eventAddressState) {
		this.eventAddressState = eventAddressState;
	}
	public String getEventAddressCity() {
		return eventAddressCity;
	}
	public void setEventAddressCity(String eventAddressCity) {
		this.eventAddressCity = eventAddressCity;
	}
	public String getEventAddressPincode() {
		return eventAddressPincode;
	}
	public void setEventAddressPincode(String eventAddressPincode) {
		this.eventAddressPincode = eventAddressPincode;
	}
	public String getEventAddressLongitude() {
		return eventAddressLongitude;
	}
	public void setEventAddressLongitude(String eventAddressLongitude) {
		this.eventAddressLongitude = eventAddressLongitude;
	}
	public String getEventAddressLatitude() {
		return eventAddressLatitude;
	}
	public void setEventAddressLatitude(String eventAddressLatitude) {
		this.eventAddressLatitude = eventAddressLatitude;
	}
	
	
	
}
