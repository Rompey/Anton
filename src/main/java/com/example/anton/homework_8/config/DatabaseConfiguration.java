package com.example.anton.homework_8.config;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DatabaseConfiguration {
    public Connection getConnection() {

        Connection connection = null;
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/employee";
        String user = "postgres";
        String password = "root";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                log.info("Connected to the Postgresql server successfully.");
            } else {
                log.error("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            log.error(sqlException.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
