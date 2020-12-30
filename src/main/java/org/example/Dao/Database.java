package org.example.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    private static  Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    static void initDBConnection() {/// Connection with mySQL database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Agile";

            con = DriverManager.getConnection(url, "root", "Danieldd11");

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Dao.Database connection failed");
        }
    }
//    public static void main(String []args) {
//    	initDBConnection();
//    }




//    public boolean createCustomer(String name, String address, String contact, int age) {
//        String cmd = "INSERT INTO customer_details VALUES(" + null + ",'" + name + "','" + address + "','" + contact
//                + "'," + age + ",false);";
//        try {
//            stmt.executeUpdate(cmd);
//            return true;
//        } catch (Exception e1) {
//        }
//        return false;
//    }
}
