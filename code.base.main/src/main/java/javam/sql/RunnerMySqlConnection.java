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
public class RunnerMySqlConnection {
	public static void main(String[] args) {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://192.168.2.59:3306/test";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
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
