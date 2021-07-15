package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;

/**
 * Converts SongDTOs to SongEntities and vice versa
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-14
 */
@Component
public class SongConverter {
	
	/**
	 * Convert a SongEntity to a SongDTO
	 * 
	 * @param songEntity to convert
	 * @return a converted DTO
	 */
	public SongDTO toDTO(SongEntity songEntity) {
		// Initialize a DTO
		SongDTO songDTO = new SongDTO();

		// Get album id from the entity's album
		Long albumId = null;
		try {
			albumId = songEntity.getAlbum().getId();
		} catch (NullPointerException ex) {
			// Do nothing
		}

		// Get singer ids from entity's singer list
		List<Long> singerIds = new ArrayList<>();
		try {
			for (SingerEntity singer : songEntity.getSingers()) {
				singerIds.add(singer.getId());
			}
		} catch (NullPointerException ex) {
			singerIds = null;
		}

		// Set values from the entity to the DTO
		if (songEntity.getId() != null) {
			songDTO.setId(songEntity.getId());
		}
		songDTO.setTitle(songEntity.getTitle());
		songDTO.setAlbumId(albumId);
		songDTO.setCategory(songEntity.getCategory());
		songDTO.setSingerIds(singerIds);

		return songDTO;
	}

	/**
	 * Convert a SongDTO to a SongEntity
	 * 
	 * @param songDTO to convert
	 * @return converted entity
	 */
	public SongEntity toEntity(SongDTO songDTO) {
		// Initialize an entity
		SongEntity songEntity = new SongEntity();

		// Set values from the DTO to the entity
		if (songDTO.getId() != null) {
			songEntity.setId(songDTO.getId());
		}
		songEntity.setTitle(songDTO.getTitle());
		songEntity.setCategory(songDTO.getCategory());

		return songEntity;
	}

}
