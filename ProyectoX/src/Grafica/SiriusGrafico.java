package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class SiriusGrafico extends PersonajeGrafico{

	private static final long serialVersionUID = 1L;

	protected SiriusGrafico(int x, int y) {
		super(x, y);
		try {
			
			centro = ImageIO.read(getClass().getResource("/Imagenes/sirius-abajo1.png"));
			abajo1 = ImageIO.read(getClass().getResource("/Imagenes/sirius-abajo2.png"));
			abajo2 = ImageIO.read(getClass().getResource("/Imagenes/sirius-abajo3.png"));
			
			arriba1 = ImageIO.read(getClass().getResource("/Imagenes/sirius-arriba1.png"));
			arriba2 = ImageIO.read(getClass().getResource("/Imagenes/sirius-arriba2.png"));
			arriba3 = ImageIO.read(getClass().getResource("/Imagenes/sirius-arriba3.png"));
			
			derecha1 = ImageIO.read(getClass().getResource("/Imagenes/sirius-derecha1.png"));
			derecha2 = ImageIO.read(getClass().getResource("/Imagenes/sirius-derecha2.png"));
			derecha3 = ImageIO.read(getClass().getResource("/Imagenes/sirius-derecha3.png"));
			
			izquierda1 = ImageIO.read(getClass().getResource("/Imagenes/sirius-izquierda1.png"));
			izquierda2 = ImageIO.read(getClass().getResource("/Imagenes/sirius-izquierda2.png"));
			izquierda3 = ImageIO.read(getClass().getResource("/Imagenes/sirius-izquierda3.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
