package com.musicmanager.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.musicmanager.AbstractControllerTest;
import com.musicmanager.dto.SongDTO;

public class SongControllerTest extends AbstractControllerTest {

	@Before
	public void setUp() {
		System.out.println("Setting up.");
		super.setUp();
	}

	@After
	public void tearDown() {
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test readSong
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadSong() throws Exception {
		System.out.println("Testing readSong.");

		// Given a song exists

		// When request get that song
		String uri = "/music-manager/song/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return that song with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);

		SongDTO songDTO = super.mapFromJson(response, SongDTO.class);
		assertTrue(songDTO != null);
	}

	/**
	 * Test createSong
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateSong() throws Exception {
		System.out.println("Testing createSong.");

		// When request create a song
		String uri = "/music-manager/song";
		
		SongDTO songDTO = new SongDTO();
		
		songDTO.setId(1L);
		songDTO.setTitle("Song Title");
		songDTO.setCategory("Song Category");
		String inputJson = super.mapToJson(songDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create and return that song with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);
	}

	/**
	 * Test updateSong
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateSong() throws Exception {
		System.out.println("Testing updateSong.");

		// Given a song exists

		// When request update that song
		String uri = "/music-manager/song/1";
		
		SongDTO songDTO = new SongDTO();
		songDTO.setTitle("Updated Title");
		songDTO.setCategory("Updated Category");
		String inputJson = super.mapToJson(songDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated song with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);
	}

	/**
	 * Test deleteSong
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteSong() throws Exception {
		System.out.println("Testing deleteSong.");

		// Given some songs exists

		// When request delete these songs
		String uri = "/music-manager/song";
		
		long[] ids = { 1, 2 };
		String inputJson = super.mapToJson(ids);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these songs and return with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response, "");
	}

}
