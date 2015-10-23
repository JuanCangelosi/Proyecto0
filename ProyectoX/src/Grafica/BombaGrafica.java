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
	private Timer timer;
	private boolean girar;

	public BombaGrafica(int x, int y) {
		super(x, y);
		try {
			
			imageA = ImageIO.read(getClass().getResource("/Imagenes/bom1.png"));
			imageB = ImageIO.read(getClass().getResource("/Imagenes/bom2.png"));
			imageC = ImageIO.read(getClass().getResource("/Imagenes/bom3.png"));
			image  = imageA;
			girar  = true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void colocarBomba(){
		
	    timer = new Timer(500,new ActionListener () 
	    { 
		public void actionPerformed(ActionEvent e) 
			 {
			    	girar = true;
			    	image = imageA;
			        
	         } 
		});
			
		timer.start();

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
			image = imageB;
		}
		
	}
	
	public void explotarBomba(){
		try {
			image = ImageIO.read(getClass().getResource("/Imagenes/fire-middle1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		timer.stop();
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(image!=null){
			if(girar)
				cambiarImagen();
			g.drawImage(image, 0, 0, this);
		}
		
	}

}
