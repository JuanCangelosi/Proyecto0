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
	@Override
	public void run() {
		try {
				sleep(5000);
				bomb.setTermino(true);
				
				
			} catch (InterruptedException e) {

			}
		}
}
