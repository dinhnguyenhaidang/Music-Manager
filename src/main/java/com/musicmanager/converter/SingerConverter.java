package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.SongRepository;

/**
 * SingerConverter converts SingerDTOs to SingerEntities and vice versa
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-09
 */
@Component
public class SingerConverter {
	
	@Autowired
	private SongRepository songRepository;

	/**
	 * Convert a singerEntity to a singerDTO
	 * 
	 * @param entity to convert
	 * @return converted dto
	 */
	public SingerDTO toDTO(SingerEntity entity) {
		// Initialize a dto
		SingerDTO dto = new SingerDTO();

		// If the action is update, set id from entity to dto, if the action is create the id is auto-generated
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		
		// Get song ids from entity's song list
		List<Long> songIds = new ArrayList<>();
		for (SongEntity song : entity.getSongs()) {
			songIds.add(song.getId());
		}
		
		// Set values from entity to dto
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		dto.setSongIds(songIds);

		return dto;
	}

	/**
	 * Convert a singerDTO to a singerEntity
	 * 
	 * @param dto to convert
	 * @return converted entity
	 */
	public SingerEntity toEntity(SingerDTO dto) {
		// Initialize an entity
		SingerEntity entity = new SingerEntity();

		// Get songs from DB with provided song ids
		List<SongEntity> songEntities = songRepository.findById(dto.getSongIds());

		// Set values from dto to entity
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setSongs(songEntities);

		return entity;
	}

	/**
	 * Convert updatedSingerDTO to a singer entity
	 * 
	 * @param an updatedSingerDTO to convert
	 * @return converted entity
	 */
	public SingerEntity toEntity(SingerDTO updatedSingerDTO, SingerEntity entity) {
		// Get songs from DB with provided song ids
		List<SongEntity> songEntities = songRepository.findById(updatedSingerDTO.getSongIds());

		// Set values from dto to entity
		entity.setName(updatedSingerDTO.getName());
		entity.setAge(updatedSingerDTO.getAge());
		entity.setSongs(songEntities);

		return entity;
	}

}
