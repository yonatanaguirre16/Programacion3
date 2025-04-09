package Aplication;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Timer;


public class KeyboardJuego implements KeyListener {

    private JFrame frame;
    public int x = 200, y = 200;
    private PaintPanel panel_2;
    Graphics2D g2;
    public Player sombra;
    public Player player;
    private int segundos = 0;
    private int lastPressed = 0;
    private int minutos = 0;
    public int anchoFigura = 50, altoFigura = 50;
    Timer cronometro, cronometro2;

    private ArrayList<Player> obstaculos = new ArrayList<>();
	private JLabel timerLbl;

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

        player = new Player(200, 200, 50, 50, Color.green); 
        sombra = new Player(player.x, player.y, player.alto, player.ancho, Color.green); 
        obstaculos.add(new Player(150, 350, 100, 60, Color.orange)); 
        obstaculos.add(new Player(300, 100, 80, 80, Color.red)); 

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        timerLbl = new JLabel("0:00");
        timerLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(timerLbl);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Reiniciar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.x = 200;
                player.y = 200;
                sombra.x = player.x;
                sombra.y = player.y;
                lastPressed = 0;
                panel_2.repaint();
                resetTimer();
                frame.requestFocusInWindow(); // re-gana el focus al frame para volver a mover desde el teclado
            }
        });
        panel_1.add(btnNewButton);

        panel_2 = new PaintPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);

        frame.setFocusable(true);
        frame.addKeyListener(this);
        
	    cronometro = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            segundos++;
	            if (segundos == 60) {
	                segundos = 0;
	                minutos++;
	            }
	            actualizarTiempo();
	        }
	    });
	    
	    cronometro2 = new Timer(8, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//System.out.println("movimiento");
	        	update();
	        }
	    });
}
    

	private void resetTimer() {
	    minutos = 0;
	    segundos = 0;
	    actualizarTiempo();
	}
	
	private void actualizarTiempo() {
	    String tiempo = String.format("%d:%02d", minutos, segundos);
	    timerLbl.setText(tiempo);
	}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	
    	lastPressed = e.getKeyCode();
	    cronometro.start();
	    cronometro2.start();
	    
	    panel_2.repaint();
	    update();

       
    }
    
    public void update() {
    	 boolean movimiento = true;

         sombra.x = player.x;
         sombra.y = player.y;
         
         if (lastPressed == 87) { // ARRIBA
             if (player.y > 0) {
                 player.y -= 6;
             }
         }
         if (lastPressed == 83) { // ABAJO
             if (player.y + altoFigura < 562) {
                 player.y += 6;
             }
         }
         if (lastPressed == 65) { // IZQUIERDA
             if (player.x > 0) {
                 player.x -= 6;
             }
         }
         if (lastPressed == 68) { // DERECHA
             if (player.x + anchoFigura < 655) {
                 player.x += 6;
             }
         }
         
         for (Player pared : obstaculos) {
             if (player.colision(pared)) {
                 //System.out.println("colision");
                 movimiento = false;
                 break;
             }
         }

         if (movimiento) {
             sombra.x = player.x;
             sombra.y = player.y;
         } else {
             player.x = sombra.x;
             player.y = sombra.y;
         }

         panel_2.repaint();
    	
    }

    public void keyReleased(KeyEvent e) {
    }

    class Player {
        int x = 0, y = 0, alto = 0, ancho = 0;
        Color c;

        public Player(int x, int y, int alto, int ancho, Color c) {
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.c = c;
        }

        public Boolean colision(Player target) {
            if (this.x < target.x + target.ancho &&
                this.x + this.ancho > target.x &&
                this.y < target.y + target.alto &&
                this.y + this.alto > target.y) {
                return true;
            } else {
                return false;
            }
        }
    }

    class PaintPanel extends JPanel {
        public PaintPanel() {
            this.setBackground(Color.black);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2 = (Graphics2D) g; 

            g2.setColor(player.c);
            g2.fillRect(player.x, player.y, player.ancho, player.alto); // jugador

            for (Player pared : obstaculos) { // obstaculos actualmente pinta 2 porque son los que hay en el arraylist
                g2.setColor(pared.c);
                g2.fillRect(pared.x, pared.y, pared.ancho, pared.alto);
            }
        }
    }
}
