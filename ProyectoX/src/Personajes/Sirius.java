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
		velocidad = 4;
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
			if ((xB < x) && (yB < y)) {
				Random rnd = new Random();
				int n = rnd.nextInt(2) + 1;
				switch (n) {
				case 1: {
					arriba();
					break;
				}
				case 2: {
					izquierda();
					break;
				}
				}
				if (celda.getPosX() == x && celda.getPosY() == y) {
					if (n == 1)
						izquierda();
					else
						arriba();
				}
			} else {
				if ((xB > x) && (yB > y)) {
					Random rnd = new Random();
					int n = rnd.nextInt(2) + 1;
					switch (n) {
					case 1: {
						abajo();
						break;
					}
					case 2: {
						derecha();
						break;
					}
					}
					if (celda.getPosX() == x && celda.getPosY() == y) {
						if (n == 1)
							derecha();
						else
							abajo();
					}
				} else {
					if ((xB > x) && (yB < y)) {
						Random rnd = new Random();
						int n = rnd.nextInt(2) + 1;
						switch (n) {
						case 1: {
							abajo();
							break;
						}
						case 2: {
							izquierda();
							break;
						}
						}
						if (celda.getPosX() == x && celda.getPosY() == y) {
							if (n == 1)
								izquierda();
							else
								abajo();
						}
					} else {
						if((xB < x) && (yB > y)){
							Random rnd = new Random();
							int n = rnd.nextInt(2) + 1;
							switch (n) {
							case 1: {
								arriba();
								break;
							}
							case 2: {
								derecha();
								break;
							}
							}
							if (celda.getPosX() == x && celda.getPosY() == y) {
								if (n == 1)
									derecha();
								else
									arriba();
							}
							
						}else{
						if (xB < x)
							arriba();
						else {
							if (yB < y)
								izquierda();
							else {
								if (xB > x)
									abajo();
								else {
									if (yB > y)
										derecha();
								}
							}
						}
					}}
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
