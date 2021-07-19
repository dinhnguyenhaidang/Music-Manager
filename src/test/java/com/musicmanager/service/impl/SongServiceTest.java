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

import com.musicmanager.converter.SongConverter;
import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SongEntity;
import com.musicmanager.repository.AlbumRepository;
import com.musicmanager.repository.SingerRepository;
import com.musicmanager.repository.SongRepository;

/**
 * Tests SongService
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-14
 */
@RunWith(MockitoJUnitRunner.class)
public class SongServiceTest {

	private SongService songService = new SongService();
	private SongConverter songConverter;
	private AlbumRepository albumRepository;
	private SingerRepository singerRepository;
	private SongRepository songRepository;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of SongServiceTest.\n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("End of SongServiceTest.\n");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up.");
		songConverter = Mockito.mock(SongConverter.class);
		albumRepository = Mockito.mock(AlbumRepository.class);
		singerRepository = Mockito.mock(SingerRepository.class);
		songRepository = Mockito.mock(SongRepository.class);
		songService.setSongConverter(songConverter);
		songService.setAlbumRepository(albumRepository);
		songService.setSingerRepository(singerRepository);
		songService.setSongRepository(songRepository);
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

		// Given a SongEntity called songEntity exists
		SongEntity songEntity = new SongEntity();
		songEntity.setId(1L);
		songEntity.setTitle("Song Title");
		songEntity.setCategory("Song Category");

		SongDTO expectedAlbumDTO = new SongDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setTitle("Song Title");
		expectedAlbumDTO.setCategory("Song Category");

		Mockito.when(songRepository.findOne(Mockito.anyLong())).thenReturn(songEntity);
		Mockito.when(songConverter.toDTO(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When get a song with id matching songEntity's id
		SongDTO songDTO = songService.get(songEntity.getId());

		// Then return a corresponding SongDTO
		Mockito.verify(songRepository, Mockito.times(1)).findOne(Mockito.anyLong());
		Assert.assertEquals(songEntity.getId(), songDTO.getId());
		Assert.assertEquals(songEntity.getTitle(), songDTO.getTitle());
		Assert.assertEquals(songEntity.getCategory(), songDTO.getCategory());
	}

	/**
	 * Test save
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception {
		System.out.println("Testing save.");

		// Given a SongEntity called songEntity
		SongEntity songEntity = new SongEntity();
		songEntity.setId(1L);
		songEntity.setTitle("Song Title");
		songEntity.setCategory("Song Category");

		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(1L);
		expectedSongDTO.setTitle("Song Title");
		expectedSongDTO.setCategory("Song Category");

		Mockito.when(songConverter.toEntity(Mockito.anyObject())).thenReturn(songEntity);
		Mockito.when(songRepository.save(Mockito.any(SongEntity.class))).thenReturn(songEntity);
		Mockito.when(songConverter.toDTO(Mockito.anyObject())).thenReturn(expectedSongDTO);

		// When save songEntity
		SongDTO actualSongDTO = songService.save(expectedSongDTO);

		// Then save it and return a corresponding SongDTO
		Mockito.verify(songRepository, Mockito.times(1)).save(songEntity);
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	/**
	 * Test update
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		System.out.println("Testing update.");

		// Given an SongEntity called songEntity exists
		SongEntity songEntity = new SongEntity();
		songEntity.setId(1L);
		songEntity.setTitle("Song Title");
		songEntity.setCategory("Song Category");

		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(1L);
		expectedSongDTO.setTitle("Song Title");
		expectedSongDTO.setCategory("Song Category");

		Mockito.when(songRepository.findOne(Mockito.anyLong())).thenReturn(songEntity);
		Mockito.when(songConverter.toEntity(Mockito.anyObject())).thenReturn(songEntity);
		Mockito.when(songRepository.save(Mockito.any(SongEntity.class))).thenReturn(songEntity);
		Mockito.when(songConverter.toDTO(Mockito.anyObject())).thenReturn(expectedSongDTO);

		// When update songEntity
		SongDTO actualSongDTO = songService.update(expectedSongDTO);

		// Then update it and return a corresponding AlbumDTO
		Mockito.verify(songRepository, Mockito.times(1)).save(songEntity);
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	/**
	 * Test delete
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		System.out.println("Testing delete.");

		// Given some SongEntities exist
		SongEntity songEntity1 = new SongEntity();
		songEntity1.setId(1L);
		
		SongEntity songEntity2 = new SongEntity();
		songEntity2.setId(2L);

		long[] ids = { songEntity1.getId(), songEntity2.getId() };
		Mockito.doNothing().when(songRepository).delete(Mockito.anyLong());

		// When delete these SongEntities
		songService.delete(ids);

		// Then these SongEntities are deleted
		Mockito.verify(songRepository, Mockito.times(1)).delete(songEntity1.getId());
		Mockito.verify(songRepository, Mockito.times(1)).delete(songEntity2.getId());
	}

}
