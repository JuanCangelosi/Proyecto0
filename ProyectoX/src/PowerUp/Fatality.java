/**
 * Clase fatality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica el radio de las bombas de bomberman y retorna el puntaje.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUp;
import Personajes.*;
import PowerUpGrafico.PowerupGrafico;
import PowerUpGrafico.FatalityGrafico;

public class Fatality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Fatality(){
		eg=new FatalityGrafico();
	}
	
	/**
	 * Incopora el beneficio del powerUp en Bomberman
	 * @param b Bomberman
	 * @return retorna el puntaje del powerUp
	 */
	public int dar(Bomberman b){
		b.fabrica().duplicar();
		eg.setAgarrado(true);
		return 35;
	}
	
	/**
	 * Retorna su representacion grafica
	 * @return representacion grafica
	 */
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
