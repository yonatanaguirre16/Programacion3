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
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

public class Paint implements MouseListener, MouseMotionListener {

	private JFrame frame;
	int tool = 1;
	Color color = Color.black;
	private ArrayList<Point> puntos = new ArrayList<Point>();
	private JLabel lblNewLabel;
	private boolean isSolido = false;

	int tamañoPincel=1;
 	
 	List<List<Point>> listaDePuntos = new ArrayList<>(); 
 	
 	ArrayList<point> puntos2 = new ArrayList<point>();
	List<List<point>> listaDePuntos2 = new ArrayList<>();
 	int puntoX, puntoY;
 	
 	ArrayList<figura> figuras = new ArrayList<figura>();
	
 	int tipoFig;
 	Graphics2D g2;
 	Point puntoInicio;
 	Point puntoFinal;
 	boolean segundoClick = false;
	private PaintPanel panel_2;

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
				listaDePuntos.clear();
				listaDePuntos2.clear();
				figuras.clear();
				puntos2.clear();
				
		        puntos.clear();
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
		
		JButton btnNewButton_7 = new JButton("Borrador");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = 5;
				color = Color.white;
			}
		});
		panel_1.add(btnNewButton_7);
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
				color = Color.white;
				
			}
		});
		botonBlanco.setBackground(new Color(255, 255, 255));
		panel_1.add(botonBlanco);
		
		JButton botonNegro = new JButton("");
		botonNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.black;

			}
		});
		botonNegro.setBackground(new Color(0, 0, 0));
		panel_1.add(botonNegro);
		
		JButton botonGris = new JButton("");
		botonGris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.gray;

			}
		});
		botonGris.setBackground(new Color(192, 192, 192));
		panel_1.add(botonGris);
		
		JButton botonAzul = new JButton("");
		botonAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.blue;

			}
		});
		botonAzul.setBackground(new Color(0, 0, 255));
		panel_1.add(botonAzul);
		
		JButton botonRed = new JButton("");
		botonRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.red;

			}
		});
		botonRed.setBackground(new Color(255, 0, 0));
		panel_1.add(botonRed);
		
		JButton botonVerde = new JButton("");
		botonVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = Color.green;

			}
		});
		botonVerde.setBackground(new Color(0, 255, 0));
		panel_1.add(botonVerde);
		
		JButton btnNewButton_3 = new JButton("Brocha");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = 1;
				color = Color.black;

			}
		});
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cuadrado");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = 2;
				isSolido=false;
				color = Color.black;

			}
		});
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Circulo");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool=3;
				isSolido=false;

				color = Color.black;

			}
		});
		
		JButton btnNewButton_8 = new JButton("Cuadrado Solido");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSolido = true;
			}
		});
		panel_1.add(btnNewButton_8);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Linea");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tool = 4;
				color = Color.black;

			}
		});
		
		JButton btnNewButton_9 = new JButton("Circulo Solido");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSolido=true;
			}
		});
		panel_1.add(btnNewButton_9);
		panel_1.add(btnNewButton_6);
		
		panel_2 = new PaintPanel();
		
		panel_2.addMouseListener(this);
		panel_2.addMouseMotionListener(this);
		
		panel.add(panel_2, BorderLayout.CENTER);
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(tool == 2) {
			tipoFig=2;
			figuras.add(new figura(e.getX(), e.getY(), 50*tamañoPincel, 50*tamañoPincel, color, tipoFig, tamañoPincel, isSolido));
			panel_2.repaint();
		}
		if(tool == 3) {
			tipoFig=3;
			figuras.add(new figura(e.getX(), e.getY(), 50*tamañoPincel, 50*tamañoPincel, color, tipoFig, tamañoPincel, isSolido));
			panel_2.repaint();
		}if(tool == 4) {
			
			tipoFig=4;
			
			if (!segundoClick) {
	            puntoInicio = e.getPoint();
	            segundoClick = true;
	        }else {
				
	            puntoFinal = e.getPoint();
	            
	            figuras.add(new figura(puntoInicio.x, puntoInicio.y, puntoFinal.x, puntoFinal.y, color, tipoFig, tamañoPincel, isSolido));
	            panel_2.repaint();
	            
	            segundoClick = false;
	        }

		}if(tool == 5){
				tipoFig=5;
				figuras.add(new figura(e.getX(), e.getY(), 50, 50, Color.white, tipoFig, tamañoPincel, isSolido));	
				panel_2.repaint();
			
			
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		ArrayList<point> ArrList2 = new ArrayList<>(puntos2);
		listaDePuntos2.add(ArrList2);
		
 		listaDePuntos2.add(ArrList2);
 		
 		puntos2.clear();
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		
	}

	@Override
	public void mouseExited(MouseEvent e) { 
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(tool == 1) {
			puntoX = e.getX();
			puntoY = e.getY();
			puntos2.add(new point(puntoX, puntoY, color, tamañoPincel));
			panel_2.repaint(); 
		}
		
		if(tool == 5) {
			
			figuras.add(new figura(e.getX(), e.getY(), 50, 50, Color.white, tipoFig, tamañoPincel, isSolido));
			panel_2.repaint();
			

		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { 
		panel_2.repaint();
	}
	
	class PaintPanel extends JPanel{
		
		public PaintPanel(){
			this.setBackground(Color.white);
		}
		
	   public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	       
	       
 	       g2 = (Graphics2D) g; 
 	       
 	       if(puntos2.size()>1) {
 	    	   
 	    	   for (int i = 1; i < puntos2.size(); i++) {

 	    		   point p1 = puntos2.get(i-1);
 	    		   point p2 = puntos2.get(i);
 	    		   
 	    		   p1.nuevoTrazo(p1.getX(), p1.getY(), p2.getX(), p2.getY(), g2);
 	    	   }
 	    	   
 	       }
 	       
	       
 	       for (@SuppressWarnings("rawtypes")
 	       	Iterator iterator = listaDePuntos2.iterator(); iterator.hasNext();) {
 			@SuppressWarnings("unchecked")
			List<point> trazo = (List<point>) iterator.next();
 			
 			
 				if(trazo.size()>1) {
 		    	   
 		    	   for (int i = 1; i < trazo.size(); i++) {

 		    		   point p1 = trazo.get(i-1);
 	 	    		   point p2 = trazo.get(i);
 	 	    		   
 	 	    		   p1.nuevoTrazo(p1.getX(), p1.getY(), p2.getX(), p2.getY(), g2);
 		    	   }
 		    	   
 		       }
 			
 	       }
 	       
  	      for (figura f : figuras) {
  	    	 
 	    	  g.setColor(f.color);
 	    	  ((Graphics2D) g).setStroke(new BasicStroke(f.grosor));
 	    	  
 	    	  switch(f.tipo) {
 	    	  
 	    	  case 2:
 	    		  if(f.isSolido) {
 	    			  g.fillRect(f.x, f.y, f.ancho, f.alto);
 	    		  }
 	    		 g.drawRect(f.x, f.y, f.ancho, f.alto);
 	    		 break;
 	    		 
 	    	  case 3:
 	    		  if(f.isSolido) {
 	    			  g.fillOval(f.x, f.y, f.ancho, f.alto);
 	    		  }
 	    		 g.drawOval(f.x, f.y, f.ancho, f.alto);
 	    		 break;
 	    		 
 	    	  case 4:
 	    		  g.drawLine(f.x, f.y, f.ancho, f.alto);
 	    		  break;
 	    	  case 5:
 	    		  g.fillRect(f.x, f.y, f.ancho, f.alto);

 	    		  break;
 	    		  
 	    	  }
 	      }
	       



       
	
	   }
	}
	
		class point{
				
				public int y;
				public int x;
				private Color color;
				private int grosor;
				
				public point(int x, int y, Color color, int grosor) {
					this.x = x;
					this.y = y;
					this.color = color;
					this.grosor = grosor;
				}
		
				public int getY() {
					return y;
				}
				
				public void setY(int y) {
					this.y = y;
				}
		
				public int getX() {
					return x;
				}
		
				public void setX(int x) {
					this.x = x;
				}
		
				public Color getColor() {
					return this.color;
				}
		
				public void setColor(Color color) {
					this.color = color;
				}
		
				public int getGrosor() {
					return grosor;
				}
		
				public void setGrosor(int grosor) {
					this.grosor = grosor;
				}
		
				public void nuevoTrazo(int p1X, int p1Y, int p2X, int p2Y, Graphics2D g2) {
					g2.setColor(color);
					g2.setStroke(new BasicStroke(grosor));
					g2.drawLine(p1X, p1Y, p2X,p2Y);
				}
				
			}
			
			class figura{
				
				public int x, y, ancho, alto, tipo,grosor;
				public boolean isSolido=false;
				Color color;
				
				public figura(int x, int y, int ancho, int alto, Color color, int tipo, int grosor, boolean isSolido) {
				
					this.x=x;
					this.y=y;
					this.ancho=ancho;
					this.alto=alto;
					this.color=color;
					this.tipo=tipo;
					this.grosor = grosor;
					this.isSolido=isSolido;
					 	   
		    	   for (int i = 1; i < figuras.size(); i++) {
		    		   
		    		   figura p1 = figuras.get(i-1);
		    		   
		    		   g2.setColor(color);
		    		   g2.setStroke(new BasicStroke(grosor));

		    		  switch(tipo) {
		 	    	  case 2:
		 	    		  if(!isSolido) {
		 	    			  g2.fillRect(p1.x, p1.y, 50, 50);
		 	    		  }
		 	    		 g2.drawRect(p1.x, p1.y, 50, 50);
		 	    		 break;
		 	    		 
		 	    	  case 3:
		 	    		  if(!isSolido) {
		 	    			  g2.fillOval(p1.x, p1.y, 50, 50);
		 	    		  }
		 	    		 g2.drawOval(p1.x, p1.y, 50, 50);
		 	    		 break;
		 	    		 
		 	    	  case 4:
		 	    		  g2.drawLine(p1.x, p1.y, ancho, alto);
		 	    		 break;
		 	    	  case 5:
		 	    		  g2.fillRect(p1.x, p1.y, ancho, alto);
		 	    		  break;
		    	      }
		    		  
		    	  }	 	       
			 	       
				}	
				
			}

	
}
		
	




