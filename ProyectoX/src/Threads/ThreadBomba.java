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
			sleep(5000);
			b.explotar();
			sleep(2000);
			b.getBombaGrafica().setVisible(false);
		} catch (InterruptedException e) {

		}
	}
}
