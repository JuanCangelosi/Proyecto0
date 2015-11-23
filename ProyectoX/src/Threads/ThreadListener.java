package Threads;

import Grafica.*;

public class ThreadListener extends Thread {
	protected Juego gui;

	public ThreadListener(Juego j) {
		gui = j;
	}

	public void run() {
		while (true) {
			if (!gui.estaBloqueado()) {
				System.out.println("entre");
				gui.mover();
				gui.bloqueado(false);
			}
		}
	}
}
