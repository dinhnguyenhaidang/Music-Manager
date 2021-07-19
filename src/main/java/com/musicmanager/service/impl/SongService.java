package com.musicmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SongConverter;
import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.repository.SongRepository;
import com.musicmanager.service.ISongService;

/**
 * Provides services related to song
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-19
 */
@Service
public class SongService implements ISongService {

	@Autowired
	private SongConverter songConverter;
	
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private SingerRepository singerRepository;

	@Autowired
	private SongRepository songRepository;

	public void setSongConverter(SongConverter songConverter) {
		this.songConverter = songConverter;
	}

	public void setAlbumRepository(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	public void setSongRepository(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	@Override
	public SongDTO get(long id) {
		SongEntity entity = songRepository.findOne(id);
		return songConverter.toDTO(entity);
	}

	@Override
	public SongDTO save(SongDTO songDTO) {
		// Initialize
		SongEntity songEntity = new SongEntity();

		// Convert singerDTO to a singer entity and assign it to singerEntity
		songEntity = songConverter.toEntity(songDTO);
		
		// Get album from database with the provided album id
		try {
			AlbumEntity albumEntity = albumRepository.findOne(songDTO.getAlbumId());
			songEntity.setAlbum(albumEntity);
		} catch (Exception ex) {
			songEntity.setAlbum(null);
		}

		// Get singers from DB with provided singer ids
		try {
			List<SingerEntity> singerEntities = singerRepository.findAll(songDTO.getSingerIds());
			songEntity.setSingers(singerEntities);
		} catch (NullPointerException ex) {
			songEntity.setSingers(null);
		}

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
		
		// Get album from database with the provided album id
		try {
			AlbumEntity albumEntity = albumRepository.findOne(songDTO.getAlbumId());
			songEntity.setAlbum(albumEntity);
		} catch (Exception ex) {
			songEntity.setAlbum(null);
		}

		// Get singers from DB with provided singer ids
		try {
			List<SingerEntity> singerEntities = singerRepository.findAll(songDTO.getSingerIds());
			songEntity.setSingers(singerEntities);
		} catch (NullPointerException ex) {
			songEntity.setSingers(null);
		}

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
