/**
 * La clase activa el hilo de los enemigos para que comiencen a moverse por el mapa
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Threads;

import Personajes.*;

public class ThreadEnemigo extends Thread {
	// Atributo de Instancia
	protected Enemigo e;
	protected boolean activado;

	public ThreadEnemigo(Enemigo en) {
		e = en;
		activado = true;
	}

	/**
	 * Envia al enemigo a moverse una vez por segundo
	 */
	public void run() {
		while (activado == true) {
			e.loop();
		}
	}

	/**
	 * Detiene el thread en el momento que el enemigo muere
	 */
	public void detener() {
		activado = false;
		this.interrupt();
	}
}
