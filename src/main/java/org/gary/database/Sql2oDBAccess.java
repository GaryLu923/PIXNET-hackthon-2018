package org.gary.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.data.Table;

public class Sql2oDBAccess {
    private Sql2o sql2o;
    private static Logger logger = LoggerFactory.getLogger(Sql2oDBAccess.class);
    //TODO Need to implement method to get data from db
    public Sql2oDBAccess() {
//        String databaseURL = "jdbc:mysql://localhost:3306/pixnet";
        String databaseURL = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "root";
        sql2o = new Sql2o(databaseURL, username, password);
        Connection connection = sql2o.beginTransaction();
        Query query = connection.createQuery("SELECT * FROM user");
        Table table = query.executeAndFetchTable();
        table.columns().stream().forEach(s -> logger.info(s.getName()));
    }

}
