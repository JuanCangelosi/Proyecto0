/**
 * Clase bombality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la cantidad de bombas de bomberman y retorna el puntaje.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUp;
import Personajes.*;
import PowerUpGrafico.PowerupGrafico;
import PowerUpGrafico.BombalityGrafico;

public class Bombality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Bombality(){
		eg=new BombalityGrafico();
	}
	
	/**
	 * Incopora el beneficio del powerUp en Bomberman
	 * @param b Bomberman
	 * @return retorna el puntaje del powerUp
	 */
	public int dar(Bomberman b){
		b.setCantBombas(b.cantBombas()*2);
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
