package com.musicmanager.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.converter.AlbumConverter;
import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.repository.AlbumRepository;

/**
 * Tests AlbumService
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-19
 */
@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {

	private AlbumService albumService = new AlbumService();
	private AlbumConverter albumConverter;
	private AlbumRepository albumRepository;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of AlbumServiceTest.\n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("End of AlbumServiceTest.\n");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up.");
		albumConverter = Mockito.mock(AlbumConverter.class);
		albumRepository = Mockito.mock(AlbumRepository.class);
		albumService.setAlbumConverter(albumConverter);
		albumService.setAlbumRepository(albumRepository);
	}

	@After
	public void tearDOwn() {
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test get
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGet() throws Exception {
		System.out.println("Testing get.");

		// Given an AlbumEntity called albumEntity exists
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		albumEntity.setName("Album Name");

		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Album Name");

		Mockito.when(albumRepository.findOne(Mockito.anyLong())).thenReturn(albumEntity);
		Mockito.when(albumConverter.toDTO(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When get an album with id matching albumEntity's id
		AlbumDTO albumDTO = albumService.get(albumEntity.getId());

		// Then return a corresponding AlbumDTO
		Mockito.verify(albumRepository, Mockito.times(1)).findOne(Mockito.anyLong());
		Assert.assertEquals(albumEntity.getId(), albumDTO.getId());
		Assert.assertEquals(albumEntity.getName(), albumDTO.getName());
	}

	/**
	 * Test save
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		System.out.println("Testing save.");

		// Given an AlbumEntity called albumEntity
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		albumEntity.setName("Album Name");

		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Album Name");

		Mockito.when(albumConverter.toEntity(Mockito.anyObject())).thenReturn(albumEntity);
		Mockito.when(albumRepository.save(Mockito.any(AlbumEntity.class))).thenReturn(albumEntity);
		Mockito.when(albumConverter.toDTO(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When save albumEntity
		AlbumDTO actualAlbumDTO = albumService.save(expectedAlbumDTO);

		// Then save it and return a corresponding AlbumDTO
		Mockito.verify(albumRepository, Mockito.times(1)).save(albumEntity);
		Assert.assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		Assert.assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
	}

	/**
	 * Test update
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		System.out.println("Testing update.");

		// Given an AlbumEntity called albumEntity exists
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		albumEntity.setName("Album Name");

		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Updated Name");

		Mockito.when(albumRepository.findOne(Mockito.anyLong())).thenReturn(albumEntity);
		Mockito.when(albumConverter.toEntity(Mockito.anyObject())).thenReturn(albumEntity);
		Mockito.when(albumRepository.save(Mockito.any(AlbumEntity.class))).thenReturn(albumEntity);
		Mockito.when(albumConverter.toDTO(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When update albumEntity
		AlbumDTO actualAlbumDTO = albumService.update(expectedAlbumDTO);

		// Then update it and return a corresponding AlbumDTO
		Mockito.verify(albumRepository, Mockito.times(1)).save(albumEntity);
		Assert.assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		Assert.assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
	}

	/**
	 * Test delete
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		System.out.println("Testing delete.");

		// Given some AlbumEntities exist
		AlbumEntity albumEntity1 = new AlbumEntity();
		albumEntity1.setId(1L);

		AlbumEntity albumEntity2 = new AlbumEntity();
		albumEntity2.setId(2L);

		long[] ids = { albumEntity1.getId(), albumEntity2.getId() };
		Mockito.doNothing().when(albumRepository).delete(Mockito.anyLong());

		// When delete these AlbumEntities
		albumService.delete(ids);

		// Then these AlbumEntities are deleted
		Mockito.verify(albumRepository, Mockito.times(1)).delete(albumEntity1.getId());
		Mockito.verify(albumRepository, Mockito.times(1)).delete(albumEntity2.getId());
	}

}
