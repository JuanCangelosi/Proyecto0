package Grafica;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class PersonajeGrafico extends EntidadGrafica{

	protected int direccion;
	protected BufferedImage centro,abajo1,abajo2,arriba1,arriba2,arriba3,derecha1,derecha2,derecha3,izquierda1,izquierda2,izquierda3;
	private static final long serialVersionUID = 1L;

	public PersonajeGrafico(int x, int y) {
		super(x, y);
		direccion = 0 ;
	}
	
	public void derecha(){
		
		if(x<928){
			this.x+=32;
					
			if(direccion != 30 && direccion!=31 && direccion!=32)
				direccion = 30;

			else if(direccion == 30)
				direccion = 31;
			
			else if(direccion == 31)
				direccion = 32;
			
			else if(direccion == 32)
				direccion = 30;

			setBounds(x,y,32,32);
		}
	}
	
	public void izquierda(){
		
		if(x>32){
			this.x-=32;
					
			if(direccion != 10 && direccion != 11 && direccion !=12)
				direccion = 10;
				
			else if(direccion == 10)
				direccion = 11;

			else if(direccion == 11)
				direccion = 12;
			
			else if(direccion == 12)
				direccion = 10;
					
			setBounds(x,y,32,32);
		}
	}
	
	public void arriba(){
		
		if(y>32){
			this.y-=32;
					
			if(direccion !=40 && direccion!=41 && direccion!=42)
				direccion = 40;
		
			else if(direccion == 40)
				direccion = 41;
			
			else if(direccion == 41)
				direccion = 42;
			
			else if(direccion == 42)
				direccion = 40;
			
					
			setBounds(x,y,32,32);
		}
	}
	
	public void abajo(){
		
		if(y<352){
			this.y+=32;
					
			if(direccion!=0 && direccion!=20 && direccion!=21)
				direccion = 0;

			else if(direccion == 0)
				direccion = 20;

			else if(direccion == 20)
				direccion = 21;
				
			else if(direccion == 21)
				direccion = 0;
					
			setBounds(x,y,32,32);
			
		}
	}
	
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
