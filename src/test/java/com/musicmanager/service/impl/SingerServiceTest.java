package com.musicmanager.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.converter.SingerConverter;
import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.repository.SongRepository;

/**
 * Tests SingerService
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-14
 */
@RunWith(MockitoJUnitRunner.class)
public class SingerServiceTest {

	@InjectMocks
	private SingerService singerService = new SingerService();

	@Mock
	private SingerConverter singerConverter;

	@Mock
	private SingerRepository singerRepository;
	
	@Mock
	private SongRepository songRepository;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of SingerServiceTest.\n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("End of SingerServiceTest.\n");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up.");
		singerConverter = Mockito.mock(SingerConverter.class);
		singerRepository = Mockito.mock(SingerRepository.class);
		songRepository = Mockito.mock(SongRepository.class);
		singerService.setSingerConverter(singerConverter);
		singerService.setSingerRepository(singerRepository);
		singerService.setSongRepository(songRepository);
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

		// Given a SingerEntity called singerEntity exists
		SingerEntity singerEntity = new SingerEntity();
		singerEntity.setId(1L);
		singerEntity.setName("Singer Name");
		singerEntity.setAge(10);

		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Singer Name");
		expectedSingerDTO.setAge(10);

		Mockito.when(singerRepository.findOne(Mockito.anyLong())).thenReturn(singerEntity);
		Mockito.when(singerConverter.toDTO(Mockito.anyObject())).thenReturn(expectedSingerDTO);

		// When get a singer with id matching singerEntity's id
		SingerDTO singerDTO = singerService.get(singerEntity.getId());

		// Then return a corresponding SingerDTO
		Mockito.verify(singerRepository, Mockito.times(1)).findOne(Mockito.anyLong());
		Assert.assertEquals(singerEntity.getId(), singerDTO.getId());
		Assert.assertEquals(singerEntity.getName(), singerDTO.getName());
		Assert.assertEquals(singerEntity.getAge(), singerDTO.getAge());
	}

	/**
	 * Test save
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		System.out.println("Testing save.");

		// Given an SingerEntity called singerEntity
		SingerEntity singerEntity = new SingerEntity();
		singerEntity.setId(1L);
		singerEntity.setName("Singer Name");

		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Singer Name");

		Mockito.when(singerConverter.toEntity(Mockito.anyObject())).thenReturn(singerEntity);
		Mockito.when(singerRepository.save(Mockito.any(SingerEntity.class))).thenReturn(singerEntity);
		Mockito.when(singerConverter.toDTO(Mockito.anyObject())).thenReturn(expectedSingerDTO);

		// When save albumEntity
		SingerDTO actualSingerDTO = singerService.save(expectedSingerDTO);

		// Then save it and return a corresponding AlbumDTO
		Mockito.verify(singerRepository, Mockito.times(1)).save(singerEntity);
		Assert.assertEquals(expectedSingerDTO.getId(), actualSingerDTO.getId());
		Assert.assertEquals(expectedSingerDTO.getName(), actualSingerDTO.getName());
		Assert.assertEquals(expectedSingerDTO.getAge(), actualSingerDTO.getAge());
	}

	/**
	 * Test update
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		System.out.println("Testing update.");

		// Given a SingerEntity called singerEntity exists
		SingerEntity singerEntity = new SingerEntity();
		singerEntity.setId(1L);
		singerEntity.setName("Singer Name");
		singerEntity.setAge(10);

		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Updated Name");
		expectedSingerDTO.setAge(20);

		Mockito.when(singerRepository.findOne(Mockito.anyLong())).thenReturn(singerEntity);
		Mockito.when(singerConverter.toEntity(Mockito.anyObject())).thenReturn(singerEntity);
		Mockito.when(singerRepository.save(Mockito.any(SingerEntity.class))).thenReturn(singerEntity);
		Mockito.when(singerConverter.toDTO(Mockito.anyObject())).thenReturn(expectedSingerDTO);

		// When update singerEntity
		SingerDTO actualSingerDTO = singerService.update(expectedSingerDTO);

		// Then update it and return a corresponding SingerDTO
		Mockito.verify(singerRepository, Mockito.times(1)).save(singerEntity);
		Assert.assertEquals(expectedSingerDTO.getId(), actualSingerDTO.getId());
		Assert.assertEquals(expectedSingerDTO.getName(), actualSingerDTO.getName());
		Assert.assertEquals(expectedSingerDTO.getAge(), actualSingerDTO.getAge());
	}

	/**
	 * Test delete
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		System.out.println("Testing delete.");

		// Given some SingerEntities exist
		SingerEntity singerEntity1 = new SingerEntity();
		singerEntity1.setId(1L);
		
		SingerEntity singerEntity2 = new SingerEntity();
		singerEntity2.setId(2L);
		
		long[] ids = { singerEntity1.getId(), singerEntity2.getId() };
		Mockito.doNothing().when(singerRepository).delete(Mockito.anyLong());

		// When delete these SingerEntities
		singerService.delete(ids);

		// Then these SingerEntities are deleted
		Mockito.verify(singerRepository, Mockito.times(1)).delete(singerEntity1.getId());
		Mockito.verify(singerRepository, Mockito.times(1)).delete(singerEntity2.getId());
	}

}
