package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;

/**
 * Tests SingerConverter
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-14
 */
public class SingerConverterTest {

	private SingerConverter singerConverter;

	@Before
	public void setUp() {
		System.out.println("Setting up.");
		singerConverter = new SingerConverter();
	}

	@After
	public void tearDown() {
		singerConverter = null;
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test toDTO
	 */
	@Test
	public void testToDTO() {
		System.out.println("Testing toDTO.");

		// Given a SingerEntity called singerEntity
		SongEntity songEntity1 = new SongEntity();
		songEntity1.setId(1L);

		SongEntity songEntity2 = new SongEntity();
		songEntity2.setId(2L);

		List<SongEntity> songEntities = new ArrayList<>();
		songEntities.add(songEntity1);
		songEntities.add(songEntity2);

		SingerEntity singerEntity = new SingerEntity();
		singerEntity.setId(1L);
		singerEntity.setName("Singer Name");
		singerEntity.setAge(1);
		singerEntity.setSongs(songEntities);

		// When convert singerEntity to a SingerDTO called singerDTO
		SingerDTO singerDTO = singerConverter.toDTO(singerEntity);

		// Then singerDTO's attributes equal singerEntity's attributes
		Assert.assertEquals(singerEntity.getId(), singerDTO.getId());
		Assert.assertEquals(singerEntity.getName(), singerDTO.getName());
		Assert.assertEquals(singerEntity.getAge(), singerDTO.getAge());
		Assert.assertEquals(singerEntity.getSongs().size(), singerDTO.getSongIds().size());
		for (int i = 0; i < singerEntity.getSongs().size(); i++) {
			Assert.assertEquals(singerEntity.getSongs().get(i).getId(), singerDTO.getSongIds().get(i));
		}
	}

	/**
	 * Test toEntity
	 */
	@Test
	public void testToEntity() {
		System.out.println("Testing toEntity.");

		// Given a SingerDTO called singerDTO
		List<Long> songIds = new ArrayList<>();
		songIds.add(1L);
		songIds.add(2L);

		SingerDTO singerDTO = new SingerDTO();
		singerDTO.setId(1L);
		singerDTO.setName("Singer Name");
		singerDTO.setAge(1);
		singerDTO.setSongIds(songIds);

		// When convert singerDTO to a SingerEntity called singerEntity
		SingerEntity singerEntity = singerConverter.toEntity(singerDTO);

		// Then singerEntity's attributes equal singerDTO's attributes respectively
		Assert.assertEquals(singerDTO.getId(), singerEntity.getId());
		Assert.assertEquals(singerDTO.getName(), singerEntity.getName());
		Assert.assertEquals(singerDTO.getAge(), singerEntity.getAge());
	}

}
