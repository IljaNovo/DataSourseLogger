package com.epam.loggerproject;
import oracle.jdbc.OracleDriver;
import org.slf4j.LoggerFactory;

import java.sql.*;

import org.slf4j.Logger;

import javax.sql.RowSet;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class DataBase {
    private Connection connection = null;
    private Statement statement = null;
    private final Logger log = LoggerFactory.getLogger(DataBase.class);
    private String path = "jdbc:oracle:thin:@localhost:1521:xe" ;
    private String pass = "myuser";
    private String login = "SOUTHWIND";
    private String driver = "oracle.jdbc.driver.OracleDriver";


    public void addConnection() {
        try {
            Class.forName(driver).newInstance();
            this.connection = DriverManager.getConnection(path, login, pass);
            this.statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnection() {
        if (this.connection == null) {

        }

        boolean ativation = false;
        try {
            ativation = this.connection.isClosed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ativation;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;

        try {
            rs = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}

