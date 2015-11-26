package PowerUp;
import Personajes.*;
import Grafica.*;

/**
 * Clase fatality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica el radio de las bombas de bomberman y retorna el puntaje.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Fatality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Fatality(){
		eg=new FatalityGrafico();
	}
	
	public int dar(Bomberman b){
		b.fabrica().duplicar();
		System.out.println("fatality otorgado, rango de las bombas duplicado");
		eg.setAgarrado(true);
		return 35;
	}
	
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
