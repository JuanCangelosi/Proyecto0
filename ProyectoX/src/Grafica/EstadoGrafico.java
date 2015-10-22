package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EstadoGrafico extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	protected BufferedImage imageA;
	
	public EstadoGrafico(int x, int y) {
		super(x, y);
		
	}
	
	public EstadoGrafico(){
		super(0 ,0);
		
	}
	
	public void setX(int x){
		this.x = x;
		setBounds(x,y,width,height);
		
	}
	
	public void setY(int y){
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	public void mostrarPowerUp(PowerupGrafico p){
		
			imageA = p.imagen();

		
	}
	
	public void setPared(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/pared.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public void setPiso(){
		try {
			imageA = ImageIO.read(getClass().getResource("/Imagenes/piso.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public void setParedDestruible(){
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
