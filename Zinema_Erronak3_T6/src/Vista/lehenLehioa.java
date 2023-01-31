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

public class lehenLehioa extends JFrame {

	private JPanel contentPane;

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
		contentPane.setLayout(null);
		
		
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
		
		JPanel prueba = new JPanel();
		prueba.setBounds(5, 5, 484, 314);
		contentPane.add(prueba);
		prueba.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(197, 5, 89, 23);
		prueba.add(btnNewButton);
		
		btnInv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        System.out.println(e);
                    }
                ongiEtorri.setVisible(false);
                prueba.setVisible(true);
            }
		});	
		
	}

}
