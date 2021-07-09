package com.musicmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicmanager.entity.SingerEntity;

/**
 * SingerRepository provides supported queries from Spring Boot
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-07
 */
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {
	
	List<SingerEntity> findById(List<Long> ids);

}
