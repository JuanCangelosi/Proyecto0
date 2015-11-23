/**
 * Es el enemigo mas inteligente de Boomberman, capaz de perseguirlo y muy veloz
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import java.util.Random;

import mapa.Celda;
import Grafica.SiriusGrafico;

public class Sirius extends Enemigo {

	// Constructor
	public Sirius(Celda c) {
		super(c);
		p = new SiriusGrafico(celda.getPosY() * 32, celda.getPosX() * 32);
		puntaje = 50;
		especial = false;
		velocidad = 3;
		p.setVelocidad(velocidad);
	}

	// Metodos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public void loop() {
		int xB = celda.getMapa().getHeroe().getCelda().getPosX();
		int yB = celda.getMapa().getHeroe().getCelda().getPosY();

		int x = celda.getPosX();
		int y = celda.getPosY();
		if (!celda.getMapa().getHeroe().murio()) {
			if (xB < x && yB < y) {
				arriba();
				if (celda.getPosX() == x && celda.getPosY() == y) {
					izquierda();
				}
			} else {
				if (xB > x && yB > y) {
					abajo();
					if (celda.getPosX() == x && celda.getPosY() == y) {
						derecha();
					}
				} else {
					if (xB < x)
						izquierda();
					else {
						if (yB < y)
							arriba();
						else {
							if (xB > x)
								derecha();
							else {
								if (yB > y)
									abajo();
							}
						}
					}
				}
			}
		}
		if (celda.getPosX() == x && celda.getPosY() == y) {
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

}
