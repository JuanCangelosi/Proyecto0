/**
 * Interfaz con el objetivo de simular el patron AbstractFactory para proveer bombas
 * a los personajes
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Bomba;

import mapa.Celda;

public interface AbstractFactory {

	/**
	 * Duplica el valor del radio de la bomba
	 */
	public void duplicar();

	/**
	 * Disminuje en uno la cantidad de bombas colocadas, uso exclusivo de la
	 * bomba cada vez que explote
	 */
	public void bombaMenos();

	/**
	 * Aumenta en uno la cantidad de bombas colocadas, uso exclusivo de la bomba
	 * cada vez que explote
	 */
	public void bombaMas();

	/**
	 * crea un objeto Bomba y se lo retorna al Personaje
	 * 
	 * @param c
	 *            es la celda en la cual se va colocar la bombar
	 * @return retorna una bomba, colocada en la celda
	 */
	public Bomba darBomba(Celda c);

	/**
	 * Devuelve la cantidad de bombas en el mapa que no han explotado
	 * 
	 * @return Devuelve la cantidad de bombas colocadas
	 */
	public int cantBombas();
}