package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;
import models.ProductModel;

public class ProductView {

	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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

		JButton add = new JButton("añadir producto");
		add.setBounds(655, 50, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventana.dispose();
				ProductController pc = new ProductController();
				pc.add();
			}
			
		});
		panel.add(add);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);

		int y = 90;

		for (Object product1 : data) {

			JSONObject product = (JSONObject) product1; 

			JLabel lblNewLabel2 = new JLabel((String) product.get("title"));
			lblNewLabel2.setForeground(new Color(0, 0, 0)); 
			lblNewLabel2.setBounds(50, y, 100, 26);
			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel2);
			
			JLabel lblNewLabel3 = new JLabel((String) product.get("description"));
			lblNewLabel3.setForeground(new Color(0, 0, 0)); 
			lblNewLabel3.setBounds(150, y, 100, 26);
			lblNewLabel3.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel3);
			
			JLabel lblNewLabel4 = new JLabel((String) product.get("category"));
			lblNewLabel4.setForeground(new Color(0, 0, 0)); 
			lblNewLabel4.setBounds(250, y, 100, 26);
			lblNewLabel4.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel4);
			
			JLabel lblNewLabel5 = new JLabel((String) product.get("brand"));
			lblNewLabel5.setForeground(new Color(0, 0, 0)); 
			lblNewLabel5.setBounds(350, y, 100, 26);
			lblNewLabel5.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel5);
			
			//y+=35;

			JButton remove = new JButton("Eliminar");
			remove.setName((Long) product.get("id")+"");

			remove.setBounds(500, y, 100, 26);
			remove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) { 

					((JButton) e.getSource()).getName();

					System.out.println("Hola: "+((JButton) e.getSource()).getName());

					ProductModel pm = new ProductModel();
					pm.remove();
					
					ventana.dispose();
					
					ProductController pc = new ProductController();
					pc.products();
				}

			});
			
			


			panel.add(remove);

			y+=35;
			
		}
	}



	

	public void add()
	{
		
		JFrame ventana = new JFrame();
		
		ventana.setBounds(100, 100, 920, 534);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JLabel nameTag = new JLabel("Nombre del producto");
		nameTag.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameTag.setBounds(271, 105, 179, 40);
		panel.add(nameTag);
		
		JTextField nameInput = new JTextField();
		nameInput.setBounds(460, 109, 200, 40);
		panel.add(nameInput);
		
		
		JButton add = new JButton("Añadir producto");
		add.setBounds(490, 331, 200, 40);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = nameInput.getText();
				
				
				
			}});
		
		panel.add(add); 
		
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(354, 158, 106, 30);
		panel.add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(460, 160, 200, 35);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(371, 199, 79, 40);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(388, 250, 62, 30);
		panel.add(lblNewLabel_3);
		
		textField_9 = new JTextField();
		textField_9.setBounds(460, 206, 200, 40);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(460, 259, 200, 40);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Añadir Producto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(354, 39, 223, 40);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String name = nameInput.getText();
				String desc = textField_8.getText();
				String cate = textField_9.getText();
				String brandd = textField_10.getText();
				
				ProductModel pm = new ProductModel();
				
				pm.addProduct(name, cate, brandd, desc); 


				
				ventana.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}});
	
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(271, 331, 192, 40);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				
				ProductController pc = new ProductController();
				pc.products();
				
			}
			
		});
		panel.add(btnNewButton_2);
		
		
		
	}
	
	private static void parseTestData(JSONObject product)
    {

		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);

	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);

	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
	    String brand = (String) product.get("brand"); 
	    System.out.println("Brand: " + brand); 

    }
}
/*


public class ProductView {

    public ProductView() {
    }

    public void products(JSONArray data) {
        String[] columnNames = {"ID", "Title", "Price", "Stock"};
        Object[][] tableData = new Object[data.size()][4];

        for (int i = 0; i < data.size(); i++) {
            JSONObject product = (JSONObject) data.get(i);
            tableData[i][0] = product.get("id");
            tableData[i][1] = product.get("title");
            tableData[i][2] = product.get("price");
            tableData[i][3] = product.get("stock");
        }

        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());

        JTable table = new JTable(tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panelTabla.add(scrollPane, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Actualizar");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se actualizaron los datos de la tabla");
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(refreshButton);
        panelTabla.add(panelBoton, BorderLayout.SOUTH);

        JFrame frameTabla = new JFrame("Agregar");
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabla.setSize(600, 400);
        frameTabla.setLocationRelativeTo(null);
        frameTabla.getContentPane().add(panelTabla);
        frameTabla.setVisible(true);
    }
}
*/