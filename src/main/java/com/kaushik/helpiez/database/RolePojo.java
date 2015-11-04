package com.kaushik.helpiez.database;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
public class RolePojo implements Serializable{
	private Integer roleId;
	private String roleName;
	private String roleStatus;
	
	@JsonManagedReference
	private Set<LoginPojo> loginPojos;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	public Set<LoginPojo> getLoginPojos() {
		return loginPojos;
	}
	public void setLoginPojos(Set<LoginPojo> loginPojos) {
		this.loginPojos = loginPojos;
	}
	
	
	
}
