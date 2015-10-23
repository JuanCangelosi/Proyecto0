package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class FatalityGrafico extends PowerupGrafico{

	public FatalityGrafico(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public FatalityGrafico(){
		super(0,0);
	}

	public void mostrar() {
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/fatality.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
