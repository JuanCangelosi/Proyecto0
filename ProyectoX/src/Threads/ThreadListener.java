package Threads;

import Grafica.*;

public class ThreadListener extends Thread {
	protected Juego gui;

	public ThreadListener(Juego j) {
		gui = j;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
				if (gui.estaBloqueado()) {
					if (!gui.getLogica().getNivel().getMapa().getHeroe()
							.murio()) {
						gui.mover();
						gui.bloqueado(false);
					} else
						this.stop();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
