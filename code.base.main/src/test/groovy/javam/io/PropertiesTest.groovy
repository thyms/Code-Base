/**
 * 
 */
package javam.io

import org.junit.Test

/**
 * @author Deniz KALFA
 *
 */
class PropertiesTest {
	@Test
	void "Loading a resource/properties file"() {
		def properties = new Properties()
		def inputStream = this.getClass().getClassLoader().getResourceAsStream("foo.properties")
		properties.load(inputStream)
		inputStream.close()
		
		"this is foo.bar value" == properties.getProperty("foo.bar")
	}
}
