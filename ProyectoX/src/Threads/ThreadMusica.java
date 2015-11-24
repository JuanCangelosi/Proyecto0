package Threads;

import java.io.BufferedInputStream;
import java.io.IOException;

import Sonidos.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.omg.CORBA.portable.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class ThreadMusica extends Thread {
//Atributos de instancia
	private Clip sonido;
	public ThreadMusica(){
		try {
			/*sonido = AudioSystem.getClip();
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("/Sonidos/Electrodynamix.wav"));
			AudioInputStream ais= AudioSystem.getAudioInputStream(bis);
			sonido.open(ais);*/
		}
			catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
			}
	}
	
	public void run(){
		while(true){ 
			//try{
			//sonido.start();
			/*sleep(205000);
			sonido.close();
			}catch(Exception e){}*/
		}
	}
}
