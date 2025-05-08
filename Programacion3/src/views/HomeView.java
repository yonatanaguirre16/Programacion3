package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;
import models.ProductModel;

public class HomeView {
	
	ImageIcon iconnotif = new ImageIcon(getClass().getResource("/images/notificacion.png"));
	ImageIcon icondiag = new ImageIcon(getClass().getResource("/images/diagrama.png"));


	
	private JFrame frame;
	private JLabel lblHora;

	public HomeView(){
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); 
		frame.setTitle("Pagina Inicial");
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(324, 82, 226, 42);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 0, 812, 55);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton productsBtn = new JButton("Productos"); 
		productsBtn.setBounds(327, 21, 109, 23);
		productsBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	ProductModel model = new ProductModel();
		    	JSONArray data = model.get();

		    	ProductView productView = new ProductView();
		    	productView.products(data);


		    }
		});

		panel_1.add(productsBtn);

		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.setBounds(463, 21, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Prueba de boton usuario!");

			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registros");
		btnNewButton_1.setBounds(578, 21, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Prueba de boton Registros!");

			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Configuracion");
		btnNewButton_2.setBounds(685, 21, 117, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Prueba de boton Configuracion!");

			}
		});
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(255, 140, 0), 5));
		panel_2.setBounds(44, 147, 359, 157);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuarios Actuales:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(77, 11, 214, 51);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("4");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_5.setBounds(148, 72, 62, 27);
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(60, 179, 113), 5));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(423, 147, 359, 157);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(iconnotif);
		lblNewLabel_6.setBounds(112, 21, 159, 114);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(189, 183, 107), 5));
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(44, 325, 359, 157);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Hora Actual");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(102, 11, 151, 52);
		panel_4.add(lblNewLabel_3);
		
		lblHora = new JLabel();
		lblHora.setBounds(120, 70, 120, 25);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblHora);

		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(224, 255, 255), 5));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(423, 329, 359, 153);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(icondiag);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(83, 23, 180, 95);
		panel_5.add(lblNewLabel_7);
		
		
		Timer reloj = new Timer(1000, new ActionListener() { 
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        LocalTime horaActual = LocalTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		        lblHora.setText(horaActual.format(formatter));
		    }
		});
		reloj.start(); 
	}
	

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public void dispose() {
        frame.dispose();
    }
}
