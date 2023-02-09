package Vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import Controlador.WindowBuilderMetodoak;
import Controlador.datuBase;
import Controlador.metodoak;
import Modelo.Areto;
import Modelo.Bezero;
import Modelo.DateLabelFormatter;
import Modelo.Eskaria;
import Modelo.Film;
import Modelo.Saioa;
import Modelo.Sarrera;
import Modelo.Zinema;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import java.awt.Cursor;

public class lehenLehioa extends JFrame {
	
	private JPanel contentPane;
	private final ButtonGroup zinemaGroup = new ButtonGroup();
	private JTable laburpenaTaula;
	private JTextField textPrezioa;
	private JTextField textBeherapena;
	private JTextField textTotala;
	private JPasswordField passwordField;
	private JTextField textFieldNan;
	private JPasswordField passwordField_1;
	private JTextField txtNan;
	private JPasswordField passwordField_2;
	private JTable pelikulakTaula;
	private final ButtonGroup pelikulakGroup = new ButtonGroup();
	private JTable table;
	

	
	//Aldagaiak
	int pelikula_kont=0;
	private JTextField textField;
	private JTextField textAbizena1;
	private JTextField textAbizena2;
	private int ID_zinema;
	private String izena;
	private String zinema_helbide;
	private Zinema [] zinemak;
	private Areto [] aretoak;
	private Film [] filmak;
	private Bezero [] bezeroak;
	private Eskaria [] eskariak;
	private Saioa [] saioak;
	private Sarrera [] sarrerak;
	LocalDateTime locaDate;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lehenLehioa frame = new lehenLehioa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	Connection con = datuBase.konektatuDB();
	public lehenLehioa() {	
		//Film
		try (Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM Film")) {
			int i = 0;
		    rs.last();
		    int length = rs.getRow();
		    filmak = new Film[length];
		    rs.beforeFirst();
		    while (rs.next()) {   
		        Film myFilm = new Film();
		        int ID_zinema = rs.getInt(1);
		        String tituloa = rs.getString(2);
		        int iraupena = rs.getInt(3);
		        String generoa = rs.getString(4);
		        myFilm.setID_film(ID_zinema);
		        myFilm.setTituloa(tituloa); 
		        myFilm.setIraupena(iraupena);
		        myFilm.setGeneroa(generoa);
		        filmak[i] = myFilm;
		        i++;
		    }
		  
		} catch (SQLException e) {
		   e.printStackTrace();
		} 
		//Bezero
        try(Statement stmt = con.createStatement();
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
        //Saioa
        try(Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Saioa")) {
                int i = 0;
                rs.last();
                int length = rs.getRow();
                saioak = new Saioa[length];
                rs.beforeFirst();
                while (rs.next()) {   
                    Saioa mySaioa = new Saioa();
                    int  id_saioa = rs.getInt(1);
                    Date data = rs.getDate(2);
                    Time ordua_time = rs.getTime(3);
                    LocalTime ordua = ordua_time.toLocalTime();
                    mySaioa.setID_saioa(id_saioa);
                    mySaioa.setData(data);
                    mySaioa.setOrdua(ordua);
                    int id_filma  = rs.getInt(5);
                    Film f1 = new Film();
                    f1 = filmak[id_filma-1];
                    mySaioa.setFilma(f1);
                    saioak[i] = mySaioa;
                    i++;
                }
                System.out.println(saioak[56].getFilma());
        } catch (SQLException e) {
               e.printStackTrace();
            }
        //Areto
      		try (Statement stmt = con.createStatement();
      			    ResultSet rs = stmt.executeQuery("SELECT * FROM Areto")) {
      				int i = 0;
      			    rs.last();
      			    int length = rs.getRow();
      			    aretoak = new Areto[length];
      			    rs.beforeFirst();
      			    while (rs.next()) {   
      			        Areto myAreto = new Areto();
      			        int ID_areto = rs.getInt(1);
      			        int areto_zbk = rs.getInt(2);
      			        myAreto.setID_areto(ID_areto);
      			        myAreto.setZenbakia(areto_zbk); 
      			        aretoak[i] = myAreto;
      			       
      			     	try (Statement stmt2 = con.createStatement();
      			     		ResultSet rs2 = stmt2.executeQuery("SELECT ID_saioa, data, ordua, ID_film, bukaera_ordua FROM saioa JOIN areto ON saioa.ID_areto = areto.ID_areto WHERE saioa.ID_areto = "+ ID_areto + ";")) {
      			     		int j = 0;
      			     		rs2.last();
      	      			    int length2 = rs2.getRow();
      	      			    Saioa saioak_fk[] = new Saioa[length2];
      	      			    rs2.beforeFirst();
      	      			    while (rs2.next()) {   
      	      			    	Saioa mySaioa = new Saioa();
      	      			    		int ID_saioa = rs2.getInt(1);
      		      			        Date data = rs2.getDate(2);
      		      			        Time ordua_time = rs2.getTime(3);
      		      			        LocalTime ordua = ordua_time.toLocalTime();
	      		      			    int id_filma  = rs2.getInt(4);
	      		                    Film f1 = new Film();
	      		                    f1 = filmak[id_filma-1];
	      		                    Time buk_ordua_time = rs2.getTime(5);
	      		                    LocalTime bukaera_ordua = buk_ordua_time.toLocalTime();
	      		                    mySaioa.setID_saioa(ID_saioa);
	      		                    mySaioa.setOrdua(ordua);
	      		                    mySaioa.setFilma(f1);
	      		                    mySaioa.setData(data);
	      		                    mySaioa.setBuk_ordua(bukaera_ordua);
      		      			        saioak_fk[j] = mySaioa;
      		      			        j++;
      		      			}
      	      			myAreto.setSaioak(saioak_fk);
      	  		        aretoak[i] = myAreto;
      	  		        i++;
      			        }
      			    }	
      			  for (int k = 0;k<aretoak[6].getSaioak().length;k++) {
      				System.out.println(aretoak[4].getSaioak()[k].getID_saioa());
      			  }
      			  
  			    } catch (SQLException e) {
      			   e.printStackTrace();
      			} 
 
		//Zinemak
		try (Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM Zinema")) {
			int i = 0;
		    rs.last();
		    int length = rs.getRow();
		    zinemak = new Zinema[length];
		    rs.beforeFirst();
		    while (rs.next()) {   
		        Zinema myZinema = new Zinema();
		        int ID_zinema = rs.getInt(1);
		        String izena = rs.getString(2);
		        String zinema_helbide = rs.getString(3);
		        myZinema.setID_zinema(ID_zinema);
		        myZinema.setIzena(izena); 
		        myZinema.setLokalitatea(zinema_helbide);
		        
		        try (Statement stmt2 = con.createStatement();
      			    ResultSet rs2 = stmt2.executeQuery("SELECT ID_areto, areto_zbk FROM Areto JOIN zinema ON areto.Id_zinema = zinema.ID_zinema WHERE areto.ID_zinema = +" +ID_zinema +";")) {
  			    	int j = 0;
      			    rs2.last();
      			    int length2 = rs2.getRow();
      			    Areto aretoak_fk[] = new Areto[length2];
      			    rs2.beforeFirst();
      			    while (rs2.next()) {   
      			        Areto myAreto = new Areto();
	      			        int ID_areto= rs2.getInt(1);
	      			        int areto_zbk = rs2.getInt(2);
	      			        myAreto.setID_areto(ID_areto);
	      			        myAreto.setZenbakia(areto_zbk); 
	      			        aretoak_fk[j] = myAreto;
	      			        j++;
	      			    }
      			myZinema.setAretoak(aretoak_fk);
  		        zinemak[i] = myZinema;
  		        i++;
		        }
		        
		        
		    } 
		} catch (SQLException e) {
	    	e.printStackTrace();
	    }
			
		
        
        //Eskaria
        try(Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Eskaria")) {
                int i = 0;
                rs.last();
                int length = rs.getRow();
                eskariak = new Eskaria[length];
                rs.beforeFirst();
                while (rs.next()) {   
                    Eskaria myEskaria = new Eskaria();
                    int id_eskari = rs.getInt(1);
                    double prezio_totala=rs.getDouble(2);
                    Date erosketa_date=rs.getDate(3);
                    Bezero bezeroa=(Bezero) rs.getArray(4); 
                    myEskaria.setId_eskari(id_eskari);
                    myEskaria.setPrezio_totala(prezio_totala);
                    myEskaria.setErosketa_data(erosketa_date);
                    myEskaria.setBezeroa(bezeroa);
                    
                    eskariak[i] = myEskaria;
                    i++;
                }
        } catch (SQLException e) {
               e.printStackTrace();
            }
      //Sarrera
        try(Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Sarrera")) {
                int i = 0;
                rs.last();
                int length = rs.getRow();
                sarrerak = new Sarrera[length];
                rs.beforeFirst();
                while (rs.next()) {  
                	Sarrera mySarrera = new Sarrera();
                    int id_sarrera = rs.getInt(1);
                    Date data = rs.getDate(2);
                    Time ordua_time = rs.getTime(3);
                    LocalTime ordua = ordua_time.toLocalTime();
                    
                    mySarrera.setID_sarrera(id_sarrera);
                    mySarrera.setData(data);
                    mySarrera.setOrdua(ordua);
                    mySarrera.setSaioa(saioak);
                    mySarrera.setEskariak(eskariak);
               
                    sarrerak[i] = mySarrera;
                    i++;
                }
        } catch (SQLException e) {
               e.printStackTrace();
            }
       
		
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/logo2.png")).getImage();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//ONGI ETORRI
		JPanel ongiEtorri = new JPanel();
		ongiEtorri.setBounds(5, 5, 484, 314);
		contentPane.add(ongiEtorri);
		
		JLabel logoa1_1 = new JLabel("");
		logoa1_1.setBounds(85, 0, 325, 251);
        logoa1_1.setIcon(new ImageIcon(img));
		
		JLabel txt1 = new JLabel("Ongi Etorri!");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setBounds(159, 249, 179, 54);
		txt1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		
		JButton btnOngiEtorri = new JButton("");
		btnOngiEtorri.setBounds(0, 0, 484, 314);
		btnOngiEtorri.setOpaque(false);
		btnOngiEtorri.setContentAreaFilled(false);
		btnOngiEtorri.setBorderPainted(false);
		ongiEtorri.setLayout(null);
		ongiEtorri.add(logoa1_1);
		ongiEtorri.add(txt1);
		ongiEtorri.add(btnOngiEtorri);
		
		//ZINEMA ARETOA
		
		JPanel zinemaAreto = new JPanel();
		zinemaAreto.setToolTipText("PEPE");
		contentPane.add(zinemaAreto, "name_19385331456200");
		zinemaAreto.setLayout(null);
		
		JLabel logoa2_1 = new JLabel("");
		logoa2_1.setBounds(0, 0, 101, 80);
		logoa2_1.setIcon(new ImageIcon(img2));
		zinemaAreto.add(logoa2_1);
		
		JLabel titulo2 = new JLabel("Hautatu hurrengo zinema areto bat");
		titulo2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		titulo2.setBounds(111, 11, 352, 54);
		zinemaAreto.add(titulo2);
		
		JButton btnBukatu = new JButton("Bukatu");
		btnBukatu.setToolTipText("");
		btnBukatu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBukatu.setBounds(10, 276, 95, 31);
		zinemaAreto.add(btnBukatu);
		
		JButton btnHurrengoa1 = new JButton("Hurrengoa");
		btnHurrengoa1.setToolTipText("");
		btnHurrengoa1.setEnabled(false);
		btnHurrengoa1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa1.setBounds(349, 276, 127, 31);
		zinemaAreto.add(btnHurrengoa1);
		
		JComboBox CBZinemak = new JComboBox();
		CBZinemak.setModel(new DefaultComboBoxModel(zinemak));
		CBZinemak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CBZinemak.setBounds(129, 98, 190, 31);
		zinemaAreto.add(CBZinemak);
		
		//PELIKULAK
		
		JPanel pelikulak = new JPanel();
		contentPane.add(pelikulak, "name_2894301677400");
		pelikulak.setLayout(null);
		
		JScrollPane scrollPanePelikulak = new JScrollPane();
		scrollPanePelikulak.setBounds(155, 90, 319, 124);
		pelikulak.add(scrollPanePelikulak);
		
		pelikulakTaula = new JTable();
		pelikulakTaula.getTableHeader().setReorderingAllowed(false);
		pelikulakTaula.getTableHeader().setResizingAllowed(false);
		pelikulakTaula.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pelikulakTaula.setEnabled(false);
		pelikulakTaula.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Durazioa", "Pelikula", "///////"
			}
		));
		scrollPanePelikulak.setViewportView(pelikulakTaula);
		
		JButton btnHurrengoa2 = new JButton("Hurrengoa");
		btnHurrengoa2.setEnabled(false);
		btnHurrengoa2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa2.setBounds(347, 272, 127, 31);
		pelikulak.add(btnHurrengoa2);
		
		JButton btnAtzera1 = new JButton("Atzera");
		btnAtzera1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtzera1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtzera1.setBounds(10, 272, 95, 31);
		pelikulak.add(btnAtzera1);
		
		JLabel logoa2_2 = new JLabel("");
		logoa2_2.setBounds(0, 0, 100, 80);
		logoa2_2.setIcon(new ImageIcon(img2));
		pelikulak.add(logoa2_2);
		
		JComboBox comboPelikula = new JComboBox();
		comboPelikula.setModel(new DefaultComboBoxModel(new String[] {"Avatar", "Handia"}));
		comboPelikula.setBounds(10, 108, 135, 22);
		pelikulak.add(comboPelikula);
		
		//PELIKULAK DATA
		JPanel pelikulakData = new JPanel();
		contentPane.add(pelikulakData, "name_3591189006900");
		pelikulakData.setLayout(null);
		
		JLabel logoa2_3 = new JLabel("");
		logoa2_3.setBounds(0, 0, 100, 80);
		logoa2_3.setIcon(new ImageIcon(img2));
		pelikulakData.add(logoa2_3);
		
		//DATEPICKER
        UtilDateModel model = new UtilDateModel();
        Calendar calendar = Calendar.getInstance();
        model.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        model.setSelected(true);

        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(138, 37, 213, 20);
        pelikulakData.add(datePicker);
        
		
		JButton btnHurrengoa3 = new JButton("Hurrengoa");
		btnHurrengoa3.setEnabled(false);
		btnHurrengoa3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa3.setBounds(347, 272, 127, 31);
		pelikulakData.add(btnHurrengoa3);
		
		JButton btnAtzera2 = new JButton("Atzera");
		btnAtzera2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtzera2.setBounds(10, 272, 95, 31);
		pelikulakData.add(btnAtzera2);	
		
		JComboBox comboSesioak = new JComboBox();
		comboSesioak.setVisible(false);
		comboSesioak.setEnabled(false);
		comboSesioak.setModel(new DefaultComboBoxModel(new String[] {"18:00", "20:00", "22:00"}));
		comboSesioak.setBounds(138, 182, 213, 22);
		pelikulakData.add(comboSesioak);
		
		//LABURPENA
		JPanel laburpena = new JPanel();
		contentPane.add(laburpena, "name_357675593712100");
		laburpena.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LABURPENA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(180, 0, 124, 27);
		laburpena.add(lblNewLabel); 
        
		JButton btnAtzera3 = new JButton("Atzera");
		btnAtzera3.setBounds(10, 280, 134, 23);
		laburpena.add(btnAtzera3);
		
		textPrezioa = new JTextField();
		textPrezioa.setEditable(false);
		textPrezioa.setBounds(247, 139, 86, 20);
		laburpena.add(textPrezioa);
		textPrezioa.setColumns(10);
		
		textBeherapena = new JTextField();
		textBeherapena.setEditable(false);
		textBeherapena.setColumns(10);
		textBeherapena.setBounds(247, 177, 86, 20);
		laburpena.add(textBeherapena);
		
		textTotala = new JTextField();
		textTotala.setEditable(false);
		textTotala.setColumns(10);
		textTotala.setBounds(247, 219, 86, 20);
		laburpena.add(textTotala);
		
		JLabel lblNewLabel_1 = new JLabel("Azkenengo prezioa");
		lblNewLabel_1.setBounds(129, 222, 130, 14);
		laburpena.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prezio beherapen gabe");
		lblNewLabel_1_1.setBounds(106, 142, 131, 14);
		laburpena.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Beherpena");
		lblNewLabel_1_1_1.setBounds(173, 180, 86, 14);
		laburpena.add(lblNewLabel_1_1_1);
		
		//LOGIN
		JPanel login = new JPanel();
		contentPane.add(login, "name_359351979134700");
		login.setLayout(null);
		
		JLabel logoa2_4 = new JLabel("");
		logoa2_4 .setBounds(0, 0, 100, 80);
		logoa2_4.setIcon(new ImageIcon(img2));
		login.add(logoa2_4);
		
		JLabel lblNewLabel_2 = new JLabel("NAN");
		lblNewLabel_2.setBounds(146, 119, 35, 14);
		login.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pasahitza");
		lblNewLabel_2_1.setBounds(129, 150, 62, 14);
		login.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 147, 132, 20);
		login.add(passwordField);
		
		textFieldNan = new JTextField();
		textFieldNan.setBounds(191, 116, 131, 20);
		login.add(textFieldNan);
		textFieldNan.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLogin.setBounds(223, 57, 71, 27);
		login.add(lblLogin);
		
		JButton btnAtzera4 = new JButton("Atzera");
		btnAtzera4.setBounds(10, 280, 148, 23);
		login.add(btnAtzera4);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(181, 280, 134, 23);
		login.add(btnErregistratu);
		
		JButton btnBukatuErosketa2 = new JButton("Bukatu erosketa");
		btnBukatuErosketa2.setBounds(340, 280, 134, 23);
		login.add(btnBukatuErosketa2);
		
		JButton btnBerrezarri = new JButton("Berrezarri datu guztiak");
		btnBerrezarri.setBounds(10, 246, 464, 23);
		login.add(btnBerrezarri);
		
		JButton btnBukatuErosketa = new JButton("Bukatu erosketa");
		btnBukatuErosketa.setBounds(340, 280, 134, 23);
		laburpena.add(btnBukatuErosketa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 38, 344, 82);
		laburpena.add(scrollPane);
		
		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
	    table.setEnabled(false);
	    table.setToolTipText("");
	    table.setModel(new DefaultTableModel(
	          new Object[][] {
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	             {null, null, null, null},
	           },
	           new String[] {
	                "Titulua", "Data", "Areto", "Prezioa"
	            }
	        ));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(247, 250, 86, 27);
		textBeherapena.setText(metodoak.zenbatBeherapen(pelikula_kont));
		laburpena.add(lblNewLabel_4);
		
		//ERREGISTRATU		
		JPanel erregistratu = new JPanel();
		erregistratu.setLayout(null);
		contentPane.add(erregistratu, "name_359911054480700");
		
		JLabel lblAbizena2 = new JLabel("2. Abizena");
		lblAbizena2.setBounds(280, 168, 62, 14);
		erregistratu.add(lblAbizena2);
		
		JLabel logoa2_5 = new JLabel("");
		logoa2_5.setBounds(0, 0, 100, 80);
		logoa2_5.setIcon(new ImageIcon(img2));
		erregistratu.add(logoa2_5);
		
		JLabel lblNewLabelNAN = new JLabel("NAN");
		lblNewLabelNAN.setBounds(70, 101, 35, 14);
		erregistratu.add(lblNewLabelNAN);
		
		JLabel lblNewLabelPasahitza1 = new JLabel("Pasahitza");
		lblNewLabelPasahitza1.setBounds(53, 132, 62, 14);
		erregistratu.add(lblNewLabelPasahitza1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("");
		passwordField_1.setBounds(115, 129, 132, 20);
		erregistratu.add(passwordField_1);
		
		txtNan = new JTextField();
		txtNan.setToolTipText("");
		txtNan.setColumns(10);
		txtNan.setBounds(115, 98, 131, 20);
		erregistratu.add(txtNan);
		
		JLabel lblErregistratu = new JLabel("ERREGISTRATU");
		lblErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblErregistratu.setBounds(169, 11, 177, 27);
		erregistratu.add(lblErregistratu);
		
		JButton btnAtzera5 = new JButton("Atzera");
		btnAtzera5.setBounds(10, 280, 148, 23);
		erregistratu.add(btnAtzera5);
		
		JButton btnBukatuErregistratu3 = new JButton("Bukatu erosketa");
		btnBukatuErregistratu3.setBounds(340, 280, 134, 23);
		erregistratu.add(btnBukatuErregistratu3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(115, 162, 132, 20);
		erregistratu.add(passwordField_2);
		
		JLabel lblNewLabelPasahitza2 = new JLabel("Errepikatu pasahitza");
		lblNewLabelPasahitza2.setBounds(10, 165, 105, 14);
		erregistratu.add(lblNewLabelPasahitza2);
		
		JLabel lblNewLabelSexua = new JLabel("Sexua");
		lblNewLabelSexua.setBounds(158, 218, 46, 14);
		erregistratu.add(lblNewLabelSexua);
		
		JComboBox comboSexua = new JComboBox();
		comboSexua.setModel(new DefaultComboBoxModel(new String[] {"Gizona", "Emakumea"}));
		comboSexua.setBounds(214, 214, 132, 22);
		erregistratu.add(comboSexua);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setBounds(297, 101, 35, 14);
		erregistratu.add(lblIzena);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(342, 98, 131, 20);
		erregistratu.add(textField);
		
		JLabel lblAbizena1 = new JLabel("1. Abizena");
		lblAbizena1.setBounds(280, 132, 62, 14);
		erregistratu.add(lblAbizena1);
		
		textAbizena1 = new JTextField();
		textAbizena1.setColumns(10);
		textAbizena1.setBounds(343, 129, 131, 20);
		erregistratu.add(textAbizena1);
		
		textAbizena2 = new JTextField();
		textAbizena2.setColumns(10);
		textAbizena2.setBounds(343, 165, 131, 20);
		erregistratu.add(textAbizena2);
		
		//TIKET
		JPanel tiket = new JPanel();
		contentPane.add(tiket, "name_360289319246600");
		tiket.setLayout(null);
		
		JLabel logoa2_6 = new JLabel("");
		logoa2_6.setBounds(0, 0, 97, 80);
		logoa2_6.setIcon(new ImageIcon(img2));
		tiket.add(logoa2_6);
		
		JLabel lblNewLabel_3 = new JLabel("Tiket-a gorde nahi duzu?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(124, 71, 234, 49);
		tiket.add(lblNewLabel_3);
		
		JButton btnBai = new JButton("Bai");
		btnBai.setBounds(124, 159, 89, 23);
		tiket.add(btnBai);
				
		JButton btnEz = new JButton("Ez");
		btnEz.setBounds(279, 159, 89, 23);
		tiket.add(btnEz);
		
		//BUKAERA
		JPanel bukaera = new JPanel();
		bukaera.setLayout(null);
		contentPane.add(bukaera, "name_4579996000400");
		
		JLabel logoa1_2 = new JLabel("");
		logoa1_2.setBounds(80, 0, 325, 251);
		logoa1_2.setIcon(new ImageIcon(img));
		bukaera.add(logoa1_2);
		
		JLabel txt2 = new JLabel("Eskerrik asko gure");
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		txt2.setBounds(80, 244, 325, 45);
		bukaera.add(txt2);
		
		JLabel lblProgramaEreabiltzeaGaitik = new JLabel("programa ereabiltzea gaitik!");
		lblProgramaEreabiltzeaGaitik.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramaEreabiltzeaGaitik.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblProgramaEreabiltzeaGaitik.setBounds(76, 269, 341, 45);
		bukaera.add(lblProgramaEreabiltzeaGaitik);
		
		JButton btnAmaitu = new JButton("");
		btnAmaitu.setOpaque(false);
		btnAmaitu.setContentAreaFilled(false);
		btnAmaitu.setBorderPainted(false);
		btnAmaitu.setBounds(0, 0, 484, 314);
		bukaera.add(btnAmaitu);
        

		
		//ongiEtorri
		//ongiEtorri panelean click egin eta 3 segundu pasa ondoren zinemaAreto panelera pasatzeko
		btnOngiEtorri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.btn3secDelay(zinemaAreto, 3, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera, e);
            }
		});	
		
		//zinemaAreto (zinema aukeratu)
		//zinemaAreto (zinema aukeratu) panelean "Hurrengoa" botoiari click egin eta pelikulak panelera pasatzeko
		CBZinemak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int zinema_aukera = CBZinemak.getSelectedIndex();
        		System.out.println(zinema_aukera);
        		//zinemak[zinema_aukera].get
    			btnHurrengoa1.setEnabled(true);
            }
		});
		
		btnHurrengoa1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulak, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		btnBukatu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(pelikula_kont>0) {
                WindowBuilderMetodoak.hurrengoaBtn(laburpena, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            	}else {
                    WindowBuilderMetodoak.hurrengoaBtn(bukaera, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            	}
            	textBeherapena.setText(metodoak.zenbatBeherapen(pelikula_kont));
            }
		});
		
		//pelikulak
		//pelikulak panelean "Atzera" botoiari click egin eta zinemaAreto panelera bueltatzeko
		btnAtzera1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(zinemaAreto, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
    			btnHurrengoa1.setEnabled(false);
            }
		});
		
		//pelikulak panelean "Hurrengoa" botoiari click egin eta pelikulaDatak panelera pasatzeko
		comboPelikula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    			btnHurrengoa2.setEnabled(true);
            }
		});
		btnHurrengoa2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulakData, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//pelikulaDatak
		//pelikulaDatak panelean "Atzera" botoiari click egin eta pelikulak panelera bueltatzeko
		btnAtzera2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulak, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
                WindowBuilderMetodoak.ezkutatu(btnHurrengoa1, btnHurrengoa2);
            }
		});
		
		//pelikulaDatak panelean "Hurrengoa" botoiari click egin eta zinemaAreto panelera pasatzeko
		btnHurrengoa3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Zure sarrera zuzen gorde da");
                WindowBuilderMetodoak.hurrengoaBtn(zinemaAreto, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
                pelikula_kont++;
                System.out.println(pelikula_kont);
                WindowBuilderMetodoak.ezkutatu(btnHurrengoa1, btnHurrengoa2);
            }
		});
		
		//DATEPICKER
		//Zinemara joan ahal izetako restrikzio batzuk daude, adibidez astelehenetan ezin da joan. Aukeratutako egunean 
		// ezin bada ikusi pelikula hori showMesasgeDialog bat agertuko da eta "hurrengo" botoia desabilitatuko da
		datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.setTime(model.getValue());
                //Gaurko egunaren aurreko egunak hartzen dira
                Calendar before = Calendar.getInstance();
                before.add(Calendar.DATE, -1);
                //Gaurko eguna hartzen da
                Calendar today = Calendar.getInstance();
                today.add(Calendar.DATE, 0);
                //Bi hilbete eta geroko egunak hartzen dira
                Calendar month = Calendar.getInstance();
                month.add(Calendar.MONTH, +2);
                
                if (selectedDate.before(before)) {
                    model.setValue(before.getTime());
                    JOptionPane.showMessageDialog(null, "Ezin da aukeratu igaro den egun bat");
                    WindowBuilderMetodoak.ezkutatu(btnHurrengoa3, comboSesioak);
                }else if(selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                    JOptionPane.showMessageDialog(null, "Astelehenetan zinema itxita dago");
                    WindowBuilderMetodoak.ezkutatu(btnHurrengoa3, comboSesioak);	
                }else if(selectedDate.before(today)) {
                    JOptionPane.showMessageDialog(null, "Gaur bakrarrik lehiatilan erosi ahal dira");
                    WindowBuilderMetodoak.ezkutatu(btnHurrengoa3, comboSesioak);
                }else if(selectedDate.after(month)){
                    JOptionPane.showMessageDialog(null, "Ez daukagu zinemarako sarrerarik hain urruneko data baterako");
                    WindowBuilderMetodoak.ezkutatu(btnHurrengoa3, comboSesioak);
                		}else {
                			WindowBuilderMetodoak.erakutsi(btnHurrengoa3, comboSesioak); 
                		}
            }
        });
		
		//Bukaera
		//Pantailan kilkatzean 2 segundu itxaroten du eta berriro ongiEtorri panelara doa
		btnAmaitu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.btn3secDelay(ongiEtorri, 2, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera, e);
            }
		});	
		
		//Laburpena
		//Laburpena panelean "Atzera" botoiari click egin eta zinemaAreto panelera bueltatzeko
		btnAtzera3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(zinemaAreto, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//pelikulak panelean "Hurrengoa" botoiari click egin eta pelikulaDatak panelera pasatzeko
		btnBukatuErosketa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(login, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//Login
		//Login panelean "Atzera" botoiari click egin eta laburpena panelera bueltatzeko
		btnAtzera4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(laburpena, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//Login panelean "Erregistratu" botoiari click egin eta erregistratu panelera bueltatzeko
		btnErregistratu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(erregistratu, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//Login panelean "BukatuErosketa2" botoiari click egin eta tiket panelera bueltatzeko
		btnBukatuErosketa2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Erosketa zuzen burutu da");
                WindowBuilderMetodoak.hurrengoaBtn(tiket, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//Login panelean "berrezarri" botoiari click egin eta ongiEtorri panelera bueltatzeko
		btnBerrezarri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.btn3secDelay(ongiEtorri, 2, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera, e);
            }
		});
		
		//Erregistratu
		//Erregistrtu panelean "Atzera" botoiari click egin eta laburpena panelera bueltatzeko
		btnAtzera5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(laburpena, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            }
		});
		
		//Erregistratu panelean "Atzera" botoiari click egin eta laburpena panelera bueltatzeko
		btnBukatuErregistratu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 JOptionPane.showMessageDialog(null, "Erosketa zuzen burutu da");
                 WindowBuilderMetodoak.hurrengoaBtn(tiket, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);            }
		});
		
		//Tiket
		//Tiket panelean "bai" botoiari click egin eta showDialog bat agertuko da, tiketa gordeko da eta bukaera penelera joango da
		btnBai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Faktura zuzen gorde da");
                WindowBuilderMetodoak.btn3secDelay(bukaera, 2, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera, e);
            }
		});
		
		//Tiket panelean "ez" botoiari click egin eta bukaera panelera joango da
		btnBai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.btn3secDelay(bukaera, 2, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera, e);
            }
		});
	}
}