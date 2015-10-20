/**
 * Es el enemigo mas inteligente de Boomberman, capaz de perseguirlo y muy veloz
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;


import Logica.Celda;

public class Sirius extends Enemigo {

	// Constructor
	public Sirius(Celda c) {
		super(c);
		puntaje = 50;
		especial = false;
		velocidad = 3;
	}

	// Metodos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public void loop() {
		/* A completar */
	}
}
