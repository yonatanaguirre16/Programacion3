package Aplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class PrimeraVentana {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraVentana window = new PrimeraVentana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrimeraVentana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Registro de Usuarios");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 64));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel datos_generales = new JPanel();
		datos_generales.setBackground(new Color(0, 255, 255));
		datos_generales.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(datos_generales);
		datos_generales.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(72, 24, 46, 14);
		datos_generales.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(123, 21, 86, 20);
		datos_generales.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido Paterno:");
		lblNewLabel_2.setBounds(32, 59, 86, 14);
		datos_generales.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 56, 86, 20);
		datos_generales.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido Materno:");
		lblNewLabel_3.setBounds(32, 90, 86, 14);
		datos_generales.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 87, 86, 20);
		datos_generales.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_4.setBounds(10, 120, 108, 14);
		datos_generales.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setText("17/05/1998");
		textField_3.setBounds(123, 117, 86, 20);
		datos_generales.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/Aplication/option.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(218, 106, 46, 33);
		datos_generales.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(48, 145, 46, 14);
		datos_generales.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Masculino");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(100, 141, 109, 23);
		rdbtnNewRadioButton.setOpaque(false);		
		datos_generales.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Femenino");
		rdbtnNewRadioButton_1.setBounds(100, 167, 109, 23);
		rdbtnNewRadioButton_1.setOpaque(false);
		datos_generales.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Nacionalidad:");
		lblNewLabel_6.setBounds(30, 191, 64, 14);
		datos_generales.add(lblNewLabel_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Perú", "Mexicano", "Americano", "Chileno"}));
		comboBox.setBounds(110, 187, 99, 22);
		datos_generales.add(comboBox);
		
		JPanel perfil_usuario = new JPanel();
		perfil_usuario.setBackground(new Color(255, 128, 255));
		perfil_usuario.setBorder(new TitledBorder(null, "Perfil de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(perfil_usuario);
		perfil_usuario.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/Aplication/usuario.png")));
		lblNewLabel_7.setBounds(44, 11, 245, 152);
		perfil_usuario.add(lblNewLabel_7);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar Foto de Perfil");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(109, 160, 129, 23);
		chckbxNewCheckBox.setOpaque(false);
		perfil_usuario.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Mostrar Fecha de Nacimiento");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setBounds(107, 186, 165, 23);
		chckbxNewCheckBox_1.setOpaque(false);
		perfil_usuario.add(chckbxNewCheckBox_1);
		
		JPanel datos_opcionales = new JPanel();
		datos_opcionales.setBackground(new Color(255, 128, 255));
		datos_opcionales.setBorder(new TitledBorder(null, "Datos Opcionales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(datos_opcionales);
		datos_opcionales.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Descripcion");
		lblNewLabel_8.setBounds(21, 46, 76, 14);
		datos_opcionales.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Preferencias");
		lblNewLabel_9.setBounds(148, 50, 95, 14);
		datos_opcionales.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 71, 100, 53);
		datos_opcionales.add(scrollPane);
		
		JTextArea txtrHolaAmigosDe = new JTextArea();
		scrollPane.setViewportView(txtrHolaAmigosDe);
		txtrHolaAmigosDe.setLineWrap(true);
		txtrHolaAmigosDe.setWrapStyleWord(true);
		txtrHolaAmigosDe.setText("hola amigos de youtube gracias por compartir mis videos.");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(158, 75, 123, 53);
		datos_opcionales.add(scrollPane_1);
		
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Cantar", "Escuchar Musica", "Leer", "Deportes", "Otros"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		
		JPanel botones = new JPanel();
		botones.setBackground(new Color(0, 255, 255));
		panel_1.add(botones);
		botones.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/Aplication/save.png")));
		btnNewButton_2.setBounds(120, 94, 115, 23);
		botones.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/Aplication/home.png")));
		btnNewButton_3.setBounds(120, 150, 115, 23);
		botones.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PrimeraVentana.class.getResource("/Aplication/cancel2.png")));
		btnNewButton_1.setBounds(120, 42, 115, 23);
		botones.add(btnNewButton_1);
	}
}
