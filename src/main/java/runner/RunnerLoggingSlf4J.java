package runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Deniz KALFA
 *
 */
public class RunnerLoggingSlf4J {
	private static final Logger logger = LoggerFactory.getLogger(RunnerLoggingSlf4J.class);

	public static void main(String[] args) {
		logger.trace("This is a trace message.");
		logger.debug("This is a debug message.");
		logger.info("This is an info message.");
		logger.warn("This is a {} message.", "warning");
		
		try {
			throw new Exception("Some exception");
		} catch (Exception e) {
			logger.error("An exception has been thrown. Message: {}", e.getMessage(), e);
		}
	}
}
