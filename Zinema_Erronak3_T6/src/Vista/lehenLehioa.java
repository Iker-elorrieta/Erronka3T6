package Vista;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JScrollPane;

public class lehenLehioa extends JFrame {

	private JPanel contentPane;
	private JTable laburpenaTaula;
	private JTextField textPrezioa;
	private JTextField textField;
	private JTextField textTotala;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField txtNan;
	private JPasswordField passwordField_2;

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
				
				JLabel logoa = new JLabel("");
				logoa.setBounds(70, 0, 325, 251);
				Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		        logoa.setIcon(new ImageIcon(img));
				
				JLabel txt1 = new JLabel("Ongi Etorri!");
				txt1.setBounds(159, 249, 179, 54);
				txt1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
				
				JButton btnInv = new JButton("");
				btnInv.setBounds(0, 0, 484, 314);
				btnInv.setOpaque(false);
				btnInv.setContentAreaFilled(false);
				btnInv.setBorderPainted(false);
				ongiEtorri.setLayout(null);
				ongiEtorri.add(logoa);
				ongiEtorri.add(txt1);
				ongiEtorri.add(btnInv);
				
				
				//Aritza
				
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
				
				JPanel login = new JPanel();
				contentPane.add(login, "name_359351979134700");
				login.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("NAN");
				lblNewLabel_2.setBounds(123, 73, 35, 14);
				login.add(lblNewLabel_2);
				
				JLabel lblNewLabel_2_1 = new JLabel("Pasahitza");
				lblNewLabel_2_1.setBounds(106, 104, 62, 14);
				login.add(lblNewLabel_2_1);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(168, 101, 132, 20);
				login.add(passwordField);
				
				textField_1 = new JTextField();
				textField_1.setBounds(168, 70, 131, 20);
				login.add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblLogin = new JLabel("LOGIN");
				lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
				lblLogin.setBounds(200, 11, 71, 27);
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
				
				JPanel erregistratu = new JPanel();
				erregistratu.setLayout(null);
				contentPane.add(erregistratu, "name_359911054480700");
				
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
				
				JPanel tiket = new JPanel();
				contentPane.add(tiket, "name_360289319246600");
				tiket.setLayout(null);
				
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
				btnLaburpenaBukatuErosketa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		                ongiEtorri.setVisible(false);
		                laburpena.setVisible(false);
		                login.setVisible(true);
					}
				});
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
