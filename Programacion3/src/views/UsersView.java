package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controllers.UsersController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.User;
import models.UsersModel;
import views.ProductView.ButtonEditor;

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

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Editar", "Eliminar"};

        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (User user : usuarios) {
            Object[] fila = {
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPhone(),
                "Editar",
                "Eliminar"
            };
            model.addRow(fila);
        }

        JTable tabla = new JTable(model);
        
        tabla.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        tabla.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox(), usuarios, false));
        
        tabla.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        tabla.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox(), usuarios, true));

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
    
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
        	
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    
    class ButtonEditor extends DefaultCellEditor {

        private String label;
        private ArrayList<User> usuarios;
        private boolean esEliminar; 

        public ButtonEditor(JCheckBox checkBox, ArrayList<User> usuarios, boolean esEliminar) {
            super(checkBox);
            this.usuarios = usuarios;
            this.esEliminar = esEliminar;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            JButton boton = new JButton(label);
            
            if (esEliminar) { //eliminar
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int op = JOptionPane.showConfirmDialog(table, "¿Deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                        if (op == 0) {
                            User usuarioSeleccionado = usuarios.get(row);
                            UsersController uc = new UsersController();
                            uc.delete(usuarioSeleccionado.getId());

                        }
                    }
                });
            } else { //editar  
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        User usuarioSeleccionado = usuarios.get(row);
                        UsersView usersView = new UsersView();
                        usersView.updateUsers(usuarioSeleccionado); 
                    }
                });
            }
            return boton;
        }
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
    
    public void updateUsers(User user) {
    	JFrame ventana = new JFrame("Editar Usuarios");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); 

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel("Editar Usuarios", SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.NORTH);
        
        JLabel nameLabel = new JLabel("Ingresa el nuevo nombre: ");
        nameLabel.setBounds(350, 50, 300, 30);
        JTextField nameInput = new JTextField(user.getName()); 

        nameInput.setBounds(250, 100, 300, 30);
        ventana.add(nameLabel);
        ventana.add(nameInput);
        
        JLabel rolLabel = new JLabel("Ingresa el nuevo rol: ");
        rolLabel.setBounds(350, 150, 300, 30);
        JTextField rolInput = new JTextField(user.getRole()); 
        rolInput.setBounds(250, 200, 300, 30);
        ventana.add(rolLabel);
        ventana.add(rolInput);
        
        JLabel emailLabel = new JLabel("Ingresa el nuevo email: ");
        emailLabel.setBounds(350, 250, 300, 30);
        JTextField emailInput = new JTextField(user.getEmail()); 
        emailInput.setBounds(250, 300, 300, 30);
        ventana.add(emailLabel);
        ventana.add(emailInput);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        
        JButton updateUser = new JButton("Finalizar edicion");
        updateUser.addActionListener(e ->{
        	
        	String name = nameInput.getText();
        	String rol = rolInput.getText();
        	String email = emailInput.getText();
        	
        	UsersModel um = new UsersModel();
        	
        	user.setName(name);
        	user.setRole(rol);
        	user.setEmail(email);
        	
        	if(um.update(user)) {
        		ventana.dispose();
        		
        		UsersController uc = new UsersController();
        		uc.usuarios();
        	}

        	
        	
        });
        
        JPanel botonPanel = new JPanel();
        botonPanel.add(updateUser);
        panel.add(botonPanel, BorderLayout.SOUTH);

        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
                
    }
    
}
