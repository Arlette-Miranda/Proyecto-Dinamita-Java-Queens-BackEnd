package com.yoatzin.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="privileges")

public class Privileges {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_privilege;
	
	@Column(name="privilege", length=20, nullable=false)
	private Long privilege;
	@Column(name="description", length=280, nullable=true)
	private Long description;
	private boolean active;



	public Privileges () {
		
	}

	public Privileges(Long privilege, Long description, boolean active) {
		super();
		this.privilege = privilege;
		this.description = description;
		this.active = active;
	}

	public Long getId_privilege() {
		return id_privilege;
	}

	public void setId_privilege(Long id_privilege) {
		this.id_privilege = id_privilege;
	}

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
    
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Privileges [id_privlege=");
		builder.append(id_privilege);
		builder.append(", privilege=");
		builder.append(privilege);
		builder.append(", description=");
		builder.append(description);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
		
	}

	public void setId_Privilege(Object object) {
		
		
	}

	
	
}
