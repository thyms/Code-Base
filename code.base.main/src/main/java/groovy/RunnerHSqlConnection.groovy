import groovy.sql.Sql

// sql = Sql.newInstance("jdbc:h2:~/test", "sa","", "org.h2.Driver")   // test db in the home directory 
sql = Sql.newInstance("jdbc:hsqldb:mem:test", "sa","", "org.hsqldb.jdbcDriver")

sql.execute("create table tableName (firstName varchar(200))")

firstName = "Deniz"
sql.execute("insert into tableName values(${firstName})")

sql.eachRow("select * from tableName", { println " -- ${it.firstName} --"} )
