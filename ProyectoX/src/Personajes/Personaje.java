package Personajes;
import Logica.*;

public abstract class Personaje {
	//Atributos de Instancia
		protected int velocidad;
		protected boolean muerto;
		protected boolean especial;
		protected Celda celda;
		
	//Constructor
		protected Personaje(Celda c){	
		celda=c;
		velocidad=3;
		muerto=false;
	}
			
	public Celda getCelda(){
		return celda;
	}
	
	public void setCelda(Celda c){
		celda=c;
	}

	public boolean murio(){
		return muerto;
	}
	
	public abstract boolean esEspecial();
	
	public abstract void arriba();
	
	public abstract void abajo();
	
	public abstract void izquierda();
	
	public abstract void derecha();
}
