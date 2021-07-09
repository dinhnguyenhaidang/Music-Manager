package com.musicmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicmanager.converter.SingerConverter;
import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.service.ISingerService;

/**
 * SingerService provides services related to album
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-02
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
		SingerEntity singerEntity = new SingerEntity();

		// If id != null, HTTP method is PUT, otherwise HTTP method is POST
		if (singerDTO.getId() != null) {
			// Get old song entity
			SingerEntity oldSingerEntity = singerRepository.findOne(singerDTO.getId());
			singerEntity = singerConverter.toEntity(singerDTO, oldSingerEntity);
		} else {
			// Convert songDTO to songEntity to process
			singerEntity = singerConverter.toEntity(singerDTO);
		}

		// Save songEntity to DB
		singerEntity = singerRepository.save(singerEntity);

		// Return the saved singerEntity as singerDTO to check
		return singerConverter.toDTO(singerEntity);
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			singerRepository.delete(item);
		}
	}

}
