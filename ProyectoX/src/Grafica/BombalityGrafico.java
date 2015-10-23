package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BombalityGrafico extends PowerupGrafico{

	public BombalityGrafico(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public BombalityGrafico(){
		super(0,0);
	}

	public void mostrar() {
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/bombality.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
		
	}

}
