package com.musicmanager.service;

import com.musicmanager.dto.AlbumDTO;

/**
 * Follows a template for Data Injection
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public interface IAlbumService {
	
	/**
	 * Get an album DTO converted from an album entity that has the provided id from database
	 * 
	 * @param id of the album DTO to get
	 * @return an album DTO converted from the album entity that has the provided id
	 */
	AlbumDTO get(long id);

	/**
	 * Save an album entity, converted from the provided album DTO, to database
	 * 
	 * @param albumDTO to save
	 * @return an album DTO converted from the saved album entity
	 */
	AlbumDTO save(AlbumDTO albumDTO);
	
	/**
	 * Update an album entity, with data from the provided album DTO, from database
	 * 
	 * @param albumDTO with updated data
	 * @return an album DTO converted from the updated album entity
	 */
	AlbumDTO update(AlbumDTO albumDTO);
	
	/**
	 * Delete album entities that have provided ids from database
	 * 
	 * @param ids of album entities to delete
	 */
	void delete(long[] ids);
	
}
