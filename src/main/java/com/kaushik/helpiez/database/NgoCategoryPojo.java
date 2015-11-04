package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
public class NgoCategoryPojo implements Serializable{
	private Integer categoryId;
	private String categoryName;
	private String categoryStatus;
	
	@JsonManagedReference
	private Set<NgoRegistrationPojo> ngoRegistrationPojos;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public Set<NgoRegistrationPojo> getNgoRegistrationPojos() {
		return ngoRegistrationPojos;
	}
	public void setNgoRegistrationPojos(
			Set<NgoRegistrationPojo> ngoRegistrationPojos) {
		this.ngoRegistrationPojos = ngoRegistrationPojos;
	}

	
}
