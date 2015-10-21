package Grafica;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Logica.Logica;

public class Juego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private Logica logica;
	
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
	
	public Juego(){
		
		
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 480);
		setLocationRelativeTo(null);
        setLayout(null);
		
		contentPane = new JLayeredPane();
		logica      = new Logica();
		
		setContentPane(contentPane);


		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode() == KeyEvent.VK_UP)
					logica.getNivel().getHeroe().arriba();
				
				else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
					logica.getNivel().getHeroe().abajo();
				
				else if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
					logica.getNivel().getHeroe().izquierda();
				
				else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
					logica.getNivel().getHeroe().derecha();
				
				else if(arg0.getKeyCode() == KeyEvent.VK_SPACE)
					logica.getNivel().getHeroe().colocarBomba();
				
			}
		});
		
	}
	


}
