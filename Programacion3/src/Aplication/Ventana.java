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
		this.setSize(300, 420); // Tamaño del frame
		this.setResizable(false); // decide si cambia de tamaño la ventana o no
		this.setLocationRelativeTo(null); // centra la ventana 
		
		this.setMinimumSize(new Dimension(400, 400));
		this.setMaximumSize(new Dimension(800, 1200));
		
		//this.add(this.login());
		//this.add(this.registro());
		this.add(this.calculadora());
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
		etiqueta1.setSize(220, 65);
		etiqueta1.setLocation(150, 10);
		etiqueta1.setBackground(Color.red);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(true); // para backgrounds
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		login.add(etiqueta1); // agrega la etiqueta1 al panel login
		
		
		JLabel etiqueta2 = new JLabel("Correo: ");
		etiqueta2.setBounds(65, 90, 80, 30); // junta size y location en uno solo
		etiqueta2.setBackground(Color.WHITE);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(fuenteEtiquetas);
		
		login.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(65, 125, 250, 30); // junta size y location en uno solo
		// x ,y width height
		email.setBackground(Color.WHITE);
		email.setOpaque(true);
		email.setFont(fuenteEtiquetas);
		login.add(email);
		
		JLabel etiqueta3 = new JLabel("Password: ");
		etiqueta3.setBounds(65, 180, 120, 30); // junta size y location en uno solo
		etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(true);
		etiqueta3.setFont(fuenteEtiquetas);
		
		login.add(etiqueta3);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(65, 215, 250, 30); // junta size y location en uno solo
		// x ,y width height
		pass.setBackground(Color.WHITE);
		pass.setOpaque(true);
		pass.setFont(fuenteEtiquetas);
		login.add(pass);
		
		JCheckBox recuerdame = new JCheckBox("Recuerdame");
		recuerdame.setBounds(65, 265, 250, 30); // junta size y location en uno solo
		recuerdame.setOpaque(false);
		recuerdame.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recuerdame);
		
		JButton recordarContra = new JButton("¿olvidaste tu contraseña?");
		recordarContra.setBounds(200, 265, 240, 30); // junta size y location en uno solo
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
		etiqueta1.setSize(220, 65);
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
		etiqueta3.setBounds(190, 165, 120, 30); // junta size y location en uno solo
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
		pref1.setBounds(65, 320, 80, 30); // junta size y location en uno solo
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
		term.setBounds(130, 365, 250, 30); // junta size y location en uno solo
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
		recuerdame.setBounds(65, 265, 250, 30); // junta size y location en uno solo
		recuerdame.setOpaque(false);
		recuerdame.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recuerdame);
		
		JButton recordarContra = new JButton("¿olvidaste tu contraseña?");
		recordarContra.setBounds(200, 265, 240, 30); // junta size y location en uno solo
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

	public JPanel calculadora() {
		
		Border borderCalc = new LineBorder(Color.WHITE, 1, true);

		
		JPanel calculadora = new JPanel();
		calculadora.setLocation(0, 0);
		calculadora.setSize(500, 500); 
		calculadora.setOpaque(true);
		calculadora.setBackground(Color.black);
		calculadora.setVisible(true);
		calculadora.setLayout(null);
		
		JTextField espacioNumeros = new JTextField();
		espacioNumeros.setBounds(42, 5, 300, 50); // junta size y location en uno solo
		// x ,y width height
		espacioNumeros.setBackground(Color.BLACK);
		espacioNumeros.setForeground(Color.WHITE);
		espacioNumeros.setBorder(borderCalc);
		//espacioNumeros.setBorderPainted(true);
		espacioNumeros.setOpaque(true);
		espacioNumeros.setFont(fuenteEtiquetas);
		espacioNumeros.setHorizontalAlignment(JTextField.CENTER);
		calculadora.add(espacioNumeros);
		
		JButton borrarTodo = new JButton("CE");
		borrarTodo.setBounds(42, 65, 65, 50);
		borrarTodo.setBackground(Color.ORANGE);
		borrarTodo.setOpaque(true);
		borrarTodo.setFont(fuenteEtiquetas);
		calculadora.add(borrarTodo);
		
		JButton botonVacio1 = new JButton();
		botonVacio1.setBounds(120, 65, 65, 50);
		botonVacio1.setBackground(Color.GRAY);
		botonVacio1.setOpaque(true);
		botonVacio1.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio1);
		
		JButton botonVacio2 = new JButton();
		botonVacio2.setBounds(200, 65, 65, 50);
		botonVacio2.setBackground(Color.GRAY);
		botonVacio2.setOpaque(true);
		botonVacio2.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio2);
		
		JButton botonVacio3 = new JButton();
		botonVacio3.setBounds(278, 65, 65, 50);
		botonVacio3.setBackground(Color.GRAY);
		botonVacio3.setOpaque(true);
		botonVacio3.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio3);
		
		JButton boton7 = new JButton("7"); // 7
		boton7.setBounds(42, 127, 65, 50);
		boton7.setBackground(Color.GRAY);
		boton7.setOpaque(true);
		boton7.setFont(fuenteEtiquetas);
		calculadora.add(boton7);
		
		JButton boton8 = new JButton("8"); // 8
		boton8.setBounds(120, 127, 65, 50);
		boton8.setBackground(Color.GRAY);
		boton8.setOpaque(true);
		boton8.setFont(fuenteEtiquetas);
		calculadora.add(boton8);
		
		JButton boton9 = new JButton("9"); // 9
		boton9.setBounds(200, 127, 65, 50);
		boton9.setBackground(Color.GRAY);
		boton9.setOpaque(true);
		boton9.setFont(fuenteEtiquetas);
		calculadora.add(boton9);
		
		JButton botonSlash = new JButton("/"); // /
		botonSlash.setBounds(278, 127, 65, 50);
		botonSlash.setBackground(Color.ORANGE);
		botonSlash.setOpaque(true);
		botonSlash.setFont(fuenteEtiquetas);
		calculadora.add(botonSlash);
		
		JButton boton4 = new JButton("4"); // 4
		boton4.setBounds(42, 192, 65, 50);
		boton4.setBackground(Color.GRAY);
		boton4.setOpaque(true);
		boton4.setFont(fuenteEtiquetas);
		calculadora.add(boton4);
		
		JButton boton5 = new JButton("5"); // 5
		boton5.setBounds(120, 192, 65, 50);
		boton5.setBackground(Color.GRAY);
		boton5.setOpaque(true);
		boton5.setFont(fuenteEtiquetas);
		calculadora.add(boton5);
		
		JButton boton6 = new JButton("6"); // 6
		boton6.setBounds(200, 192, 65, 50);
		boton6.setBackground(Color.GRAY);
		boton6.setOpaque(true);
		boton6.setFont(fuenteEtiquetas);
		calculadora.add(boton6);
		
		JButton botonMult = new JButton("*"); // *
		botonMult.setBounds(278, 192, 65, 50);
		botonMult.setBackground(Color.ORANGE);
		botonMult.setOpaque(true);
		botonMult.setFont(fuenteEtiquetas);
		calculadora.add(botonMult);
		
		JButton boton1 = new JButton("1"); // 1
		boton1.setBounds(42, 256, 65, 50);
		boton1.setBackground(Color.GRAY);
		boton1.setOpaque(true);
		boton1.setFont(fuenteEtiquetas);
		calculadora.add(boton1);
		
		JButton boton2 = new JButton("2"); // 2
		boton2.setBounds(120, 256, 65, 50);
		boton2.setBackground(Color.GRAY);
		boton2.setOpaque(true);
		boton2.setFont(fuenteEtiquetas);
		calculadora.add(boton2);
		
		JButton boton3 = new JButton("3"); // 3
		boton3.setBounds(200, 256, 65, 50);
		boton3.setBackground(Color.GRAY);
		boton3.setOpaque(true);
		boton3.setFont(fuenteEtiquetas);
		calculadora.add(boton3);
		
		JButton botonMenos = new JButton("-"); // -
		botonMenos.setBounds(278, 256, 65, 50);
		botonMenos.setBackground(Color.ORANGE);
		botonMenos.setOpaque(true);
		botonMenos.setFont(fuenteEtiquetas);
		calculadora.add(botonMenos);
		
		JButton boton0 = new JButton("0"); // 0
		boton0.setBounds(42, 320, 65, 50);
		boton0.setBackground(Color.GRAY);
		boton0.setOpaque(true);
		boton0.setFont(fuenteEtiquetas);
		calculadora.add(boton0);
		
		JButton botonDot = new JButton("."); // .
		botonDot.setBounds(120, 320, 65, 50);
		botonDot.setBackground(Color.GRAY);
		botonDot.setOpaque(true);
		botonDot.setFont(fuenteEtiquetas);
		calculadora.add(botonDot);
		
		JButton botonIgual = new JButton("="); // =
		botonIgual.setBounds(200, 320, 65, 50);
		botonIgual.setBackground(Color.ORANGE);
		botonIgual.setOpaque(true);
		botonIgual.setFont(fuenteEtiquetas);
		calculadora.add(botonIgual);
		
		JButton botonMas = new JButton("+"); // +
		botonMas.setBounds(278, 320, 65, 50);
		botonMas.setBackground(Color.ORANGE);
		botonMas.setOpaque(true);
		botonMas.setFont(fuenteEtiquetas);
		calculadora.add(botonMas);
		
		
		
		
		
		
		
		return calculadora;
	}
	
	
}