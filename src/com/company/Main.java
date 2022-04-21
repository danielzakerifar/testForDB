package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try
        {
//            Class.forName("org.sql.JDBC");
            String jdbcUrl = "jdbc:sqlite:C:\\Users\\danie\\Documents\\testForDB\\testjava.db";
            Connection conn = DriverManager.getConnection(jdbcUrl);
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Payam',654987,'pay@dan.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Kimia',23452,'kimi@dan.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Hayde',655457,'Haide@ira.com')");
//            statement.execute("UPDATE contacts SET phone=5566789 WHERE name='Kimia'");
//            statement.execute("DELETE FROM  contacts WHERE name='Kimia'");
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                                   results.getInt("phone") + " " +
                                    results.getString("email"));
            }

            statement.close();
            conn.close();

//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\danie\\Downloads\\testjava.db");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage() );
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }

    }
}
