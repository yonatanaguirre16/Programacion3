package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;

public class ProductView {


	public ProductView() {
		
	}
	
	public void products(JSONArray data) {
		
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		int x = 70;
		
		for (Object product1 : data) {
			
			JSONObject product = (JSONObject) product1;
			
			JLabel lblNewLabel2 = new JLabel((String) product.get("title"));
			
			lblNewLabel2.setForeground(new Color(0, 0, 0));
			lblNewLabel2.setBounds(107, x, 210, 26);
			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel2);
			
 
			x+=35;
        }

			/*
           JSONObject producto = (JSONObject) product1;
            String titulo = (String) producto.get("title");
            String descripcion = (String) producto.get("description");
            String categoria = (String) producto.get("category");

            System.out.println("Título: " + titulo);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Categoría: " + categoria);
            System.out.println("---------------");
			
			;*/
			
		}
		
		//data.forEach( emp -> parseTestData( (JSONObject) emp ) );
		 
	
	
	private static void parseTestData(JSONObject product){
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}
