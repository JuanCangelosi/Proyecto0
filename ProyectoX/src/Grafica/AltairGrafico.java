package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class AltairGrafico extends PersonajeGrafico{

	public AltairGrafico(int x, int y) {
		super(x, y);
		try {
			
			centro = ImageIO.read(getClass().getResource("/Imagenes/altair3.png"));
			abajo1 = ImageIO.read(getClass().getResource("/Imagenes/altair3.png"));
			abajo2 = ImageIO.read(getClass().getResource("/Imagenes/altair3.png"));
			
			arriba1 = ImageIO.read(getClass().getResource("/Imagenes/altair1.png"));
			arriba2 = ImageIO.read(getClass().getResource("/Imagenes/altair1.png"));
			arriba3 = ImageIO.read(getClass().getResource("/Imagenes/altair1.png"));
			
			derecha1 = ImageIO.read(getClass().getResource("/Imagenes/altair4.png"));
			derecha2 = ImageIO.read(getClass().getResource("/Imagenes/altair4.png"));
			derecha3 = ImageIO.read(getClass().getResource("/Imagenes/altair4.png"));
			
			izquierda1 = ImageIO.read(getClass().getResource("/Imagenes/altair2.png"));
			izquierda2 = ImageIO.read(getClass().getResource("/Imagenes/altair2.png"));
			izquierda3 = ImageIO.read(getClass().getResource("/Imagenes/altair2.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
