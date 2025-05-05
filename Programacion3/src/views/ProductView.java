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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

        JFrame frameTabla = new JFrame("Lista de Productos");
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabla.setSize(600, 400);
        frameTabla.setLocationRelativeTo(null);
        frameTabla.getContentPane().add(panelTabla);
        frameTabla.setVisible(true);
    }
}
