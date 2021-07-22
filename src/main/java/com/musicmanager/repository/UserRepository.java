package com.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.UserEntity;

/**
 * Provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-22
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUsername(String username);

}
