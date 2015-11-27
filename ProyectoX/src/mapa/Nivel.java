/**
 * Clase nivel representa el nivel en que se esta jugando.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package mapa;
import Logica.*;


public class Nivel {
	protected int puntaje;
	protected Mapa mapa;
	protected Logica log;

	public Nivel(Logica l) {
		mapa = new Mapa(this);
		puntaje=0;
		log=l;
		
	}
	/**
	 * Suma el puntaje al nivel
	 * @param n: puntaje a sumar al nivel
	 */

	public void sumarPuntaje(int n) {
		puntaje += n;
		log.actualizarPuntaje();
	}
	
	/**
	 * Retorna el mapa asociado al nivel
	 * @return mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}
	
	/**
	 * Retorna el puntaje obtenido hasta el momento
	 * @return el puntaje obtenido hasta el momento
	 */
	public int getPuntaje(){
		return puntaje;
	}
	
	/**
	 * Envia el mensaje a logica de que se produzca el fin del juego
	 */
	public void gameOver(){
		log.gameOver();
	}
}
