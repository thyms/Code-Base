package javam.log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerLoggingLog4j {
	private static Logger logger = Logger.getLogger(RunnerLoggingLog4j.class);

	public static void main(String[] args) {
		configureLoggerInline();
		// configureLoggerFromXmlFile();
		// configureLoggerFromPropertiesFile();

		logger.debug("This is a debug message...");
	}

	private static void configureLoggerInline() {
		logger.addAppender(new ConsoleAppender(new SimpleLayout()));
		logger.setLevel(Level.DEBUG);
		logger.setAdditivity(false);
	}

	@SuppressWarnings(value = { "unused" })
	private static void configureLoggerFromXmlFile() {
		URL resource = RunnerLoggingLog4j.class.getClassLoader().getResource(
				"log4j_basic.xml");
		DOMConfigurator.configure(resource);
	}

	@SuppressWarnings(value = { "unused" })
	private static void configureLoggerFromPropertiesFile() {
		try {
			InputStream fis = RunnerLoggingLog4j.class.getClassLoader()
					.getResourceAsStream("log4j_basic.properties");
			Properties properties = new Properties();
			properties.load(fis);
			fis.close();
			PropertyConfigurator.configure(properties);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
