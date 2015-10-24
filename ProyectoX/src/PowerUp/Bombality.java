package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Clase bombality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la cantidad de bombas de bomberman y retorna el puntaje.
* @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Bombality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Bombality(){
		eg=new BombalityGrafico();
	}
	
	public int dar(Bomberman b){
		b.setCantBombas(b.cantBombas()*2);
		System.out.println("bombality otorgado, bomberman puede setear "+b.cantBombas()+ " Bombas");
		eg.setVisible(false);
		return 35;
	}
	
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
