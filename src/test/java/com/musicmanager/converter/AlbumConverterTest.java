package com.musicmanager.converter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;

@RunWith(MockitoJUnitRunner.class)
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
	 * Test toDTO(albumEntity)
	 */
	@Test
	public void testToDTO() {
		System.out.println("Testing toDTO(albumEntity).");
		
		// Given an AlbumEntity called albumEntity
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(Long.valueOf(1));
		albumEntity.setName("Album Name");

		// When convert albumEntity to an AlbumDTO called albumDTO
		AlbumDTO albumDTO = albumConverter.toDTO(albumEntity);

		// Then albumDTO's attributes equal albumEntity's attributes respectively
		Assert.assertEquals(albumEntity.getId(), albumDTO.getId());
		Assert.assertEquals(albumEntity.getName(), albumDTO.getName());
	}

	/**
	 * Test toEntity(albumDTO)
	 */
	@Test
	public void testToEntity() {
		System.out.println("Testing toEntity(albumDTO).");
		
		// Given an AlbumDTO called albumDTO
		AlbumDTO albumDTO = new AlbumDTO();
		albumDTO.setId(Long.valueOf(1));
		albumDTO.setName("Album Name");

		// When convert albumDTO to an AlbumEntity called albumEntity
		AlbumEntity albumEntity = albumConverter.toEntity(albumDTO);

		// Then albumEntity's attributes equal albumDTO's attributes respectively
		Assert.assertEquals(albumDTO.getId(), albumEntity.getId());
		Assert.assertEquals(albumDTO.getName(), albumEntity.getName());
	}

	/**
	 * Test toEntity(updatedDTO, oldEntity) function
	 */
//	@Test
//	public void testToEntity2() {
//		System.out.println("Test toEntity2");
//		
//		// Given
//		AlbumDTO albumDTO = new AlbumDTO();
//		albumDTO.setName("Album Name Updated");
//
//		AlbumEntity oldAlbumEntity = new AlbumEntity();
//		oldAlbumEntity.setName("Album Name");
//
//		AlbumEntity expectedAlbumEntity = new AlbumEntity();
//		expectedAlbumEntity.setName("Album Name Updated");
//
//		// When
//		AlbumEntity actualAlbumEntity = albumConverter.toEntity(albumDTO, oldAlbumEntity);
//
//		// Then
//		System.out.println("Album Name: " + expectedAlbumEntity.getName() + " - " + actualAlbumEntity.getName());
//		Assert.assertEquals(expectedAlbumEntity.getName(), actualAlbumEntity.getName());
//	}

}
