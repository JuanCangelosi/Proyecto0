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
}
