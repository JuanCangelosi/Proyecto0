package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class PersonajeGrafico extends EntidadGrafica{

	protected int direccion;
	protected BufferedImage centro,abajo1,abajo2,arriba1,arriba2,arriba3,derecha1,derecha2,derecha3,izquierda1,izquierda2,izquierda3;
	private static final long serialVersionUID = 1L;

	protected PersonajeGrafico(int x, int y) {
		super(x, y);
	}
	
	public abstract void mover(int dir);
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(direccion==0)
			g.drawImage(centro, 0, 0, this);
		else if(direccion==20)
			g.drawImage(abajo1, 0, 0, this);
		else if(direccion==21)
			g.drawImage(abajo2, 0, 0, this);
		
		else if(direccion==10)
			g.drawImage(izquierda1, 0, 0, this);
		else if(direccion==11)
			g.drawImage(izquierda2, 0, 0, this);
		else if(direccion==12)
			g.drawImage(izquierda3, 0, 0, this);
			
		else if(direccion==30)
			g.drawImage(derecha1, 0, 0, this);
		else if(direccion==31)
			g.drawImage(derecha2, 0, 0, this);
		else if(direccion==32)
			g.drawImage(derecha3, 0, 0, this);
		
		else if(direccion==40)
			g.drawImage(arriba1, 0, 0, this);
		else if(direccion==41)
			g.drawImage(arriba2, 0, 0, this);
		else if(direccion==42)
			g.drawImage(arriba3, 0, 0, this);
		
	}

}
