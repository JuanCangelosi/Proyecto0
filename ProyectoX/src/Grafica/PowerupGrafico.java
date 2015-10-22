package Grafica;

import java.awt.image.BufferedImage;

public class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected BufferedImage imageA;

	public PowerupGrafico(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage imagen(){
		return imageA;
	}
}
