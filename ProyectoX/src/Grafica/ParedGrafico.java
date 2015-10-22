package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ParedGrafico extends EstadoGrafico{

	private static final long serialVersionUID = 1L;
	
	public ParedGrafico(int x, int y) {
		super(x, y);
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/pared2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ParedGrafico(){
		super();
		
	}

}
