package Logica;
import mapa.Nivel;
import Personajes.*;
import Grafica.Juego;

public class Logica {
	protected Nivel nivel;
	protected Juego gui;
	
	public Logica(Juego gui){
		nivel=new Nivel();
		this.gui = gui;
		
		for(int i=0; i< 13; i++)
			for(int j=0; j<31; j++)
				gui.getContentPane().add(nivel.getMapa().getCelda(i, j).getEntidadGrafica(),0);
		
		gui.getContentPane().add(nivel.getMapa().getHeroe().grafico(),100);
		
		
				
	}
	
	public Nivel getNivel(){
		return nivel;
	}
	
	public boolean gameOver(){
		return nivel.getMapa().getHeroe().murio();
	}
}
