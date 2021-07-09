package com.musicmanager.service;

import com.musicmanager.dto.SingerDTO;

/**
 * ISingerService helps do things with Data Injection or something I don't know
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-07
 */
public interface ISingerService {
	
	/**
	 * Get a record from database
	 * 
	 * @param id
	 * @return
	 */
	SingerDTO get(long id);

	/**
	 * Save a record to database
	 * The action is create or update depends on if singerDTO has id or not
	 * 
	 * @param singerDTO
	 * @return
	 */
	SingerDTO save(SingerDTO singerDTO);
	
	/**
	 * Delete record(s) from database
	 * 
	 * @param ids
	 */
	void delete(long[] ids);

}
