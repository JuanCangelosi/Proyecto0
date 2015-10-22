package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class PisoGrafico extends EstadoGrafico{

	private static final long serialVersionUID = 1L;
	
	public PisoGrafico(int x, int y) {
		super(x, y);
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/piso.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public PisoGrafico(){
		super();
	}

}
