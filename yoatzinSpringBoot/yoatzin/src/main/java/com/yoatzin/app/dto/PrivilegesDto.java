package com.yoatzin.app.dto;

public class PrivilegesDto {
	
	private Long privilege;
	private Long description;
	
	
	public PrivilegesDto() {}

	public Long getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Long privilege) {
		this.privilege = privilege;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}

}
