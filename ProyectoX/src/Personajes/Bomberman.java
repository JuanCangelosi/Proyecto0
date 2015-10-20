package Personajes;
import Bomba.*;
import Logica.*;
public class Bomberman extends Personaje {
	//Atributos de Instancia
	private AbstractFactory a;
	protected int cantBombas;
	//Constructor
	public Bomberman(Celda c){
		super(c);
		especial=false;
		cantBombas=1;	
	}
	
	
	public Bomba colocarBomba(){
		if(a.cantBombas()<cantBombas)
			return a.darBomba(celda);
		else 
			return null;
	}
	
	public void ponerEspecial(Boolean b){
		especial=b;
	}
	
	public void setCantBombas(int n){
		cantBombas=n;
	}
	
	public int cantBombas(){
		return cantBombas;
	}
	
	public void setVelocidad(int n){
		velocidad=n;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public void morir(){
		muerto=true;
	}
	
	public void arriba(){
		int x,y;
		x= celda.getPosX();
		y= celda.getPosY();
		Celda c= celda.getMapa().getCelda(x,y+1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}
	
	public void abajo(){
		int x,y;
		x= celda.getPosX();
		y= celda.getPosY();
		Celda c= celda.getMapa().getCelda(x,y-1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}
	
	public void izquierda(){
		int x,y;
		x= celda.getPosX();
		y= celda.getPosY();
		Celda c= celda.getMapa().getCelda(x-1,y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}
	
	public void derecha(){
		int x,y;
		x= celda.getPosX();
		y= celda.getPosY();
		Celda c= celda.getMapa().getCelda(x+1,y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}
	
	public AbstractFactory fabrica(){
		return a;
	}
}
