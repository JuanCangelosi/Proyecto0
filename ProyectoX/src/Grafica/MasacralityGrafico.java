package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class MasacralityGrafico extends PowerupGrafico{

	public MasacralityGrafico(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public MasacralityGrafico(){
		super(0,0);
	}

	public void mostrar() {
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/masacrality.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

}
