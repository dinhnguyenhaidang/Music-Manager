package com.musicmanager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SongConverter;
import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.repository.SongRepository;
import com.musicmanager.service.ISongService;

/**
 * I don't know what this class does...
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
	private AlbumRepository albumRepository;
	
	@Autowired
	private SongConverter songConverter;

	@Override
	public SongDTO save(SongDTO songDTO) {
		AlbumEntity albumEntity = albumRepository.findOneById(songDTO.getAlbumId());
		SongEntity songEntity = songConverter.toEntity(songDTO);
		songEntity.setAlbum(albumEntity);
		songEntity = songRepository.save(songEntity);
		return songConverter.toDTO(songEntity);
	}
	
}
