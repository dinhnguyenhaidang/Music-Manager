package com.musicmanager.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.musicmanager.AbstractControllerTest;
import com.musicmanager.dto.AlbumDTO;
import com.musicmanager.service.IAlbumService;

public class AlbumControllerTest extends AbstractControllerTest {

	@MockBean
	private IAlbumService albumService;

	@Before
	public void setUp() {
		System.out.println("Setting up.");
		super.setUp();
	}

	@After
	public void tearDown() {
		albumService = null;
		System.out.println("Tearing down.\n");
	}

	/**
	 * Test readAlbum
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadAlbum() throws Exception {
		System.out.println("Testing readAlbum.");

		// Given an album exists
		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Album Name");

		when(albumService.get(1L)).thenReturn(expectedAlbumDTO);

		// When request get that album
		String uri = "/music-manager/album/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return that album with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);

		AlbumDTO actualAlbumDTO = super.mapFromJson(response, AlbumDTO.class);
		assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
	}

	/**
	 * Test createAlbum
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateAlbum() throws Exception {
		System.out.println("Testing createAlbum.");

		// Given
		AlbumDTO inputAlbumDTO = new AlbumDTO();
		inputAlbumDTO.setName("Album Name");
		String inputJson = super.mapToJson(inputAlbumDTO);

		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(10L);
		expectedAlbumDTO.setName("Album Name");

		when(albumService.save(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When request create an album
		String uri = "/music-manager/album";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create and return that album with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);

//		AlbumDTO actualAlbumDTO = super.mapFromJson(response, AlbumDTO.class);
//		assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
//		assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
	}

	/**
	 * Test updateAlbum
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateAlbum() throws Exception {
		System.out.println("Testing updateAlbum.");

		// Given an album exists
		AlbumDTO inputAlbumDTO = new AlbumDTO();
		inputAlbumDTO.setName("Updated Name");
		String inputJson = super.mapToJson(inputAlbumDTO);

		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Updated Name");

		when(albumService.update(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When request update that album
		String uri = "/music-manager/album/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated album with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:\n" + response);
	}

	/**
	 * Test deleteAlbum
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteAlbum() throws Exception {
		System.out.println("Testing deleteAlbum.");

		// Given some albums exists
		long[] ids = { 4, 5 };
		String inputJson = super.mapToJson(ids);

		doNothing().when(albumService).delete(ids);

		// When request delete these albums
		String uri = "/music-manager/album";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these albums and return with status 200
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		assertEquals(response, "");
		System.out.println("Response:\n" + response);
	}

}
