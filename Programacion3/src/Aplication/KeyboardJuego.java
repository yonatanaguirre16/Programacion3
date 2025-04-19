package Aplication;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Timer;


public class KeyboardJuego implements KeyListener {
	
    private final int TILE_SIZE = 28; 
    private Clip clip;

    private JFrame frame;
    private PaintPanel panel_2;
    Graphics2D g2;
    public Player sombra;
    public Player player;
    private int segundos = 0;
    private int lastPressed = 0;
    private int minutos = 0;
    public int anchoFigura = 49, altoFigura = 49;
    Timer cronometro, cronometro2;
    private int nivel;

    // 1 = pared, 2 = meta, 3 = inicio, 4 = victoria
    int[][] laberinto = {
    	    {1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    	    {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1},
    	    {1,0,1,0,1,1,0,1,1,1,1,1,0,1,0,1,0,0,0,0,0,0,1},
    	    {1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1,1,1,0,1},
    	    {1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,1,0,1},
    	    {1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
    	    {1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1},
    	    {1,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,0,1},
    	    {1,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,0,1,0,1,0,0,1},
    	    {1,0,0,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,1,1,0,1},
    	    {1,0,1,1,0,1,0,1,1,0,1,1,1,0,1,0,0,1,0,1,0,0,1},
    	    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1},
    	    {1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,1},
    	    {1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,1,0,1,1,0,1,0,1},
    	    {1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,1,1},
    	    {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1},
    	    {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1},
    	    {1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1},
    	    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,4,1},
    	    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1}
    	};
    
                                                                       
    int[][] laberinto2 = {
    	    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    	    {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    	    {1,0,1,0,1,1,0,0,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1},
    	    {1,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,1},
    	    {1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,0,0,0,0,1,0,3},
    	    {1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1},
    	    {1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,0,1,0,0,0,1},
    	    {1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,0,1,1,1,1,1},
    	    {1,1,1,0,1,1,0,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0,1},
    	    {1,0,0,0,0,1,0,1,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1},
    	    {1,0,1,1,0,1,0,1,1,0,1,1,1,0,1,0,0,0,1,1,1,0,1},
    	    {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1},
    	    {1,0,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1},
    	    {1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,1,1,0,1},
    	    {1,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,1},
    	    {2,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1},
    	    {1,4,1,1,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,0,0,1},
    	    {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,0,1},
    	    {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    	    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    	};

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
        reproducirMusica(); 
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 659, 674);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Laberinto");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("/Aplication/sonicicon.png")));
        frame.setLocationRelativeTo(null);


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
            	if(nivel==1) { // reinicia la posicion del jugador si es el tablero 1 o 2
                    player.x = 34;
                    player.y = 35;
                    sombra.x = player.x;
                    sombra.y = player.y;
                    lastPressed = 0;
                    panel_2.repaint();
                    resetTimer();
                    frame.requestFocusInWindow(); 
            	}else if(nivel ==2) {
                    player.x = 593;
                    player.y = 122;
                    sombra.x = player.x;
                    sombra.y = player.y;
                    lastPressed = 0;
                    panel_2.repaint();
                    resetTimer();
                    frame.requestFocusInWindow(); // re-gana el focus al frame para volver a mover desde el teclado
            	}

            }
        });
        
        JButton btnNewButton_2 = new JButton("Nivel 1");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		nivel=1;
        		cargarNivel(nivel);

        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        panel_1.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Nivel 2");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		nivel=2;
        		cargarNivel(nivel);
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        panel_1.add(btnNewButton_1);
        panel_1.add(btnNewButton);

        panel_2 = new PaintPanel();
        frame.getContentPane().add(panel_2, BorderLayout.CENTER);

        frame.setFocusable(true);
        frame.addKeyListener(this);
        
        
        Object[] opciones = {"Nivel 1", "Nivel 2"};

        int seleccion = JOptionPane.showOptionDialog(frame,"Elige el nivel:", "Maze Puzzle", 
        		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0] 
        );
        if (seleccion == 0) {
            nivel = 1;
            cargarNivel(nivel);
        } else if (seleccion == 1) {
            nivel = 2;
            cargarNivel(nivel);
        }
        
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
	    
	cronometro2 = new Timer(20, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//System.out.println("movimiento");
	        	update(); 
	        }
	    });
}

    private void cargarNivel(int nivel) {
        obstaculos.clear();
        
        int[][] lab = (nivel == 1) ? laberinto : laberinto2;
        
        if(nivel==1) {
        	player = new Player(1 * TILE_SIZE + 5, 1 * TILE_SIZE , TILE_SIZE - 10, TILE_SIZE - 10, Color.green, "pacifico.png");
        	sombra = new Player(player.x, player.y, player.ancho, player.alto, Color.green, null); 
        }else if(nivel==2){
        	player = new Player(1 * TILE_SIZE + 565, 1 * TILE_SIZE+85 , TILE_SIZE - 10, TILE_SIZE - 10, Color.green, "pacifico.png");
        	sombra = new Player(player.x, player.y, player.ancho, player.alto, Color.green, null); 
        }
        
        for (int fila = 0; fila < lab.length; fila++) {
            for (int col = 0; col < lab[0].length; col++) {
                if (lab[fila][col] == 1) { 
                    obstaculos.add(new Player(col * TILE_SIZE, fila * TILE_SIZE, TILE_SIZE, TILE_SIZE, null, "tape.png"));
                }
                if (lab[fila][col] == 3) { 
                    obstaculos.add(new Player(col * TILE_SIZE, fila * TILE_SIZE, TILE_SIZE, TILE_SIZE, null, "modelo.jpg"));
                }
                if (lab[fila][col] == 2) { 
                    obstaculos.add(new Player(col * TILE_SIZE - 1, fila * TILE_SIZE - 1, TILE_SIZE, TILE_SIZE, null, "home.png"));
                }
            }
        }

        panel_2.repaint();
        resetTimer();
        frame.requestFocusInWindow();
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
    public void keyTyped(KeyEvent e) {}

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
         
         verificarVictoria();
         panel_2.repaint();
    	
    }

    private void verificarVictoria() {

        int[][] lab = (nivel == 1) ? laberinto : laberinto2;

        int xInicio = player.x / TILE_SIZE;
        int yInicio = player.y / TILE_SIZE;
        int xFin = (player.x + player.ancho - 1) / TILE_SIZE; 
        int yFin = (player.y + player.alto - 1) / TILE_SIZE;

        for (int y = yInicio; y <= yFin; y++) {
            for (int x = xInicio; x <= xFin; x++) {
                if (y >= 0 && y < lab.length && x >= 0 && x < lab[0].length) {
                    if (lab[y][x] == 4) { // gana si toca 4 en la matriz 
                        cronometro.stop();
                        cronometro2.stop();
                        JOptionPane.showMessageDialog(frame, "¡A beber! Te tardaste: " + timerLbl.getText());
                        return;
                    }
                }
            }
        }

    }
    
    private void reproducirMusica() {
        try {
            File audioFile = new File(getClass().getResource("flor.wav").toURI());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                        clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    public void keyReleased(KeyEvent e) {
    }

    class Player {
    	BufferedImage imagen = null;
        int x = 0, y = 0, alto = 0, ancho = 0;
        Color c;
        

        public Player(int x, int y, int ancho, int alto, Color c, String rutaImagen){
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
            this.c = c;
            
            if (rutaImagen != null) {
                try {
                    imagen = ImageIO.read(getClass().getResource(rutaImagen));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        public Player(int x, int y, int ancho, int alto, Color c) {
            this(x, y, ancho, alto, c, null); 
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
            if (player.imagen != null) {
                g2.drawImage(player.imagen, player.x, player.y, player.ancho, player.alto, null);
            } else {
                g2.setColor(player.c);
                g2.fillRect(player.x, player.y, player.ancho, player.alto);
            }

            for (Player pared : obstaculos) {
                if (pared.imagen != null) {
                    g2.drawImage(pared.imagen, pared.x, pared.y, pared.ancho, pared.alto, null);
                } else {
                    g2.setColor(pared.c);
                    g2.fillRect(pared.x, pared.y, pared.ancho, pared.alto);
                }
            }
        }
    }
}
