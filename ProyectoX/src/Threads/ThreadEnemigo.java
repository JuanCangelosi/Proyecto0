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
	
	public void detener(){
		activado=false;
		this.detener();
	}
}
