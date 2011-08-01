import groovy.sql.Sql

// sql = Sql.newInstance("jdbc:h2:~/test", "sa","", "org.h2.Driver")   // test db in the home directory 
sql = Sql.newInstance("jdbc:h2:mem:test", "sa","", "org.h2.Driver")

sql.execute("create table tableName (id number, firstName varchar2(200))")

id = 1
firstName = "Deniz"
sql.execute("insert into tableName values(${id}, ${firstName})")

sql.eachRow("select * from tableName", { println it.id + " -- ${it.firstName} --"} )