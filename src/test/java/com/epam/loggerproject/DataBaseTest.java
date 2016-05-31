package com.epam.loggerproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseTest {
    @Test
    public void addConnection() throws Exception {
        DataBase db = new DataBase();
        db.addConnection();
    }

    @Test
    public void isConnection() throws Exception {
        DataBase db = new DataBase();
        db.addConnection();
        Assert.assertTrue(db.isConnection());
    }

    @Test
    public void closeConnection() throws Exception {
        DataBase db = new DataBase();
        db.closeConnection();
    }

    @Test
    public void executeQuery() throws Exception {

    }

}