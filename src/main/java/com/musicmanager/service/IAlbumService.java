package com.musicmanager.service;

import com.musicmanager.dto.AlbumDTO;

/**
 * IAlbumService helps do things with Data Injection or something I don't know
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
public interface IAlbumService {

	AlbumDTO save(AlbumDTO albumDTO);
	
}
