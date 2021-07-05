package com.musicmanager.converter;

import org.springframework.stereotype.Component;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;

/**
 * This class converts AlbumDTOs to AlbumEntities
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@Component
public class AlbumConverter {

	/**
	 * Convert an albumEntity to an albumDTO
	 * 
	 * @param entity to convert
	 * @return converted dto
	 */
	public AlbumDTO toDTO(AlbumEntity entity) {
		// Initialize a dto
		AlbumDTO dto = new AlbumDTO();
		
		// Set value from entity to dto
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		
		return dto;
	}
	
	/**
	 * Convert an albumDTO to an albumEntity
	 * 
	 * @param dto to convert
	 * @return converted entity
	 */
	public AlbumEntity toEntity(AlbumDTO dto) {
		// Initialize an entity
		AlbumEntity entity = new AlbumEntity();
		
		// Set value from dto to entity
		entity.setName(dto.getName());
		
		return entity;
	}
	
	/**
	 * Convert updatedAlbumDTO to an album entity
	 * 
	 * @param updatedAlbumDTO to convert
	 * @return converted entity
	 */
	public AlbumEntity toEntity(AlbumDTO updatedAlbumDTO, AlbumEntity entity) {
		// Set value from dto to entity
		entity.setName(updatedAlbumDTO.getName());
		
		return entity;
	}
	
}
