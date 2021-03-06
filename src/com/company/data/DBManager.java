package com.company.data;

import com.company.data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager {
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/supermarket", "postgres", "postgre");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
