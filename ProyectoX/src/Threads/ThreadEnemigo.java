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
		try {
			while (activado == true) {
				e.loop();
				sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Detiene el thread en el momento que el enemigo muere
	 */
	public void detener(){
		activado=false;
		this.detener();
	}
}
