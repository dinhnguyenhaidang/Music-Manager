package com.musicmanager.security.model;

/**
 * Provides AuthenticationResponse model
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-22
 */
public class AuthenticationResponse {
	
	private final String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
}
