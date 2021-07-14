package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SongConverter;
import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.SongRepository;
import com.musicmanager.service.ISongService;

/**
 * Provides services related to song
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-12
 */
@Service
public class SongService implements ISongService {

	@Autowired
	private SongConverter songConverter;

	@Autowired
	private SongRepository songRepository;

	@Override
	public SongDTO get(long id) {
		SongEntity entity = songRepository.findOne(id);
		return songConverter.toDTO(entity);
	}

	@Override
	public SongDTO save(SongDTO songDTO) {
		// Initialize (assume songDTO's id is always null)
		SongEntity songEntity = new SongEntity();

		// Convert singerDTO to a singer entity and assign it to singerEntity
		songEntity = songConverter.toEntity(songDTO);

		// Save songEntity to database
		songEntity = songRepository.save(songEntity);

		// Return a song DTO converted from songEntity
		return songConverter.toDTO(songEntity);
	}

	@Override
	public SongDTO update(SongDTO songDTO) {
		// Get old song entity
		SongEntity songEntity = songRepository.findOne(songDTO.getId());

		// Convert songDTO to the old song entity to update it
		songEntity = songConverter.toEntity(songDTO);

		// Save songEntity to database
		songEntity = songRepository.save(songEntity);

		// Return a song DTO converted from songEntity
		return songConverter.toDTO(songEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			songRepository.delete(id);
		}
	}

}
