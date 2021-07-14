package com.musicmanager.converter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.entity.SongEntity;

@RunWith(MockitoJUnitRunner.class)
public class SongConverterTest {

	SongConverter songConverter;
	
	@Before
	public void setUp() {
		System.out.println("Setting Up");
		songConverter = new SongConverter();
	}
	
	@After
	public void tearDown() {
		songConverter = null;
		System.out.println("Tearing Down\n");
	}

	@Test
	public void testToDTO() {
		System.out.println("Test toDTO");
		
		// Given
		SongEntity songEntity = new SongEntity();
		songEntity.setId(Long.valueOf(1));
		songEntity.setTitle("Song Title");
		songEntity.setCategory("Song Category");

		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(Long.valueOf(1));
		expectedSongDTO.setTitle("Song Title");
		expectedSongDTO.setCategory("Song Category");

		// When
		SongDTO actualSongDTO = songConverter.toDTO(songEntity);

		// Then
		System.out.println("Song Id: " + expectedSongDTO.getId() + " - " + actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		
		System.out.println("Song Title: " + expectedSongDTO.getTitle() + " - " + actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		
		System.out.println("Song Category: " + expectedSongDTO.getCategory() + " - " + actualSongDTO.getCategory());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	@Test
	public void testToEntity() {
		System.out.println("Test toEntity");
		
		// Given
		SongDTO songDTO = new SongDTO();
		songDTO.setTitle("Song Title");
		songDTO.setCategory("Song Category");

		SongEntity expectedSongEntity = new SongEntity();
		expectedSongEntity.setTitle("Song Title");
		expectedSongEntity.setCategory("Song Category");

		// When
		SongEntity actualSongEntity = songConverter.toEntity(songDTO);

		// Then
		System.out.println("Song Title: " + expectedSongEntity.getTitle() + " - " + actualSongEntity.getTitle());
		Assert.assertEquals(expectedSongEntity.getTitle(), actualSongEntity.getTitle());
		
		System.out.println("Song Category: " + expectedSongEntity.getCategory() + " - " + actualSongEntity.getCategory());
		Assert.assertEquals(expectedSongEntity.getCategory(), actualSongEntity.getCategory());
	}

	@Test
	public void testToEntity2() {
		System.out.println("Test toEntity2");
		
		// Given
		SongDTO songDTO = new SongDTO();
		songDTO.setTitle("Song Title Updated");
		songDTO.setCategory("Song Category Updated");

		SongEntity oldSongEntity = new SongEntity();
		oldSongEntity.setTitle("Song Title");
		oldSongEntity.setCategory("Song Category");

		SongEntity expectedSongEntity = new SongEntity();
		expectedSongEntity.setTitle("Song Title Updated");
		expectedSongEntity.setCategory("Song Category Updated");

		// When
		SongEntity actualSongEntity = songConverter.toEntity(songDTO);

		// Then
		System.out.println("Song Title: " + expectedSongEntity.getTitle() + " - " + actualSongEntity.getTitle());
		Assert.assertEquals(expectedSongEntity.getTitle(), actualSongEntity.getTitle());
		
		System.out.println("Song Category: " + expectedSongEntity.getCategory() + " - " + actualSongEntity.getCategory());
		Assert.assertEquals(expectedSongEntity.getCategory(), actualSongEntity.getCategory());
	}

}
