package com.musicmanager.converter;

import org.springframework.stereotype.Component;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;

/**
 * Converts album DTOs to album entities and vice versa
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
@Component
public class AlbumConverter {

	/**
	 * Converts an album entity to an album DTO
	 * 
	 * @param albumEntity to convert
	 * @return a converted DTO
	 */
	public AlbumDTO toDTO(AlbumEntity albumEntity) {
		// Initialize a DTO
		AlbumDTO albumDTO = new AlbumDTO();
		
		// Set values from the entity to the DTO
		if (albumEntity.getId() != null) {
			albumDTO.setId(albumEntity.getId());
		}
		albumDTO.setName(albumEntity.getName());
		
		return albumDTO;
	}
	
	/**
	 * Converts an album DTO to an album entity
	 * 
	 * @param albumDTO to convert
	 * @return a converted entity
	 */
	public AlbumEntity toEntity(AlbumDTO albumDTO) {
		// Initialize an entity
		AlbumEntity albumEntity = new AlbumEntity();
		
		// Set values from the DTO to the entity
		if (albumDTO.getId() != null) {
			albumEntity.setId(albumDTO.getId());
		}
		albumEntity.setName(albumDTO.getName());
		
		return albumEntity;
	}
	
	/**
	 * Converts an updated album DTO to an album entity with an old album entity as a base
	 * 
	 * @param updatedDTO to convert
	 * @param oldEntity as a base to update
	 * @return a converted and updated entity
	 */
//	public AlbumEntity toEntity(AlbumDTO updatedDTO, AlbumEntity oldEntity) {
//		// Set values from the updated DTO to the entity
//		oldEntity.setName(updatedDTO.getName());
//		
//		return oldEntity;
//	}
	
}
