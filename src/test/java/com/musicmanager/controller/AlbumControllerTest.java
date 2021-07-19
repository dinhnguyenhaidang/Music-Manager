package com.musicmanager.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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

/**
 * Tests AlbumController
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-19
 */
public class AlbumControllerTest extends AbstractControllerTest {

	@MockBean
	private IAlbumService albumService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of AlbumControllerTest.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of AlbumControllerTest.\n");
	}

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
	 * Test readAlbum
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReadAlbum() throws Exception {
		System.out.println("Testing readAlbum.");

		// Given an AlbumEntity called albumEntity exists
		AlbumDTO expectedAlbumDTO = new AlbumDTO();
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Album Name");

		Mockito.when(albumService.get(Mockito.anyLong())).thenReturn(expectedAlbumDTO);

		// When request get an album with id matching albumEntity's id
		String uri = "/music-manager/album/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return a corresponding AlbumDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(albumService, Mockito.times(1)).get(Mockito.anyLong());

		AlbumDTO actualAlbumDTO = super.mapFromJson(response, AlbumDTO.class);
		Assert.assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		Assert.assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
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
		expectedAlbumDTO.setId(1L);
		expectedAlbumDTO.setName("Album Name");

		Mockito.when(albumService.save(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When request create an album
		String uri = "/music-manager/album";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create an album and return a corresponding AlbumDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(albumService, Mockito.times(1)).save(Mockito.anyObject());

		AlbumDTO actualAlbumDTO = super.mapFromJson(response, AlbumDTO.class);
		Assert.assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		Assert.assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
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

		Mockito.when(albumService.update(Mockito.anyObject())).thenReturn(expectedAlbumDTO);

		// When request update that album
		String uri = "/music-manager/album/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated album with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(albumService, Mockito.times(1)).update(Mockito.anyObject());

		AlbumDTO actualAlbumDTO = super.mapFromJson(response, AlbumDTO.class);
		Assert.assertEquals(expectedAlbumDTO.getId(), actualAlbumDTO.getId());
		Assert.assertEquals(expectedAlbumDTO.getName(), actualAlbumDTO.getName());
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
		long[] ids = { 4L, 5L };
		String inputJson = super.mapToJson(ids);

		Mockito.doNothing().when(albumService).delete(ids);

		// When request delete these albums
		String uri = "/music-manager/album";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these albums and return with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals(response, "");
		System.out.println("Response:" + response);
		
		Mockito.verify(albumService, Mockito.times(1)).delete(ids);
	}

}
