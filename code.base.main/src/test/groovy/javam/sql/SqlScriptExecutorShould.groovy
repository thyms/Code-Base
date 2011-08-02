package javam.sql

import groovy.sql.Sql

import java.sql.DriverManager

import javam.sql.SqlScriptExecutor
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author Deniz KALFA
 *
 */
class SqlScriptExecutorShould extends Specification {
	@Shared sql = Sql.newInstance("jdbc:h2:mem:test", "sa", "", "org.h2.Driver")
	
	def "execute sql statements in script file."() {
		when:
		Class.forName("org.h2.Driver")
		def connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")
		def statement = connection.createStatement()
		
		def file = new File("src/main/resources/db.sql")
		def sqlScriptExecutor = new SqlScriptExecutor(statement)
		sqlScriptExecutor.execute(file)
		
		def params = ['John', 'Carpenter']
		sql.execute("insert into person values (?, ?)", params)
		def row = sql.firstRow("select first_name, last_name from person")
		
		then:
		row.FIRST_NAME == 'John'
		row['LAST_NAME'] == 'Carpenter'
	}
}
