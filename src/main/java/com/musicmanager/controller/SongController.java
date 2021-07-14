package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.service.ISongService;

/**
 * Handles requests related to song
 * 
 * @author Void Wind
 * @version 1.4
 * @since 2021-07-12
 */
@RestController
public class SongController {

	@Autowired
	private ISongService songService;

	/**
	 * Handles GET requests related to song
	 * 
	 * @param id of song to read, receive from path variable
	 * @return a song DTO that has the requested id
	 */
	@RequestMapping(value = "/music-manager/song/{song-id}", method = RequestMethod.GET)
	public SongDTO readtSong(@PathVariable("song-id") long id) {
		return songService.get(id);
	}

	/**
	 * Handles POST requests related to song
	 * 
	 * @param model to create, receive from request body
	 * @return a song DTO that matches the model
	 */
	@RequestMapping(value = "/music-manager/song", method = RequestMethod.POST)
	public SongDTO createSong(@RequestBody SongDTO model) {
		return songService.save(model);
	}

	/**
	 * Handles PUT requests related to song
	 * 
	 * @param model to update, receive from request body
	 * @param id of the song to update, receive from path variable
	 * @return a song DTO that matches the model 
	 */
	@RequestMapping(value = "/music-manager/song/{song-id}", method = RequestMethod.PUT)
	public SongDTO updateSong(@RequestBody SongDTO model, @PathVariable("song-id") long id) {
		model.setId(id);
		return songService.update(model);
	}

	/**
	 * Handle DELETE requests related to song
	 * 
	 * @param ids of songs to delete, receive from request body
	 */
	@RequestMapping(value = "/music-manager/song", method = RequestMethod.DELETE)
	public void deleteSong(@RequestBody long[] ids) {
		songService.delete(ids);
	}

}
