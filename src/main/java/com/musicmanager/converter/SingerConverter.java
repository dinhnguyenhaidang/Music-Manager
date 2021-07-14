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
 * Converts singer DTOs to singer entities and vice versa
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
@Component
public class SingerConverter {

	@Autowired
	private SongRepository songRepository;

	/**
	 * Converts a singer entity to a singer DTO
	 * 
	 * @param singerEntity to convert
	 * @return a converted DTO
	 */
	public SingerDTO toDTO(SingerEntity singerEntity) {
		// Initialize a DTO
		SingerDTO singerDTO = new SingerDTO();

		// Get song ids from the entity's song list
		List<Long> songIds = new ArrayList<>();
		try {
			for (SongEntity song : singerEntity.getSongs()) {
				songIds.add(song.getId());
			}
		} catch (NullPointerException ex) {
			songIds = null;
		}

		// Set values from the entity to the DTO
		if (singerEntity.getId() != null) {
			singerDTO.setId(singerEntity.getId());
		}
		singerDTO.setName(singerEntity.getName());
		singerDTO.setAge(singerEntity.getAge());
		singerDTO.setSongIds(songIds);

		return singerDTO;
	}

	/**
	 * Convert a singer DTO to a singer entity
	 * 
	 * @param singerDTO to convert
	 * @return a converted entity
	 */
	public SingerEntity toEntity(SingerDTO singerDTO) {
		// Initialize an entity
		SingerEntity singerEntity = new SingerEntity();

		// Get songs from database with provided song ids
		List<SongEntity> songEntities = null;
		try {
			songEntities = songRepository.findAll(singerDTO.getSongIds());
		} catch (NullPointerException ex) {
			// Do nothing
		}

		// Set values from the DTO to the entity
		if (singerDTO.getId() != null) {
			singerEntity.setId(singerDTO.getId());
		}
		singerEntity.setName(singerDTO.getName());
		singerEntity.setAge(singerDTO.getAge());
		singerEntity.setSongs(songEntities);

		return singerEntity;
	}

	/**
	 * Converts an updated singer DTO to a singer entity with an old singer entity
	 * as a base
	 * 
	 * @param updatedDTO to convert
	 * @param oldEntity  as a base to update
	 * @return a converted and updated entity
	 */
//	public SingerEntity toEntity(SingerDTO updatedDTO, SingerEntity oldEntity) {
//		// Get songs from database with provided song ids
//		List<SongEntity> songEntities = new ArrayList<>();
//		try {
//			songEntities = songRepository.findAll(updatedDTO.getSongIds());
//		} catch (NullPointerException ex) {
//			// Do nothing
//		}
//
//		// Set values from the updatedDTO to the entity
//		oldEntity.setName(updatedDTO.getName());
//		oldEntity.setAge(updatedDTO.getAge());
//		oldEntity.setSongs(songEntities);
//
//		return oldEntity;
//	}

}
