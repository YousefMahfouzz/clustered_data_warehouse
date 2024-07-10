package com.progresssoft.clustered_data_warehouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DatabaseConfig {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void createDatabase() {
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            // Check if the database exists and create it if it doesn't
            stmt.executeUpdate("CREATE DATABASE clustered_data_warehouse");
        } catch (SQLException e) {
            // Ignore if the database already exists
            if (!e.getMessage().contains("database \"clustered_data_warehouse\" already exists")) {
                e.printStackTrace();
            }
        }
    }
}
