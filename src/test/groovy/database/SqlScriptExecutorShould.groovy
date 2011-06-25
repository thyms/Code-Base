/**
 * 
 */
package database

import spock.lang.*
import groovy.sql.Sql
import java.sql.*
import model.database.SqlScriptExecutor

/**
 * @author Deniz KALFA
 *
 */
class SqlScriptExecutorShould extends Specification {
	@Shared sql = Sql.newInstance("jdbc:h2:mem:test", "sa", "", "org.h2.Driver")
	
	def "execute sql statements in script file."() {
		when:
		def file = new File("src/main/resources/db.sql")
		
		Class.forName("org.h2.Driver")
		def connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")
		def statement = connection.createStatement()
		
		def sqlScriptExecutor = new SqlScriptExecutor(statement)
		sqlScriptExecutor.execute(file)
		sql.execute("CREATE TABLE USERS(FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255))")
		sql.execute("insert into users1 values ('John', 'Carpenter')")
		def name
		def surname
		def row = sql.firstRow("select first_name, last_name from users1")
		
		then:
		row['FIRST_NAME'] == 'John'
		row.LAST_NAME == 'Carpenter'
	}
}
