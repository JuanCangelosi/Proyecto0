package Grafica;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class BombaGrafica extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage image,imageA,imageB,imageC;


	public BombaGrafica(int x, int y) {
		super(x, y);
		imageA = null;

	}
	
	public void colocarBomba(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/bom1.png"));
			/*imageB = ImageIO.read(getClass().getResource("/Imagenes/bom2.png"));
			imageC = ImageIO.read(getClass().getResource("/Imagenes/bom3.png"));*/
			image = imageA;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		repaint();
		
	}
	
	private void cambiarImagen(){
		if(image == imageA){
			image = imageB;
		}
		else if(image == imageB){
			image = imageC;
		}
		else if(image == imageC){
			image = imageA;
		}
		
	}
	
	public void explotarBomba(){
		try {
			image = ImageIO.read(getClass().getResource("/Imagenes/fire-middle1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(image!=null)
			g.drawImage(image, 0, 0, this);
	}

}
