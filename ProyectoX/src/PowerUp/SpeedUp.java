package PowerUp;
import Personajes.*;
import Grafica.*;
/**
 * Clase Speedup es uno de los powerUps disponibles en el juego.
 * el metodo dar duplica la velocidad de bomberman y retorna el puntaje correspondiente.
 */
public class SpeedUp implements PowerUp {
	protected PowerupGrafico eg;
	
	public SpeedUp(){
		eg=new SpeedUpGrafico();
	}
	
	public int dar(Bomberman b){
		b.setVelocidad(b.getVelocidad()*2);
		System.out.println("SpeedUp otorgado, bomberman tiene el doble de velocidad");
		eg.setVisible(false);
		return 30;
	}
	
	public PowerupGrafico getEntidadGrafica(){
		return eg;
	}
}
