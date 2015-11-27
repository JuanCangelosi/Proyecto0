/**
 * Crea la ventana a desarrollar del juego
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package Menu;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Logica.Logica;
import Threads.ThreadListener;
public class Juego extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int LOOP_CONTINUOUSLY = -1;
	private JLayeredPane contentPane;
	private Logica logica;
	private Panel panel;
	private boolean semaforo;
	private int dir;
	private ThreadListener t;
	private Menu menu;
	private Clip c;

	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Juego frame = new Juego();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	public Juego() {

		start();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (logica!=null && !logica.perdio()) {
					if (semaforo) {
						if (arg0.getKeyCode() == KeyEvent.VK_UP) {
							dir = 0;
							semaforo = false;
						}
						else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
							dir = 1;
							semaforo = true;
						} else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
							dir = 2;
							semaforo = true;
						} else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
							dir = 3;
							semaforo = true;
						}
					}

					if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
						dir = 4;
						semaforo = true;
					}
				}
			}
		});

		
		

	}
	
	/**
	 * Crea el menu de inicio del juego
	 */
	public void start(){
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 500);
		setLocationRelativeTo(null);
		setLayout(null);

		contentPane = new JLayeredPane();
		setContentPane(contentPane);
		menu     = new Menu(this);
		
	}
	/**
	 * Bloquea o desbloquea el mando del jugador
	 * @param b introduce el nuevo valor del semaforo
	 */
	public void bloqueado(boolean b) {
		semaforo = !b;
	}
	
	/**
	 * Indica si el mando de ljugador esta bloqueado
	 * @return true si esta bloqueado, false si no lo esta
	 */
	public boolean estaBloqueado() {
		return !semaforo;
	}
	
	/**
	 * Mueve al personaje
	 */
	public void mover() {
		switch (dir) {
		case 0: {
			logica.arriba();
			break;
		}
		case 1: {
			logica.abajo();
			break;
		}
		case 2: {
			logica.izquierda();
			break;
		}
		case 3: {
			logica.derecha();
			break;
		}
		case 4: {
			logica.colocarBomba();
			break;
		}
		case 5: {// Mantenga al bomberman quieto
		}
		}
		dir = 5;
	}
	
	/**
	 * Inicia el juego
	 */
	public void iniciarJuego(){
		semaforo = true;
		dir      = 5;
		t        = new ThreadListener(this);
		logica   = new Logica(this);
		panel    = new Panel(this);
		
		t.start();
		if (menu.sonido())
			startMusic();
		this.requestFocus();
		
	}
	/**
	 * Devuelve el panel principal del Juego
	 * @return el panel principal del Juego
	 */
	public Panel getPanel(){
		return panel;
	}
	
	/**
	 * Cierra el juego completamente
	 */
	public void salirJuego(){
		System.exit(0);
	}
	
	/**
	 * Inicia la musica de fondo del juego
	 */
	public void startMusic(){

	    try {
	        AudioInputStream a = AudioSystem.getAudioInputStream(new File(getClass().getResource("/Sonidos/Electrodynamix.wav").toURI()));
	        c = AudioSystem.getClip();
	        c.open(a);
	        FloatControl gainControl =  (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
	        c.loop(LOOP_CONTINUOUSLY);
	    }catch(Exception error){
	        System.out.println("File Not Found");
	        System.out.println(error);
	    }  
	}
	
	/**
	 * Cierra el juego, volviendo al menu principal
	 */
	public void gameOver(){
		startGameOver();
		Mensaje m = new Mensaje(0,0);
		contentPane.add(m,new Integer(400));
		m.GameOver();
		contentPane.moveToFront(m);
		try{
		Thread.sleep(5000);
		}catch (Exception e){}
		t.interrupt();
		contentPane.removeAll();
		contentPane.repaint();
		c.close();
		menu     = new Menu(this);
		
		
	}
	
	/**
	 * Reproduce la musica de Juego Terminado
	 */
	public void startGameOver(){

	    try {
	        AudioInputStream a = AudioSystem.getAudioInputStream(new File(getClass().getResource("/Sonidos/gameover.wav").toURI()));
	        Clip c = AudioSystem.getClip();
	        c.open(a);
	        c.start();
	    }catch(Exception error){
	        System.out.println("File Not Found");
	        System.out.println(error);
	    }  
	}
}
