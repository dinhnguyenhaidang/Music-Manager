package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.AlbumConverter;
import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.service.IAlbumService;

/**
 * Provides services related to album
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
@Service
public class AlbumService implements IAlbumService {

	@Autowired
	private AlbumConverter albumConverter;

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public AlbumDTO get(long id) {
		AlbumEntity albumEntity = albumRepository.findOne(id);
		return albumConverter.toDTO(albumEntity);
	}

	@Override
	public AlbumDTO save(AlbumDTO albumDTO) {
		// Initialize
		AlbumEntity albumEntity = new AlbumEntity();

		// Convert albumDTO to an album entity and assign it to albumEntity
		albumEntity = albumConverter.toEntity(albumDTO);

		// Save albumEntity to database
		albumEntity = albumRepository.save(albumEntity);

		// Return an album DTO converted from albumEntity
		return albumConverter.toDTO(albumEntity);
	}

	@Override
	public AlbumDTO update(AlbumDTO albumDTO) {
		// Get old album entity
		AlbumEntity albumEntity = albumRepository.findOne(albumDTO.getId());
		
		// Convert albumDTO to the old album entity to update it
		albumEntity = albumConverter.toEntity(albumDTO);

		// Save albumEntity to database
		albumEntity = albumRepository.save(albumEntity);

		// Return an album DTO converted from albumEntity
		return albumConverter.toDTO(albumEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			albumRepository.delete(id);
		}
	}

}
