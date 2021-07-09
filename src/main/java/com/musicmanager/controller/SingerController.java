package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.service.ISingerService;

/**
 * SingerController handles requests related to song
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-07
 */
@RestController
public class SingerController {
	
	@Autowired
	private ISingerService singerService;

	/**
	 * Handles GET requests related to singer
	 * Uses request parameter to send id
	 * 
	 * @param id of singer to get
	 * @return singer having matching id
	 */
	@RequestMapping(value = "/music-manager/singer", method = RequestMethod.GET)
	public SingerDTO getSinger(@RequestParam long id) {
		return singerService.get(id);
	}

	/**
	 * Handles POST requests related to singer
	 * Uses request body to send model
	 * 
	 * @param model to post
	 * @return posted model
	 */
	@RequestMapping(value = "/music-manager/singer", method = RequestMethod.POST)
	public SingerDTO createSinger(@RequestBody SingerDTO model) {
		return singerService.save(model);
	}

	/**
	 * Handles PUT requests related to singer
	 * Uses request body to send model and path variable to send id
	 * 
	 * @param updated model 
	 * @param id of old model to put
	 * @return put model
	 */
	@RequestMapping(value = "/music-manager/singer/{singer-id}", method = RequestMethod.PUT)
	public SingerDTO updateSinger(@RequestBody SingerDTO model, @PathVariable("singer-id") long id) {
		model.setId(id);
		return singerService.save(model);
	}

	/**
	 * Handle DELETE requests related to singer
	 * Uses request body to send ids
	 * 
	 * @param ids of singers to delete
	 */
	@RequestMapping(value = "/music-manager/singer", method = RequestMethod.DELETE)
	public void deleteSinger(@RequestBody long[] ids) {
		singerService.delete(ids);
	}

}
