package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import models.User;

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
    }
}
