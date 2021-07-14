package com.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.SingerEntity;

/**
 * Provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {
	
}
