package Logica;
import Personajes.*;
/**
 * Interfaz powerup
 */
public interface PowerUp {
	/**
	 * El metodo dar otorga a bomberman el powerup correspondiente y retorna el puntaje asociado al powerup.
	 * 
	 */
	public int dar(Bomberman b);
}
