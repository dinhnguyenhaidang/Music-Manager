package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/music-manager/album")
	public void getAlbum(@RequestBody long[] ids) {
	}

	@PostMapping(value = "/music-manager/album")
	public AlbumDTO createAlbum(@RequestBody AlbumDTO model) {
		return albumService.save(model);
	}

	@PutMapping(value = "/music-manager/album")
	public AlbumDTO updateAlbum(@RequestBody AlbumDTO model) {
		return model;
	}

	@DeleteMapping(value = "/music-manager/album")
	public void deleteAlbum(@RequestBody long[] ids) {
		albumService.delete(ids);
	}
	
}
