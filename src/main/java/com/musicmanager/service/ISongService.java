package com.musicmanager.service;

import com.musicmanager.dto.SongDTO;

/**
 * I don't know what this interface does...
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
public interface ISongService {

	/**
	 * 
	 * @param songDTO
	 * @return
	 */
	SongDTO save(SongDTO songDTO);
	
}
