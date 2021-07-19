package com.musicmanager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.musicmanager.controller.ControllerTestSuite;
import com.musicmanager.converter.ConverterTestSuite;
import com.musicmanager.service.impl.ServiceTestSuite;

/**
 * Runs all tests
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ControllerTestSuite.class, ConverterTestSuite.class, ServiceTestSuite.class })
public class ApplicationTestSuite {

}
