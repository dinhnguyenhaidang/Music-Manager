package com.musicmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.SongEntity;

/**
 * SongRepository provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
public interface SongRepository extends JpaRepository<SongEntity, Long> {
	
	List<SongEntity> findById(List<Long> ids);

}
