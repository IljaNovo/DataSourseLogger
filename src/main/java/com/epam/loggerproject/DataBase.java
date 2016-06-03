package com.epam.loggerproject;
import org.slf4j.LoggerFactory;

import java.sql.*;

import org.slf4j.Logger;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class DataBase {
    private Connection connection = null;
    private Statement statement = null;
    private final Logger log = LoggerFactory.getLogger(DataBase.class);
    private String path = "jdbc:oracle:thin:@localhost:1521:xe" ;
    private String pass = "myuser";
    private String login = "SOUTHWIND";
    private String driver = "oracle.jdbc.driver.OracleDriver";


    public void addConnection() throws NullConnectionException {
        try {
            Class.forName(driver).newInstance();
            this.connection = DriverManager.getConnection(path, login, pass);
            this.statement = connection.createStatement();
            log.info("connection is open");
        } catch (Exception e) {
            log.error("connection is null", e);
        }
    }

    public boolean isConnection() {
        if (this.connection == null) {
            log.warn("connection is null");
            return false;
        }

        boolean ativation = false;
        try {
            ativation = this.connection.isClosed();
        } catch (Exception e) {
            log.error("read error of data", e);
        }
        return !ativation;
    }

    public void closeConnection() {
        try {
            this.connection.close();
            log.info("connection is close");
        } catch (Exception e) {
            log.error("read error of data", e);
        }
    }

    public void executeUpdate(String sql) throws NullConnectionException, IncorrectQueryException {
        if (sql == null) {
            throw new IncorrectQueryException("SQL query is incorrect");
        }
        if (this.connection == null) {
            log.error("connection is null");
            throw new NullConnectionException("connection is null");
        }
        try {
            statement.executeUpdate(sql);
            log.info("update query is executed");
        } catch (Exception e) {
            log.error("read error of date", e);
        }
    }

    public ResultSet executeQuery(String sql) throws NullConnectionException, IncorrectQueryException {
        if (sql == null) {
            throw new IncorrectQueryException("SQL query is incorrect");
        }
        if (this.connection == null) {
            log.error("connection is null");
            throw new NullConnectionException("connection is null");
        }
        ResultSet rs = null;

        try {
            rs = statement.executeQuery(sql);
            log.info("SELECT query is executed");
        } catch (Exception e) {
            log.error("read error of date", e);
        }
        return rs;
    }
}
