/**
 * Clase Masacrality es uno de los powerUps disponibles en el juego.
 * el metodo dar vuelve especial a bomberman (godmode) y retorna el puntaje del powerup.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUp;
import Personajes.*;
import Threads.ThreadMasacrality;
import PowerUpGrafico.PowerupGrafico;
import PowerUpGrafico.MasacralityGrafico;

public class Masacrality implements PowerUp {
	protected PowerupGrafico eg;
	protected ThreadMasacrality t;
	
	public Masacrality(){
		eg=new MasacralityGrafico();
		t=new ThreadMasacrality();
	}
	
	/**
	 * Incopora el beneficio del powerUp en Bomberman
	 * @param b Bomberman
	 * @return retorna el puntaje del powerUp
	 */
	public int dar(Bomberman b){
		b.ponerEspecial(true);
		eg.setAgarrado(true);
		t.darBomberman(b);
		return 50;
	}
	
	/**
	 * Retorna su representacion grafica
	 * @return representacion grafica
	 */
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
