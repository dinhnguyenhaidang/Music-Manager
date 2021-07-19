package com.musicmanager.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs controller tests
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AlbumControllerTest.class, SingerControllerTest.class, SongControllerTest.class })
public class ControllerTestSuite {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of ControllerTestSuite.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of ControllerTestSuite.\n");
	}

}
