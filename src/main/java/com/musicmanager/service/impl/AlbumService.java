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
	private AlbumConverter albumConverter;
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Override
	public AlbumDTO get(long id) {
		AlbumEntity entity = albumRepository.findOneById(id);
		return albumConverter.toDTO(entity);
	}

	@Override
	public AlbumDTO save(AlbumDTO albumDTO) {
		AlbumEntity albumEntity = new AlbumEntity();

		// If id != null, HTTP method is PUT, otherwise HTTP method is POST
		if (albumDTO.getId() != null) {
			// Get old album entity
			AlbumEntity oldAlbumEntity = albumRepository.findOne(albumDTO.getId());
			albumEntity = albumConverter.toEntity(albumDTO, oldAlbumEntity);
		} else {
			// Convert albumDTO to albumEntity to process
			albumEntity = albumConverter.toEntity(albumDTO);
		}

		// Save albumEntity to DB
		albumEntity = albumRepository.save(albumEntity);

		// Return the saved albumEntity as albumDTO to check
		return albumConverter.toDTO(albumEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			albumRepository.delete(item);
		}
	}

}
