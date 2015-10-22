package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Clase Masacrality es uno de los powerUps disponibles en el juego.
 * el metodo dar vuelve especial a bomberman (godmode) y retorna el puntaje del powerup.
 */
public class Masacrality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Masacrality(){
		eg=new MasacralityGrafico();
	}
	public int dar(Bomberman b){
		b.ponerEspecial(true);
		return 50;
	}
	public EntidadGrafica getEntidadGrafica(){
		return eg;
	}
}
