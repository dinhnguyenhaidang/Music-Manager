package com.musicmanager.service;

import com.musicmanager.dto.SongDTO;

/**
 * Follows a template for Data Injection
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public interface ISongService {
	
	/**
	 * Get a song DTO converted from a song entity that has the provided id from database
	 * 
	 * @param id of the song DTO to get
	 * @return a song DTO converted from the song entity that has the provided id
	 */
	SongDTO get(long id);

	/**
	 * Save a song entity, converted from the provided song DTO, to database
	 * 
	 * @param songDTO to save
	 * @return a song DTO converted from the saved song entity
	 */
	SongDTO save(SongDTO songDTO);
	
	/**
	 * Update a song entity, with data from the provided song DTO, from database
	 * 
	 * @param songDTO with updated data
	 * @return a song DTO converted from the updated song entity
	 */
	SongDTO update(SongDTO songDTO);
	
	/**
	 * Delete song entities that have provided ids from database
	 * 
	 * @param ids of song entities to delete
	 */
	void delete(long[] ids);
	
}
