package com.musicmanager.converter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;

/**
 * Tests AlbumConverter
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
public class AlbumConverterTest {

	private AlbumConverter albumConverter;

	@Before
	public void setUp() {
		System.out.println("Setting up.");
		albumConverter = new AlbumConverter();
	}
	
	@After
	public void tearDown() {
		albumConverter = null;
		System.out.println("Tearing down.\n");
	}
	
	/**
	 * Test toDTO
	 */
	@Test
	public void testToDTO() {
		System.out.println("Testing toDTO.");
		
		// Given an AlbumEntity called albumEntity
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		albumEntity.setName("Album Name");

		// When convert albumEntity to an AlbumDTO called albumDTO
		AlbumDTO albumDTO = albumConverter.toDTO(albumEntity);

		// Then albumDTO's attributes equal albumEntity's attributes respectively
		Assert.assertEquals(albumEntity.getId(), albumDTO.getId());
		Assert.assertEquals(albumEntity.getName(), albumDTO.getName());
	}

	/**
	 * Test toEntity
	 */
	@Test
	public void testToEntity() {
		System.out.println("Testing toEntity.");
		
		// Given an AlbumDTO called albumDTO
		AlbumDTO albumDTO = new AlbumDTO();
		albumDTO.setId(1L);
		albumDTO.setName("Album Name");

		// When convert albumDTO to an AlbumEntity called albumEntity
		AlbumEntity albumEntity = albumConverter.toEntity(albumDTO);

		// Then albumEntity's attributes equal albumDTO's attributes respectively
		Assert.assertEquals(albumDTO.getId(), albumEntity.getId());
		Assert.assertEquals(albumDTO.getName(), albumEntity.getName());
	}

}
