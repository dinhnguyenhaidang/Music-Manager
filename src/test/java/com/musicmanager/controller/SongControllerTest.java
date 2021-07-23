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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.musicmanager.dto.SongDTO;
import com.musicmanager.service.ISongService;

/**
 * Tests SongController
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-19
 */
public class SongControllerTest extends AbstractControllerTest {

	@MockBean
	private ISongService songService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of SongControllerTest.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of SongControllerTest.\n");
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
	 * Test readSong
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testReadSong() throws Exception {
		System.out.println("Testing readSong.");

		// Given a SongEntity called songEntity exists
		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(1L);
		expectedSongDTO.setTitle("Song Title");
		expectedSongDTO.setCategory("Song Category");

		Mockito.when(songService.get(Mockito.anyLong())).thenReturn(expectedSongDTO);

		// When request get a song with id matching songEntity's id
		String uri = "/music-manager/song/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return a corresponding SongDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(songService, Mockito.times(1)).get(Mockito.anyLong());

		SongDTO actualSongDTO = super.mapFromJson(response, SongDTO.class);
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	/**
	 * Test createSong
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testCreateSong() throws Exception {
		System.out.println("Testing createSong.");

		// Given
		SongDTO inputSongDTO = new SongDTO();
		inputSongDTO.setTitle("Song Title");
		inputSongDTO.setCategory("Song Category");
		String inputJson = super.mapToJson(inputSongDTO);

		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(1L);
		expectedSongDTO.setTitle("Song Title");
		expectedSongDTO.setCategory("Song Category");

		Mockito.when(songService.save(Mockito.anyObject())).thenReturn(expectedSongDTO);

		// When request create a song
		String uri = "/music-manager/song";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create a song and return a corresponding SongDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(songService, Mockito.times(1)).save(Mockito.anyObject());
		
		SongDTO actualSongDTO = super.mapFromJson(response, SongDTO.class);
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	/**
	 * Test updateSong
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testUpdateSong() throws Exception {
		System.out.println("Testing updateSong.");

		// Given a song exists
		SongDTO inputSongDTO = new SongDTO();
		inputSongDTO.setTitle("Updated Title");
		inputSongDTO.setCategory("Updated Category");
		String inputJson = super.mapToJson(inputSongDTO);

		SongDTO expectedSongDTO = new SongDTO();
		expectedSongDTO.setId(1L);
		expectedSongDTO.setTitle("Update Title");
		expectedSongDTO.setCategory("Updated Category");

		Mockito.when(songService.update(Mockito.anyObject())).thenReturn(expectedSongDTO);

		// When request update that song
		String uri = "/music-manager/song/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated song with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(songService, Mockito.times(1)).update(Mockito.anyObject());
		
		SongDTO actualSongDTO = super.mapFromJson(response, SongDTO.class);
		Assert.assertEquals(expectedSongDTO.getId(), actualSongDTO.getId());
		Assert.assertEquals(expectedSongDTO.getTitle(), actualSongDTO.getTitle());
		Assert.assertEquals(expectedSongDTO.getCategory(), actualSongDTO.getCategory());
	}

	/**
	 * Test deleteSong
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testDeleteSong() throws Exception {
		System.out.println("Testing deleteSong.");

		// Given some songs exists
		long[] ids = { 1, 2 };
		String inputJson = super.mapToJson(ids);
		
		Mockito.doNothing().when(songService).delete(ids);

		// When request delete these songs
		String uri = "/music-manager/song";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these songs and return with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals(response, "");
		System.out.println("Response:" + response);
		
		Mockito.verify(songService, Mockito.times(1)).delete(ids);
	}

}
