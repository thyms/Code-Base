/**
 * 
 */
package javam.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.StringUtils;

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
				// Skip comments and empty lines
				if ((thisLine.length() > 0 && thisLine.charAt(0) == '-') || thisLine.length() == 0)
					continue;
				sqlQuery = sqlQuery + " " + thisLine;
				// If one command complete
				if (sqlQuery.charAt(sqlQuery.length() - 1) == ';') {
					sqlQuery = sqlQuery.replace(";", ""); // Remove the ; since jdbc complains
					statement.execute(sqlQuery);

					sqlQuery = "";
				}
			}
		} catch (Exception ex) {
			System.out.println("Error...");
		}
	}
	
	// Alternative method, supports both ";" and "\" delimited scripts, but seems to be specific for Oracle
    public static void processSqlFile(String sqlFile, boolean ignoreExceptions) throws IOException, Exception {
        LineIterator li = FileUtils.lineIterator(new File(sqlFile));
        ArrayList<String> commands = new ArrayList<String>();
        StringBuffer command = new StringBuffer();
        String separator = "\n";
        while (true) {
            try {
                String line = li.nextLine().trim();
                if (line.length() == 0) {
                    String commandString = command.toString();
                    if (commandString.length() > 0) {
                        if (!commandString.toLowerCase().startsWith("create or replace")) {
                            commandString = commandString.substring(0, StringUtils.lastIndexOf(commandString, ";"));
                        }
                        
                        commands.add(commandString);
                        command = new StringBuffer();
                    }
                } else {
                    command.append(line + separator);
                }
            } catch (NoSuchElementException endOfFile) {
                String commandString = command.toString();
                if (commandString.length() > 0) {
                    if (!commandString.toLowerCase().startsWith("create or replace")) {
                        commandString = commandString.substring(0, StringUtils.lastIndexOf(commandString, ";"));
                    }
                    commands.add(commandString);
                }
                break;
            }
        }
        
        for (String currentCommand : commands) {
            try {
                executeCommand(currentCommand);
            } catch (Exception e) {
                if (!ignoreExceptions) {
                    throw e;
                }
            }
            
        }
    }
    
    private static void executeCommand(String command) throws Exception {
    	// getInstance().getJdbcTemplate().execute(command);
    }
}
