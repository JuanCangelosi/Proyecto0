package Grafica;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ParedDestruibleGrafico extends EstadoGrafico{
	
	private static final long serialVersionUID = 1L;
	
	public ParedDestruibleGrafico(int x, int y) {
		super(x, y);
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/paredDestruible.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ParedDestruibleGrafico(){
		super();
		
	}

}
