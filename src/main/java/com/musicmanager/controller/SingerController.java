package com.musicmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.service.ISingerService;

/**
 * Handles requests related to song
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-23
 */
@RestController
public class SingerController {
	
	@Autowired
	private ISingerService singerService;

	/**
	 * Handles GET requests related to singer
	 * 
	 * @param id of singer to read, receive from path variable
	 * @return a singer DTO that has the requested id
	 */
	@RequestMapping(value = "/music-manager/singer/{singer-id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public SingerDTO readSinger(@PathVariable("singer-id") long id) {
		return singerService.get(id);
	}

	/**
	 * Handles POST requests related to singer
	 * 
	 * @param model to create, receive from request body
	 * @return a singer DTO that matches the model
	 */
	@RequestMapping(value = "/music-manager/singer", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public SingerDTO createSinger(@RequestBody SingerDTO model) {
		return singerService.save(model);
	}

	/**
	 * Handles PUT requests related to singer
	 * 
	 * @param model to update, receive from request body
	 * @param id of singer to update, receive from path variable
	 * @return a singer DTO that matches the model 
	 */
	@RequestMapping(value = "/music-manager/singer/{singer-id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public SingerDTO updateSinger(@RequestBody SingerDTO model, @PathVariable("singer-id") long id) {
		model.setId(id);
		return singerService.update(model);
	}

	/**
	 * Handle DELETE requests related to singer
	 * 
	 * @param ids of singers to delete, receive from request body
	 */
	@RequestMapping(value = "/music-manager/singer", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteSinger(@RequestBody long[] ids) {
		singerService.delete(ids);
	}

}
