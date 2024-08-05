package com.yoatzin.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="users")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long fk_id_user;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	@Column(name="lastname", length=100, nullable=false)
	private String last_name;
	@Column(name="phone", nullable=false)
	private int phone;
	@Column(name="email", length=50, nullable=false, unique=true)
	private String email;
	@Column(name="password", length=100, nullable=false)
	private String password;
	@Column(name="active", nullable=true)
	private boolean active;
	
	public User() {
		
	}

	public User(String name, String last_name, int phone, String email, String password, boolean active) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFk_id_user() {
		return fk_id_user;
	}

	public void setFk_id_user(Long fk_id_user) {
		this.fk_id_user = fk_id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		builder.append("User [id=");
		builder.append(id);
		builder.append(", fk_id_user=");
		builder.append(fk_id_user);
		builder.append(", name=");
		builder.append(name);
		builder.append(", last_name=");
		builder.append(last_name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
