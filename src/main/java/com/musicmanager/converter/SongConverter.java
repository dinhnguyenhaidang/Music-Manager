package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.repository.SingerRepository;

/**
 * SongConverter converts SongDTOs to SongEntities and vice versa
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-09
 */
@Component
public class SongConverter {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private SingerRepository singerRepository;

	/**
	 * Convert a songEntity to a songDTO
	 * 
	 * @param entity to convert
	 * @return converted dto
	 */
	public SongDTO toDTO(SongEntity entity) {
		// Initialize a dto
		SongDTO dto = new SongDTO();

		// If the action is update, set id from entity to dto, if the action is create the id is auto-generated
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		
		// Get singer ids from entity's singer list
		List<Long> singerIds = new ArrayList<>();
		for (SingerEntity singer : entity.getSingers()) {
			singerIds.add(singer.getId());
		}
		
		// Set values from entity to dto
		dto.setTitle(entity.getTitle());
		dto.setAlbumId(entity.getAlbum().getId()); //catch nullpointerex
		dto.setCategory(entity.getCategory());
		dto.setSingerIds(singerIds);

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

		// Get album from DB with provided album id
		AlbumEntity albumEntity = albumRepository.findOne(dto.getAlbumId());
		
		// Get singers from DB with provided singer ids
		List<SingerEntity> singerEntities = singerRepository.findById(dto.getSingerIds());

		// Set values from dto to entity
		entity.setTitle(dto.getTitle());
		entity.setAlbum(albumEntity);
		entity.setCategory(dto.getCategory());
		entity.setSingers(singerEntities);

		return entity;
	}

	/**
	 * Convert updatedSongDTO to a song entity
	 * 
	 * @param a updatedSongDTO to convert
	 * @return converted entity
	 */
	public SongEntity toEntity(SongDTO updatedSongDTO, SongEntity entity) {
		// Get album from DB with provided album id
		AlbumEntity albumEntity = albumRepository.findOne(updatedSongDTO.getAlbumId());
		
		// Get singers from DB with provided singer ids
		List<SingerEntity> singerEntities = singerRepository.findById(updatedSongDTO.getSingerIds());

		// Set values from dto to entity
		entity.setTitle(updatedSongDTO.getTitle());
		entity.setAlbum(albumEntity);
		entity.setCategory(updatedSongDTO.getCategory());
		entity.setSingers(singerEntities);

		return entity;
	}

}
