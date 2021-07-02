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

	SongDTO save(SongDTO songDTO);
	
	void delete(long[] ids);
	
}
