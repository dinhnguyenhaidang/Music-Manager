package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SingerConverter;
import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.service.ISingerService;

/**
 * Provides services related to singer
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
@Service
public class SingerService implements ISingerService {

	@Autowired
	private SingerConverter singerConverter;

	@Autowired
	private SingerRepository singerRepository;

	@Override
	public SingerDTO get(long id) {
		SingerEntity entity = singerRepository.findOne(id);
		return singerConverter.toDTO(entity);
	}

	@Override
	public SingerDTO save(SingerDTO singerDTO) {
		// Initialize
		SingerEntity singerEntity = new SingerEntity();

		// Convert singerDTO to a singer entity and assign it to singerEntity
		singerEntity = singerConverter.toEntity(singerDTO);

		// Save singerEntity to database
		singerEntity = singerRepository.save(singerEntity);

		// Return a singer DTO converted from singerEntity
		return singerConverter.toDTO(singerEntity);
	}

	@Override
	public SingerDTO update(SingerDTO singerDTO) {
		// Get old singer entity
		SingerEntity singerEntity = singerRepository.findOne(singerDTO.getId());
		
		// Convert singerDTO to the old singer entity to update it
		singerEntity = singerConverter.toEntity(singerDTO);

		// Save singerEntity to database
		singerEntity = singerRepository.save(singerEntity);

		// Return a singer DTO converted from singerEntity
		return singerConverter.toDTO(singerEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			singerRepository.delete(id);
		}
	}

}
