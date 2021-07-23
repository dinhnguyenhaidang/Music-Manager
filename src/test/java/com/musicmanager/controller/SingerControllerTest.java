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

import com.musicmanager.dto.SingerDTO;
import com.musicmanager.service.ISingerService;

/**
 * Tests SingerController
 * 
 * @author Void Wind
 * @version 1.3
 * @since 2021-07-19
 */
public class SingerControllerTest extends AbstractControllerTest {

	@MockBean
	private ISingerService singerService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of SingerControllerTest.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of SingerControllerTest.\n");
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
	 * Test readSinger
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testReadSinger() throws Exception {
		System.out.println("Testing readSinger.");

		// Given a SingerEntity called singerEntity exists
		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Album Name");
		expectedSingerDTO.setAge(10);

		Mockito.when(singerService.get(Mockito.anyLong())).thenReturn(expectedSingerDTO);

		// When request get a singer with id matching singerEntity's id
		String uri = "/music-manager/singer/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return a corresponding SingerDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(singerService, Mockito.times(1)).get(Mockito.anyLong());

		SingerDTO actualSingerDTO = super.mapFromJson(response, SingerDTO.class);
		Assert.assertEquals(expectedSingerDTO.getId(), actualSingerDTO.getId());
		Assert.assertEquals(expectedSingerDTO.getName(), actualSingerDTO.getName());
		Assert.assertEquals(expectedSingerDTO.getAge(), actualSingerDTO.getAge());
	}

	/**
	 * Test createSinger
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testCreateSinger() throws Exception {
		System.out.println("Testing createSinger.");

		// Given
		SingerDTO inputSingerDTO = new SingerDTO();
		inputSingerDTO.setName("Singer Name");
		inputSingerDTO.setAge(10);
		String inputJson = super.mapToJson(inputSingerDTO);

		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Singer Name");
		expectedSingerDTO.setAge(10);

		Mockito.when(singerService.save(Mockito.anyObject())).thenReturn(expectedSingerDTO);

		// When request create a singer
		String uri = "/music-manager/singer";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then create a singer and return a corresponding SingerDTO with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(singerService, Mockito.times(1)).save(Mockito.anyObject());

		SingerDTO actualSingerDTO = super.mapFromJson(response, SingerDTO.class);
		Assert.assertEquals(expectedSingerDTO.getId(), actualSingerDTO.getId());
		Assert.assertEquals(expectedSingerDTO.getName(), actualSingerDTO.getName());
		Assert.assertEquals(expectedSingerDTO.getAge(), actualSingerDTO.getAge());
	}

	/**
	 * Test updateSinger
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testUpdateSinger() throws Exception {
		System.out.println("Testing updateSinger.");

		// Given a singer exists
		SingerDTO inputSingerDTO = new SingerDTO();
		inputSingerDTO.setName("Updated Name");
		inputSingerDTO.setAge(20);
		String inputJson = super.mapToJson(inputSingerDTO);

		SingerDTO expectedSingerDTO = new SingerDTO();
		expectedSingerDTO.setId(1L);
		expectedSingerDTO.setName("Updated Name");
		expectedSingerDTO.setAge(20);

		Mockito.when(singerService.update(Mockito.anyObject())).thenReturn(expectedSingerDTO);

		// When request update that singer
		String uri = "/music-manager/singer/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then return the updated album with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		System.out.println("Response:" + response);
		
		Mockito.verify(singerService, Mockito.times(1)).update(Mockito.anyObject());

		SingerDTO actualSingerDTO = super.mapFromJson(response, SingerDTO.class);
		Assert.assertEquals(expectedSingerDTO.getId(), actualSingerDTO.getId());
		Assert.assertEquals(expectedSingerDTO.getName(), actualSingerDTO.getName());
		Assert.assertEquals(expectedSingerDTO.getAge(), actualSingerDTO.getAge());
		
	}

	/**
	 * Test deleteSinger
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	public void testDeleteSinger() throws Exception {
		System.out.println("Testing deleteSinger.");

		// Given some singers exists
		long[] ids = { 4L, 5L };
		String inputJson = super.mapToJson(ids);
		
		Mockito.doNothing().when(singerService).delete(ids);

		// When request delete these singers
		String uri = "/music-manager/singer";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();

		// Then delete these singers and return with status 200
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);

		String response = mvcResult.getResponse().getContentAsString();
		Assert.assertEquals(response, "");
		System.out.println("Response:" + response);
		
		Mockito.verify(singerService, Mockito.times(1)).delete(ids);
	}

}
