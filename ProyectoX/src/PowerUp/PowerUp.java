package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Interfaz powerup
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public interface PowerUp {
	/**
	 * Retorna el objeto grafico del powerUP
	 * @return Retorna el objeto grafico del powerUP
	 */
	public PowerupGrafico getEntidadGrafica();
	
	/**
	 * 
	 * @param b es el Bomberman
	 * @return retorna el puntaje correspondiente del power up
	 */
	public int dar(Bomberman b);
}
