/**
 * 
 */
package javam.sql

import groovy.sql.Sql
import org.apache.tools.ant.taskdefs.SQLExec
import org.apache.tools.ant.types.EnumeratedAttribute

import spock.lang.Specification

/**
 * @author Deniz KALFA
 *
 */
class SqlExecuterShould extends Specification {
	
	def "executer given sql script."() {
		setup:
		Sql sql = Sql.newInstance('jdbc:h2:mem:test', 'sa', 'sa', 'org.h2.Driver')
		def sqlFilePath = "src/test/resources/script/database_script_h2_002.sql" 
				
		SqlExecuter sqlExecuter = new SqlExecuter()
	    sqlExecuter.setSrc(new File(sqlFilePath));
	    sqlExecuter.setUrl("jdbc:h2:mem:test");
	    sqlExecuter.setDriver("org.h2.Driver");
	    sqlExecuter.setPassword("sa");
	    sqlExecuter.setUserid("sa");
	    sqlExecuter.setDelimiter(";");
	    sqlExecuter.setAutocommit(true);
	    sqlExecuter.setOnerror(((SQLExec.OnError)(EnumeratedAttribute.getInstance( SQLExec.OnError.
	            class, "continue"))));
		
		when:
		sqlExecuter.execute()
		
		then:
		def firstRow = sql.firstRow("select * from users_table")
		firstRow.'FIRST_NAME' == 'Deniz'
	}
}
