package Personajes;
import Logica.*;

public abstract class Personaje {
	//Atributos de Instancia
		protected int velocidad;
		protected boolean muerto;
		protected boolean especial;
		protected Celda celda;
		
	//Constructor
		protected Personaje(){	
		velocidad=3;
		muerto=false;
	}
			
	public Celda getCelda(){
		return celda;
	}

	public boolean murio(){
		return muerto;
	}
	
	public abstract boolean esEspecial();
	
	public void arriba(){
		int x,y;
		x= celda.getPosH();
		y= celda.getPosV();
		Celda c= celda.getMapa().getCelda(x,y+1);
		celda.ocuparBomberman(null);
		c.ocuparBomberman(this);
	}
	
	public void abajo(){
		int x,y;
		x= celda.getPosH();
		y= celda.getPosV();
		Celda c= celda.getMapa().getCelda(x,y-1);
		celda.ocuparBomberman(null);
		c.ocuparBomberman(this);
	}
	
	public void izquierda(){
		int x,y;
		x= celda.getPosH();
		y= celda.getPosV();
		Celda c= celda.getMapa().getCelda(x-1,y);
		celda.ocuparBomberman(null);
		c.ocuparBomberman(this);
	}
	
	public void derecha(){
		int x,y;
		x= celda.getPosH();
		y= celda.getPosV();
		Celda c= celda.getMapa().getCelda(x+1,y);
		celda.ocuparBomberman(null);
		c.ocuparBomberman(this);
	}
}
