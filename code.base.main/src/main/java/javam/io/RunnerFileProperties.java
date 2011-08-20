/**
 * 
 */
package javam.io;

import java.io.File;
import java.util.Date;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerFileProperties {
	public static void main(String[] args) throws Exception {
		//
		// Getting and setting last modified information
		//
        File file = new File("src/main/resources/temp/temp_write.txt");
        Long lastModified = file.lastModified();
        System.out.println(lastModified);
        Date date = new Date(lastModified);
        System.out.println(date);

		//
		// Getting current working directory
		//
        String USER_DIR_KEY = "user.dir";
        String currentDir = System.getProperty(USER_DIR_KEY);
        
        System.out.println("Working Directory: " + currentDir);
	}
}
