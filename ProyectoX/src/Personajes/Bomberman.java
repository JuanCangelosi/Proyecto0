/**
 * Es el personaje principal del juego, el usuario lo utilizara para tratar de ganar el juego,
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import Bomba.*;
import Logica.*;

public class Bomberman extends Personaje {
	// Atributos de Instancia
	private AbstractFactory a;
	protected int cantBombas;

	// Constructor
	public Bomberman(Celda c) {
		super(c);
		velocidad = 3;
		especial = false;
		cantBombas = 1;
	}

	// Metodos
	/**
	 * Aumenta o reduce la velocidad segun le parametro n
	 * 
	 * @param n
	 *            es el numero por el cual sera reemplazada la velocidad
	 */
	public void setVelocidad(int n) {
		velocidad = n;
	}

	/**
	 * Permite a boomberman darle el modo especial donde puede atravesar paredes
	 * y poner bombas ilimitadas
	 * 
	 * @param b
	 *            indica el valor que permitira a bomberman ser o no especial
	 */
	public void ponerEspecial(Boolean b) {
		especial = b;
	}

	/**
	 * Puede aumentar o disminuir la cantidad de bombas disponibles para
	 * Bomberman
	 * 
	 * @param n
	 *            es la nueva cantidad de bombas disponibles a colocar
	 */
	public void setCantBombas(int n) {
		cantBombas = n;
	}

	/**
	 * Si el personaje es tocado por algun enemigo ó alcanzado por la bomba, se
	 * muere
	 */
	public void morir() {
		muerto = true;
	}

	/**
	 * Mueve a Bomberman hacia arriba
	 */
	public void arriba() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y + 1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	/**
	 * Mueve a Bomberman hacia abajo
	 */
	public void abajo() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y - 1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	/**
	 * Mueve a Bomberman hacia la izquierda
	 */
	public void izquierda() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x - 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	/**
	 * Mueve a Bomberman hacia la derecha
	 */
	public void derecha() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x + 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	// Consultas
	/**
	 * Le pide una bomba a la fabrica y la coloca en el mapa
	 * 
	 * @return Devuelve la bomba colocada en el mapa
	 */
	public Bomba colocarBomba() {
		if (especial) {
			return a.darBomba(celda);
		} else {
			if (a.cantBombas() < cantBombas)
				return a.darBomba(celda);
			else
				return null;
		}
	}

	/**
	 * Devuelve la cantidad de bombas que bomberman puede colocar
	 * 
	 * @return retorna el maximo de bombas a colocar
	 */
	public int cantBombas() {
		return cantBombas;
	}

	/**
	 * Devuelve la velocidad que bomberman puede andar
	 * 
	 * @return retorna la velocidad de bomberman
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Devuelve la fabrica de bombas de Bomberman
	 * 
	 * @return retorna la fabrica de bombas
	 */
	public AbstractFactory fabrica() {
		return a;
	}

}
