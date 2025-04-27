package views;
import models.AuthModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import models.AuthModel;

public class AuthView {
	
	Font fuenteGrande = new Font("Times New Roman", Font.BOLD, 35);
	Font fuenteEtiquetas = new Font("Times New Roman", Font.BOLD, 20);
	Font fuenteLoginTitle = new Font("Dejavu Sans Mono", Font.ITALIC, 30);
	Font fuenteLoginSub = new Font("Dejavu Sans Mono", Font.CENTER_BASELINE, 20);
	Font fuenteLoginSmaller = new Font("Dejavu Sans Mono", Font.CENTER_BASELINE, 10);
	Font fuenteBoton = new Font("Tahoma", Font.CENTER_BASELINE, 0);

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private AuthModel functions;
	private JTextField fieldNombre;
	private JTextField fieldApellidos;
	private JTextField fieldEmpresa;
	private JComboBox comboBox;
	private JTextField fieldCargo;
	private JTextField fieldUser;
	private JPasswordField fieldPass;
	private JPasswordField fieldPass2;
	private JTextField fieldCorreo;
	private JCheckBox checkBoxTerminos;
	private JButton enviarRegistro;
	private int flagCont = 0;
	private String nombre, apellido, empresa, cargo, user, correo;
	private JButton returnBtn;
	
	
	public AuthView() {
		functions = new AuthModel();
	}
	
	public void login() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Login");
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
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
		
		textField = new JTextField();
		textField.setBounds(341, 181, 250, 30); 
		textField.setBackground(Color.WHITE);
		textField.setOpaque(true);
		textField.setFont(fuenteEtiquetas);
		login.add(textField);
		
		JLabel etiqueta3 = new JLabel("Contraseña");
		etiqueta3.setBounds(341, 222, 120, 30); 
		etiqueta3.setForeground(Color.WHITE);
		etiqueta3.setFont(fuenteLoginSub);
		login.add(etiqueta3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 263, 250, 30); 
		passwordField.setBackground(Color.WHITE);
		passwordField.setOpaque(true);
		passwordField.setFont(fuenteEtiquetas);
		login.add(passwordField);
		
		JCheckBox recuerdame = new JCheckBox("Recuerdame");
		recuerdame.setBounds(140, 2140, 250, 30); 
		recuerdame.setOpaque(false);
		recuerdame.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		login.add(recuerdame);
		
