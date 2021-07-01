package com.musicmanager.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SongDTO;

/**
 * This API (class) handles requests sent to host:port/music-manager
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-01-07
 */
@RestController
public class MusicManagerAPI {

	/**
	 * This function handles GET requests, return the MusicManagerDTO received (currently)
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/music-manager")
	public SongDTO getMusicManager(@RequestBody SongDTO model) {
		return model;
	}

	/**
	 * This function handles POST requests, return the MusicManagerDTO received (currently)
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/music-manager")
	public SongDTO createMusicManager(@RequestBody SongDTO model) {
		return model;
	}

	/**
	 * This function handles PUT requests, return the MusicManagerDTO received (currently) 
	 * 
	 * @param model
	 * @return
	 */
	@PutMapping(value = "/music-manager")
	public SongDTO updateMusicManager(@RequestBody SongDTO model) {
		return model;
	}

	/**
	 * This function handles DELETE requests, does nothing (currently)
	 * 
	 * @param ids
	 */
	@DeleteMapping(value = "/music-manager")
	public void deleteMusicManager(@RequestBody long[] ids) {
	}

}
