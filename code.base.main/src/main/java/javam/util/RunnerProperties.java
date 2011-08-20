/**
 * 
 */
package javam.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerProperties {
	public static void main(String[] args) throws Exception {
        //
		// Getting Properties from xml properties file
		//
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/temp/temp_jdbc_connection.xml");
        properties.loadFromXML(fis);
        properties.list(System.out);

        String dataFolder = properties.getProperty("database.driver");
        System.out.println("databaseDriver = " + dataFolder);
        String jdbcUrl = properties.getProperty("database.url");
        System.out.println("databaseUrl = " + jdbcUrl);
        

        //
		// Storing/Setting Properties to xml properties file
		//
        Properties properties1 = new Properties();
        properties1.setProperty("database.driver", "com.mysql.jdbc.Driver");
        properties1.setProperty("database.url", "jdbc:mysql://localhost/mydb");
        properties1.setProperty("database.username", "root");
        properties1.setProperty("database.password", "root");

        FileOutputStream fos = new FileOutputStream("src/main/resources/temp/temp_jdbc_connection.xml");
        properties1.storeToXML(fos, "Database Configuration", "UTF-8");
	}
}
