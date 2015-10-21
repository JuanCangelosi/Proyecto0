/**
 * Es una clase abstracta que establece el comportamiento general de todos los personajes del juego
 * tanto a Bomberman como a los enemigos
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import mapa.Celda;

public abstract class Personaje {
	// Atributos de Instancia
	protected int velocidad;
	protected boolean muerto;
	protected boolean especial;
	protected Celda celda;

	// Constructor
	protected Personaje(Celda c) {
		celda = c;
		muerto = false;
	}

	// Metodos abstractos

	/**
	 * Libera la celda actual y ocupa la siguiente con Bomberman o Enemigo segun
	 * corresponda
	 */
	protected abstract void ocupar(Celda c);

	// Metodos

	/**
	 * Mueve al personaje hacia arriba
	 */
	public void arriba() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y + 1);
		ocupar(c);
	}

	/**
	 * Mueve al personaje hacia abajo
	 */
	public void abajo() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y - 1);
		ocupar(c);
	}

	/**
	 * Mueve al personaje hacia la izquierda
	 */
	public void izquierda() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x - 1, y);
		ocupar(c);
	}

	/**
	 * Mueve al personaje hacia la derecha
	 */
	public void derecha() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x + 1, y);
		ocupar(c);
	}

	/**
	 * Establece la celda en la que se encuentra el personaje
	 * 
	 * @param c
	 *            es la celda en la que el personaje se encuentra
	 */
	public void setCelda(Celda c) {
		celda = c;
	}

	// Consultas

	/**
	 * Devuelve la celda en la que se encuentra el personaje
	 * 
	 * @return retorna la celda de la posicion del personaje
	 */
	public Celda getCelda() {
		return celda;
	}

	/**
	 * Informa si el personaje esta muerto o no
	 * 
	 * @return retorna el estado del personaje
	 */
	public boolean murio() {
		return muerto;
	}

	/**
	 * Informa si el personaje es especial o no, el significado de especial
	 * varia segun el personaje que lo implemente
	 * 
	 * @return retorna el estado especial del Personaje
	 */
	public boolean esEspecial() {
		return especial;
	}
}
