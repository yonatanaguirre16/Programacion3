package Aplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Ventana extends JFrame {
	
	Font fuenteGrande = new Font("Times New Roman", Font.BOLD, 35);
	Font fuenteEtiquetas = new Font("Times New Roman", Font.BOLD, 20);
	Font fuenteLoginTitle = new Font("Dejavu Sans Mono", Font.ITALIC, 30);
	Font fuenteLoginSub = new Font("Dejavu Sans Mono", Font.CENTER_BASELINE, 20);
	Font fuenteLoginSmaller = new Font("Dejavu Sans Mono", Font.CENTER_BASELINE, 10);
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTextField textField_9;
	
		
	@Override
	public Image getIconImage() { // agregar el icono personalizado
	   Image retValue = Toolkit.getDefaultToolkit().
	         getImage(ClassLoader.getSystemResource("resources/sonicicon.png"));


	   return retValue;
	}


	public Ventana(String title)  {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/Aplication/sonicicon.png")));

		this.setTitle(title);
		this.setBackground(Color.RED);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(683, 699);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        getContentPane().add(this.listenerBotones());
        

        

        this.repaint();
        this.setVisible(true);
        
        

	    }
	
	
	
	
	public JPanel interes() {
		
					
        JPanel panelPrincipal = new JPanel(new BorderLayout()); // panel principal
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE, 20));


        JPanel panelTitulo = new JPanel(); // panel de titulo "interes"
        panelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación del panel a la izquierda
        JLabel tituloText = new JLabel("Interés", SwingConstants.LEFT);
        panelTitulo.setBackground(Color.WHITE);
        tituloText.setForeground(Color.RED);
        tituloText.setFont(new Font("Serif", Font.BOLD, 20));
        panelTitulo.add(tituloText);
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
		
	    JPanel panelCentral = new JPanel(new GridLayout(4, 2)); // primer panel verde con gris
        panelCentral.setBackground(Color.green);
        panelCentral.setBorder(BorderFactory.createLineBorder(Color.green, 50));
        panelCentral.setBorder(BorderFactory.createTitledBorder("Calcular Interés"));

        panelCentral.add(new JLabel("Capital:", SwingConstants.CENTER));
        JTextField capitalText = new JTextField();
        panelCentral.add(capitalText);

        panelCentral.add(new JLabel("Tiempo:", SwingConstants.CENTER));
        JTextField tiempoText = new JTextField();
        panelCentral.add(tiempoText);

        panelCentral.add(new JLabel("Tasa Interés:", SwingConstants.CENTER));
        JTextField tasaText = new JTextField();
        panelCentral.add(tasaText);

        JButton botonCalc = new JButton("Calcular");
        JButton botonCancelar = new JButton("Cancelar");
        panelCentral.add(botonCalc);
        panelCentral.add(botonCancelar);

        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        JPanel panelResultados = new JPanel(new GridLayout(2, 2)); // segundo panel rosa con grid
        panelResultados.setBackground(Color.PINK);
        
        panelResultados.add(new JLabel("Interés:", SwingConstants.CENTER));
        JTextField interesText = new JTextField();
        interesText.setFont(new Font("Serif", Font.BOLD, 10));
        panelResultados.add(interesText);

        panelResultados.add(new JLabel("Monto:", SwingConstants.CENTER));
        JTextField montoText = new JTextField();
        montoText.setFont(new Font("Serif", Font.BOLD, 10));
        panelResultados.add(montoText);
        
        panelResultados.setBorder(BorderFactory.createLineBorder(Color.pink, 10));


        panelPrincipal.add(panelResultados, BorderLayout.SOUTH);
		

		return panelPrincipal;
		
		
	}
	
	public void manager(String target) {
		
		this.getContentPane().removeAll();

		if(target.equals("registro")) {
			getContentPane().add(this.registro());

		}
		if(target.equals("login")) {
			getContentPane().add(this.login());
			
		}
		
		if(target.equals("recuperar")) {
			getContentPane().add(this.recuperar());
			
		}
		if(target.equals("alta")) {
			getContentPane().add(this.alta());
			
		}
		

		if(target.equals("baja")) {
			getContentPane().add(this.baja());
			
		}
		
		if(target.equals("tablas")) {
			getContentPane().add(this.tablas());
			
		}
		
		
		if(target.equals("como_crear")) {
			getContentPane().add(this.como_crear());
			
		}
		
		if(target.equals("como_acceder")) {
			getContentPane().add(this.como_acceder());
			
		}
		
		
		if(target.equals("olvide_contra")) {
			getContentPane().add(this.olvide_contra());
			
		}
		
		this.repaint();
		this.revalidate();
	}

	public JPanel calcLayout() {
		
	        JTextField pantalla = new JTextField("");
	        pantalla.setBackground(Color.WHITE);
	        pantalla.setForeground(Color.BLACK);
	        pantalla.setHorizontalAlignment(JTextField.CENTER);
	        
	        JPanel panelCalculadora = new JPanel();
	        panelCalculadora.setLayout(new BorderLayout());
	        panelCalculadora.add(pantalla, BorderLayout.NORTH);

	        JPanel panelBotones = new JPanel();
	        panelBotones.setLayout(new GridLayout(4, 4));

	        JButton boton7 = new JButton("7");
	        JButton boton8 = new JButton("8");
	        JButton boton9 = new JButton("9");
	        JButton botonDividir = new JButton("/");

	        JButton boton4 = new JButton("4");
	        JButton boton5 = new JButton("5");
	        JButton boton6 = new JButton("6");
	        JButton botonMultiplicar = new JButton("*");

	        JButton boton1 = new JButton("1");
	        JButton boton2 = new JButton("2");
	        JButton boton3 = new JButton("3");
	        JButton botonRestar = new JButton("-");

	        JButton boton0 = new JButton("0");
	        JButton botonPunto = new JButton(".");
	        JButton botonIgual = new JButton("=");
	        JButton botonSumar = new JButton("+");

	        panelBotones.add(boton7);
	        panelBotones.add(boton8);
	        panelBotones.add(boton9);
	        panelBotones.add(botonDividir);

	        panelBotones.add(boton4);
	        panelBotones.add(boton5);
	        panelBotones.add(boton6);
	        panelBotones.add(botonMultiplicar);

	        panelBotones.add(boton1);
	        panelBotones.add(boton2);
	        panelBotones.add(boton3);
	        panelBotones.add(botonRestar);

	        panelBotones.add(boton0);
	        panelBotones.add(botonPunto);
	        panelBotones.add(botonIgual);
	        panelBotones.add(botonSumar);

	        panelCalculadora.add(panelBotones, BorderLayout.CENTER);

	        return panelCalculadora;
	        
	    }
		
	public JPanel login() {
			
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(400, 700); 
		login.setOpaque(true);
		login.setBackground(Color.BLACK);
		login.setVisible(true);
		login.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(220, 50);
		etiqueta1.setLocation(366, 29);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setFont(fuenteLoginTitle);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); 
		
		login.add(etiqueta1); 
		
		
		JLabel etiqueta2 = new JLabel("Correo ");
		etiqueta2.setBounds(341, 140, 80, 30);
		etiqueta2.setForeground(Color.WHITE);
		etiqueta2.setFont(fuenteLoginSub);
		
		login.add(etiqueta2);
		
		JTextField email = new JTextField();
		email.setBounds(341, 181, 250, 30); 
		// x ,y width height
		email.setBackground(Color.WHITE);
		email.setOpaque(true);
		email.setFont(fuenteEtiquetas);
		login.add(email);
		
		JLabel etiqueta3 = new JLabel("Contraseña");
		etiqueta3.setBounds(341, 222, 120, 30); 
		etiqueta3.setForeground(Color.WHITE);
		etiqueta3.setFont(fuenteLoginSub);
		login.add(etiqueta3);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(341, 263, 250, 30); 
		pass.setBackground(Color.WHITE);
		pass.setOpaque(true);
		pass.setFont(fuenteEtiquetas);
		login.add(pass);
		
		JCheckBox recuerdame = new JCheckBox("Recuerdame");
		recuerdame.setBounds(140, 2140, 250, 30); 
		recuerdame.setOpaque(false);
		recuerdame.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recuerdame);
		
		JButton access = new JButton("Acceder");
		access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passText = new String(pass.getPassword());

				if(email.getText().equals("")) {
					email.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					email.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					
				}if(passText.equals("")) {
					pass.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					pass.setBorder(BorderFactory.createLineBorder(Color.green, 3));

				}
				if(email.getText().equals("") && passText.equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresa los datos deseados", "Error", JOptionPane.ERROR_MESSAGE);

				}else {
					if(email.getText().equals("yonatan@gmail.com") && passText.equals("hola123")) {
						JOptionPane.showMessageDialog(null, "¡Bienvenido!");
					}else {
						JOptionPane.showMessageDialog(null, "¡Datos Incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				

			}
		});
		access.setBounds(390, 341, 171, 55); 
		access.setBackground(Color.WHITE);
		access.setOpaque(true);
		access.setFont(fuenteEtiquetas);
		access.setHorizontalAlignment(JButton.CENTER); // alinea las cosas al centro
		
		access.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	access.setBackground(Color.BLUE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	access.setBackground(UIManager.getColor("control"));
		    }
		});
		
		JLabel registerText = new JLabel("¿No tienes una cuenta? Registrate");
		registerText.setSize(220, 50);
		registerText.setLocation(366, 474);
		registerText.setForeground(Color.WHITE);
		registerText.setFont(fuenteLoginSmaller);
		registerText.setHorizontalAlignment(JLabel.CENTER); 
		login.add(registerText);
		
		JButton register = new JButton("Registrate");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager("registro");
			}
		});
		
		register.setBounds(404, 535, 140, 30); 
		register.setBackground(Color.WHITE);
		register.setOpaque(true);
		register.setFont(fuenteLoginSub);
		register.setHorizontalAlignment(JButton.CENTER); 
		login.add(register);
		
		register.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        register.setBackground(Color.BLUE);
		        
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) { 
		        register.setBackground(UIManager.getColor("control"));
		    }
		});


		login.add(access);
		
		
		login.revalidate();
		
		return login;
		
	}

	public JPanel registro() {
		
		JPanel registro = new JPanel();
		registro.setLocation(1000, 0);
		registro.setSize(500, 500); 
		registro.setOpaque(true);
		registro.setBackground(Color.LIGHT_GRAY);
		registro.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(220, 70);
		etiqueta1.setLocation(342, 11);
		//etiqueta1.setBackground(Color.black);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(false); // para backgrounds
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		registro.add(etiqueta1); // agrega la etiqueta1 al panel login
		
		
		JLabel etiqueta2 = new JLabel("NOMBRE DE USUARIO: ");
		etiqueta2.setBounds(264, 78, 410, 30); // junta size y location en uno solo
		// x y, w h
		etiqueta2.setBackground(Color.yellow);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(fuenteEtiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		
		registro.add(etiqueta2);
		
		JTextField user = new JTextField();
		user.setBounds(264, 109, 410, 30); // junta size y location en uno solo
		// x ,y width height
		user.setBackground(Color.WHITE);
		user.setOpaque(true);
		user.setFont(fuenteEtiquetas);
		registro.add(user);
		
		JLabel etiqueta3 = new JLabel("BIO ");
		etiqueta3.setBounds(410, 149, 120, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(fuenteEtiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.CENTER);
		
		registro.add(etiqueta3);
		
		JTextField bio = new JTextField();
		bio.setBounds(264, 183, 410, 90); // junta size y location en uno solo
		// x ,y width height
		bio.setBackground(Color.WHITE);
		bio.setOpaque(true);
		bio.setFont(fuenteEtiquetas);
		registro.add(bio);
		
		Border border = new LineBorder(Color.RED, 2, true);
		//bio.setBorder(border);
		
		JLabel preferencias = new JLabel("PREFERENCIAS");
		preferencias.setBounds(370, 288, 220, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		preferencias.setOpaque(false);
		preferencias.setFont(fuenteEtiquetas);
		preferencias.setHorizontalAlignment(JLabel.CENTER);
		registro.add(preferencias);
		
		JCheckBox pref1 = new JCheckBox("Dulce");
		pref1.setBounds(328, 325, 80, 30); // junta size y location en uno solo
		pref1.setOpaque(false);
		pref1.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref1);
		
		JCheckBox pref2 = new JCheckBox("Salado");
		pref2.setBounds(431, 325, 80, 30); // junta size y location en uno solo
		pref2.setOpaque(false);
		pref2.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref2);
		
		JCheckBox pref3 = new JCheckBox("Saludable");
		pref3.setBounds(533, 325, 100, 30); // junta size y location en uno solo
		pref3.setOpaque(false);
		pref3.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		registro.add(pref3);
		//pref3.setBorderPainted(true);
		pref3.setBorder(border);
		
		JLabel term = new JLabel("TÉRMINOS ");
		term.setBounds(130, 3140, 250, 30); // junta size y location en uno solo
		// x y, w h
		term.setBackground(Color.yellow);
		term.setOpaque(true);
		term.setFont(fuenteEtiquetas);
		term.setHorizontalAlignment(JLabel.CENTER);
		registro.add(term);
		
		JRadioButton terminos1 = new JRadioButton("Acepto los terminos");
		terminos1.setLocation(315, 358);
		terminos1.setSize(180, 40);
		terminos1.setOpaque(false);
		registro.add(terminos1);
		
		JRadioButton terminos2 = new JRadioButton("No acepto los terminos");
		terminos2.setLocation(503, 358);
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
		preferenciass.setLocation(264, 405);
		preferenciass.setSize(410, 40);
		registro.add(preferenciass);
		
		
		
		
		JButton crear = new JButton("Crear Cuenta");
		crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getText().equals("")) {
					user.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					user.setBorder(BorderFactory.createLineBorder(Color.green, 3));

				}
				if(bio.getText().equals("")) {
					bio.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					bio.setBorder(BorderFactory.createLineBorder(Color.green, 3));

				}
				if(!terminos1.isSelected() && !terminos2.isSelected()) {
					terminos1.setForeground(Color.red);
				}else {
					terminos1.setForeground(Color.green);

				}
			}
		});
		crear.setBounds(264, 476, 410, 40); 
		crear.setBackground(Color.WHITE);
		crear.setOpaque(true);
		crear.setFont(fuenteEtiquetas);
		etiqueta1.setHorizontalAlignment(JButton.CENTER); // alinea las cosas al centro
		registro.add(crear);
		
		JButton btnNewButton = new JButton("Registrate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager("login");
			}
		});
		btnNewButton.setBounds(264, 552, 410, 40);
		btnNewButton.setFont(fuenteEtiquetas);
		registro.add(btnNewButton);

	
		
		registro.revalidate();
		
		return registro;
		
	}

	public JPanel recuperar() {
		
		JPanel recuperar = new JPanel();
		
		recuperar.setBackground(Color.orange);
		recuperar.setLayout(null);
		JLabel lblNewLabel = new JLabel("¿Olvidaste tu cuenta?");
		lblNewLabel.setBounds(420, 161, 215, 24);
		lblNewLabel.setFont(fuenteLoginSub);
		recuperar.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Ingresa tu correo:");
		lblNewLabel_6.setFont(fuenteLoginSub);
		lblNewLabel_6.setBounds(409, 214, 243, 24);
		recuperar.add(lblNewLabel_6);
		
		JTextField correoRecuperar = new JTextField();
		correoRecuperar.setBounds(409, 249, 227, 35);
		recuperar.add(correoRecuperar);
		
		JTextArea txtRecuperar = new JTextArea();
		txtRecuperar.setLineWrap(true);
		txtRecuperar.setText("Al presionar Recordar Usuario se le mandará un correo con sus datos");
		txtRecuperar.setFont(fuenteLoginSmaller);
		txtRecuperar.setOpaque(false);
		txtRecuperar.setBounds(352, 363, 364, 35);
		recuperar.add(txtRecuperar);
		
		JButton btnNewButton_1 = new JButton("Recordar Usuario");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(correoRecuperar.getText().equals("")) {
					correoRecuperar.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					JOptionPane.showMessageDialog(null, "Ingresa algun correo", "Error", JOptionPane.ERROR_MESSAGE);

				}else {
					correoRecuperar.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					JOptionPane.showMessageDialog(null, "Credenciales reenviadas al correo");

				}

			}
		});
		btnNewButton_1.setBounds(409, 305, 227, 47);
		recuperar.add(btnNewButton_1);
		btnNewButton_1.setFont(fuenteLoginSub);
		
		
		return recuperar;

		
	}
	
	public JPanel alta() {
		
		JPanel alta = new JPanel();
		alta.setLayout(null);
		alta.setBackground(new Color(102, 205, 170));
		JLabel lblNewLabel_1 = new JLabel("Alta de Usuarios");
		lblNewLabel_1.setBounds(434, 92, 150, 14);
		lblNewLabel_1.setFont(fuenteEtiquetas);
		alta.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(347, 131, 335, 317);
		alta.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Ingresa el Correo");
		lblNewLabel_7.setBounds(79, 37, 127, 14);
		panel.add(lblNewLabel_7);
		
		JTextField correoField = new JTextField();
		correoField.setBounds(79, 62, 178, 20);
		panel.add(correoField);
		
		JLabel lblNewLabel_8 = new JLabel("Ingresa la Contraseña");
		lblNewLabel_8.setBounds(79, 93, 178, 14);
		panel.add(lblNewLabel_8);
		
		JPasswordField contraField = new JPasswordField();
		contraField.setBounds(79, 118, 178, 20);
		panel.add(contraField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"La Paz", "Los Cabos", "Mulege", "Tijuana"}));
		comboBox.setBounds(79, 260, 178, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_9 = new JLabel("Ingresa tu Nombre");
		lblNewLabel_9.setBounds(79, 149, 114, 14);
		panel.add(lblNewLabel_9);
		
		JTextField nombreField = new JTextField();
		nombreField.setBounds(79, 174, 180, 20);
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Ingresa tu Edad");
		lblNewLabel_10.setBounds(79, 217, 103, 14);
		panel.add(lblNewLabel_10);
		
		JTextField edadField = new JTextField();
		edadField.setBounds(210, 214, 47, 20);
		panel.add(edadField);
		
		JButton btnNewButton_2 = new JButton("Agregar Usuario");
		btnNewButton_2.addActionListener(new ActionListener() {
			String passText = new String(contraField.getPassword());

			public void actionPerformed(ActionEvent e) {
				if(correoField.getText().equals("") && passText.equals("") && nombreField.getText().equals("") && edadField.getText().equals("")) {
					correoField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					nombreField.setBorder(BorderFactory.createLineBorder(Color.red, 3)); 
					edadField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					JOptionPane.showMessageDialog(null,  "Llena los campos que se piden", "Error", JOptionPane.ERROR_MESSAGE);
					
				}else {
					correoField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					contraField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					nombreField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					edadField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					JOptionPane.showMessageDialog(null,  "Usuario Agregado Correctamente");

				}
			}
		});
		btnNewButton_2.setBounds(458, 480, 141, 54);
		alta.add(btnNewButton_2);
		
		
		return alta;
		
	}
	
	public JPanel baja() {
		
		JPanel baja = new JPanel();
		baja.setLayout(null);
		baja.setBackground(new Color(160, 82, 45));
		JLabel lblNewLabel_2 = new JLabel("Baja de Usuarios");
		lblNewLabel_2.setBounds(396, 69, 194, 24);
		lblNewLabel_2.setFont(fuenteLoginSub);
		baja.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("Ingresa el correo");
		lblNewLabel_11.setFont(fuenteLoginSub);
		lblNewLabel_11.setBounds(388, 146, 218, 24);
		baja.add(lblNewLabel_11);
		
		JTextField bajaField = new JTextField();
		bajaField.setBounds(388, 181, 202, 20);
		baja.add(bajaField);
		
		JButton btnNewButton_3 = new JButton("Dar de Baja");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bajaField.getText().equals("")) {
					bajaField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					JOptionPane.showMessageDialog(null,  "Ingresa un correo", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
				if(bajaField.getText().equals("yonatan123@gmail")) {
					bajaField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					JOptionPane.showMessageDialog(null,  "Usuario Eliminado Correctamente");
				}else {
					bajaField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					JOptionPane.showMessageDialog(null,  "El Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
				}

			}
		});
		btnNewButton_3.setFont(fuenteLoginSub);
		btnNewButton_3.setBounds(409, 235, 169, 41);
		baja.add(btnNewButton_3);
		
		
		return baja;
		
	}
	
	public JPanel como_crear() {
		
		JPanel como_crear = new JPanel();
		como_crear.setLayout(null);
		como_crear.setBackground(new Color(0, 153, 102));
		JLabel lblNewLabel_3 = new JLabel("¿Como crear un usuario?");
		lblNewLabel_3.setFont(fuenteEtiquetas);
		lblNewLabel_3.setBounds(387, 33, 248, 34);
		como_crear.add(lblNewLabel_3);
		
		JLabel lblNewLabel_12 = new JLabel("1- En el menú superior, selecciona la opción Alta:");
		lblNewLabel_12.setBounds(10, 106, 426, 24);
		lblNewLabel_12.setFont(fuenteEtiquetas);
		como_crear.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/crear1.png")));
		lblNewLabel_13.setBounds(99, 141, 192, 151);
		como_crear.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("2- Llena todos los campos y presiona Agregar Usuario:");
		lblNewLabel_14.setBounds(490, 101, 470, 34);
		lblNewLabel_14.setFont(fuenteEtiquetas);
		como_crear.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/crear2.png")));
		lblNewLabel_15.setBounds(500, 141, 426, 467);
		como_crear.add(lblNewLabel_15);
		
		
		return como_crear;
		
	}
	
	public JPanel como_acceder() {
		
		JPanel como_acceder = new JPanel();
		como_acceder.setBackground(new Color(0, 102, 204));
		como_acceder.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("¿Como acceder al sistema?");
		lblNewLabel_4.setBounds(342, 11, 312, 14);
		lblNewLabel_4.setFont(fuenteEtiquetas);
		como_acceder.add(lblNewLabel_4);
		
		JLabel lblNewLabel_16 = new JLabel("Ingresa con tus credenciales de Usuario o Registrate si no tienes cuenta");
		lblNewLabel_16.setBounds(37, 49, 385, 14);
		lblNewLabel_16.setFont(fuenteLoginSmaller);
		como_acceder.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/acceder1.png")));
		lblNewLabel_17.setBounds(10, 74, 397, 547);
		como_acceder.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/acceder2.png")));
		lblNewLabel_18.setBounds(445, 47, 517, 574);
		como_acceder.add(lblNewLabel_18);
		
		
		return como_acceder;
		
	}
	
	public JPanel olvide_contra() {
		
		JPanel olvide_contra = new JPanel();
		olvide_contra.setBackground(new Color(102, 153, 255));
		olvide_contra.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("¿Qué pasa si olvidé mi contraseña?");
		lblNewLabel_5.setBounds(330, 34, 325, 48);
		lblNewLabel_5.setFont(fuenteEtiquetas);
		olvide_contra.add(lblNewLabel_5);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/olvide1.png")));
		lblNewLabel_20.setBounds(128, 195, 248, 191);
		olvide_contra.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("2- Ingresa un correo, y recibirás tus credenciales");
		lblNewLabel_21.setBounds(489, 135, 415, 28);
		lblNewLabel_21.setFont(fuenteEtiquetas);
		olvide_contra.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/olvide2.png")));
		lblNewLabel_22.setBounds(471, 174, 415, 266);
		olvide_contra.add(lblNewLabel_22);
		
		JTextArea txtrDesdeEl = new JTextArea();
		txtrDesdeEl.setOpaque(false);
		txtrDesdeEl.setWrapStyleWord(true);
		txtrDesdeEl.setFont(fuenteEtiquetas);
		txtrDesdeEl.setLineWrap(true);
		txtrDesdeEl.setText("1- Desde el menú superior, presiona en Recuperación de Cuenta");
		txtrDesdeEl.setBounds(84, 135, 316, 83);
		olvide_contra.add(txtrDesdeEl);
		
		return olvide_contra;
		
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
		borrarTodo.setBounds(42, 140, 140, 50);
		borrarTodo.setBackground(Color.ORANGE);
		borrarTodo.setOpaque(true);
		borrarTodo.setFont(fuenteEtiquetas);
		calculadora.add(borrarTodo);
		
		JButton botonVacio1 = new JButton();
		botonVacio1.setBounds(120, 140, 140, 50);
		botonVacio1.setBackground(Color.GRAY);
		botonVacio1.setOpaque(true);
		botonVacio1.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio1);
		
		JButton botonVacio2 = new JButton();
		botonVacio2.setBounds(200, 140, 140, 50);
		botonVacio2.setBackground(Color.GRAY);
		botonVacio2.setOpaque(true);
		botonVacio2.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio2);
		
		JButton botonVacio3 = new JButton();
		botonVacio3.setBounds(278, 140, 140, 50);
		botonVacio3.setBackground(Color.GRAY);
		botonVacio3.setOpaque(true);
		botonVacio3.setFont(fuenteEtiquetas);
		calculadora.add(botonVacio3);
		
		JButton boton7 = new JButton("7"); // 7
		boton7.setBounds(42, 127, 140, 50);
		boton7.setBackground(Color.GRAY);
		boton7.setOpaque(true);
		boton7.setFont(fuenteEtiquetas);
		calculadora.add(boton7);
		
		JButton boton8 = new JButton("8"); // 8
		boton8.setBounds(120, 127, 140, 50);
		boton8.setBackground(Color.GRAY);
		boton8.setOpaque(true);
		boton8.setFont(fuenteEtiquetas);
		calculadora.add(boton8);
		
		JButton boton9 = new JButton("9"); // 9
		boton9.setBounds(200, 127, 140, 50);
		boton9.setBackground(Color.GRAY);
		boton9.setOpaque(true);
		boton9.setFont(fuenteEtiquetas);
		calculadora.add(boton9);
		
		JButton botonSlash = new JButton("/"); // /
		botonSlash.setBounds(278, 127, 140, 50);
		botonSlash.setBackground(Color.ORANGE);
		botonSlash.setOpaque(true);
		botonSlash.setFont(fuenteEtiquetas);
		calculadora.add(botonSlash);
		
		JButton boton4 = new JButton("4"); // 4
		boton4.setBounds(42, 192, 140, 50);
		boton4.setBackground(Color.GRAY);
		boton4.setOpaque(true);
		boton4.setFont(fuenteEtiquetas);
		calculadora.add(boton4);
		
		JButton boton5 = new JButton("5"); // 5
		boton5.setBounds(120, 192, 140, 50);
		boton5.setBackground(Color.GRAY);
		boton5.setOpaque(true);
		boton5.setFont(fuenteEtiquetas);
		calculadora.add(boton5);
		
		JButton boton6 = new JButton("6"); // 6
		boton6.setBounds(200, 192, 140, 50);
		boton6.setBackground(Color.GRAY);
		boton6.setOpaque(true);
		boton6.setFont(fuenteEtiquetas);
		calculadora.add(boton6);
		
		JButton botonMult = new JButton("*"); // *
		botonMult.setBounds(278, 192, 140, 50);
		botonMult.setBackground(Color.ORANGE);
		botonMult.setOpaque(true);
		botonMult.setFont(fuenteEtiquetas);
		calculadora.add(botonMult);
		
		JButton boton1 = new JButton("1"); // 1
		boton1.setBounds(42, 256, 140, 50);
		boton1.setBackground(Color.GRAY);
		boton1.setOpaque(true);
		boton1.setFont(fuenteEtiquetas);
		calculadora.add(boton1);
		
		JButton boton2 = new JButton("2"); // 2
		boton2.setBounds(120, 256, 140, 50);
		boton2.setBackground(Color.GRAY);
		boton2.setOpaque(true);
		boton2.setFont(fuenteEtiquetas);
		calculadora.add(boton2);
		
		JButton boton3 = new JButton("3"); // 3
		boton3.setBounds(200, 256, 140, 50);
		boton3.setBackground(Color.GRAY);
		boton3.setOpaque(true);
		boton3.setFont(fuenteEtiquetas);
		calculadora.add(boton3);
		
		JButton botonMenos = new JButton("-"); // -
		botonMenos.setBounds(278, 256, 140, 50);
		botonMenos.setBackground(Color.ORANGE);
		botonMenos.setOpaque(true);
		botonMenos.setFont(fuenteEtiquetas);
		calculadora.add(botonMenos);
		
		JButton boton0 = new JButton("0"); // 0
		boton0.setBounds(42, 320, 140, 50);
		boton0.setBackground(Color.GRAY);
		boton0.setOpaque(true);
		boton0.setFont(fuenteEtiquetas);
		calculadora.add(boton0);
		
		JButton botonDot = new JButton("."); // .
		botonDot.setBounds(120, 320, 140, 50);
		botonDot.setBackground(Color.GRAY);
		botonDot.setOpaque(true);
		botonDot.setFont(fuenteEtiquetas);
		calculadora.add(botonDot);
		
		JButton botonIgual = new JButton("="); // =
		botonIgual.setBounds(200, 320, 140, 50);
		botonIgual.setBackground(Color.ORANGE);
		botonIgual.setOpaque(true);
		botonIgual.setFont(fuenteEtiquetas);
		calculadora.add(botonIgual);
		
		JButton botonMas = new JButton("+"); // +
		botonMas.setBounds(278, 320, 140, 50);
		botonMas.setBackground(Color.ORANGE);
		botonMas.setOpaque(true);
		botonMas.setFont(fuenteEtiquetas);
		calculadora.add(botonMas);
		
		
		
		
		
		
		
		return calculadora;
	}
	
	public JPanel tablas() {
		JPanel tablas = new JPanel();
		
		tablas.setLocation(0, 0);
		tablas.setSize(900, 750); 
		tablas.setOpaque(true);
		tablas.setBackground(Color.gray);
		tablas.setVisible(true);
		tablas.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("USUARIOS");
		etiqueta1.setSize(220, 60);
		etiqueta1.setLocation(340, 10);
		etiqueta1.setBackground(Color.BLACK);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(true);
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		tablas.add(etiqueta1);
		
		JTextArea usuarios = new JTextArea("     \n         Total de Usuarios: \n                    100");
		usuarios.setBounds(100, 100, 250, 80);
		usuarios.setBackground(Color.BLACK);
		usuarios.setForeground(Color.WHITE);
		usuarios.setOpaque(true);
		usuarios.setFont(fuenteEtiquetas);
		//usuarios.setHorizontalAlignment(JTextArea.CENTER_ALIGNMENT);
		tablas.add(usuarios);

		JButton exportar = new JButton("Exportar"); 
		exportar.setBounds(600, 160, 100, 30); 
		exportar.setOpaque(false);
		exportar.setBorderPainted(false);
		exportar.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		tablas.add(exportar);
		
		JButton añadir = new JButton("Añadir");
		añadir.setBounds(730, 160, 100, 30); 
		añadir.setOpaque(false);
		añadir.setBorderPainted(false);
		añadir.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		tablas.add(añadir);
		
        
        Object data[][]  = { {"1", "Yonatan", "yona@alasldasld", 12, "La Paz"}, 
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"},
        		{"2", "Yonatan", "yona@alasldasld", 12, "La Paz"}
        	
        		
        };
		
        String columnNames[] = {"ID",
            	"Nombre",
            	"Correo Electronico",
            	"Edad",
            	"Estado"
            };
        
        JTable newTable = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(newTable);
        
        sp.setBounds(100, 250, 700, 400);

        tablas.add(sp);

      
		
		return tablas;
		
		
		
	}

	public JPanel examen2() {
		
		JPanel examen = new JPanel();
		examen.setBounds(0, 0, 667, 638);
		examen.setBackground(Color.WHITE);
		examen.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 667, 86);
		panel.setBackground(Color.decode("#006699"));
		examen.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("Factura en Java - NetBeans - ArrayList y POO");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setBounds(28, 23, 369, 21);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_23 = new JLabel("[Sin Base de Datos]");
		lblNewLabel_23.setForeground(Color.WHITE);
		lblNewLabel_23.setBounds(28, 61, 144, 14);
		panel.add(lblNewLabel_23);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 97, 619, 119);
		examen.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_24 = new JLabel("Documento:");
		lblNewLabel_24.setBounds(20, 27, 81, 14);
		panel_1.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Dirección: ");
		lblNewLabel_25.setBounds(20, 72, 81, 14);
		panel_1.add(lblNewLabel_25);
		
		textField_5 = new JTextField();
		textField_5.setBounds(111, 24, 144, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(111, 69, 144, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_26 = new JLabel("Nombres:");
		lblNewLabel_26.setBounds(296, 27, 62, 14);
		panel_1.add(lblNewLabel_26);
		
		textField_7 = new JTextField();
		textField_7.setBounds(377, 27, 157, 20);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_27 = new JLabel("Teléfono:");
		lblNewLabel_27.setBounds(296, 72, 62, 14);
		panel_1.add(lblNewLabel_27);
		
		textField_8 = new JTextField();
		textField_8.setBounds(377, 69, 157, 20);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Datos de Factora", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(21, 216, 619, 78);
		examen.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_28 = new JLabel("No. Factura:");
		lblNewLabel_28.setBounds(10, 24, 101, 14);
		panel_2.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("1");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_29.setBounds(83, 24, 46, 14);
		panel_2.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Fecha:");
		lblNewLabel_30.setBounds(295, 24, 46, 14);
		panel_2.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("2021/50/21");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_31.setBounds(361, 24, 79, 14);
		panel_2.add(lblNewLabel_31);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(21, 296, 619, 41);
		examen.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Ver Listado de Productos");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setOpaque(false); 
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/lista.png")));
		btnNewButton_4.setBounds(22, 11, 181, 23);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Agregar"); 
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/agregar.png")));
		btnNewButton_5.setBounds(412, 11, 98, 23);
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorder(null);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Eliminar");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setIcon(new ImageIcon(Ventana.class.getResource("/Aplication/eliminar.png")));
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setBorder(null);
		btnNewButton_6.setBounds(520, 11, 89, 23);
		panel_3.add(btnNewButton_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 348, 619, 92);
		examen.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Agua", "2", "500", "1000.0"},
				{"Cereal", "5", "1000", "5000.0"},
				{"Leche", "2", "300", "600.0"},
			},
			new String[] {
				"Producto", "Cantidad", "Valor", "Sub Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_35 = new JLabel("SubTotal:");
		lblNewLabel_35.setBounds(38, 451, 61, 14);
		examen.add(lblNewLabel_35);
		
		JLabel lblNewLabel_32 = new JLabel("% Descuento:");
		lblNewLabel_32.setBounds(21, 491, 78, 14);
		examen.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("IVA 19%:");
		lblNewLabel_33.setBounds(36, 528, 63, 14);
		examen.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Total Factura:");
		lblNewLabel_34.setBounds(21, 569, 78, 14);
		examen.add(lblNewLabel_34);
		
		textField_9 = new JTextField();
		textField_9.setBounds(109, 488, 54, 20);
		examen.add(textField_9);
		textField_9.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(179, 488, 29, 23);
		examen.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_36 = new JLabel("Valor descontado:");
		lblNewLabel_36.setBounds(230, 491, 107, 14);
		examen.add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("330.0");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_37.setBounds(347, 491, 46, 14);
		examen.add(lblNewLabel_37);
		
		JLabel lblNewLabel_38 = new JLabel("6600.0");
		lblNewLabel_38.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_38.setBounds(109, 451, 46, 14);
		examen.add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("7524.0");
		lblNewLabel_39.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_39.setBounds(109, 569, 46, 14);
		examen.add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("1254.0");
		lblNewLabel_40.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_40.setBounds(109, 528, 46, 14);
		examen.add(lblNewLabel_40);
		
		JButton btnNewButton_7 = new JButton("Finalizar Factura");
		btnNewButton_7.setBounds(413, 604, 129, 23);
		examen.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Limpiar");
		btnNewButton_8.setBounds(551, 604, 89, 23);
		examen.add(btnNewButton_8);
		
		
		return examen;
		
	}

	
	public JPanel listenerBotones() {
		
		JPanel botones = new JPanel();
		botones.setBackground(Color.green);
		
        JButton btnNewButton_9 = new JButton("Click me!!!!");
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JButton randomBtn = new JButton("random");
        		int r = (int) (Math.random() * 250);
        		int g = (int) (Math.random() * 250);
        		int b = (int) (Math.random() * 250);

        		randomBtn.setBackground(new Color(r,g,b));
        		
                int x = (int) (Math.random() * 400); 
                int y = (int) (Math.random() * 400); 
   
                int width = (int) (Math.random() * 200); 
                int height = (int) (Math.random() * 200); 
                
                randomBtn.setLocation(x, y);
                randomBtn.setSize(width, height);
                botones.add(randomBtn); 

                botones.repaint();
        		
        	}
        });
        btnNewButton_9.setBounds(284, 455, 150, 30);
        getContentPane().add(btnNewButton_9);
	
	
	return botones;
	
}
}