		JButton access = new JButton("Acceder");
		access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());	
				boolean flag1 = false, flag2 = false;
				
				String username = textField.getText();
	
				
				if(username.equals("")) {
					textField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					textField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flag1=true;
					
				}if(passText.equals("")) {
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
				}else {
					passwordField.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flag2=true;
				}
				
				if(username.equals("") && passText.equals("")) {
					JOptionPane.showMessageDialog(null, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(flag1 && flag2) {
						boolean user_auth = functions.access(username, passText);
						
						if(user_auth) {
							JOptionPane.showMessageDialog(null, "¡Bienvenido!");
							manager("home");
						}else {
							textField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
							passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);
						}
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
		registerText.setLocation(356, 394);
		registerText.setForeground(Color.WHITE);
		registerText.setFont(fuenteLoginSmaller);
		registerText.setHorizontalAlignment(JLabel.CENTER); 
		login.add(registerText);
		
		JButton register = new JButton("Registrate");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager("register");
			}
		});
		
		register.setBounds(400, 434, 140, 30); 
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
		frame.add(login);

		frame.repaint();
		login.repaint();
		login.revalidate();
	}

	public void home() {
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Home");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel home = new JPanel();
		home.setLocation(0, 0);
		home.setSize(400, 700); 
		home.setOpaque(true);
		home.setBackground(Color.BLACK);
		home.setVisible(true);
		home.setLayout(null);
		
		frame.add(home);

		frame.repaint();
		home.repaint();
		home.revalidate();
		
		JLabel textoGrande = new JLabel("This is a home test!");
		textoGrande.setBounds(350, 200, 300, 100);
		textoGrande.setForeground(Color.white);
		textoGrande.setFont(fuenteGrande);
		
		home.add(textoGrande);
	}
	
	public void register() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Register");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 0, 582, 485);
		panel_1.setBorder(new TitledBorder(null, "Ingresa los siguientes datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 16, 243, 328);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nombres");
		lblNewLabel_2.setBounds(0, 2, 295, 36);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setBounds(0, 38, 295, 36);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Empresa/Institucion");
		lblNewLabel_1.setBounds(0, 74, 295, 36);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Ámbito de la empresa");
		lblNewLabel_5.setBounds(0, 110, 295, 36);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cargo");
		lblNewLabel_6.setBounds(0, 146, 295, 36);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nombre de usuario");
		lblNewLabel_7.setBounds(0, 182, 295, 36);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Contraseña");
		lblNewLabel_8.setBounds(0, 218, 295, 36);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Repita la contraseña");
		lblNewLabel_9.setBounds(0, 254, 295, 36);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("Correo Electronico");
		lblNewLabel_4.setBounds(0, 290, 295, 36);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(263, 16, 309, 328);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		fieldNombre = new JTextField();
		fieldNombre.setBounds(20, 0, 240, 32);
		panel_4.add(fieldNombre);
		fieldNombre.setColumns(10);
		
		fieldApellidos = new JTextField();
		fieldApellidos.setBounds(20, 37, 240, 32);
		panel_4.add(fieldApellidos);
		fieldApellidos.setColumns(10);
		
		fieldEmpresa = new JTextField();
		fieldEmpresa.setBounds(20, 74, 240, 32);
		panel_4.add(fieldEmpresa);
		fieldEmpresa.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(20, 111, 240, 32);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tecnología", "Salud", "Educación", "Comercio", "Otro"}));
		panel_4.add(comboBox);
		
		fieldCargo = new JTextField();
		fieldCargo.setBounds(20, 148, 240, 32);
		panel_4.add(fieldCargo);
		fieldCargo.setColumns(10);
		
		fieldUser = new JTextField();
		fieldUser.setBounds(20, 185, 240, 32);
		panel_4.add(fieldUser);
		fieldUser.setColumns(10);
		
		fieldPass = new JPasswordField();
		fieldPass.setBounds(20, 222, 240, 32);
		panel_4.add(fieldPass);
		fieldPass.setColumns(10);
		
		fieldPass2 = new JPasswordField();
		fieldPass2.setBounds(20, 259, 240, 32);
		panel_4.add(fieldPass2);
		fieldPass2.setColumns(10);
		
		fieldCorreo = new JTextField();
		fieldCorreo.setBounds(20, 296, 240, 32);
		panel_4.add(fieldCorreo);
		fieldCorreo.setColumns(10);
		
		checkBoxTerminos = new JCheckBox("He leído y acepto los terminos del sistema");
		//checkBoxTerminos.setOpaque(false);
		checkBoxTerminos.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxTerminos.setBounds(140, 389, 286, 23);
		panel_1.add(checkBoxTerminos);
		
		enviarRegistro = new JButton("Enviar formulario");
		enviarRegistro.setBounds(225, 430, 133, 23);
		panel_1.add(enviarRegistro);
		enviarRegistro.setBackground(new Color(0, 153, 0));
		
		returnBtn = new JButton("Regresar");
		returnBtn.setBounds(10, 451, 89, 23);
		panel_1.add(returnBtn);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager("login");
			}
		});
		
		
		enviarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passText = new String(fieldPass.getPassword());	
				String passText2 = new String(fieldPass2.getPassword());	
				String sector = (String) comboBox.getSelectedItem();


	            if (fieldNombre.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { 
	            	nombre = fieldNombre.getText();
					fieldNombre.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
					fieldNombre.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if (fieldApellidos.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { 
	            	apellido = fieldApellidos.getText();
	            	fieldApellidos.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	fieldApellidos.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if (fieldCargo.getText().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) { 
	            	cargo = fieldCargo.getText();
	            	fieldCargo.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	fieldCargo.setBorder(BorderFactory.createLineBorder(Color.red, 3));

	            }
	            if(fieldEmpresa.getText().matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
	            	empresa = fieldEmpresa.getText();
	            	fieldEmpresa.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	fieldEmpresa.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if(fieldUser.getText().matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
	            	user = fieldUser.getText();
	            	fieldUser.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	fieldUser.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if(passText.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9])(?!.*\\s).+$")) {
	            	fieldPass.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	fieldPass.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if(passText2.equals(passText)) {
	            	//System.out.println("son iguales");
	            	fieldPass2.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;
	            }else{
	            	//System.out.println("son diferentes");
	            	fieldPass2.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if(fieldCorreo.getText().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
	            	correo = fieldCorreo.getText();
	            	//System.out.println("si es correo");
	            	fieldCorreo.setBorder(BorderFactory.createLineBorder(Color.green, 3));
					flagCont++;        
	            }else{
	            	//System.out.println("no es correo");
	            	fieldCorreo.setBorder(BorderFactory.createLineBorder(Color.red, 3));
	            }
	            if(flagCont >= 8) {
	            	if(checkBoxTerminos.isSelected()) {
	    	            String linea = String.join("|", nombre, apellido, empresa, sector, cargo, user, correo, passText);
	    	            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\files\\users.txt", true))) {
	    	                writer.write(linea);
	    	                writer.newLine(); 
	    	                JOptionPane.showMessageDialog(frame, "Usuario guardado correctamente.");
	    	                System.out.println(linea);
	    	            } catch (IOException ex) {
	    	                ex.printStackTrace();
	    	                JOptionPane.showMessageDialog(frame, "Error al guardar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
	    	            }
	            	}else{
	            		checkBoxTerminos.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		                JOptionPane.showMessageDialog(frame, "Acepta los terminos", "Error", JOptionPane.ERROR_MESSAGE);
	            	}
	            }else {
	                JOptionPane.showMessageDialog(frame, "Te falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
	            	
	            }

			}
			
			
		});
		
		
		frame.add(panel);
		panel.revalidate();
	}
	
	

	
	public void manager(String target) { 
		
		frame.dispose();
		
		if(target.equals("register")) {
			register();

		}
		if(target.equals("login")) {
			login();			
		}
		
		if(target.equals("home")) {
			home();
		}
		
		frame.repaint();
		frame.revalidate();
	}
}
