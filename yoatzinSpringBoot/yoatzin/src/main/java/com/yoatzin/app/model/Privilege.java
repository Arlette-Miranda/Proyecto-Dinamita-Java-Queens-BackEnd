package com.yoatzin.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="privileges")

public class Privilege {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_privilege;
	
	@Column(name="privilege", length=20, nullable=false)
	private String privilege;
	@Column(name="description", length=280, nullable=true)
	private String description;
	private boolean active;



	public Privilege () {
		
	}
	public Privilege(Long id_privilege, String privilege, String description, boolean active) {
		this.id_privilege = id_privilege;
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

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
		builder.append("Privilege [id_privlege=");
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

	
	
}
