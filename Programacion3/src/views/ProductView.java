package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
	    panel.setLayout(null);
	    ventana.getContentPane().add(panel, BorderLayout.CENTER);

	    JButton add = new JButton("añadir producto");
	    add.setBounds(655, 50, 200, 40);
	    add.addActionListener(e -> {
	        ventana.dispose();
	        ProductController pc = new ProductController();
	        pc.add();
	    });
	    panel.add(add);

	    JLabel lblNewLabel = new JLabel("Productos");
	    lblNewLabel.setForeground(new Color(0, 0, 0));
	    lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
	    lblNewLabel.setBounds(107, 35, 210, 26);
	    lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
	    panel.add(lblNewLabel);

	    String[] columnNames = {"Título", "Descripción", "Categoría", "Marca", "Acción"};
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

	    for (Object product1 : data) {
	        JSONObject product = (JSONObject) product1;
	        model.addRow(new Object[]{
	            product.get("title"),
	            product.get("description"),
	            product.get("category"),
	            product.get("brand"),
	            product.get("id") 
	        });
	    }

	    JTable tablaProductos = new JTable(model) {
	        public boolean isCellEditable(int row, int column) {
	            return column == 4; 
	        }
	    };

	    tablaProductos.setRowHeight(30);

	    tablaProductos.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
	    tablaProductos.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), data, ventana));

	    JScrollPane scrollPane = new JScrollPane(tablaProductos);
	    scrollPane.setBounds(50, 100, 800, 350);
	    panel.add(scrollPane);
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer { // clase para agregar un boton en tabla
	    public ButtonRenderer() {
	        setOpaque(true);
	        setText("Eliminar");
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	                                                   boolean hasFocus, int row, int column) {
	        return this;
	    }
	}

	class ButtonEditor extends DefaultCellEditor {
	    private JButton button;
	    private Long productId;
	    private boolean clicked;
	    private JFrame ventana;
	    private JSONArray data;

	    public ButtonEditor(JCheckBox checkBox, JSONArray data, JFrame ventana) {
	        super(checkBox);
	        this.ventana = ventana;
	        this.data = data;
	        button = new JButton("Eliminar");
	        button.addActionListener(e -> fireEditingStopped());
	    }

	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        productId = (Long) value;
	        clicked = true;
	        return button;
	    }

	    public Object getCellEditorValue() {
	        if (clicked) {
	            ProductModel pm = new ProductModel();
	            pm.remove(productId); 

	            ventana.dispose();
	            ProductController pc = new ProductController();
	            pc.products();
	        }
	        clicked = false;
	        return "Eliminar";
	    }

	    public boolean stopCellEditing() {
	        clicked = false;
	        return super.stopCellEditing();
	    }
	}

	public void add(){
		
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
	
}
