package Aplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Ventana extends JFrame {
	
	// definir fuente para utilizar solo la palabra etiqueta al usar esta fuente
	Font fuenteGrande = new Font("Times New Roman", Font.BOLD, 35);
	Font fuenteEtiquetas = new Font("Times New Roman", Font.BOLD, 20);

	public Ventana(String title) {
		
		
		this.setTitle(title);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina el programa al cerrar
		this.setSize(500, 600); // Tamaño del frame
		this.setResizable(false); // decide si cambia de tamaño la ventana o no
		this.setLocationRelativeTo(null); // centra la ventana 
		
		this.setMinimumSize(new Dimension(400, 400));
		this.setMaximumSize(new Dimension(800, 1200));
		
		//this.add(this.login());
		this.add(this.registro());
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
	
	public JPanel registro() {
		
		JPanel registro = new JPanel();
		registro.setLocation(0, 0);
		registro.setSize(500, 1500); 
		registro.setOpaque(true);
		registro.setBackground(Color.LIGHT_GRAY);
		registro.setVisible(true);
		registro.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(220, 60);
		etiqueta1.setLocation(150, 10);
		etiqueta1.setBackground(Color.black);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(true); // para backgrounds
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		registro.add(etiqueta1); // agrega la etiqueta1 al panel login
		
		
		JLabel etiqueta2 = new JLabel("NOMBRE DE USUARIO: ");
		etiqueta2.setBounds(39, 90, 410, 30); // junta size y location en uno solo
		// x y, w h
		etiqueta2.setBackground(Color.yellow);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(fuenteEtiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		
		registro.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(39, 121, 410, 30); // junta size y location en uno solo
		// x ,y width height
		email.setBackground(Color.WHITE);
		email.setOpaque(true);
		email.setFont(fuenteEtiquetas);
		registro.add(email);
		
		JLabel etiqueta3 = new JLabel("BIO ");
		etiqueta3.setBounds(190, 160, 120, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(fuenteEtiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.CENTER);
		
		registro.add(etiqueta3);
		
		JTextField bio = new JTextField();
		bio.setBounds(39, 190, 410, 90); // junta size y location en uno solo
		// x ,y width height
		bio.setBackground(Color.WHITE);
		bio.setOpaque(true);
		bio.setFont(fuenteEtiquetas);
		registro.add(bio);
		
		Border border = new LineBorder(Color.RED, 2, true);
		//bio.setBorder(border);
		
		JLabel preferencias = new JLabel("PREFERENCIAS");
		preferencias.setBounds(140, 280, 220, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		preferencias.setOpaque(false);
		preferencias.setFont(fuenteEtiquetas);
		preferencias.setHorizontalAlignment(JLabel.CENTER);
		registro.add(preferencias);
		
		JCheckBox pref1 = new JCheckBox("Dulce");
		pref1.setBounds(60, 320, 80, 30); // junta size y location en uno solo
		pref1.setOpaque(false);
		pref1.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref1);
		
		JCheckBox pref2 = new JCheckBox("Salado");
		pref2.setBounds(140, 320, 80, 30); // junta size y location en uno solo
		pref2.setOpaque(false);
		pref2.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref2);
		
		JCheckBox pref3 = new JCheckBox("Saludable");
		pref3.setBounds(220, 320, 100, 30); // junta size y location en uno solo
		pref3.setOpaque(false);
		pref3.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref3);
		pref3.setBorderPainted(true);
		pref3.setBorder(border);
		
		JLabel term = new JLabel("TÉRMINOS ");
		term.setBounds(130, 360, 250, 30); // junta size y location en uno solo
		// x y, w h
		term.setBackground(Color.yellow);
		term.setOpaque(true);
		term.setFont(fuenteEtiquetas);
		term.setHorizontalAlignment(JLabel.CENTER);
		registro.add(term);
		
		JRadioButton terminos1 = new JRadioButton("Acepto los terminos");
		terminos1.setLocation(30, 400);
		terminos1.setSize(180, 40);
		terminos1.setOpaque(false);
		registro.add(terminos1);
		
		JRadioButton terminos2 = new JRadioButton("No acepto los terminos");
		terminos2.setLocation(220, 400);
		terminos2.setSize(180, 40);
		terminos2.setOpaque(false);
		registro.add(terminos2);
		
		ButtonGroup terminos = new ButtonGroup();
		
		terminos.add(terminos1);
		terminos.add(terminos2);
		
		/*terminos1.setBorder(border);
		terminos1.setBorderPainted(true);
		terminos2.setBorder(border);
		terminos2.setBorderPainted(false);
		 */

		String [] preferencias_set = {"Centro", "Camino Real", "Indeco"};
		
		JComboBox preferenciass = new JComboBox(preferencias_set);
		preferenciass.setLocation(39, 450);
		preferenciass.setSize(410, 40);
		registro.add(preferenciass);
		
		JButton crear = new JButton("Crear Cuenta");
		crear.setBounds(39, 500, 410, 40); 
		crear.setBackground(Color.WHITE);
		crear.setOpaque(true);
		crear.setFont(fuenteEtiquetas);
		etiqueta1.setHorizontalAlignment(JButton.CENTER); // alinea las cosas al centro
		registro.add(crear);
		
		
		
		
		/*
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
		*/
		//login.add(access);
		
		
		registro.revalidate();
		
		return registro;
		
	}

}