package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.UsersController;

import java.awt.*;
import java.util.ArrayList;
import models.User;
import models.UsersModel;

public class UsersView {

    public UsersView() {
    }

    public void usuarios(ArrayList<User> usuarios) {
    	
        JFrame ventana = new JFrame("Usuarios");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); 

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("Usuarios", SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono"};

        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (User user : usuarios) {
            Object[] fila = {
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPhone()
            };
            model.addRow(fila);
        }

        JTable tabla = new JTable(model);
        tabla.setRowHeight(24);

        JScrollPane scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane, BorderLayout.CENTER);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        
        JButton addNew = new JButton("Agregar");
        addNew.setBounds(400, 35, 150, 40);
        addNew.addActionListener(e ->{
        	
        	UsersController uc = new UsersController();
        	uc.add();
        	
        	ventana.dispose();
        	
        
        	
        });
        
        JPanel botonPanel = new JPanel();
        botonPanel.add(addNew);
        panel.add(botonPanel, BorderLayout.EAST);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
           
        
        
    }
    
    public void addUsers() {
        JFrame ventana = new JFrame("Agregar Usuarios");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); 

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("Agregar Usuarios", SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);
        
        JLabel nameLabel = new JLabel("Ingresa el nombre: ");
        nameLabel.setBounds(350, 50, 300, 30);
        JTextField nameInput = new JTextField();
        nameInput.setBounds(250, 100, 300, 30);
        ventana.add(nameLabel);
        ventana.add(nameInput);
        
        JLabel rolLabel = new JLabel("Ingresa el rol: ");
        rolLabel.setBounds(350, 150, 300, 30);
        JTextField rolInput = new JTextField();
        rolInput.setBounds(250, 200, 300, 30);
        ventana.add(rolLabel);
        ventana.add(rolInput);
        
        JLabel emailLabel = new JLabel("Ingresa el email: ");
        emailLabel.setBounds(350, 250, 300, 30);
        JTextField emailInput = new JTextField();
        emailInput.setBounds(250, 300, 300, 30);
        ventana.add(emailLabel);
        ventana.add(emailInput);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        
        JButton addNew = new JButton("Agregar nuevo");
        addNew.addActionListener(e ->{
        	
        	String name = nameInput.getText();
        	String rol = rolInput.getText();
        	String email = emailInput.getText();
        	
        	UsersModel um = new UsersModel();
        	
        	if(um.add(name, email, rol)) {
        		ventana.dispose();
        		
        		UsersController uc = new UsersController();
        		uc.usuarios();
        	}

        	
        	
        });
        
        JPanel botonPanel = new JPanel();
        botonPanel.add(addNew);
        panel.add(botonPanel, BorderLayout.SOUTH);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
                
        
    }
    
    
}
