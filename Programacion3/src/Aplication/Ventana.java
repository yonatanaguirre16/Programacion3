package Aplication;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	public Ventana(String title) {
		this.setTitle(title);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //termina el programa al cerrar
		this.setSize(500, 500); // Tamaño del frame
		this.setResizable(false); // decide si cambia de tamaño la ventana o no
		this.setLocationRelativeTo(null); // centra la ventana 
		
		JLabel etiqueta1 = new JLabel("Bienvenido");
		etiqueta1.setSize(100, 100);
		etiqueta1.setLocation(10, 50);
		etiqueta1.setBackground(Color.ORANGE);
		
		this.add(etiqueta1);
		
	}

}
