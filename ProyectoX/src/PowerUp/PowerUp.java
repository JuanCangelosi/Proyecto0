package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Interfaz powerup
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public interface PowerUp {
	/**
	 * El metodo dar otorga a bomberman el powerup correspondiente y retorna el puntaje asociado al powerup.
	 * 
	 */
	public PowerupGrafico getEntidadGrafica();
	public int dar(Bomberman b);
}
