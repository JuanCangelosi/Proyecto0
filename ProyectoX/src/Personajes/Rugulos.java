package Personajes;

import Logica.*;
import java.util.Random;

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
	
	// Consultas
	
	/**
	 * Establece al enemigo como muerto
	 * 
	 * @return retorna el puntaje que el enemigo posee al morir
	 */
	public int morir() {
		muerto = true;
		return puntaje;
	}
}
