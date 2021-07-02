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
	private SongRepository songRepository;

	@Autowired
	private SongConverter songConverter;

	@Override
	public SongDTO save(SongDTO songDTO) {
		// Convert songDTO to songEntity to process
		SongEntity songEntity = songConverter.toEntity(songDTO);
		
		// Save songEntity to DB
		songEntity = songRepository.save(songEntity);
		
		// Return the saved songEntity as songDTO to check
		return songConverter.toDTO(songEntity);
	}

}
