package Logica;
import Personajes.*;
import Bomba.*;
/**
 * Clase bombality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la cantidad de bombas de bomberman y retorna el puntaje.
 */
public class Bombality implements PowerUp {
	public int dar(Bomberman b){
		b.setCantBombas(b.cantBombas()*2);
		return 35;
	}
}
