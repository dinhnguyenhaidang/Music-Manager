package com.musicmanager.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.musicmanager.AbstractTest;

public class AlbumControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testGetAlbum() throws Exception {
//		String uri = "/music-manager/album/1";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		System.out.println(content);
		// Given
		
		// When
		
		// Then
	}

	@Test
	public void testCreateAlbum() throws Exception {

	}

	@Test
	public void testUpdateAlbum() throws Exception {

	}

	@Test
	public void testDeleteAlbum() throws Exception {

	}

}
