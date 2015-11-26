package mapa;
import Logica.*;

/**
 * Clase nivel representa el nivel en que se esta jugando.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
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
	 * Retorna true si no hay mas paredes en el mapa
	 * @return true si no hay mas paredes en el mapa, false caso contrario
	 */
	public boolean gano() {
		return mapa.getCantParedesDest()==0;
	}
	public int getPuntaje(){
		return puntaje;
	}
	public void gameOver(){
		log.gameOver();
	}
}
