package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ParedDestruibleGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage imageA;
	
	protected ParedDestruibleGrafico(int x, int y) {
		super(x, y);
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/paredDestruible.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	    g.drawImage(imageA, 0, 0, this);
	}

}
