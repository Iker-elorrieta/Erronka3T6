package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.Statement;

import Modelo.Areto;
import Modelo.Bezero;
import Modelo.Eskaria;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Sarrera;
import Modelo.Zinema;

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
	 
	 

	 public Zinema[] ZinemakKarga() {
			Zinema[] zinemak = new Zinema[0];
			Areto[] aretoak = new Areto[0];
			
			Connection connection = null;
			try {
				String url = "jdbc:mysql://localhost:3306/zinema";
				connection = DriverManager.getConnection(url, "root","");
				Statement stmt = (Statement) connection.createStatement();	
				ResultSet rs = stmt.executeQuery("SELECT Id_zinema, zinema_izena, zinema_helbide FROM zinema;");

				int ID_zinema = 1;
				//Zinemen informazioa
				while(rs.next()) {
					Zinema zinema = new Zinema();
					
					
					zinema.setID_zinema(Integer.parseInt(rs.getString(1)));
					zinema.setIzena(rs.getString(2));
					zinema.setLokalitatea(rs.getString(3));
					
					Connection connection2;
					try {	
						connection2 = (Connection) DriverManager.getConnection (url, "root","");
						Statement stmt2 = (Statement) connection2.createStatement();	
						ResultSet rs2 = stmt2.executeQuery("Select ID_areto, areto_zbk from areto join zinema zinema ON areto.ID_zinema=zinema.ID_zinema WHERE areto.ID_zinema="+ID_zinema+";");		
						aretoak= new Areto[0];
						//Zinema bakoitzeko aretoak
						while(rs2.next()) {
							Areto areto = new Areto();
							
							areto.setID_areto(Integer.parseInt(rs2.getString(1)));
							areto.setZenbakia(2);
							
							//Aretoen array-a berridazten du
							Areto[] areto0 = new Areto[aretoak.length+1];
							for(int i = 0; i < aretoak.length; i++){
								areto0[i] = aretoak[i];
							}
							areto0[aretoak.length] = areto;
							aretoak = areto0;
						}
						connection2.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}			
					zinema.setAretoak(aretoak);
					
					//Zinemen array-a berridazten du
					Zinema[] zinemak0 = new Zinema[zinemak.length+1];				
					for(int i = 0; i < zinemak.length; i++) {
						zinemak0[i] = zinemak[i];					
					}	
					zinemak0[zinemak.length] = zinema;				
					zinemak=zinemak0;
					ID_zinema++;
				}			
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return zinemak;
	 }
	 
		public Areto[] AretoakKarga() {
			Areto[] aretoak = new Areto[0];
			
			Connection connection = null;				
			try {
				String url = "jdbc:mysql://localhost:3306/db_zinema";
				connection = (Connection) DriverManager.getConnection (url, "root","");
				Statement stmt = (Statement) connection.createStatement();	
				ResultSet rs = stmt.executeQuery("SELECT ID_areto, areto_zbk FROM areto;");
				
				//Zinema bakoitzean dauden aretoen informazioa gorde
				while(rs.next()) {
					Areto areto = new Areto();
					
					areto.setID_areto(Integer.parseInt(rs.getString(1)));
					areto.setZenbakia(2);

					//Aretoen array-a berridazten du
					Areto[] areto0 = new Areto[aretoak.length+1];
					for(int i = 0; i < aretoak.length; i++){
						areto0[i] = aretoak[i];
					}
					areto0[aretoak.length] = areto;
					aretoak = areto0;
				}
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}		
			return aretoak;
		}

}