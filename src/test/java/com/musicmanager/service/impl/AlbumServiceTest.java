package com.musicmanager.service.impl;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.entity.AlbumEntity;
import com.musicmanager.repository.AlbumRepository;

/**
 * Tests AlbumService
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-14
 */
@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {

	@InjectMocks
	private AlbumService albumService;

	@Mock
	private AlbumRepository albumRepository;

	@Before
	public void setUp() {
		System.out.println("Setting up.");
	}

	@After
	public void tearDOwn() {
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test get
	 */
	@Test
	public void testGet() {
		System.out.println("Testing get.");

		// Given an AlbumEntity called albumEntity exists
		AlbumEntity albumEntity = new AlbumEntity();
		albumEntity.setId(1L);
		
		when(albumRepository.findOne(albumEntity.getId())).thenReturn(albumEntity);

		// When get that AlbumEntity
		AlbumDTO albumDTO = albumService.get(albumEntity.getId());
		System.out.println(albumDTO.getId());

		// Then return a corresponding AlbumDTO
		Assert.assertEquals(albumEntity.getId(), albumDTO.getId());
	}

	/**
	 * Test save
	 */
	@Test
	public void testSave() {
		System.out.println("Testing save.");

		// Given

		// When

		// Then

	}

	/**
	 * Test update
	 */
	@Test
	public void testUpdate() {
		System.out.println("Testing update.");

		// Given

		// When

		// Then

	}

	/**
	 * Test delete
	 */
	@Test
	public void testDelete() {
		System.out.println("Testing delete.");

		// Given

		// When

		// Then

	}

}
