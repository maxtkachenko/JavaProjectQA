package mssql;

import java.io.IOException;
import java.sql.*;

public class Main {

 private static Connection con = null;
 private static String username = "root";
 private static String password = "max1975";
 private static String URL = "jdbc:mysql://localhost:3306/mydb";
 private static Statement st = null;
 private static ResultSet rs = null;

 public static void main(String[] args) {

     try {

         Object newClass = Class.forName("com.mysql.jdbc.Driver").//класс поиска внешней библиотеки class loader
                           newInstance();
         DriverManager.registerDriver((Driver) newClass);//регистрирует этот класс и подключает

         con = DriverManager.getConnection(URL, username, password);//коннект к TCP/IP сокету
         if (con != null)
             System.out.println("Connection Successful !\n");
         if (con == null)
             System.exit(0);//выключ. программа
         Statement st = con.createStatement();//создаю объект statement
         ResultSet rs = st.executeQuery("select*from student");//подаю запрос query и получаю результат
         int x = rs.getMetaData().getColumnCount();//от результата прошу описание таблицы и сколько колонок

         while (rs.next()) {
             for (int i = 1; i <= x; i++) {
                 System.out.print(rs.getString(i) + "\t");//по колонкам
             }

             System.out.println();//по записям
         }

     } catch (Exception e) {
         System.out.println(e.getMessage());

     } finally {
         if (rs != null) {
             try {
                 rs.close();//порядок закрытия важен!!!!!
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