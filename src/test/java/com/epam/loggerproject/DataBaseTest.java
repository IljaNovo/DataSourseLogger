package com.epam.loggerproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseTest {

    @Test
    public void testIsConnection() throws Exception {
        DataBase db = new DataBase();
        db.addConnection();
        Assert.assertTrue(db.isConnection());
    }

    @Test
    public void testCloseConnection() throws Exception {
        DataBase db = new DataBase();
        db.closeConnection();
        Assert.assertFalse(db.isConnection());
    }

    @Test
    public void testAddConnection() throws Exception {
        DataBase db = new DataBase();
        db.addConnection();
        boolean b = db.isConnection();
        Assert.assertTrue(b);
    }

    @Test
    public void testNullSqlQuery() throws Exception {
        try {
            DataBase db = new DataBase();
            db.executeQuery(null);
        } catch (NullConnectionException e) {
            Assert.assertTrue(true);
        } catch (IncorrectQueryException e) {
            Assert.assertTrue(true);
        }
    }
}