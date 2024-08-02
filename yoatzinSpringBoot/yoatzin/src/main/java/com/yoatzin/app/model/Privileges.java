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
	private Long id_privlege;
	
	@Column(name="privilege", length=20, nullable=false)
	private String privilege;
	@Column(name="description", length=280, nullable=true)
	private String description;

	public Privileges () {
		
	}

	public Privileges(String privilege, String description) {
		super();
		this.privilege = privilege;
		this.description = description;
	}

	public Long getId_privlege() {
		return id_privlege;
	}

	public void setId_privlege(Long id_privlege) {
		this.id_privlege = id_privlege;
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
		builder.append("Privileges [id_privlege=");
		builder.append(id_privlege);
		builder.append(", privilege=");
		builder.append(privilege);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}
