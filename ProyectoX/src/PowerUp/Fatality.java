package PowerUp;
import Personajes.*;
import Grafica.*;
import Bomba.*;

/**
 * Clase fatality es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica el radio de las bombas de bomberman y retorna el puntaje.
 */
public class Fatality implements PowerUp {
	protected EntidadGrafica eg;
	
	public Fatality(){
		eg=new FatalityGrafico();
	}
	
	public int dar(Bomberman b){
		b.fabrica().duplicar();
		return 35;
	}
	
	public EntidadGrafica getEntidadGrafica(){
		return eg;
	}
}
