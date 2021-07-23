package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.musicmanager.entity.UserEntity;
import com.musicmanager.repository.UserRepository;
import com.musicmanager.security.model.MyUserDetails;

/**
 * Provides user details services
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-21
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("Not found: " + username);
		}

        return new MyUserDetails(userEntity);
	}

}
