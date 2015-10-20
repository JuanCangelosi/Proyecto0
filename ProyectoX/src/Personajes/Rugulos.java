/**
 * Es el enemigo menos inteligente de Bomberman
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import Logica.*;

import java.util.Random;

import mapa.Celda;

public class Rugulos extends Enemigo {
	// Constructor
	public Rugulos(Celda c) {
		super(c);
		puntaje = 15;
		especial = false;
		velocidad = 1;
	}

	// Metodos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public void loop() {
		Random rnd = new Random();
		int n = rnd.nextInt(4) + 1;
		switch (n) {
		case 1: {
			arriba();
			break;
		}
		case 2: {
			abajo();
			break;
		}
		case 3: {
			izquierda();
			break;
		}
		case 4: {
			derecha();
			break;
		}
		}
	}
}
