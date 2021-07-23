package com.musicmanager.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.musicmanager.entity.UserEntity;

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
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public MyUserDetails() {
	}

	public MyUserDetails(UserEntity userEntity) {
		this.username = userEntity.getUsername();
		this.password = userEntity.getPassword();
		this.active = userEntity.isActive();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userEntity.getRoles());
		this.authorities = new ArrayList<>();
		this.authorities.add(authority);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
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

	@Override
	public boolean isEnabled() {
		return active;
	}

}
