/**
 * 
 */
package groovy.sql

import spock.lang.*

/**
 * @author Deniz KALFA
 *
 */
class SqlBasics extends Specification {
	@Shared Sql sql = Sql.newInstance("jdbc:h2:mem:test", "sa", "", "org.h2.Driver")

	def setupSpec() {
		sql.execute("drop table if exists person")
		sql.execute("create table person (id int primary key, first_name varchar(50), last_name varchar(50))")
	}

	def setup() {
		def params = [1, 'John', 'Carpenter']
		sql.execute("insert into person values (?, ?, ?)", params)
	}

	def cleanup() {
		sql.execute("delete from person")
	}
	
	def "Selecting all rows from the table"() {
		setup:
		def params = [2, 'Bob', 'Black']
		sql.execute("insert into person values (?, ?, ?)", params)

		when:
		def rows = sql.rows("select * from person")

		then:
		rows.size() == 2
	}

	def "Selecting each row from the table and processing them"() {
		setup:
		def params = [2, 'Bob', 'Black']
		sql.execute("insert into person values (?, ?, ?)", params)

		when:
		sql.eachRow("select * from person") {
			println it.id + ", ${it.FIRST_NAME}, ${it.LAST_NAME}"
		}


		then:
		notThrown(Exception.class)
	}

	def "Selecting first row from the table"() {
		when:
		def row = sql.firstRow("select * from person")

		then:
		row.FIRST_NAME == 'John'
		row.LAST_NAME == 'Carpenter'
	}

	def "Using \${} expression in sql statement"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(${id}, ${firstName}, ${lastName})")
		def rows = sql.rows("select * from person")

		then:
		rows.size() == 2
	}

	def "Using [] expression in sql statement"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		def rows = sql.rows("select * from person")

		then:
		rows.size() == 2
	}

	def "Updating a row"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		sql.executeUpdate("update person set last_name=? where id=$id", ['White'])
		def row = sql.firstRow("select * from person where id=2")

		then:
		row['LAST_NAME'] == 'White'
	}

	def "Deleting a row"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"

		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		def rows = sql.rows("select * from person")
		def rowSizeBeforeDelete = rows.size()

		sql.execute("delete from person where id=2")
		rows = sql.rows("select * from person")
		def rowSizeAfterDelete = rows.size()

		then:
		rowSizeBeforeDelete == 2
		rowSizeAfterDelete == 1
	}

	def "Using rows vs iteration"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])

		def rows = sql.rows("select * from person")

		def rowsWithIteration = []
		sql.eachRow("select * from person") {
			rowsWithIteration << it.toRowResult()
		}

		then:
		rows == rowsWithIteration
	}
	def "Using dataset and adding a row with it"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])

		def dataSet = sql.dataSet("person")
		def rowsBeforeAddition = dataSet.rows().size()

		dataSet.add(id: 3, first_name:'Tom', last_name:'Baker')
		def rowsAfterAddition = sql.rows("select * from person").size()

		then:
		rowsBeforeAddition == 2
		rowsAfterAddition == 3
	}

	def "Using negative index on row and printing"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		def rows = sql.rows("select * from person")

		rows.each { row ->
			row.each{ i  ->
				print "Field ${i}: "
				println row.getAt(i)
			}
			println "Last field using -1 index = " + row.getAt(-1)
		}

		then:
		rows.size() == 2
	}

	def "Using negative index on row"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		def rows = sql.rows("select * from person")


		def lastFieldByPositiveIndex
		def lastFieldByNegativeIndex
		rows.each { row ->
			lastFieldByPositiveIndex = row.getAt(row.size()-1)
			lastFieldByNegativeIndex = row.getAt(-1)
		}

		then:
		lastFieldByPositiveIndex == lastFieldByNegativeIndex
	}


	def "Using named ordinal parameters"() {
		when:
		def id = 2
		def firstName = "Bob"
		def lastName = "Black"
		sql.execute("insert into person (id, first_name, last_name) values(?, ?, ?)", [id, firstName, lastName])
		def rows = sql.rows("select * from person where id=:id and first_name=?.first_name and last_name=:last_name",[id:2, first_name:'Bob', last_name:'Black'])

		then:
		rows.size() == 1
	}
}
