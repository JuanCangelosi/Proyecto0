/**
 * Clase Speedup es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la velocidad de bomberman y retorna el puntaje correspondiente.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUp;
import Personajes.*;
import PowerUpGrafico.PowerupGrafico;
import PowerUpGrafico.SpeedUpGrafico;

public class SpeedUp implements PowerUp {
	protected PowerupGrafico eg;
	
	public SpeedUp(){
		eg=new SpeedUpGrafico();
	}
	
	/**
	 * Incopora el beneficio del powerUp en Bomberman
	 * @param b Bomberman
	 * @return retorna el puntaje del powerUp
	 */
	public int dar(Bomberman b){
		b.setVelocidad(b.getVelocidad()*2);
		System.out.println("SpeedUp otorgado, bomberman tiene el doble de velocidad");
		eg.setAgarrado(true);
		return 30;
	}
	
	/**
	 * Retorna su representacion grafica
	 * @return representacion grafica
	 */
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
