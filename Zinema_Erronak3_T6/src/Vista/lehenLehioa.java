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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.toedter.calendar.JDateChooser;

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
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

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
	private Bezero [] bezeroak;
	private Eskaria [] eskariak;
	private Sarrera [] sarrerak;
	private Saioa [] saioak;
	private Areto [] aretoak;
	Film aukeratutakoFilm = new Film();
	Date aukeratutakoData;
	LocalTime aukeratutakoOrdua; 
	int aretoZbk;
	String [] filmAukerak;
	Zinema aukeratutakoZinema;
	Film aukeratutakoPelikula;
	Saioa aukeratutakoSaioa;
	LocalDateTime locaDate;
	Saioa[] beharSaioa;
	private JTable tablePelData;
	
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
	
	public lehenLehioa() {	
		//String[] filmGordeta = new String [15];
		zinemak = datuBase.ZinemakKarga();
		
		Zinema z1 = datuBase.kargaHutsa();
        String  aukeratutakoPelikula = (String) "Million Dolar Baby";	
		beharSaioa = metodoak.saioakBete(z1, aukeratutakoPelikula);	
        for (int i = 0;i<beharSaioa.length;i++) {
        	beharSaioa[0].getData();
        	System.out.println(beharSaioa[0].getData());
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
		zinemaAreto.setToolTipText("");
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
		
		JComboBox CBFilm = new JComboBox();
		CBFilm.setBounds(19, 98, 445, 22);
		pelikulak.add(CBFilm);
		
		//PELIKULAK DATA
		JPanel pelikulakData = new JPanel();
		contentPane.add(pelikulakData, "name_3591189006900");
		pelikulakData.setLayout(null);
		
		JLabel logoa2_3 = new JLabel("");
		logoa2_3.setBounds(0, 0, 100, 80);
		logoa2_3.setIcon(new ImageIcon(img2));
		pelikulakData.add(logoa2_3);
		
		//JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formatoa
        dateChooser.setDate(new Date()); // Lehen eguna, gaurko eguna
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
        maxDate.set(Calendar.MONTH, Calendar.APRIL);
        maxDate.set(Calendar.DATE, 1);
        maxDate.set(Calendar.HOUR_OF_DAY, 23);
        maxDate.set(Calendar.MINUTE, 59);
        maxDate.set(Calendar.SECOND, 59);
        if (maxDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            maxDate.add(Calendar.DATE, -1);
        }
        Date fechaMaxima = maxDate.getTime();
        dateChooser.getJCalendar().setSelectableDateRange(new Date(), fechaMaxima); // Daten rangoa aplikatzen du.
        dateChooser.setBounds(138, 37, 213, 20);
        pelikulakData.add(dateChooser);
        
		
		JButton btnHurrengoa3 = new JButton("Hurrengoa");
		btnHurrengoa3.setEnabled(false);
		btnHurrengoa3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa3.setBounds(347, 272, 127, 31);
		pelikulakData.add(btnHurrengoa3);
		
		JButton btnAtzera2 = new JButton("Atzera");
		btnAtzera2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtzera2.setBounds(10, 272, 95, 31);
		pelikulakData.add(btnAtzera2);
		
		JScrollPane scrollPanePelData = new JScrollPane();
		scrollPanePelData.setBounds(10, 166, 464, 39);
		scrollPanePelData.setEnabled(false);
		scrollPanePelData.setVisible(false);
		pelikulakData.add(scrollPanePelData);
		
		tablePelData = new JTable();
		
		JComboBox CBSesioak = new JComboBox();
		CBSesioak.setBounds(138, 100, 213, 22);
		
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Beherpena:");
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
	    ) {
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, false
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    table.getColumnModel().getColumn(0).setResizable(false);
	    table.getColumnModel().getColumn(1).setResizable(false);
	    table.getColumnModel().getColumn(2).setResizable(false);
	    table.getColumnModel().getColumn(3).setResizable(false);
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
    			btnHurrengoa1.setEnabled(true);
            }
		});
		
		btnHurrengoa1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulak, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
            
              //CBZinemak-en zein zinema aukeratu den gordetzen du.
                aukeratutakoZinema = (Zinema) CBZinemak.getSelectedItem();
                filmAukerak = metodoak.filmErakutsi(aukeratutakoZinema);  

                //Aukeratutako zineman dauden Saioetako pelikulak aktualizatzen ditu.
                CBFilm.setModel(new DefaultComboBoxModel(filmAukerak));

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
		CBFilm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    			btnHurrengoa2.setEnabled(true);
            }
		});
		
		//
		btnHurrengoa2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulakData, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
                String aukeratutakoTiltulo = (String) CBFilm.getSelectedItem();
                aukeratutakoFilm.setTituloa(aukeratutakoTiltulo);	

        		beharSaioa = metodoak.saioakBete(aukeratutakoZinema, aukeratutakoFilm);	
                
        		CBSesioak.setVisible(false);
        		CBSesioak.setEnabled(false);
            }
		});
		
		//pelikulaDatak
		//pelikulaDatak panelean "Atzera" botoiari click egin eta pelikulak panelera bueltatzeko
		btnAtzera2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WindowBuilderMetodoak.hurrengoaBtn(pelikulak, ongiEtorri, zinemaAreto, pelikulak, pelikulakData, laburpena, login, erregistratu, tiket, bukaera);
                WindowBuilderMetodoak.ezkutatu(btnHurrengoa1, btnHurrengoa2);
        		CBSesioak.setEnabled(false);
        		CBSesioak.setVisible(false);
        		scrollPanePelData.setEnabled(false);
        		scrollPanePelData.setVisible(false);
            }
		});
		
		//DATECHOOSER
		dateChooser.getDateEditor().addPropertyChangeListener((PropertyChangeListener) new PropertyChangeListener(){ 
	        public void propertyChange(PropertyChangeEvent e) {
	        	CBSesioak.setVisible(true);
	        	CBSesioak.setEnabled(true);
	        	Date selectedDate = dateChooser.getDate();
	        	aukeratutakoData = selectedDate;
	        	LocalTime [] saioOrduak = new LocalTime [0];
	        	int saioOrduaI= 0;
	        	
	        	for (int i = 0; i < beharSaioa.length; i++) {
//	        	    System.out.print(beharSaioa[i].getData());
//	        	    System.out.println(" // " + beharSaioa[i].getOrdua());
					if (beharSaioa[i].getData().equals(aukeratutakoData)) {
						if(saioOrduaI == saioOrduak.length) {
							LocalTime [] saioOrduaBerria = new LocalTime[saioOrduak.length+1];
							System.arraycopy(saioOrduak, 0, saioOrduaBerria, 0, saioOrduak.length);
							saioOrduak = saioOrduaBerria;
						}
						saioOrduak[saioOrduaI++] = beharSaioa[i].getOrdua();
						//saioOrduak[0] = beharSaioa[i].getOrdua();
					}
	        	}	
	        	CBSesioak.setModel(new DefaultComboBoxModel(saioOrduak));        	
	    		pelikulakData.add(CBSesioak);
	    		
	        }
	});
		
		//pelikulak panelean "Hurrengoa" botoiari click egin eta pelikulaDatak panelera pasatzeko
		CBSesioak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	tablePelData.getTableHeader().setReorderingAllowed(false);
            	tablePelData.getTableHeader().setResizingAllowed(false);
            	aukeratutakoOrdua = (LocalTime) CBSesioak.getSelectedItem();	
        		CBSesioak.setEnabled(true);
        		CBSesioak.setVisible(true);
        		//CBSesioak.setPopupVisible(true);
        		
        		scrollPanePelData.setEnabled(true);
        		scrollPanePelData.setVisible(true);
        		aukeratutakoSaioa = new Saioa();
        		for (int i = 0; i < aukeratutakoZinema.getAretoak().length; i++) {
        			for (int j = 0; j< aukeratutakoZinema.getAretoak()[i].getSaioak().length; j++) {
        				if (aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getTituloa().equals(aukeratutakoFilm.getTituloa())) {
        					aukeratutakoSaioa = aukeratutakoZinema.getAretoak()[i].getSaioak()[j];
        					if (aukeratutakoSaioa.getOrdua().equals(aukeratutakoOrdua) && aukeratutakoSaioa.getData().equals(aukeratutakoData)) {
        						aretoZbk = aukeratutakoZinema.getAretoak()[i].getZenbakia();
        						aukeratutakoFilm.setPrezioa(aukeratutakoZinema.getAretoak()[i].getSaioak()[j].getFilma().getPrezioa());
        					}
        					
        				}
        			}
        				
        		}
	        	DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	        	String aukeratutakoDataStr = dt.format(aukeratutakoData);
        //		System.out.println(aukeratutakoZinema.getAretoak()[]);
        		tablePelData.setModel(new DefaultTableModel(
        				new Object[][] {
        					{aukeratutakoFilm.getTituloa(), aukeratutakoDataStr + " / " + aukeratutakoOrdua, aretoZbk, aukeratutakoFilm.getPrezioa()},
        				},
        				new String[] {
        					"Izenburua", "Data", "Areto", "Prezio"
        				}
        				) {
        	    	boolean[] columnEditables = new boolean[] {
        	    		false, false, false, false
        	    	};
        	    	public boolean isCellEditable(int row, int column) {
        	    		return columnEditables[column];
        	    	}
        	    });
        		tablePelData.getColumnModel().getColumn(0).setResizable(false);
        		tablePelData.getColumnModel().getColumn(1).setResizable(false);
        		tablePelData.getColumnModel().getColumn(2).setResizable(false);
        		tablePelData.getColumnModel().getColumn(3).setResizable(false);
        		
    			tablePelData.getColumnModel().getColumn(0).setPreferredWidth(186);
    			tablePelData.getColumnModel().getColumn(1).setPreferredWidth(102);
    			scrollPanePelData.setViewportView(tablePelData);
    			
    			btnHurrengoa3.setEnabled(true);
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
                
        		CBSesioak.setEnabled(false);
        		CBSesioak.setVisible(false);
        		scrollPanePelData.setEnabled(false);
        		scrollPanePelData.setVisible(false);
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