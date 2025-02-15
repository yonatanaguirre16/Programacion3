package Aplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javafx.scene.control.CheckBox;

public class Ventana extends JFrame {
	
	// definir fuente para utilizar solo la palabra etiqueta al usar esta fuente
	Font fuenteGrande = new Font("Times New Roman", Font.BOLD, 35);
	Font fuenteEtiquetas = new Font("Times New Roman", Font.PLAIN, 20);

	public Ventana(String title) {
		
		
		this.setTitle(title);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina el programa al cerrar
		this.setSize(500, 500); // Tamaño del frame
		this.setResizable(false); // decide si cambia de tamaño la ventana o no
		this.setLocationRelativeTo(null); // centra la ventana 
		
		this.setMinimumSize(new Dimension(400, 400));
		this.setMaximumSize(new Dimension(800, 900));
		
		this.add(this.login());
		this.repaint();
		
		
	}
	
	
	public JPanel login() {
		
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(500, 500); 
		login.setOpaque(true);
		login.setBackground(Color.gray);
		login.setVisible(true);
		login.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(220, 60);
		etiqueta1.setLocation(150, 10);
		etiqueta1.setBackground(Color.red);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(true); // para backgrounds
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		login.add(etiqueta1); // agrega la etiqueta1 al panel login
		
		
		JLabel etiqueta2 = new JLabel("Correo: ");
		etiqueta2.setBounds(60, 90, 80, 30); // junta size y location en uno solo
		etiqueta2.setBackground(Color.WHITE);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(fuenteEtiquetas);
		
		login.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(60, 125, 250, 30); // junta size y location en uno solo
		// x ,y width height
		email.setBackground(Color.WHITE);
		email.setOpaque(true);
		email.setFont(fuenteEtiquetas);
		login.add(email);
		
		JLabel etiqueta3 = new JLabel("Password: ");
		etiqueta3.setBounds(60, 180, 120, 30); // junta size y location en uno solo
		etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(true);
		etiqueta3.setFont(fuenteEtiquetas);
		
		login.add(etiqueta3);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(60, 215, 250, 30); // junta size y location en uno solo
		// x ,y width height
		pass.setBackground(Color.WHITE);
		pass.setOpaque(true);
		pass.setFont(fuenteEtiquetas);
		login.add(pass);
		
		JCheckBox recuerdame = new JCheckBox("Recuerdame");
		recuerdame.setBounds(60, 260, 250, 30); // junta size y location en uno solo
		recuerdame.setOpaque(false);
		recuerdame.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recuerdame);
		
		JButton recordarContra = new JButton("¿olvidaste tu contraseña?");
		recordarContra.setBounds(200, 260, 240, 30); // junta size y location en uno solo
	    recordarContra.setOpaque(false);
		recordarContra.setBorderPainted(false);
		recordarContra.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recordarContra);
		
		JButton access = new JButton("Acceder");
		access.setBounds(180, 320, 120, 30); 
		access.setBackground(Color.WHITE);
		access.setOpaque(true);
		access.setFont(fuenteEtiquetas);
		etiqueta1.setHorizontalAlignment(JButton.CENTER); // alinea las cosas al centro

		login.add(access);
		
		
		login.revalidate();
		
		return login;
		
	}

}
