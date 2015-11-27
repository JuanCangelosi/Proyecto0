/**
 * Es el enemigo de bomberman capaz de atravesar las paredes, tan inteligente como rugulos
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import java.util.Random;
import PersonajesGraficos.AltairGrafico;
import mapa.Celda;

public class Altair extends Enemigo {
	// Constructor
	public Altair(Celda c) {
		super(c);
		p=new AltairGrafico(celda.getPosY()*32,celda.getPosX()*32);
		puntaje = 20;
		especial = true;
		velocidad = 1;
		p.setVelocidad(velocidad);
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
