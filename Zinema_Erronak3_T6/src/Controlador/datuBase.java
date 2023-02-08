package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class datuBase {
	
	public static Connection konektatuDB() {
        Connection connection = null;
        try {  
          // Datu-basearekin konektatzea
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zinema", "root", "");
        } catch (SQLException e) {
          System.out.println("Ezin izan da datu basera konektatu: " + e.getMessage());
        }
        return connection;
      }
	
	 public static void deskonektatuDB(Connection connection) {
	        try {
	          if (connection != null) {
	            connection.close();
	            connection = null;
	          }
	        } catch (SQLException e) {
	          e.printStackTrace();
	        }
	      }
	 

}