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
	private Long idPrivilege;
	
	
	
	@Column(name="privilege", length=20, nullable=false)
	private String privilege;
	@Column(name="description", length=280, nullable=true)
	private String description;

	public Privilege () {}

	public Privilege(String privilege, String description) {
		super();
		this.privilege = privilege;
		this.description = description;
	}

	public Long getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
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
    
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Privilege [id_privlege=");
		builder.append(idPrivilege);
		builder.append(", privilege=");
		builder.append(privilege);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
		
	}
	
}
