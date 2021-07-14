package com.musicmanager.converter;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.entity.SingerEntity;
import com.musicmanager.entity.SongEntity;

@RunWith(MockitoJUnitRunner.class)
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
	 * Test toDTO(singerEntity)
	 */
	@Test
	public void testToDTO() {
		System.out.println("Testing toDTO(singerEntity)");

		// Given a SingerEntity called singerEntity
		SongEntity songEntity1 = new SongEntity();
		songEntity1.setId(Long.valueOf(1));

		SongEntity songEntity2 = new SongEntity();
		songEntity2.setId(Long.valueOf(2));

		List<SongEntity> songEntities = new ArrayList<>();
		songEntities.add(songEntity1);
		songEntities.add(songEntity2);

		SingerEntity singerEntity = new SingerEntity();
		singerEntity.setId(Long.valueOf(1));
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
	 * Test toEntity(singerDTO)
	 */
	@Test
	public void testToEntity() {
		System.out.println("Testing toEntity(singerDTO)");

		// Given a SingerDTO called singerDTO
		List<Long> songIds = new ArrayList<>();
		songIds.add(Long.valueOf(1));
		songIds.add(Long.valueOf(2));

		SingerDTO singerDTO = new SingerDTO();
		singerDTO.setId(Long.valueOf(1));
		singerDTO.setName("Singer Name");
		singerDTO.setAge(1);
		singerDTO.setSongIds(songIds);

		// When convert singerDTO to a SingerEntity called singerEntity
		SingerEntity singerEntity = singerConverter.toEntity(singerDTO);

		// Then singerEntity's attributes equal singerDTO's attributes respectively
		Assert.assertEquals(singerDTO.getId(), singerEntity.getId());
		Assert.assertEquals(singerDTO.getName(), singerEntity.getName());
		Assert.assertEquals(singerDTO.getAge(), singerEntity.getAge());
		Assert.assertEquals(singerDTO.getSongIds().size(), singerEntity.getSongs().size());
		for (int i = 0; i < singerDTO.getSongIds().size(); i++) {
			Assert.assertEquals(singerDTO.getSongIds().get(i), singerEntity.getSongs().get(i).getId());
		}
	}

//	@Test
//	public void testToEntity2() {
//		System.out.println("Test toEntity2");
//
//		// Given
//		SingerDTO singerDTO = new SingerDTO();
//		singerDTO.setName("Singer Name Updated");
//		singerDTO.setAge(2);
//
//		SingerEntity oldSingerEntity = new SingerEntity();
//		oldSingerEntity.setName("Singer Name");
//		oldSingerEntity.setAge(1);
//
//		SingerEntity expectedSingerEntity = new SingerEntity();
//		expectedSingerEntity.setName("Singer Name Updated");
//		expectedSingerEntity.setAge(2);
//
//		// When
//		SingerEntity actualSingerEntity = singerConverter.toEntity(singerDTO, oldSingerEntity);
//
//		// Then
//		System.out.println("Singer Name: " + expectedSingerEntity.getName() + " - " + actualSingerEntity.getName());
//		Assert.assertEquals(expectedSingerEntity.getName(), actualSingerEntity.getName());
//
//		System.out.println("Singer Age: " + expectedSingerEntity.getAge() + " - " + actualSingerEntity.getAge());
//		Assert.assertEquals(expectedSingerEntity.getAge(), actualSingerEntity.getAge());
//	}

}
