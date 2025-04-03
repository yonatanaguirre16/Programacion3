package Aplication;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Aplication.Paint.PaintPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class KeyboardJuego implements KeyListener{

	private JFrame frame;	
	public int x=200, y=200;
	private PaintPanel panel_2;
 	Graphics2D g2;

 	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyboardJuego window = new KeyboardJuego();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KeyboardJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Keyboard Game");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("/Aplication/sonicicon.png")));
		frame.setLocationRelativeTo(null);

		//frame.isResizable(false);
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("0:00");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel_1.add(btnNewButton);
		
		panel_2 = new PaintPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		frame.setFocusable(true);
		//panel_2.requestFocusInWindow();
		frame.addKeyListener(this);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode()); 

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		/*
		 * 87
         * 83
         * 65
		 * 68
		 */
		// BOUNDS X = 675, Y = 675 
		if(e.getKeyCode() == 87) { // ARRIBA
				y -= 4;
			

		}
		if(e.getKeyCode() == 83) { // ABAJO
				y += 4;
			
		}
		if(e.getKeyCode() == 65) { // iZQUIERDA
				x -= 4;
			
		}
		if(e.getKeyCode() == 68) { // DERECHA
				x += 4;				
			
		}
		frame.repaint();
		
}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	class PaintPanel extends JPanel{
		
		public PaintPanel(){
			this.setBackground(Color.black);
		}
		
	   public void paintComponent(Graphics g) {
	       super.paintComponent(g);
	      
 	       g2 = (Graphics2D) g;
 	       g2.setColor(Color.green);
 	       
 	       g2.fillRect(x, y, 50, 50);
 	       
	   }
	}



}
