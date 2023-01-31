package Vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class lehenLehioa extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup zinemaGroup = new ButtonGroup();
	private JTable laburpenaTaula;
	private JTextField textPrezioa;
	private JTextField textField;
	private JTextField textTotala;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField txtNan;
	private JPasswordField passwordField_2;
	private JTable pelikulakTaula;
	private final ButtonGroup pelikulakGroup = new ButtonGroup();

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
		
		JButton btnInv = new JButton("");
		btnInv.setBounds(0, 0, 484, 314);
		btnInv.setOpaque(false);
		btnInv.setContentAreaFilled(false);
		btnInv.setBorderPainted(false);
		ongiEtorri.setLayout(null);
		ongiEtorri.add(logoa1_1);
		ongiEtorri.add(txt1);
		ongiEtorri.add(btnInv);
		
		//ZINEMA ARETOA
		
		JPanel zinemaAreto = new JPanel();
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
		
		JRadioButton zinema1 = new JRadioButton("Cinesa");
		zinema1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		zinema1.setHorizontalAlignment(SwingConstants.CENTER);
		zinemaGroup.add(zinema1);
		zinema1.setBounds(90, 112, 109, 23);
		zinemaAreto.add(zinema1);
		
		JRadioButton zinema2 = new JRadioButton("Yelmo");
		zinema2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		zinema2.setHorizontalAlignment(SwingConstants.CENTER);
		zinemaGroup.add(zinema2);
		zinema2.setBounds(291, 112, 109, 23);
		zinemaAreto.add(zinema2);
		
		JRadioButton zinema3 = new JRadioButton("Golem");
		zinema3.setToolTipText("");
		zinema3.setHorizontalAlignment(SwingConstants.CENTER);
		zinema3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		zinemaGroup.add(zinema3);
		zinema3.setBounds(90, 184, 109, 23);
		zinemaAreto.add(zinema3);
		
		JRadioButton zinema4 = new JRadioButton("Ocine");
		zinema4.setHorizontalAlignment(SwingConstants.CENTER);
		zinema4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		zinemaGroup.add(zinema4);
		zinema4.setBounds(291, 188, 109, 23);
		zinemaAreto.add(zinema4);
		
		JButton btnBukatu = new JButton("Bukatu");
		btnBukatu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBukatu.setBounds(10, 276, 95, 31);
		zinemaAreto.add(btnBukatu);
		
		JButton btnHurrengoa1 = new JButton("Hurrengoa");
		btnHurrengoa1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa1.setBounds(349, 276, 127, 31);
		zinemaAreto.add(btnHurrengoa1);
		
		//PELIKULAK
		
		JPanel pelikulak = new JPanel();
		contentPane.add(pelikulak, "name_2894301677400");
		pelikulak.setLayout(null);
		
		JScrollPane scrollPanePelikulak = new JScrollPane();
		scrollPanePelikulak.setBounds(79, 91, 343, 140);
		pelikulak.add(scrollPanePelikulak);
		
		pelikulakTaula = new JTable();
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
		btnHurrengoa2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHurrengoa2.setBounds(347, 272, 127, 31);
		pelikulak.add(btnHurrengoa2);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAtzera.setBounds(10, 272, 95, 31);
		pelikulak.add(btnAtzera);
		
		JLabel logoa2_2 = new JLabel("");
		logoa2_2.setBounds(0, 0, 100, 80);
		logoa2_2.setIcon(new ImageIcon(img2));
		pelikulak.add(logoa2_2);
		
		JRadioButton pelikula1 = new JRadioButton("");
		pelikulakGroup.add(pelikula1);
		pelikula1.setBounds(50, 113, 109, 23);
		pelikulak.add(pelikula1);
		
		JRadioButton pelikula2 = new JRadioButton("");
		pelikulakGroup.add(pelikula2);
		pelikula2.setBounds(50, 131, 109, 23);
		pelikulak.add(pelikula2);
		
		JRadioButton pelikula3 = new JRadioButton("");
		pelikulakGroup.add(pelikula3);
		pelikula3.setBounds(50, 149, 109, 23);
		pelikulak.add(pelikula3);
		
		//PELIKULAK DATA
		JPanel pelikulakData = new JPanel();
		contentPane.add(pelikulakData, "name_3591189006900");
		pelikulakData.setLayout(null);
		
		JLabel logoa2_3 = new JLabel("");
		logoa2_3.setBounds(0, 0, 100, 80);
		logoa2_3.setIcon(new ImageIcon(img2));
		pelikulakData.add(logoa2_3);
		
		//LABURPENA
		
		JPanel laburpena = new JPanel();
		contentPane.add(laburpena, "name_357675593712100");
		laburpena.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LABURPENA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(180, 0, 124, 27);
		laburpena.add(lblNewLabel);

		laburpenaTaula = new JTable();
		laburpenaTaula.setEnabled(false);
		laburpenaTaula.setToolTipText("");
		laburpenaTaula.setModel(new DefaultTableModel(
			new Object[][] {
				{"Titulua", "Data", "Areto", "Prezioa"},
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
		laburpenaTaula.setBounds(82, 48, 293, 81);
		laburpena.add(laburpenaTaula);
		
		JButton btnLaburpenaAtzera = new JButton("Atzera");
		btnLaburpenaAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ongiEtorri.setVisible(true);
                laburpena.setVisible(false);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		laburpena.add(scrollPane);
		btnLaburpenaAtzera.setBounds(10, 280, 134, 23);
		laburpena.add(btnLaburpenaAtzera);
		
		textPrezioa = new JTextField();
		textPrezioa.setEditable(false);
		textPrezioa.setBounds(247, 139, 86, 20);
		laburpena.add(textPrezioa);
		textPrezioa.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(247, 177, 86, 20);
		laburpena.add(textField);
		
		textTotala = new JTextField();
		textTotala.setEditable(false);
		textTotala.setColumns(10);
		textTotala.setBounds(247, 219, 86, 20);
		laburpena.add(textTotala);
		
		JLabel lblNewLabel_1 = new JLabel("Azkenengo prezioa");
		lblNewLabel_1.setBounds(130, 222, 106, 14);
		laburpena.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prezio beherapen gabe");
		lblNewLabel_1_1.setBounds(106, 142, 131, 14);
		laburpena.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Beherpena");
		lblNewLabel_1_1_1.setBounds(164, 180, 86, 14);
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
		lblNewLabel_2.setBounds(125, 98, 35, 14);
		login.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pasahitza");
		lblNewLabel_2_1.setBounds(108, 129, 62, 14);
		login.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 126, 132, 20);
		login.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 95, 131, 20);
		login.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLogin.setBounds(202, 36, 71, 27);
		login.add(lblLogin);
		
		JButton btnLoginAtzera = new JButton("Atzera");
		btnLoginAtzera.setBounds(10, 280, 148, 23);
		login.add(btnLoginAtzera);
		
		JButton btnLoginErregistratu = new JButton("Erregistratu");
		btnLoginErregistratu.setBounds(181, 280, 134, 23);
		login.add(btnLoginErregistratu);
		
		JButton btnLoginBukatuErosketa = new JButton("Bukatu erosketa");
		btnLoginBukatuErosketa.setBounds(340, 280, 134, 23);
		login.add(btnLoginBukatuErosketa);
		
		JButton btnLoginBerrezarri = new JButton("Berrezarri datu guztiak");
		btnLoginBerrezarri.setBounds(10, 248, 148, 23);
		login.add(btnLoginBerrezarri);
		
		JButton btnLaburpenaBukatuErosketa = new JButton("Bukatu erosketa");
		btnLaburpenaBukatuErosketa.setBounds(340, 280, 134, 23);
		laburpena.add(btnLaburpenaBukatuErosketa);
		
		//ERREGISTRATU
		
		JPanel erregistratu = new JPanel();
		erregistratu.setLayout(null);
		contentPane.add(erregistratu, "name_359911054480700");
		
		JLabel logoa2_5 = new JLabel("");
		logoa2_5.setBounds(0, 0, 100, 80);
		logoa2_5.setIcon(new ImageIcon(img2));
		erregistratu.add(logoa2_5);
		
		JLabel lblNewLabel_2_2 = new JLabel("NAN");
		lblNewLabel_2_2.setBounds(138, 94, 35, 14);
		erregistratu.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Pasahitza");
		lblNewLabel_2_1_1.setBounds(121, 125, 62, 14);
		erregistratu.add(lblNewLabel_2_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("");
		passwordField_1.setBounds(183, 122, 132, 20);
		erregistratu.add(passwordField_1);
		
		txtNan = new JTextField();
		txtNan.setColumns(10);
		txtNan.setBounds(183, 91, 131, 20);
		erregistratu.add(txtNan);
		
		JLabel lblErregistratu = new JLabel("ERREGISTRATU");
		lblErregistratu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblErregistratu.setBounds(169, 11, 177, 27);
		erregistratu.add(lblErregistratu);
		
		JButton btnErregistratuAtzera = new JButton("Atzera");
		btnErregistratuAtzera.setBounds(10, 280, 148, 23);
		erregistratu.add(btnErregistratuAtzera);
		
		JButton btnErregistratuBukatuErosketa = new JButton("Bukatu erosketa");
		btnErregistratuBukatuErosketa.setBounds(340, 280, 134, 23);
		erregistratu.add(btnErregistratuBukatuErosketa);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(183, 155, 132, 20);
		erregistratu.add(passwordField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Errepikatu pasahitza");
		lblNewLabel_2_1_1_1.setBounds(78, 158, 105, 14);
		erregistratu.add(lblNewLabel_2_1_1_1);
		
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
		
		JButton btnTiketBai = new JButton("Bai");
		btnTiketBai.setBounds(124, 159, 89, 23);
		tiket.add(btnTiketBai);
				
		JButton btnTiketEz = new JButton("Ez");
		btnTiketEz.setBounds(279, 159, 89, 23);
		tiket.add(btnTiketEz);
		
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
		
		JButton btnInv_2 = new JButton("");
		btnInv_2.setOpaque(false);
		btnInv_2.setContentAreaFilled(false);
		btnInv_2.setBorderPainted(false);
		btnInv_2.setBounds(0, 0, 484, 314);
		bukaera.add(btnInv_2);
		
		btnLaburpenaBukatuErosketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ongiEtorri.setVisible(false);
                laburpena.setVisible(false);
                login.setVisible(true);
			}
		});
		
		//ongiEtorri panelean click egin eta 3 segundu pasa ondoren laburpen panelera pasatzeko
		btnInv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        System.out.println(e);
                    }
                ongiEtorri.setVisible(false);
                laburpena.setVisible(true);
                login.setVisible(false);

            }
		});	
		
	}
}