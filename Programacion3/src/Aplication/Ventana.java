package Aplication;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	
	// definir fuente para utilizar solo la palabra etiqueta al usar esta fuente
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
		login.setBackground(new Color(229, 114, 126));
		login.setVisible(true);
		login.setLayout(null);
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(160, 40);
		etiqueta1.setLocation(160, 10);
		etiqueta1.setBackground(Color.ORANGE);
		etiqueta1.setOpaque(true); // para backgrounds
		etiqueta1.setFont(fuenteEtiquetas);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER); // alinea las cosas al centro
		
		login.add(etiqueta1); // agrega la etiqueta1 al panel login
		

		
		login.revalidate();
		
		return login;
		
	}

}
