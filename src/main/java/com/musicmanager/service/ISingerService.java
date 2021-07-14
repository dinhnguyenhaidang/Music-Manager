package com.musicmanager.service;

import com.musicmanager.dto.SingerDTO;

/**
 * Follows a template for Data Injection
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public interface ISingerService {
	
	/**
	 * Get a singer DTO converted from a singer entity that has the provided id from database
	 * 
	 * @param id of the singer DTO to get
	 * @return a singer DTO converted from the singer entity that has the provided id
	 */
	SingerDTO get(long id);

	/**
	 * Save a singer entity, converted from the provided singer DTO, to database
	 * 
	 * @param singerDTO to save
	 * @return a singer DTO converted from the saved singer entity
	 */
	SingerDTO save(SingerDTO singerDTO);
	
	/**
	 * Update a singer entity, with data from the provided singer DTO, from database
	 * 
	 * @param singerDTO with updated data
	 * @return a singer DTO converted from the updated singer entity
	 */
	SingerDTO update(SingerDTO singerDTO);
	
	/**
	 * Delete singer entities that have provided ids from database
	 * 
	 * @param ids of singer entities to delete
	 */
	void delete(long[] ids);

}
