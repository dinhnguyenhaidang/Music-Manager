package com.musicmanager.converter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs converter tests
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AlbumConverterTest.class, SingerConverterTest.class, SongConverterTest.class })
public class ConverterTestSuite {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Start of ConverterTestSuite.\n");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("End of ConverterTestSuite.\n");
	}

}
