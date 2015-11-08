/**
 * La clase implementa el hilo para explotar la bomba 5 segundos despues de haber sido colocada
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Threads;

import Bomba.*;

public class ThreadBomba extends Thread {
	// Atributos de Instancia
	Bomba b;

	public ThreadBomba(Bomba b1) {
		b = b1;
	}

	/**
	 * Espera 5 segundos y luego explota la bomba
	 */
	@Override
	public void run() {
		try {
			sleep(4000);
			b.explotar();
			sleep(750);
			b.getBombaGrafica().setVisible(false);
		} catch (InterruptedException e) {

		}
	}
}
