package com.musicmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SingerConverter;
import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.repository.SongRepository;
import com.musicmanager.service.ISingerService;

/**
 * Provides services related to singer
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-19
 */
@Service
public class SingerService implements ISingerService {

	@Autowired
	private SingerConverter singerConverter;

	@Autowired
	private SingerRepository singerRepository;

	@Autowired
	private SongRepository songRepository;

	public void setSingerConverter(SingerConverter singerConverter) {
		this.singerConverter = singerConverter;
	}

	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	public void setSongRepository(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	@Override
	public SingerDTO get(long id) {
		SingerEntity entity = singerRepository.findOne(id);
		return singerConverter.toDTO(entity);
	}

	@Override
	public SingerDTO save(SingerDTO singerDTO) {
		// Initialize
		SingerEntity singerEntity = new SingerEntity();

		// Convert singerDTO to a singer entity and assign it to singerEntity
		singerEntity = singerConverter.toEntity(singerDTO);

		// Get songs from database with provided song ids
		try {
			List<SongEntity> songEntities = songRepository.findAll(singerDTO.getSongIds());
			singerEntity.setSongs(songEntities);
		} catch (NullPointerException ex) {
			singerEntity.setSongs(null);
		}

		// Save singerEntity to database
		singerEntity = singerRepository.save(singerEntity);

		// Return a singer DTO converted from singerEntity
		return singerConverter.toDTO(singerEntity);
	}

	@Override
	public SingerDTO update(SingerDTO singerDTO) {
		// Get old singer entity
		SingerEntity singerEntity = singerRepository.findOne(singerDTO.getId());
		
		// Remove all old songs
		for (SongEntity songEntity : singerEntity.getSongs()) {
			singerEntity.removeSong(songEntity);
			songRepository.save(songEntity);
		}
		singerEntity.setSongs(new ArrayList<>());

		// Convert singerDTO to the old singer entity to update it
		singerEntity = singerConverter.toEntity(singerDTO);

		// Get songs from database with provided song ids
		try {
			List<SongEntity> songEntities = songRepository.findAll(singerDTO.getSongIds());
			// Add new songs
			for (SongEntity songEntity : songEntities) {
				singerEntity.addSong(songEntity);
				songRepository.save(songEntity);
			}
		} catch (NullPointerException ex) {
			singerEntity.setSongs(null);
		}

		// Save singerEntity to database
		singerEntity = singerRepository.save(singerEntity);

		// Return a singer DTO converted from singerEntity
		return singerConverter.toDTO(singerEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			singerRepository.delete(id);
		}
	}

}
