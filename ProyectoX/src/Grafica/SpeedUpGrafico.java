package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class SpeedUpGrafico extends PowerupGrafico{

	public SpeedUpGrafico(int x, int y) {
		super(x, y);
	}
	
	public SpeedUpGrafico(){
		super(0,0);
	}
	
	public void mostrar(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/speedup.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
