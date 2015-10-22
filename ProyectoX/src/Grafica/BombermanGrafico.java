package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;


public class BombermanGrafico extends PersonajeGrafico{
	
	private static final long serialVersionUID = 1L;
	
	public BombermanGrafico(int x, int y) {
		super(x, y);
		try {
			
			centro = ImageIO.read(getClass().getResource("/Imagenes/player-abajo1.png"));
			abajo1 = ImageIO.read(getClass().getResource("/Imagenes/player-abajo2.png"));
			abajo2 = ImageIO.read(getClass().getResource("/Imagenes/player-abajo3.png"));
			
			arriba1 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba1.png"));
			arriba2 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba2.png"));
			arriba3 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba3.png"));
			
			derecha1 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha1.png"));
			derecha2 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha2.png"));
			derecha3 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha3.png"));
			
			izquierda1 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda1.png"));
			izquierda2 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda2.png"));
			izquierda3 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda3.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
	


