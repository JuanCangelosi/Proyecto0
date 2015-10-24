package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected BufferedImage imageA;

	public PowerupGrafico(int x, int y) {
		super(x, y);
		imageA = null;
	}

	public abstract void mostrar();
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imageA!=null){
			g.drawImage(imageA, 0, 0, this);
		}
	}
}
