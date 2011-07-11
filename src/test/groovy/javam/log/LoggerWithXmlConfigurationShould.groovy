package javam.log

import org.apache.log4j.xml.DOMConfigurator
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory;

/**
 * @author Deniz KALFA
 *
 */
class LoggerWithXmlConfigurationShould {
    private static Logger logger = LoggerFactory.getLogger(LoggerWithXmlConfigurationShould.class);

	@Test
	void ""() {
		// TODO
//		def configuration = new XmlSlurper().parseText(log4jXml);
//		DOMConfigurator.configure(configuration)
//		
//		def file = new File("./logs/test.log")
//		file.createNewFile()
//		file.as
//		
//		System.err 
//		
//		logger
//		
//		assert
	}

	def log4jXml = '''
	<!DOCTYPE log4j:configuration SYSTEM "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
	<log4j:configuration debug="false" threshold="debug" xmlns:log4j='http://jakarta.apache.org/log4j/'>
		<!-- APPENDERS -->
		<appender name="ConsoleAppender" class="org.apache.log4j.ConsoleAppender">
		<param name="Target" value="System.out"/>	<!-- System.err -->
		<param name="Threshold" value="TRACE"/>		<!-- Minimum Threshold, same as filter->param->LevelMin -->
		<layout class="org.apache.log4j.PatternLayout">
		<param name="ConversionPattern" value="[%d{dd.MM.yyyy HH:mm:ss.SSS} %5p] - %-40.40m (%l)%n" />
		</layout>
			<filter class="org.apache.log4j.varia.LevelRangeFilter">
				<param name="LevelMin" value="DEBUG" />
		<param name="LevelMax" value="FATAL" />
		</filter>
		</appender>
	
		<appender name="LogFileAppender" class="org.apache.log4j.RollingFileAppender">
		<param name="File" value="./logs/application.log" />
		<param name="Append" value="true" />
		<param name="MaxFileSize" value="10000KB" />
		<param name="MaxBackupIndex" value="30" />
		<layout class="org.apache.log4j.PatternLayout">
		<param name="ConversionPattern" value="[%d{dd.MM.yyyy HH:mm:ss.SSS} [%-10t] (%c#%M %F:%L) %p] - %m%n" />
		</layout>
			<filter class="org.apache.log4j.varia.LevelRangeFilter">
				<param name="LevelMin" value="DEBUG" />
		<param name="LevelMax" value="FATAL" />
		</filter>
		</appender>
	
		<appender name="ThirdPartyDebugAppender" class="org.apache.log4j.RollingFileAppender">
		<param name="File" value="./logs/thirdParty.log" />
		<param name="Append" value="true" />
		<param name="MaxFileSize" value="10000KB" />
		<param name="MaxBackupIndex" value="30" />
		<layout class="org.apache.log4j.PatternLayout">
		<param name="ConversionPattern" value="[%d{dd.MM.yyyy HH:mm:ss.SSS} [%-10t] (%c#%M %F:%L) %p] - %m%n" />
		</layout>
			<filter class="org.apache.log4j.varia.LevelRangeFilter">
				<param name="LevelMin" value="DEBUG" />
		<param name="LevelMax" value="FATAL" />
		</filter>
		</appender>
	
		<!-- LOGGERS -->
		<logger name="org.dk" additivity="false">
		<level value="DEBUG" />
		<appender-ref ref="LogFileAppender" />
		</logger>
		
		<logger name="org.springframework" additivity="false">
			<level value="DEBUG" />
		<appender-ref ref="ThirdPartyDebugAppender" />
		</logger>
		
		<root>
			<priority value="TRACE" />
		<appender-ref ref="ConsoleAppender" />
		</root>
	</log4j:configuration>
	'''
}
