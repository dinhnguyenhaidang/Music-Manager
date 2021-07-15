package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;

/**
 * Converts SingerDTOs to SingerEntities and vice versa
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
@Component
public class SingerConverter {

	/**
	 * Converts a SingerEntity to a SingerDTO
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
	 * Convert a SingerDTO to a SingerEntity
	 * 
	 * @param singerDTO to convert
	 * @return a converted entity
	 */
	public SingerEntity toEntity(SingerDTO singerDTO) {
		// Initialize an entity
		SingerEntity singerEntity = new SingerEntity();

		// Set values from the DTO to the entity
		if (singerDTO.getId() != null) {
			singerEntity.setId(singerDTO.getId());
		}
		singerEntity.setName(singerDTO.getName());
		singerEntity.setAge(singerDTO.getAge());

		return singerEntity;
	}

}
