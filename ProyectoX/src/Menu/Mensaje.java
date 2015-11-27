/**
 * Pone en pantalla el mensaje de jeugo terminado en el juego
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package Menu;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import Grafica.EntidadGrafica;

public class Mensaje extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	private ImageIcon mensaje;
	
	public Mensaje(int x, int y) {
		super(250, 250);
		setBounds(230,130,600,300);
		mensaje = null;
		repaint();
	}
	
	/**
	 * Pone un mensaje de juego perdido
	 */
	public void GameOver(){
		mensaje = new ImageIcon(getClass().getResource("/Imagenes/game-over.png"));
		repaint();
	}
	
	/**
	 * Pone un mensaje de Juego ganado
	 */
	public void Win(){
		mensaje = new ImageIcon(getClass().getResource("/Imagenes/winner.png"));
	}
	
	/**
	 * Pinta el grafico en el mapa
	 */
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(mensaje!=null)
			g.drawImage(mensaje.getImage(), 0, 0, this);
	}

}
