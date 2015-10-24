package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Clase Masacrality es uno de los powerUps disponibles en el juego.
 * el metodo dar vuelve especial a bomberman (godmode) y retorna el puntaje del powerup.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Masacrality implements PowerUp {
	protected PowerupGrafico eg;
	
	public Masacrality(){
		eg=new MasacralityGrafico();
	}
	public int dar(Bomberman b){
		System.out.println("Masacrality otorgado, bomberman puede atravesar paredes y tiene bombas ilimitadas");
		b.ponerEspecial(true);
		eg.setVisible(false);
		return 50;
	}
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
