package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SongConverter;
import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.SongRepository;
import com.musicmanager.service.ISongService;

/**
 * SongService provides services related to album
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@Service
public class SongService implements ISongService {

	@Autowired
	private SongConverter songConverter;
	
	@Autowired
	private SongRepository songRepository;
	
	@Override
	public SongDTO get(long id) {
		SongEntity entity = songRepository.findOneById(id);
		return songConverter.toDTO(entity);
	}

	@Override
	public SongDTO save(SongDTO songDTO) {
		SongEntity songEntity = new SongEntity();

		// If id != null, HTTP method is PUT, otherwise HTTP method is POST
		if (songDTO.getId() != null) {
			// Get old song entity
			SongEntity oldSongEntity = songRepository.findOne(songDTO.getId());
			songEntity = songConverter.toEntity(songDTO, oldSongEntity);
		} else {
			// Convert songDTO to songEntity to process
			songEntity = songConverter.toEntity(songDTO);
		}

		// Save songEntity to DB
		songEntity = songRepository.save(songEntity);

		// Return the saved songEntity as songDTO to check
		return songConverter.toDTO(songEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			songRepository.delete(item);
		}
	}

}
