package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.AlbumConverter;
import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.service.IAlbumService;

/**
 * AlbumService provides services related to album
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@Service
public class AlbumService implements IAlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private AlbumConverter albumConverter;

	@Override
	public AlbumDTO save(AlbumDTO albumDTO) {
		// Convert albumDTO to albumEntity to process
		AlbumEntity albumEntity = albumConverter.toEntity(albumDTO);

		// Save albumEntity to DB
		albumEntity = albumRepository.save(albumEntity);

		// Return the saved albumEntity as albumDTO to check
		return albumConverter.toDTO(albumEntity);
	}
}
