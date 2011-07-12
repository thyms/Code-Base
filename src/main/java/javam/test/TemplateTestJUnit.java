package javam.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deniz KALFA
 *
 */
public class TemplateTestJUnit {
	@BeforeClass public static void oneTimeSetUp() {}
	
	@AfterClass public static void oneTimeTearDown() {}
	
	@Before public void setUp() {} 
	
	@After public void tearDown() {}
	
	@Test public void testMethod() {}
}
