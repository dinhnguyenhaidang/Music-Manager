package com.musicmanager.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Provides user details
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-21
 */
public class MyUserDetails implements UserDetails {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(String username) {
		this.username = username;
	}

	/**
	 * Hard coded
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	/**
	 * Hard coded
	 */
	@Override
	public String getPassword() {
		return "password";
	}

	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * Hard coded
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Hard coded
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Hard coded
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Hard coded
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
