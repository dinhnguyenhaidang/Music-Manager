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
import com.musicmanager.dto.SingerDTO;

public class SingerControllerTest extends AbstractControllerTest {

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
	 * Test readSinger
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadSinger() throws Exception {
		System.out.println("Testing readSinger.");

		// Given a singer exists

		// When request get that singer
		String uri = "/music-manager/singer/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return that singer with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);

		SingerDTO singerDTO = super.mapFromJson(response, SingerDTO.class);
		assertTrue(singerDTO != null);
	}

	/**
	 * Test createSinger
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateSinger() throws Exception {
		System.out.println("Testing createSinger.");

		// When request create a singer
		String uri = "/music-manager/singer";
		
		SingerDTO singerDTO = new SingerDTO();
		singerDTO.setId(1L);
		singerDTO.setName("Singer Name");
		singerDTO.setAge(10);
		String inputJson = super.mapToJson(singerDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create and return that singer with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);
	}

	/**
	 * Test updateSinger
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateSinger() throws Exception {
		System.out.println("Testing updateSinger.");

		// Given a singer exists

		// When request update that singer
		String uri = "/music-manager/singer/1";
		
		SingerDTO singerDTO = new SingerDTO();
		singerDTO.setName("Updated Name");
		singerDTO.setAge(20);
		String inputJson = super.mapToJson(singerDTO);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated album with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);
	}

	/**
	 * Test deleteSinger
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteSinger() throws Exception {
		System.out.println("Testing deleteSinger.");

		// Given some singers exists

		// When request delete these singers
		String uri = "/music-manager/singer";
		
		long[] ids = { 1, 2 };
		String inputJson = super.mapToJson(ids);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these singers and return with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response, "");
	}

}
