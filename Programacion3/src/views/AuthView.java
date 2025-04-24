package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
	
	
	public AuthView() {
		functions = new AuthModel();
	}
	
	public void login() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("Programacion3/src/images/sonicicon.png")));
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
						email.setBorder(BorderFactory.createLineBorder(Color.red, 3));
						pass.setBorder(BorderFactory.createLineBorder(Color.red, 3));
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
		registerText.setLocation(356, 394);
		registerText.setForeground(Color.WHITE);
		registerText.setFont(fuenteLoginSmaller);
		registerText.setHorizontalAlignment(JLabel.CENTER); 
		login.add(registerText);
		
		JButton register = new JButton("Registrate");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//manager("register");
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

	
	public void register() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("Programacion3/src/images/sonicicon.png")));
		frame.setTitle("Registro");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel register = new JPanel();
		register.setLocation(1000, 0);
		register.setSize(500, 500); 
		register.setOpaque(true);
		register.setBackground(Color.LIGHT_GRAY);
		register.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(220, 70);
		etiqueta1.setLocation(342, 11);
		//etiqueta1.setBackground(Color.black);
		etiqueta1.setForeground(Color.WHITE);
		etiqueta1.setOpaque(false); // para backgrounds
		etiqueta1.setFont(fuenteGrande);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		register.add(etiqueta1); // agrega la etiqueta1 al panel login
		
		
		JLabel etiqueta2 = new JLabel("NOMBRE DE USUARIO: ");
		etiqueta2.setBounds(264, 78, 410, 30); // junta size y location en uno solo
		// x y, w h
		etiqueta2.setBackground(Color.yellow);
		etiqueta2.setOpaque(true);
		etiqueta2.setFont(fuenteEtiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.CENTER);
		
		register.add(etiqueta2);
		
		JTextField user = new JTextField();
		user.setBounds(264, 109, 410, 30); // junta size y location en uno solo
		// x ,y width height
		user.setBackground(Color.WHITE);
		user.setOpaque(true);
		user.setFont(fuenteEtiquetas);
		register.add(user);
		
		JLabel etiqueta3 = new JLabel("BIO ");
		etiqueta3.setBounds(410, 149, 120, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(fuenteEtiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.CENTER);
		
		register.add(etiqueta3);
		
		JTextField bio = new JTextField();
		bio.setBounds(264, 183, 410, 90); // junta size y location en uno solo
		// x ,y width height
		bio.setBackground(Color.WHITE);
		bio.setOpaque(true);
		bio.setFont(fuenteEtiquetas);
		register.add(bio);
		
		Border border = new LineBorder(Color.RED, 2, true);
		//bio.setBorder(border);
		
		JLabel preferencias = new JLabel("PREFERENCIAS");
		preferencias.setBounds(370, 288, 220, 30); // junta size y location en uno solo
		//etiqueta3.setBackground(Color.WHITE);
		preferencias.setOpaque(false);
		preferencias.setFont(fuenteEtiquetas);
		preferencias.setHorizontalAlignment(JLabel.CENTER);
		register.add(preferencias);
		
		JCheckBox pref1 = new JCheckBox("Dulce");
		pref1.setBounds(328, 325, 80, 30); // junta size y location en uno solo
		pref1.setOpaque(false);
		pref1.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		register.add(pref1);
		
		JCheckBox pref2 = new JCheckBox("Salado");
		pref2.setBounds(431, 325, 80, 30); // junta size y location en uno solo
		pref2.setOpaque(false);
		pref2.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		register.add(pref2);
		
		JCheckBox pref3 = new JCheckBox("Saludable");
		pref3.setBounds(533, 325, 100, 30); // junta size y location en uno solo
		pref3.setOpaque(false);
		pref3.setFont(new Font("Times New Roman" , Font.BOLD, 15));
		register.add(pref3);
		//pref3.setBorderPainted(true);
		pref3.setBorder(border);
		
		JLabel term = new JLabel("TÉRMINOS ");
		term.setBounds(130, 3140, 250, 30); // junta size y location en uno solo
		// x y, w h
		term.setBackground(Color.yellow);
		term.setOpaque(true);
		term.setFont(fuenteEtiquetas);
		term.setHorizontalAlignment(JLabel.CENTER);
		register.add(term);
		
		JRadioButton terminos1 = new JRadioButton("Acepto los terminos");
		terminos1.setLocation(315, 358);
		terminos1.setSize(180, 40);
		terminos1.setOpaque(false);
		register.add(terminos1);
		
		JRadioButton terminos2 = new JRadioButton("No acepto los terminos");
		terminos2.setLocation(503, 358);
		terminos2.setSize(180, 40);
		terminos2.setOpaque(false);
		register.add(terminos2);
		
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
		register.add(preferenciass);
		
		
		
		
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
		register.add(crear);
		
		JButton btnNewButton = new JButton("Registrate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//manager("login");
			}
		});
		btnNewButton.setBounds(264, 552, 410, 40);
		btnNewButton.setFont(fuenteEtiquetas);
		register.add(btnNewButton);

	
		frame.add(register);
		register.revalidate();
	}
	
	
	public void manager(String target) { 
		
		frame.dispose();
		
		if(target.equals("register")) {
			register();

		}
		if(target.equals("login")) {
			login();			
		}
		
		frame.repaint();
		frame.revalidate();
	}
}
