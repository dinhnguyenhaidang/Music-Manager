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
 * Converts song DTOs to song entities and vice versa
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-14
 */
@Component
public class SongConverter {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private SingerRepository singerRepository;

	/**
	 * Convert a song entity to a song DTO
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
	 * Convert a song DTO to a song entity
	 * 
	 * @param songDTO to convert
	 * @return converted entity
	 */
	public SongEntity toEntity(SongDTO songDTO) {
		// Initialize an entity
		SongEntity songEntity = new SongEntity();

		// Get album from database with the provided album id
		try {
			AlbumEntity albumEntity = albumRepository.findOne(songDTO.getAlbumId());
			songEntity.setAlbum(albumEntity);
		} catch (Exception ex) {
			songEntity.setAlbum(null);
		}

		// Get singers from DB with provided singer ids
		List<SingerEntity> singerEntities = null;
		try {
			singerEntities = singerRepository.findAll(songDTO.getSingerIds());
		} catch (NullPointerException ex) {
			// Do nothing
		}

		// Set values from dto to entity
		if (songDTO.getId() != null) {
			songEntity.setId(songDTO.getId());
		}
		songEntity.setTitle(songDTO.getTitle());
		songEntity.setCategory(songDTO.getCategory());
		songEntity.setSingers(singerEntities);

		return songEntity;
	}

	/**
	 * Converts an updated song DTO to a song entity with an old song entity as a
	 * base
	 * 
	 * @param updatedDTO to convert
	 * @param oldEntity  as a base to update
	 * @return a converted and updated entity
	 */
//	public SongEntity toEntity(SongDTO updatedDTO, SongEntity oldEntity) {
//		// Get an album from database with the provided album id
//		try {
//			AlbumEntity albumEntity = albumRepository.findOne(updatedDTO.getAlbumId());
//			oldEntity.setAlbum(albumEntity);
//		} catch (Exception ex) {
//			oldEntity.setAlbum(null);
//		}
//
//		// Get singers from database with provided singer ids
//		List<SingerEntity> singerEntities = null;
//		try {
//			singerEntities = singerRepository.findAll(updatedDTO.getSingerIds());
//		} catch (NullPointerException ex) {
//			// Do nothing
//		}
//
//		// Set values from the updatedDTO to the entity
//		oldEntity.setTitle(updatedDTO.getTitle());
//		oldEntity.setCategory(updatedDTO.getCategory());
//		oldEntity.setSingers(singerEntities);
//
//		return oldEntity;
//	}

}
