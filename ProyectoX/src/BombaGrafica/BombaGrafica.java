/**
 * Representacion grafica de la bomba, actua unicamente sobre la GUI
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package BombaGrafica;

import Grafica.EntidadGrafica;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;


public class BombaGrafica extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen,bomba,explosion;
	private Timer timer;

	public BombaGrafica(int x, int y) {
		super(x, y);
		bomba     = new ImageIcon(getClass().getResource("/Imagenes/bomba.gif"));
		explosion = new ImageIcon(getClass().getResource("/Imagenes/BombaCentro.gif"));
		imagen    = null;

	}
	/**
	 * Coloca la bomba en el escenario grafico del juego
	 */
	public void colocarBomba(){
		imagen = bomba;
		repaint();
		startBomba();
		
	}
	
	/**
	 * Introduce en el escenario una explosion
	 */
	public void explotarBomba(){
		
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	explosion = null;
		    	setVisible(false);
		    	repaint();
		        timer.stop();
		    } 
		});
		
		timer.start();

		imagen = explosion;
		repaint();
		
	}
	
	/**
	 * Pinta el grafico en el escenario
	 * @param g grafico a pintar
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}
	
	/**
	 * Introduce el sonido que ocasiona la explosión de la bomba
	 */
	public void startBomba(){

	    try {
	        AudioInputStream a = AudioSystem.getAudioInputStream(new File(getClass().getResource("/Sonidos/boom.wav").toURI()));
	        Clip c = AudioSystem.getClip();
	        c.open(a);
	        c.start();
	    }catch(Exception error){
	        System.out.println("File Not Found");
	        System.out.println(error);
	    }  
	}

}
