package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.service.ISongService;

/**
 * SongController handles requests related to song
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-02
 */
@RestController
public class SongController {

	@Autowired
	private ISongService songService;

	@GetMapping(value = "/music-manager/song")
	public SongDTO getSong(@RequestBody long id) {
		return songService.get(id);
	}

	@PostMapping(value = "/music-manager/song")
	public SongDTO createSong(@RequestBody SongDTO model) {
		return songService.save(model);
	}

	@PutMapping(value = "/music-manager/song/{id}")
	public SongDTO updateSong(@RequestBody SongDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return songService.save(model);
	}

	@DeleteMapping(value = "/music-manager/song")
	public void deleteSong(@RequestBody long[] ids) {
		songService.delete(ids);
	}

}
