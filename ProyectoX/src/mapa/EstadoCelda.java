/**
 * Interface EstadoCelda, es el tipo de celda que puede ser pared, piso o paredIndestructible, actuando de 
 * diferentes maneras segun su tipo.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes 
 */

package mapa;

import Personajes.Bomberman;
import Personajes.Enemigo;
import Bomba.Bomba;
import CeldaGrafica.EstadoGrafico;
import PowerUp.PowerUp;

public interface EstadoCelda {
	/**
	 * Decidira si el estado sera destruido
	 * 
	 * @param c
	 *            la celda a la que pertenece el estado
	 * @return el puntaje de la explosion
	 */
	public int destruir(Celda c);

	/**
	 * Decidira si el personaje puede avanzar, y si se le puede otorgar el
	 * powerup
	 * 
	 * @param b
	 *            : bomberman que quiere avanzar
	 * @param p
	 *            : powerup que posee la celda (puede ser nulo)
	 * @param c
	 *            : celda a la que pertenece el estado
	 * @param n
	 *            : la direccion de avance 0=arriba, 1=abajo, 2= izq, 3=der
	 */
	public void serAvanzado(Bomberman b, PowerUp p, Celda c, int n);

	/**
	 * Decidira si el enemigo puede avanzar,
	 * 
	 * @param e
	 *            : enemigo que quiere avanzar
	 * @param c
	 *            : celda a la que pertenece el estado
	 * @param n
	 *            : la direccion de avance 0=arriba, 1=abajo, 2= izq, 3=der
	 */
	public void serAvanzado(Enemigo e, Celda c, int n);

	/**
	 * Decidira si la bomba puede ser colocada
	 * 
	 * @param b
	 *            : la bomba que se desea colocar
	 * @param c
	 *            : la celda a la que pertence el estado
	 */
	public void ocuparBomba(Bomba b, Celda c);

	/**
	 * Se determinara que accion toma la celda frente a una explosion
	 * 
	 * @param c
	 *            : celda a la que pertenece el estado
	 * @param r
	 *            : radio de la explosion
	 * @param pos
	 *            : direccion de la explosion 0=arriba, 1=abajo, 2= izq, 3=der
	 * @return el puntaje de la explosion
	 */
	public int explosion(Celda c, int r, int pos);

	/**
	 * Setea la imagen del estadografico de la celda
	 * 
	 * @param e
	 *            : estadografico a setear
	 */
	public void setImagen(EstadoGrafico e);
}
