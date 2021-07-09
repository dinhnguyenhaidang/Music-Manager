package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.service.ISongService;

/**
 * SongController handles requests related to song
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-07
 */
@RestController
public class SongController {

	@Autowired
	private ISongService songService;

	/**
	 * Handles GET requests related to song
	 * Uses request parameter to send id
	 * 
	 * @param id of song to get
	 * @return song having matching id
	 */
	@RequestMapping(value = "/music-manager/song", method = RequestMethod.GET)
	public SongDTO getSong(@RequestParam long id) {
		return songService.get(id);
	}

	/**
	 * Handles POST requests related to song
	 * Uses request body to send model
	 * 
	 * @param model to post
	 * @return posted model
	 */
	@RequestMapping(value = "/music-manager/song", method = RequestMethod.POST)
	public SongDTO createSong(@RequestBody SongDTO model) {
		return songService.save(model);
	}

	/**
	 * Handles PUT requests related to song
	 * Uses request body to send model and path variable to send id
	 * 
	 * @param updated model 
	 * @param id of old model to put
	 * @return put model
	 */
	@RequestMapping(value = "/music-manager/song/{song-id}", method = RequestMethod.PUT)
	public SongDTO updateSong(@RequestBody SongDTO model, @PathVariable("song-id") long id) {
		model.setId(id);
		return songService.save(model);
	}

	/**
	 * Handle DELETE requests related to song
	 * Uses request body to send ids
	 * 
	 * @param ids of songs to delete
	 */
	@RequestMapping(value = "/music-manager/song", method = RequestMethod.DELETE)
	public void deleteSong(@RequestBody long[] ids) {
		songService.delete(ids);
	}

}
