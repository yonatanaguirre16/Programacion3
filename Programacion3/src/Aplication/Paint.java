package Aplication;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Paint implements MouseListener, MouseMotionListener {

	private JFrame frame;
	private PaintPanel panel_2;
	private JLabel lblNewLabel;
    private Color colorActual = Color.BLACK; 

	private ArrayList<Point> puntos = new ArrayList<Point>();
	private List<Integer> listaDeGrosor = new ArrayList<>(); // lista para almacenar el tamaño del grosor del pincel  
    private List<Color> listaDeColores = new ArrayList<>();  // lista para almacenar cada color

	List<List<Point>> listaDePuntos = new ArrayList<>(); 

	
    public int tamañoPincel = 1; // grosor inicial del pincel

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
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
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("/Aplication/sonicicon.png")));
		frame.setTitle("canvas");
		frame.setBounds(100, 100, 839, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                puntos.clear();
                listaDePuntos.clear();
                listaDeGrosor.clear();
                listaDeColores.clear();

                panel_2.repaint();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tamañoPincel++;
				lblNewLabel.setText(String.valueOf(tamañoPincel)); 
			}
		});
		panel_1.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		                if (tamañoPincel > 1) {
		                	tamañoPincel--; 
		                    lblNewLabel.setText(String.valueOf(tamañoPincel)); 
		                }
		            }
		        });
		
		panel_1.add(btnNewButton_1);
		
		JButton botonBlanco = new JButton("");
		botonBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.white;
				
			}
		});
		botonBlanco.setBackground(new Color(255, 255, 255));
		panel_1.add(botonBlanco);
		
		JButton botonNegro = new JButton("");
		botonNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.black;

			}
		});
		botonNegro.setBackground(new Color(0, 0, 0));
		panel_1.add(botonNegro);
		
		JButton botonGris = new JButton("");
		botonGris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.gray;

			}
		});
		botonGris.setBackground(new Color(192, 192, 192));
		panel_1.add(botonGris);
		
		JButton botonAzul = new JButton("");
		botonAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.blue;

			}
		});
		botonAzul.setBackground(new Color(0, 0, 255));
		panel_1.add(botonAzul);
		
		JButton botonRed = new JButton("");
		botonRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.red;

			}
		});
		botonRed.setBackground(new Color(255, 0, 0));
		panel_1.add(botonRed);
		
		JButton botonVerde = new JButton("");
		botonVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorActual = Color.green;

			}
		});
		botonVerde.setBackground(new Color(0, 255, 0));
		panel_1.add(botonVerde);
		
		panel_2 = new PaintPanel();
		
		panel_2.addMouseListener(this);
		panel_2.addMouseMotionListener(this);
		
		panel.add(panel_2, BorderLayout.CENTER);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
        ArrayList<Point> ArrList2 = (ArrayList<Point>) puntos.clone();
        listaDePuntos.add(ArrList2);
        listaDeGrosor.add(tamañoPincel);  
        listaDeColores.add(colorActual); 

        puntos.clear();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		
	}

	@Override
	public void mouseExited(MouseEvent e) { 
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		panel_2.repaint();
		
		puntos.add(e.getPoint());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { 
		
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel()
		{
			this.setBackground(Color.white);
		}
		
	   public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       
	       Graphics2D g2 = (Graphics2D) g; 
	       g2.setColor(Color.black); 
	       
           for (int i = 0; i < listaDePuntos.size(); i++) {
               List<Point> trazo = listaDePuntos.get(i);
               int grosor = listaDeGrosor.get(i);  
               Color color = listaDeColores.get(i);  
               g2.setColor(color); 
               g2.setStroke(new BasicStroke(grosor));

               if (trazo.size() > 1) {
                   for (int j = 1; j < trazo.size(); j++) {
                       Point p1 = trazo.get(j - 1);
                       Point p2 = trazo.get(j);
                       g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                   }
               }
           }
           
           g2.setColor(colorActual); 
           g2.setStroke(new BasicStroke(tamañoPincel));
           if (puntos.size() > 1) {
               for (int i = 1; i < puntos.size(); i++) {
                   Point p1 = puntos.get(i - 1);
                   Point p2 = puntos.get(i);
                   g2.drawLine(p1.x, p1.y, p2.x, p2.y);
               }
           }
       }

		
	}
}