package mapa;
import Bomba.Bomba;
import PowerUp.*;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;
/**
 * Clase Pared representa las paredes indestructibles del mapa, que no pueden ser atravesadas y bloquean las 
 * explosiones.
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
	/**
	 * Las paredes cortan la explosion
	 */
	public int explosionArriba(Celda c,int r){
		return 0;
	}
	/**
	 * Las paredes cortan la explosion
	 */
	public int explosionAbajo(Celda c,int r){
		return 0;
	}
	/**
	 * Las paredes cortan la explosion
	 */
	public int explosionIzq(Celda c,int r){
		return 0;
	}
	/**
	 * Las paredes cortan la explosion
	 */
	public int explosionDer(Celda c,int r){
		return 0;
	}
	public void setImagen(EstadoGrafico e){
		e.setPared();
	}

}
