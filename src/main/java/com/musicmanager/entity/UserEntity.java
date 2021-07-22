package com.musicmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Defines user entity, its relationships and maps it to the corresponding table in database
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-22
 */
@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
    private String password;

	@Column(name = "active")
	private boolean active;
	
	@Column(name = "roles")
    private String roles;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

}
