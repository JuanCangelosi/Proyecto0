package mapa;
import Bomba.Bomba;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;
/**
 * Clase Pared representa las paredes indestructibles del mapa, que no pueden ser atravesadas y bloquean las 
 * explosiones.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Pared implements EstadoCelda {
	
	/**
	 * Una pared no puede ser avanzada por nadie
	 */
	public void serAvanzado(Bomberman b,PowerUp p, Celda c, int n){
	}
	/**
	 * Una pared no puede ser avanzada por nadie
	 */
	public void serAvanzado(Enemigo e, Celda c, int n){
	}
	/**
	 * Una pared no puede ser destruida
	 */
	public int destruir(Celda c){
		return 0;
	}
	/**
	 * Una pared no puede recibir bombas
	 */
	public void ocuparBomba(Bomba b,Celda c){
	}
	public int explosion(Celda c, int r, int pos){
		return 0;
	}
	public void setImagen(EstadoGrafico e){
		e.setPared();
	}

}
