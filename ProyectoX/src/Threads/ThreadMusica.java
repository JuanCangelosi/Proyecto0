package Threads;

import java.io.File;
import Sonidos.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ThreadMusica extends Thread {
//Atributos de instancia
	private Clip sonido;
	public ThreadMusica(){
		try {
			sonido = AudioSystem.getClip();
			File a = new File("/Sonidos/Electrodynamix.wav");
			sonido.open(AudioSystem.getAudioInputStream(a));
			}
			catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
			}
	}
	
	public void run(){
		while(true){
			//try{
			sonido.start();
			/*sleep(205000);
			sonido.close();
			}catch(Exception e){}*/
		}
	}
}
