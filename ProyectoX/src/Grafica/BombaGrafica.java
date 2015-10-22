package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BombaGrafica extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage imageA;

	public BombaGrafica(int x, int y) {
		super(x, y);
		imageA = null;

	}
	
	public void colocarBomba(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/bom1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repaint();
		
	}
	
	public void explotarBomba(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/fire-middle1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imageA!=null)
			g.drawImage(imageA, 0, 0, this);
	}

}
