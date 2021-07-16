package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;

/**
 * Tests SongConverter
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
public class SongConverterTest {

	SongConverter songConverter;

	@Before
	public void setUp() {
		System.out.println("Setting up.");
		songConverter = new SongConverter();
	}

	@After
	public void tearDown() {
		songConverter = null;
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test toDTO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToDTO() throws Exception {
		System.out.println("Testing toDTO.");

		// Given a SongEntity called songEntity
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		
		SingerEntity singerEntity1 = new SingerEntity();
		singerEntity1.setId(1L);
		
		SingerEntity singerEntity2 = new SingerEntity();
		singerEntity2.setId(2L);
		
		List<SingerEntity> singerEntities = new ArrayList<>();
		singerEntities.add(singerEntity1);
		singerEntities.add(singerEntity2);
		
		SongEntity songEntity = new SongEntity();
		songEntity.setId(1L);
		songEntity.setTitle("Song Title");
		songEntity.setAlbum(albumEntity);
		songEntity.setCategory("Song Category");
		songEntity.setSingers(singerEntities);

		// When convert songEntity to a SongDTO called songDTO
		SongDTO songDTO = songConverter.toDTO(songEntity);

		// Then songDTO's attributes equal songEnity's attributes respectively
		Assert.assertEquals(songEntity.getId(), songDTO.getId());
		Assert.assertEquals(songEntity.getTitle(), songDTO.getTitle());
		Assert.assertEquals(songEntity.getAlbum().getId(), songDTO.getAlbumId());
		Assert.assertEquals(songEntity.getCategory(), songDTO.getCategory());
		Assert.assertEquals(songEntity.getSingers().size(), songDTO.getSingerIds().size());
		for (int i = 0; i < songEntity.getSingers().size(); i++) {
			Assert.assertEquals(songEntity.getSingers().get(i).getId(), songDTO.getSingerIds().get(i));
		}
	}

	/**
	 * Test toEntity
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToEntity() throws Exception {
		System.out.println("Testing toEntity.");

		// Given a SongDTO called songDTO
		SongDTO songDTO = new SongDTO();
		songDTO.setId(1L);
		songDTO.setTitle("Song Title");
		songDTO.setAlbumId(null);
		songDTO.setCategory("Song Category");
		songDTO.setSingerIds(null);

		// When convert songDTO to a SongEntity called songEntity
		SongEntity songEntity = songConverter.toEntity(songDTO);

		// Then songEntity's attributes equal songDTO's attributes respectively
		Assert.assertEquals(songDTO.getId(), songEntity.getId());
		Assert.assertEquals(songDTO.getTitle(), songEntity.getTitle());
		Assert.assertEquals(songDTO.getCategory(), songEntity.getCategory());
	}

}
