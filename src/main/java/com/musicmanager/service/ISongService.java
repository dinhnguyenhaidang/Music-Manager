package com.musicmanager.service;

import com.musicmanager.dto.SongDTO;

/**
 * IASongService helps do things with Data Injection or something I don't know
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
public interface ISongService {
	
	/**
	 * Get a record from database
	 * 
	 * @param id
	 * @return
	 */
	SongDTO get(long id);

	/**
	 * Save a record to database
	 * The action is create or update depends on if albumDTO has id or not
	 * 
	 * @param albumDTO
	 * @return
	 */
	SongDTO save(SongDTO songDTO);
	
	/**
	 * Delete record(s) from database having id exists in array ids
	 * 
	 * @param ids
	 */
	void delete(long[] ids);
	
}
