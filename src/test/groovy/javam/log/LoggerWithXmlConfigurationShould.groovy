package javam.log

import groovy.xml.DOMBuilder

import org.apache.log4j.xml.DOMConfigurator
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * @author Deniz KALFA
 *
 */
class LoggerWithXmlConfigurationShould extends Specification {
	void "org.dk logs should go to application log file."() {
		setup:
		Logger logger = LoggerFactory.getLogger("org.dk.Sample");

		when:
		logger.debug("This is a debug message")
		logger.trace("This is a trace message")
		def result = fileApplicationLog.getText()

		then:
		assert result.contains("This is a debug message")
		assert !result.contains("This is a trace message")
	}

	void "org.springframework logs should go to thirdparty log file."() {
		setup:
		Logger logger = LoggerFactory.getLogger("org.springframework.Sample");

		when:
		logger.trace("This is a trace message")
		logger.debug("This is a debug message")
		logger.info("This is a info message")
		logger.warn("This is a warn message")
		logger.error("This is a error message")
		def result = fileThirdPartyLog.getText()

		then:
		assert !result.contains("This is a trace message")
		assert result.contains("This is a debug message")
		assert result.contains("This is a info message")
		assert result.contains("This is a warn message")
		assert result.contains("This is a error message")
	}

	void "other logs should go to console."() {
		setup:
		Logger logger = LoggerFactory.getLogger("org.other.Sample");

		when:
		logger.trace("This is a trace message")
		logger.debug("This is a debug message")
		logger.info("This is a info message")
		logger.warn("This is a warn message")
		logger.error("This is a error message")
		def result = outStream.toString()

		then:
		assert !result.contains("This is a trace message")
		assert result.contains("This is a debug message")
		assert result.contains("This is a info message")
		assert result.contains("This is a warn message")
		assert result.contains("This is a error message")
	}

	static def err
	static PrintStream printStream
	static OutputStream outStream

	static File fileApplicationLog = new File("./logs/application.log")
	static File fileThirdPartyLog = new File("./logs/thirdParty.log")

	def setupSpec() {
		err = System.err
		outStream = new ByteArrayOutputStream()
		printStream = new PrintStream(outStream)
		System.setErr(printStream)

		fileApplicationLog.delete()
		fileThirdPartyLog.delete()

		URL log4jFile = getClass().getClassLoader().getResource("log4j_basic.xml")
		DOMConfigurator.configure(log4jFile)
	}

	def cleanupSpec() {
		printStream.close()
		System.err = err
	}
}
