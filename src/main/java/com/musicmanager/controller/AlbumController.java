package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.service.IAlbumService;

/**
 * AlbumController handles requests related to album
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
 */
@RestController
public class AlbumController {

	@Autowired
	IAlbumService albumService;

	/**
	 * Handles GET requests related to album
	 * Uses request parameter to send id
	 * 
	 * @param id of album to get
	 * @return album having matching id
	 */
	@RequestMapping(value = "/music-manager/album", method = RequestMethod.GET)
	public AlbumDTO getAlbum(@RequestParam long id) {
		return albumService.get(id);
	}

	/**
	 * Handles POST requests related to album
	 * Uses request body to send model
	 * 
	 * @param model to post
	 * @return posted model
	 */
	@RequestMapping(value = "/music-manager/album", method = RequestMethod.POST)
	public AlbumDTO createAlbum(@RequestBody AlbumDTO model) {
		return albumService.save(model);
	}

	/**
	 * Handles PUT requests related to album
	 * Uses request body to send model and path variable to send id
	 * 
	 * @param updated model 
	 * @param id of old model to put
	 * @return put model
	 */
	@RequestMapping(value = "/music-manager/album/{album-id}", method = RequestMethod.PUT)
	public AlbumDTO updateAlbum(@RequestBody AlbumDTO model, @PathVariable(name = "album-id", required = true) long id) {
		model.setId(id);
		return albumService.save(model);
	}

	/**
	 * Handle DELETE requests related to album
	 * Uses request body to send ids
	 * 
	 * @param ids of albums to delete
	 */
	@RequestMapping(value = "/music-manager/album", method = RequestMethod.DELETE)
	public void deleteAlbum(@RequestBody long[] ids) {
		albumService.delete(ids);
	}

}
