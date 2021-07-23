package com.musicmanager.security.model;

import java.io.Serializable;

/**
 * Provides AuthenticationRequest model
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-22
 */
public class AuthenticationRequest implements Serializable {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	/**
	 * Default constructor for JSON Parsing
	 */
	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

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

}
