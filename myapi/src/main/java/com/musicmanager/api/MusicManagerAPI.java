package com.musicmanager.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.musicmanager.dto.MusicManagerDTO;

/**
 * This class does nothing
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-30-06
 */
@Controller
public class MusicManagerAPI {
	
	@RequestMapping(value = "/music-manager", method = RequestMethod.POST)
	
	@ResponseBody()
	public MusicManagerDTO createMusicManager(MusicManagerDTO model) {
		return model;
	}
	
}
