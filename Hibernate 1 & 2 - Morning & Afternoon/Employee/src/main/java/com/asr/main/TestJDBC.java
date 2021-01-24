package com.asr.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernateAssignment", "ajay", "pass123");
            System.out.println("Connection successful!");
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
}
