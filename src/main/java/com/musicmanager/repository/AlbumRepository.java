package com.musicmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.AlbumEntity;

/**
 * AlbumRepository provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
	
	AlbumEntity findOneById(Long id);
	
	// Query JPA transform DTO
	AlbumEntity findOneByIdAndName(Long id, String name);
	
}
