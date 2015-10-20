package PowerUp;
import Personajes.*;
/**
 * Clase Speedup es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la velocidad de bomberman y retorna el puntaje correspondiente.
 */
public class SpeedUp implements PowerUp {
	public int dar(Bomberman b){
		b.setVelocidad(b.getVelocidad()*2);
		return 30;
	}
}
