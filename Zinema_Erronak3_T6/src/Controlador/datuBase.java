package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import com.mysql.jdbc.Statement;

import Modelo.Areto;
import Modelo.Bezero;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Zinema;

public class datuBase {
	
	/*public static Connection konektatuDB() {
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
	      }*/
	 
	 

	 public static Zinema[] ZinemakKarga() {
			Zinema[] zinemak = new Zinema[0];
			Areto[] aretoak = new Areto[0];
			Saioa[] saioak;
			Film filma = new Film();
			
			
			Connection connection = null;
			try {
				final String url = "jdbc:mysql://10.5.14.240:3306/zinema";
				final String zinemaKontsulta = "Id_zinema, zinema_izena, zinema_helbide";
				final String aretoKontsulta = "ID_areto, areto_zbk";
				final String saioKontsulta = "ID_saioa, data, ordua, ID_film";
				final String filmKontsulta = "*";
				connection = DriverManager.getConnection(url, "Hodei","zineadmin123");
				Statement stmt = (Statement) connection.createStatement();	
				ResultSet rs = stmt.executeQuery("SELECT " + zinemaKontsulta + " FROM zinema;");

				int ID_zinema = 1;
				//Zinemen informazioa
				while(rs.next()) {
					Zinema zinema = new Zinema();
					
					zinema.setID_zinema(Integer.parseInt(rs.getString(1)));
					zinema.setIzena(rs.getString(2));
					zinema.setLokalitatea(rs.getString(3));
					
					
					try {	
						Statement stmt2 = (Statement) connection.createStatement();	
						ResultSet rs2 = stmt2.executeQuery("SELECT " + aretoKontsulta + " FROM areto join zinema ON areto.ID_zinema=zinema.ID_zinema WHERE areto.ID_zinema="+ID_zinema+";");		
						aretoak= new Areto[0];
						//Zinema bakoitzeko aretoak
						while(rs2.next()) {
							Areto areto = new Areto();
							
							int ID_areto = rs2.getInt(1);
							areto.setID_areto(ID_areto);
							areto.setZenbakia(rs2.getInt(2));
							
							//Saioa
							try {
								Statement stmt3 = (Statement) connection.createStatement();	
								ResultSet rs3 = stmt3.executeQuery("SELECT " + saioKontsulta + " FROM saioa JOIN areto ON saioa.ID_areto=areto.ID_areto WHERE saioa.ID_areto="+ID_areto+" ORDER BY data, ordua;");
								int i = 0;
								rs3.last();
								int length = rs3.getRow();
								saioak = new Saioa[length];
								rs3.beforeFirst();
								while (rs3.next()) {
									Saioa mySaioa = new Saioa();
									mySaioa.setID_saioa(rs3.getInt(1));
									mySaioa.setData(rs3.getDate(2));
									Time ordua_time = rs3.getTime(3);
									LocalTime ordua = ordua_time.toLocalTime();
									mySaioa.setOrdua(ordua);
									int ID_film_fk = rs3.getInt(4);
									//Film
									try {
										Statement stmt4 = (Statement) connection.createStatement();	
										ResultSet rs4 = stmt4.executeQuery("SELECT " + filmKontsulta + " FROM film WHERE ID_film="+ID_film_fk+";");

									    while (rs4.next()) {   
									        Film myFilm = new Film();
									        int ID_film = rs4.getInt(1);
									        String tituloa = rs4.getString(2);
									        int iraupena = rs4.getInt(3);
									        String generoa = rs4.getString(4);
									        double prezioa = rs4.getDouble(5);
									        myFilm.setID_film(ID_film);
									        myFilm.setTituloa(tituloa); 
									        myFilm.setIraupena(iraupena);
									        myFilm.setGeneroa(generoa);
									        myFilm.setPrezioa(prezioa);
									        filma = myFilm;
									    }
									mySaioa.setFilma(filma);
									}catch(SQLException e) {
										e.printStackTrace();
									}	
									
									saioak[i] = mySaioa;
									i++;
								}
								areto.setSaioak(saioak);
							}catch(SQLException e) {
								e.printStackTrace();
							}			
							
							//Aretoen array-a berridazten du
							Areto[] aretoBerriak = new Areto[aretoak.length+1];
							for(int i = 0; i < aretoak.length; i++){
								aretoBerriak[i] = aretoak[i];
							}
							aretoBerriak[aretoak.length] = areto;
							aretoak = aretoBerriak;
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}			
					zinema.setAretoak(aretoak);
					
					//Zinemen array-a berridazten du
					Zinema[] zinemaBerriak = new Zinema[zinemak.length+1];				
					for(int i = 0; i < zinemak.length; i++) {
						zinemaBerriak[i] = zinemak[i];					
					}	
					zinemaBerriak[zinemak.length] = zinema;				
					zinemak=zinemaBerriak;
					ID_zinema++;
				}			
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return zinemak;
	 }
	 
	 public static Zinema kargaHutsa() {
		 Film f1 = new Film();
		 Zinema z1 = new Zinema();
		 Areto [] a1 = new Areto[2];
		 Saioa [] s1 = new Saioa[2];
		 int ID_film = 1;
		 String tituloa = "";
		 int iraupena = 110;
		 String generoa = "Drama";
		 double prezioa = 7.5;
		 LocalTime ordua = null;
		 LocalTime buk_ordua = null;
		 int ID_saioa = 1;
		 Date data = null;
		 int ID_areto = 1;
		 int zenbakia = 1;
		 int ID_zinema = 1;
		 String izena = "Golem";
		 String lokalitatea = "Bilbao";
		 f1.setGeneroa(generoa);
		 f1.setID_film(ID_film);
		 f1.setIraupena(iraupena);
		 f1.setPrezioa(prezioa);
		 f1.setTituloa(tituloa);
			
		 s1[0] = new Saioa();
		 s1[0].setID_saioa(ID_saioa);
		 s1[0].setBuk_ordua(buk_ordua);
		 s1[0].setData(data);
		 s1[0].setFilma(f1);
		 s1[0].setOrdua(ordua);
		 s1[1] = new Saioa();
		 s1[1].setBuk_ordua(buk_ordua);
		 s1[1].setData(data);
		 s1[1].setFilma(f1);
		 s1[1].setID_saioa(ID_saioa+1);
		 s1[1].setOrdua(ordua);
		 a1[0] = new Areto();
		 a1[0].setID_areto(ID_areto);
		 a1[0].setZenbakia(zenbakia);
		 a1[0].setSaioak(s1);
		 a1[1] = new Areto();
		 a1[1].setID_areto(ID_areto+1);
		 a1[1].setZenbakia(zenbakia);
		 a1[1].setSaioak(s1);
		
		 z1.setAretoak(a1);
		 z1.setID_zinema(ID_zinema);
		 z1.setIzena(izena);
		 z1.setLokalitatea(lokalitatea);
		 return z1;
	 }


	 public static Bezero [] bezeroKarga () {
		 Bezero bezeroak [] = new Bezero [0];
		 Connection connection = null;
		 try {
			 final String url = "jdbc:mysql://10.5.14.240:3306/zinema";
			 final String bezeroKontsulta = "DNI, pasahitza";
			 connection = DriverManager.getConnection(url, "Hodei","zineadmin123");
			 Statement stmt = (Statement) connection.createStatement();	
			 ResultSet rs = stmt.executeQuery("SELECT " + bezeroKontsulta + " FROM bezero;");
			 while (rs.next()) {
				 Bezero myBezero = new Bezero();
                 String dni = rs.getString(1);
                 String pasahitza = rs.getString(2);

                 myBezero.setDNI(dni);
                 myBezero.setPasahitza(pasahitza);
                 
                 
                 Bezero[] bezeroBerriak = new Bezero[bezeroak.length+1];				
				 for(int j = 0; j < bezeroak.length; j++) {
 					 bezeroBerriak[j] = bezeroak[j];					
     			 }
     			 bezeroBerriak[bezeroak.length] = myBezero;				
     			 bezeroak=bezeroBerriak;
			  }	 
		 } catch (SQLException e) {
	            e.printStackTrace();
	     }
		 
		 return bezeroak;
	 }
		 
		 
		 
		 
		/* try(Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM Bezero")) {
	             int i = 0;
	             rs.last();
	             int length = rs.getRow();
	             bezeroak = new Bezero[length];
	             rs.beforeFirst();
	             while (rs.next()) {   
	                 Bezero myBezero = new Bezero();
	                 String dni = rs.getString(1);
	                 String izena_bezero = rs.getString(2);
	                 String abizen_1 = rs.getString(3);
	                 String abizen_2 = rs.getString(4);
	                 Boolean sexua = rs.getBoolean(5);
	                 String pasahitza = rs.getString(6);

	                 myBezero.setDNI(dni);
	                 myBezero.setIzena(izena_bezero);
	                 myBezero.setAbizen_1(abizen_1);
	                 myBezero.setAbizen_2(abizen_2);
	                 myBezero.setSexua(sexua);
	                 myBezero.setPasahitza(pasahitza);
	                 
	                 bezeroak[i] = myBezero;
	                 i++;
	             }
	     } catch (SQLException e) {
	            e.printStackTrace();
	         }
	 }*/
		//Bezero
     
  
//     //Eskaria
//     try(Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM Eskaria")) {
//             int i = 0;
//             rs.last();
//             int length = rs.getRow();
//             eskariak = new Eskaria[length];
//             rs.beforeFirst();
//             while (rs.next()) {   
//                 Eskaria myEskaria = new Eskaria();
//                 int id_eskari = rs.getInt(1);
//                 double prezio_totala=rs.getDouble(2);
//                 Date erosketa_date=rs.getDate(3);
//                 Bezero bezeroa=(Bezero) rs.getArray(4); 
//                 myEskaria.setId_eskari(id_eskari);
//                 myEskaria.setPrezio_totala(prezio_totala);
//                 myEskaria.setErosketa_data(erosketa_date);
//                 myEskaria.setBezeroa(bezeroa);
//                 
//                 eskariak[i] = myEskaria;
//                 i++;
//             }
//     } catch (SQLException e) {
//            e.printStackTrace();
//         }
//   //Sarrera
//     try(Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM Sarrera")) {
//             int i = 0;
//             rs.last();
//             int length = rs.getRow();
//             sarrerak = new Sarrera[length];
//             rs.beforeFirst();
//             while (rs.next()) {  
//             	Sarrera mySarrera = new Sarrera();
//                 int id_sarrera = rs.getInt(1);
//                 Date data = rs.getDate(2);
//                 Time ordua_time = rs.getTime(3);
//                 LocalTime ordua = ordua_time.toLocalTime();
//                 
//                 mySarrera.setID_sarrera(id_sarrera);
//                 mySarrera.setData(data);
//                 mySarrera.setOrdua(ordua);
//                 mySarrera.setEskariak(eskariak);
//            
//                 sarrerak[i] = mySarrera;
//                 i++;
//             }
//     } catch (SQLException e) {
//            e.printStackTrace();
//         }
		
	 
}