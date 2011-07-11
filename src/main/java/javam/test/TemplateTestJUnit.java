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
	@BeforeClass public static void setupOnce() {}
	
	@Before public void setup() {} 
	
	@Test public void testMethod() {}
	
	@After public void tearDown() {}
	
	@AfterClass public static void tearDownLast() {}
}
