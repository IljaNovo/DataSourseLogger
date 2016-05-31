package com.epam.loggerproject;
import oracle.jdbc.OracleDriver;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import org.slf4j.Logger;

public class DataBase {
    private Connection connection;
    private final Logger log = LoggerFactory.getLogger(DataBase.class);
    private String path = "jdbc:oracle:thin:@localhost:1521:xe" ;
    private String pass = "myuser";
    private String login = "SOUTHWIND";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    public void addConnection() {

        try {
            Class.forName(driver).newInstance();
            this.connection = DriverManager.getConnection(path, login, pass);

            if (!connection.isClosed()) {
                if (log.isDebugEnabled()) {
                    log.debug("connection successful");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.isClosed();
            } catch (Exception e) {}

        }
    }

    public void execute(String sql) {

    }
}
