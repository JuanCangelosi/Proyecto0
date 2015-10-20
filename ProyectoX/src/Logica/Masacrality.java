package Logica;
import Personajes.*;
/**
 * Clase Masacrality es uno de los powerUps disponibles en el juego.
 * el metodo dar vuelve especial a bomberman (godmode) y retorna el puntaje del powerup.
 */
public class Masacrality implements PowerUp {
	public int dar(Bomberman b){
		b.ponerEspecial(true);
		return 50;
	}
}
