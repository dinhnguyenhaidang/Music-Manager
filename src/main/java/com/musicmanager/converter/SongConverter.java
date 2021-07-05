package com.musicmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.AlbumRepository;

/**
 * This class converts SongDTOs to SongEntities
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@Component
public class SongConverter {

	@Autowired
	private AlbumRepository albumRepository;

	/**
	 * Convert a songEntity to a songDTO
	 * 
	 * @param entity to convert
	 * @return converted dto
	 */
	public SongDTO toDTO(SongEntity entity) {
		// Initialize a dto
		SongDTO dto = new SongDTO();

		// Set value from entity to dto
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTitle(entity.getTitle());
		dto.setAlbumId(entity.getAlbum().getId());
		dto.setCategory(entity.getCategory());
		dto.setSinger(entity.getSinger());

		return dto;
	}

	/**
	 * Convert a songDTO to a songEntity
	 * 
	 * @param dto to convert
	 * @return converted entity
	 */
	public SongEntity toEntity(SongDTO dto) {
		// Initialize an entity
		SongEntity entity = new SongEntity();

		// Get album from DB with provided id
		AlbumEntity albumEntity = albumRepository.findOneById(dto.getAlbumId());

		// Set value from dto to entity
		entity.setTitle(dto.getTitle());
		entity.setAlbum(albumEntity);
		entity.setCategory(dto.getCategory());
		entity.setSinger(dto.getSinger());

		return entity;
	}

	/**
	 * Convert updatedSongDTO to a song entity
	 * 
	 * @param updatedASongDTO to convert
	 * @return converted entity
	 */
	public SongEntity toEntity(SongDTO updatedSongDTO, SongEntity entity) {
		// Get album from DB with provided id
		AlbumEntity albumEntity = albumRepository.findOneById(updatedSongDTO.getAlbumId());

		// Set value from dto to entity
		entity.setTitle(updatedSongDTO.getTitle());
		entity.setAlbum(albumEntity);
		entity.setCategory(updatedSongDTO.getCategory());
		entity.setSinger(updatedSongDTO.getSinger());

		return entity;
	}

}
