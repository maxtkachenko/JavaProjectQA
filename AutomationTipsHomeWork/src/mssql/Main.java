package mssql;

import java.io.IOException;
import java.sql.*;

public class Main {

 private static Connection con = null;
 private static String username = "username";
 private static String password = "password";
 private static String URL = "jdbc:mysql://localhost:3306/mydb";
 private static Statement st = null;
 private static ResultSet rs = null;

 public static void main(String[] args) {

     try {

         Object newClass = Class.forName("com.mysql.jdbc.Driver").//search external library class loader
                           newInstance();
         DriverManager.registerDriver((Driver) newClass);//register this class and connect

         con = DriverManager.getConnection(URL, username, password);//connect to TCP/IP socket
         if (con != null)
             System.out.println("Connection Successful !\n");
         if (con == null)
             System.exit(0);//Switch off prg
         Statement st = con.createStatement();//create object
         ResultSet rs = st.executeQuery("select*from student");//send query to base and get result
         int x = rs.getMetaData().getColumnCount();//from result getting table description and column count

         while (rs.next()) {
             for (int i = 1; i <= x; i++) {
                 System.out.print(rs.getString(i) + "\t");//print by columns
             }

             System.out.println();//print by records
         }

     } catch (Exception e) {
         System.out.println(e.getMessage());

     } finally {
         if (rs != null) {
             try {
                 rs.close();//closing order is important!!
             } catch (SQLException eex) {}
         }

         if (st != null) {
             try {
                 st.close();
             } catch (SQLException eex) {}
         }     

         if (con != null) {
             try {
                 con.close();
             } catch (SQLException eex) {}
         }

     }
 }

}