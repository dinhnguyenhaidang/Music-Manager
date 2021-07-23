package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.service.IAlbumService;

/**
 * Handles requests related to album
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-23
 */
@RestController
public class AlbumController {

	@Autowired
	private IAlbumService albumService;

	/**
	 * Handles GET requests related to album
	 * 
	 * @param id of album to read, receive from path variable
	 * @return an album DTO that has the requested id
	 */
	@RequestMapping(value = "/music-manager/album/{album-id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public AlbumDTO readAlbum(@PathVariable(name = "album-id", required = true) long id) {
		return albumService.get(id);
	}

	/**
	 * Handles POST requests related to album
	 * 
	 * @param model to create, receive from request body
	 * @return an album DTO that matches the model
	 */
	@RequestMapping(value = "/music-manager/album", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public AlbumDTO createAlbum(@RequestBody AlbumDTO model) {
		return albumService.save(model);
	}

	/**
	 * Handles PUT requests related to album
	 * 
	 * @param model to update, receive from request body
	 * @param id of album to update, receive from path variable
	 * @return an album DTO that matches the model
	 */
	@RequestMapping(value = "/music-manager/album/{album-id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public AlbumDTO updateAlbum(@RequestBody AlbumDTO model, @PathVariable(name = "album-id", required = true) long id) {
		model.setId(id);
		return albumService.update(model);
	}

	/**
	 * Handle DELETE requests related to album
	 * 
	 * @param ids of albums to delete, receive from request body
	 */
	@RequestMapping(value = "/music-manager/album", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAlbum(@RequestBody long[] ids) {
		albumService.delete(ids);
	}

}
