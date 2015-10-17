package Logica;
import Personajes.*;

public class Logica {
	protected Nivel nivel;
	
	public Logica(){
		nivel=new Nivel();
	}
	
	public Nivel getNivel(){
		return nivel;
	}
	
	public boolean gameOver(){
		return nivel.getHeroe().murio();
	}
}
