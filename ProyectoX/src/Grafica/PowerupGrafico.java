package Grafica;

import java.awt.image.BufferedImage;

public abstract class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected BufferedImage imageA;

	public PowerupGrafico(int x, int y) {
		super(x, y);
		imageA = null;
	}

	public abstract void mostrar();
}
