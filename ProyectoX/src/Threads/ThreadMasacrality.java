/**
 * Este hilo espera 5 segundos y luego cancela el efecto del powerUp masacrality
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package Threads;
import Personajes.*;

public class ThreadMasacrality extends Thread {
	protected Bomberman bomb;
	public ThreadMasacrality(){
		bomb=null;
	}
	public void darBomberman(Bomberman b){
		bomb=b;
		start();
	}
	
	/**
	 * Espera 5 segundos y cancela el powerUp masacrality
	 */
	public void run() {
		try {
				sleep(5000);
				bomb.setTermino(true);
				this.interrupt();
				
				
			} catch (InterruptedException e) {

			}
		}
}
