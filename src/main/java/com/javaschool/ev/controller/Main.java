package com.javaschool.ev.controller;

/*
main class is temporary to test the connectino with DB
main class is put in the controller
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SBB_Data";
        String username = "root";
        String password = "SBB_Offer_Received1!";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}