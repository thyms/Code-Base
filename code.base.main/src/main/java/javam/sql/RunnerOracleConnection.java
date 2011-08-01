/**
 * 
 */
package javam.sql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Deniz KALFA
 * 
 */
public class RunnerOracleConnection {
	public static void main(String[] args) {
		System.out.println("ORACLE Connect Example.");
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.43.19:1522:RAC2";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String userName = "DENIZ";
		String password = "DENIZ";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to the database");
			conn.close();
			System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
