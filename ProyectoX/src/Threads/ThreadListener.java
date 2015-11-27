/**
 * Este hilo bloquea la gui cuando se indico una direccion a mover en el heroe
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package Threads;

import Menu.Juego;;

public class ThreadListener extends Thread {
	protected Juego gui;

	public ThreadListener(Juego j) {
		gui = j;
	}

	/**
	 * Mantiene la gui bloqueada mientras bomberman tenga un movimiento para hacer
	 */
	public void run() {
		while (true) {
			if (!gui.estaBloqueado()) {
				try{
					sleep(1);
				}catch (Exception e){}
				gui.mover();
				gui.bloqueado(false);
			}
		}
	}
}
