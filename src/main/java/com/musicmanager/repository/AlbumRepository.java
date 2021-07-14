package com.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.AlbumEntity;

/**
 * Provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

	// Query JPA transform DTO
	AlbumEntity findOneByIdAndName(Long id, String name);
	
}
