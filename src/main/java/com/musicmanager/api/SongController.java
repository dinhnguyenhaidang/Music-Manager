package com.musicmanager.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public void getSong(@RequestBody long[] ids) {
	}

	@PostMapping(value = "/music-manager/song")
	public SongDTO createSong(@RequestBody SongDTO model) {
		return songService.save(model);
	}

	@PutMapping(value = "/music-manager/song")
	public SongDTO updateSong(@RequestBody SongDTO model) {
		return model;
	}

	@DeleteMapping(value = "/music-manager/song")
	public void deleteSong(@RequestBody long[] ids) {
	}

}
