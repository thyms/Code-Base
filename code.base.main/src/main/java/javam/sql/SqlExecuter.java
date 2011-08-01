/*
 * Copyright (c) 2011-
 * Vodafone Teknoloji Hizmetleri A.S., Istanbul, Turkey
 *
 * All rights reserved. This Software or any portion of it can not be translated,
 * distributed, sold, adapted, arranged, used, copied, modified, de-compiled,
 * reverse assembled or otherwise reverse engineered, disassembled, replaced or made
 * additions to and to be reproduced in whole or in part, in any way, manner or form.
 */
package javam.sql;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.junit.Ignore;



/**
 * @author dkalfa
 *
 */
@Ignore
class SqlExecuter extends SQLExec {
    public SqlExecuter() {
        Project project = new Project();
        project.init();
        setProject(project);
        setTaskType("sql");
        setTaskName("sql");
        setKeepformat(true);
        setAutocommit(true);
    }
    
    /* Usage */
    //    SqlExecuter executer = new SqlExecuter();
    //    executer.setSrc(new File(sqlFilePath));
    //    executer.setUrl("jdbc:oracle:thin:@172.25.23.122:1522:RAC1");
    //    executer.setDriver("oracle.jdbc.driver.OracleDriver");
    //    executer.setPassword("DENIZ");
    //    executer.setUserid("DENIZ");
    //    executer.setDelimiter("/");
	//    executer.setAutocommit(true);
	//    executer.setOnerror(((SQLExec.OnError)(EnumeratedAttribute.getInstance( SQLExec.OnError.
	//            class, "continue"))));
    //    executer.execute();
}