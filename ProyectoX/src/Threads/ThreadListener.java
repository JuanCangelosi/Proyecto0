package Threads;
import Grafica.*;

public class ThreadListener extends Thread{
	protected Juego gui;
	public ThreadListener(Juego j){
		gui=j;
	}
	
	public void run () {
		while(true) {
			try {
				sleep(100);
				if(gui.estaBloqueado()){
					gui.mover();
					gui.bloqueado(false);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		}
	}
}
