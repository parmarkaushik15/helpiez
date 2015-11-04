package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
public class NgoEventPojo implements Serializable{
	private Integer ngoEventId;
	private Date ngoEventPostDate;
	private String ngoEventTitle;
	private String ngoEventImage;
	private String ngoEventDescription;
	private Date ngoEventDate;
	private String ngoEventOrganizerName;
	private String ngoEventOrganizerEmail;
	private String ngoEventOrganizerContactNumber;
	private String ngoEventOrganizerAlternativeContactNumber;
	private String ngoEventLocationAddress;
	private String ngoEventLocationAddressCity;
	private String ngoEventLocationAddressState;
	private String ngoEventLocationAddressCountry;
	private String ngoEventLocationAddressPincode;
	private String ngoEventLocationLongitude;
	private String ngoEventLocationLatitude;
	private String ngoEventStatus;
	
	@JsonBackReference
	private NgoRegistrationPojo ngoRegistrationPojo;
	
	@JsonManagedReference
	private Set<UserEventRegistrationPojo> eventRegistrationPojos;

	
	
	public String getNgoEventImage() {
		return ngoEventImage;
	}

	public void setNgoEventImage(String ngoEventImage) {
		this.ngoEventImage = ngoEventImage;
	}

	public String getNgoEventOrganizerName() {
		return ngoEventOrganizerName;
	}

	public void setNgoEventOrganizerName(String ngoEventOrganizerName) {
		this.ngoEventOrganizerName = ngoEventOrganizerName;
	}

	public String getNgoEventOrganizerEmail() {
		return ngoEventOrganizerEmail;
	}

	public void setNgoEventOrganizerEmail(String ngoEventOrganizerEmail) {
		this.ngoEventOrganizerEmail = ngoEventOrganizerEmail;
	}

	public String getNgoEventOrganizerContactNumber() {
		return ngoEventOrganizerContactNumber;
	}

	public void setNgoEventOrganizerContactNumber(
			String ngoEventOrganizerContactNumber) {
		this.ngoEventOrganizerContactNumber = ngoEventOrganizerContactNumber;
	}

	public String getNgoEventOrganizerAlternativeContactNumber() {
		return ngoEventOrganizerAlternativeContactNumber;
	}

	public void setNgoEventOrganizerAlternativeContactNumber(
			String ngoEventOrganizerAlternativeContactNumber) {
		this.ngoEventOrganizerAlternativeContactNumber = ngoEventOrganizerAlternativeContactNumber;
	}

	public Integer getNgoEventId() {
		return ngoEventId;
	}

	public void setNgoEventId(Integer ngoEventId) {
		this.ngoEventId = ngoEventId;
	}

	public Date getNgoEventPostDate() {
		return ngoEventPostDate;
	}

	public void setNgoEventPostDate(Date ngoEventPostDate) {
		this.ngoEventPostDate = ngoEventPostDate;
	}

	public String getNgoEventTitle() {
		return ngoEventTitle;
	}

	public void setNgoEventTitle(String ngoEventTitle) {
		this.ngoEventTitle = ngoEventTitle;
	}

	public String getNgoEventDescription() {
		return ngoEventDescription;
	}

	public void setNgoEventDescription(String ngoEventDescription) {
		this.ngoEventDescription = ngoEventDescription;
	}

	public Date getNgoEventDate() {
		return ngoEventDate;
	}

	public void setNgoEventDate(Date ngoEventDate) {
		this.ngoEventDate = ngoEventDate;
	}

	public String getNgoEventLocationAddress() {
		return ngoEventLocationAddress;
	}

	public void setNgoEventLocationAddress(String ngoEventLocationAddress) {
		this.ngoEventLocationAddress = ngoEventLocationAddress;
	}

	public String getNgoEventLocationAddressCity() {
		return ngoEventLocationAddressCity;
	}

	public void setNgoEventLocationAddressCity(String ngoEventLocationAddressCity) {
		this.ngoEventLocationAddressCity = ngoEventLocationAddressCity;
	}

	public String getNgoEventLocationAddressState() {
		return ngoEventLocationAddressState;
	}

	public void setNgoEventLocationAddressState(String ngoEventLocationAddressState) {
		this.ngoEventLocationAddressState = ngoEventLocationAddressState;
	}

	public String getNgoEventLocationAddressCountry() {
		return ngoEventLocationAddressCountry;
	}

	public void setNgoEventLocationAddressCountry(
			String ngoEventLocationAddressCountry) {
		this.ngoEventLocationAddressCountry = ngoEventLocationAddressCountry;
	}

	public String getNgoEventLocationAddressPincode() {
		return ngoEventLocationAddressPincode;
	}

	public void setNgoEventLocationAddressPincode(
			String ngoEventLocationAddressPincode) {
		this.ngoEventLocationAddressPincode = ngoEventLocationAddressPincode;
	}

	public String getNgoEventLocationLongitude() {
		return ngoEventLocationLongitude;
	}

	public void setNgoEventLocationLongitude(String ngoEventLocationLongitude) {
		this.ngoEventLocationLongitude = ngoEventLocationLongitude;
	}

	public String getNgoEventLocationLatitude() {
		return ngoEventLocationLatitude;
	}

	public void setNgoEventLocationLatitude(String ngoEventLocationLatitude) {
		this.ngoEventLocationLatitude = ngoEventLocationLatitude;
	}

	public String getNgoEventStatus() {
		return ngoEventStatus;
	}

	public void setNgoEventStatus(String ngoEventStatus) {
		this.ngoEventStatus = ngoEventStatus;
	}

	public NgoRegistrationPojo getNgoRegistrationPojo() {
		return ngoRegistrationPojo;
	}

	public void setNgoRegistrationPojo(NgoRegistrationPojo ngoRegistrationPojo) {
		this.ngoRegistrationPojo = ngoRegistrationPojo;
	}

	public Set<UserEventRegistrationPojo> getEventRegistrationPojos() {
		return eventRegistrationPojos;
	}

	public void setEventRegistrationPojos(
			Set<UserEventRegistrationPojo> eventRegistrationPojos) {
		this.eventRegistrationPojos = eventRegistrationPojos;
	}
	
	
}
