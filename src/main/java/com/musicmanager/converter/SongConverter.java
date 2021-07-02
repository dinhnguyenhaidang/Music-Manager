package com.musicmanager.converter;

import org.springframework.stereotype.Component;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SongEntity;

/**
 * This class converts SongDTOs to SongEntities
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@Component
public class SongConverter {

	public SongEntity toEntity(SongDTO dto) {
		SongEntity entity = new SongEntity();
		entity.setTitle(dto.getTitle());
		entity.setCategory(dto.getCategory());
		entity.setSinger(dto.getSinger());
		return entity;
	}
	
	public SongDTO toDTO(SongEntity entity) {
		SongDTO dto = new SongDTO();
		dto.setTitle(entity.getTitle());
		dto.setCategory(entity.getCategory());
		dto.setSinger(entity.getSinger());
		return dto;
	}
	
}
