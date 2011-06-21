/**
 * 
 */
package model.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Deniz KALFA
 * 
 */
public class SqlScriptExecutor {
	private Statement statement;

	public SqlScriptExecutor(Statement statement) {
		this.statement = statement;
	}
	
	public void execute(File file) {
        try {
            String thisLine, sqlQuery;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            sqlQuery = "";
            while ((thisLine = bufferedReader.readLine()) != null) {
                //Skip comments and empty lines
                if (thisLine.length() > 0 && thisLine.charAt(0) == '-' || thisLine.length() == 0)
                    continue;
                sqlQuery = sqlQuery + " " + thisLine;
                //If one command complete
                if (sqlQuery.charAt(sqlQuery.length() - 1) == ';') {
                    sqlQuery = sqlQuery.replace(';', ' '); //Remove the ; since jdbc complains
                    try {
                        boolean result = statement.execute(sqlQuery);
                        System.out.println("Result: " + result);
                    } catch (SQLException ex) {
                        System.out.println("Hata oldu...");
                    } catch (Exception ex) {
                        System.out.println("Hata oldu...");
                    }
                    sqlQuery = "";
                }
            }
        } catch (IOException ex) {
            System.out.println("Hata oldu...");
        } catch (Exception ex) {
            System.out.println("Hata oldu...");
        }
	}
}
