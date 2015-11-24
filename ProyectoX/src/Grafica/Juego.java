package Grafica;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Logica.Logica;
import Menu.Menu;
import Threads.ThreadListener;
import Bomba.*;
import mapa.*;
import Threads.ThreadMusica;
public class Juego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private Logica logica;
	private boolean semaforo;
	private Menu menu;
	private int dir;
	private ThreadListener t;
	private ThreadMusica musica;

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

		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 460);
		setLocationRelativeTo(null);
		setLayout(null);

		contentPane = new JLayeredPane();
		setContentPane(contentPane);
		
		menu     = new Menu(this);
		t        = new ThreadListener(this);
		musica   = new ThreadMusica();
		
		t.start();
		musica.start();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (logica!=null && !logica.gameOver()) {
					if (semaforo) {
						if (arg0.getKeyCode() == KeyEvent.VK_UP) {
							System.out.println("HOLA");
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

	public void bloqueado(boolean b) {
		semaforo = !b;
	}

	public boolean estaBloqueado() {
		return !semaforo;
	}

	public void mover() {
		switch (dir) {
		case 0: {
			logica.getNivel().getMapa().getHeroe().arriba();
			break;
		}
		case 1: {
			logica.getNivel().getMapa().getHeroe().abajo();
			break;
		}
		case 2: {
			logica.getNivel().getMapa().getHeroe().izquierda();
			break;
		}
		case 3: {
			logica.getNivel().getMapa().getHeroe().derecha();
			break;
		}
		case 4: {
			logica.getNivel().getMapa().getHeroe().colocarBomba();
			Celda c = logica.getNivel().getMapa().getHeroe().getCelda();
			Bomba b1 = logica.getNivel().getMapa()
					.getCelda(c.getPosX(), c.getPosY()).getBomba();
			if (b1 != null) {
				contentPane.add(b1.getBombaGrafica(), new Integer(2));
			}
			break;
		}
		case 5: {// Mantenga al bomberman quieto
		}
		}
		dir = 5;
	}
	
	public void iniciarJuego(){
		semaforo = true;
		dir      = 5;
		logica   = new Logica(this);
		
	}
	
	public void salirJuego(){
		System.exit(0);
	}
}
