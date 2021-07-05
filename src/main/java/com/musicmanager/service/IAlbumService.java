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
	
	/**
	 * Get a record from database
	 * 
	 * @param id
	 * @return
	 */
	AlbumDTO get(long id);

	/**
	 * Save a record to database
	 * The action is create or update depends on if albumDTO has id or not
	 * 
	 * @param albumDTO
	 * @return
	 */
	AlbumDTO save(AlbumDTO albumDTO);
	
	/**
	 * Delete record(s) from database
	 * 
	 * @param ids
	 */
	void delete(long[] ids);
	
}
