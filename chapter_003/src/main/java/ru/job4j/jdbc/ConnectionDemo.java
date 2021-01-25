package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionDemo {
    private static String url;
    private static String login;
    private static String password;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
//        String url = "jdbc:postgresql://localhost:5432/idea_db";
//        String login = "postgres";
//        String password = "password";

        Map<String, String> values = new HashMap<String, String>();

        try (BufferedReader reader = new BufferedReader(new FileReader("app.properties"))) {
            reader.lines()
                    .filter(s -> !s.contains("#") || !s.isEmpty())
                    .map(l -> l.split("="))
                    .forEach(k -> values.put(k[0], k[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, String> keys : values.entrySet()) {
            if (keys.getKey().contains("url")) {
                url = keys.getValue();
            } else if (keys.getKey().contains("username")) {
                login = keys.getValue();
            } else if (keys.getKey().contains("password")) {
                password = keys.getValue();
            }
        }

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}