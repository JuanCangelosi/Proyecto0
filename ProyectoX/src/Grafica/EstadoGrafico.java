package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	    g.drawImage(imageA, 0, 0, this);
	    
	}

}
