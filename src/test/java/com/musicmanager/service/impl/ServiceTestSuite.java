package com.musicmanager.service.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs service tests
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AlbumServiceTest.class, SingerServiceTest.class, SongServiceTest.class })
public class ServiceTestSuite {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of ServiceTestSuite.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of ServiceTestSuite.\n");
	}
	
}
