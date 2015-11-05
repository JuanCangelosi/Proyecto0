package Grafica;

import javax.swing.ImageIcon;

public class BombermanGrafico extends PersonajeGrafico{
	
	private static final long serialVersionUID = 1L;
	
	public BombermanGrafico(int x, int y) {
		super(x, y);
		
		centro = new ImageIcon(getClass().getResource("/Imagenes/player-abajo1.png"));
		abajo1 = new ImageIcon(getClass().getResource("/Imagenes/player-abajo2.png"));
		abajo2 = new ImageIcon(getClass().getResource("/Imagenes/player-abajo3.png"));
		
		arriba1 = new ImageIcon(getClass().getResource("/Imagenes/player-arriba1.png"));
		arriba2 = new ImageIcon(getClass().getResource("/Imagenes/player-arriba2.png"));
		arriba3 = new ImageIcon(getClass().getResource("/Imagenes/player-arriba3.png"));
			
		derecha1 = new ImageIcon(getClass().getResource("/Imagenes/player-derecha1.png"));
		derecha2 = new ImageIcon(getClass().getResource("/Imagenes/player-derecha2.png"));
		derecha3 = new ImageIcon(getClass().getResource("/Imagenes/player-derecha3.png"));
			
		izquierda1 = new ImageIcon(getClass().getResource("/Imagenes/player-izquierda1.png"));
		izquierda2 = new ImageIcon(getClass().getResource("/Imagenes/player-izquierda2.png"));
		izquierda3 = new ImageIcon(getClass().getResource("/Imagenes/player-izquierda3.png"));
		
		morir	   = new ImageIcon(getClass().getResource("/Imagenes/GameOver.png"));
		
	}	
}
	


