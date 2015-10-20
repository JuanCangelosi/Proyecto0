package Personajes;
import Bomba.*;
import Logica.*;
public class Bomberman extends Personaje {
	//Atributos de Instancia
	private AbstractFactory a;
	//Constructor
	public Bomberman(Celda c){
		super(c);
		
	}
	
	public Bomba colocarBomba(){
		return a.getBomba(celda);
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
}
