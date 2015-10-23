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
	public void run() {
		try {
			while (true) {
				if (b != null) {
					sleep(5000);
					b.explotar();
				}
				sleep(1000);
			}
		} catch (InterruptedException e) {

		}
	}
}
